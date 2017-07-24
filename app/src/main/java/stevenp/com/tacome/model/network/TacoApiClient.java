package stevenp.com.tacome.model.network;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import stevenp.com.tacome.model.RecipeItem;
import stevenp.com.tacome.model.Taco;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public class TacoApiClient {
    private TacoService mTacoService;

    public TacoApiClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://taco-randomizer.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build();

        mTacoService = retrofit.create(TacoService.class);
    }

    public Single<List<RecipeItem>> getRandomTaco() {
        return mTacoService.getRandomTaco()
            .map(new Function<Taco, List<RecipeItem>>() {
                @Override
                public List<RecipeItem> apply(@NonNull Taco taco) throws Exception {
                    List<RecipeItem> items = new ArrayList<>();
                    items.add(taco.getBaseLayer());
                    items.add(taco.getMixin());
                    items.add(taco.getShell());
                    items.add(taco.getSeasoning());
                    items.add(taco.getCondiment());

                    return items;
                }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
