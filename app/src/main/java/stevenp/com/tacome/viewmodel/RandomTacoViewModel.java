package stevenp.com.tacome.viewmodel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import stevenp.com.tacome.model.RecipeItem;
import stevenp.com.tacome.model.Taco;
import stevenp.com.tacome.model.network.TacoApiClient;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public class RandomTacoViewModel {
    private PublishSubject<List<RecipeItem>> mTacoDetailsSubject;
    private TacoApiClient mTacoApiClient;

    public RandomTacoViewModel(TacoApiClient tacoApiClient) {
        mTacoDetailsSubject = PublishSubject.create();
        mTacoApiClient = tacoApiClient;
    }

    public Observable<List<RecipeItem>> bindTacoRecipeItems() {
        return mTacoDetailsSubject;
    }

    public void onRandomButtonClicked() {
        mTacoApiClient.getRandomTaco().subscribe(new SingleObserver<List<RecipeItem>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {}

            @Override
            public void onSuccess(@NonNull List<RecipeItem> recipeItems) {
                mTacoDetailsSubject.onNext(recipeItems);
            }

            @Override
            public void onError(@NonNull Throwable e) {}
        });
    }
}
