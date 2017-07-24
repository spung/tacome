package stevenp.com.tacome.model.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import stevenp.com.tacome.model.Taco;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public interface TacoService {
    @GET("random") Single<Taco> getRandomTaco();
}
