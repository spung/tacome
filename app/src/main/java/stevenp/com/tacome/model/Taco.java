package stevenp.com.tacome.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public class Taco {
    @SerializedName("base_layer") RecipeItem mBaseLayer;
    @SerializedName("shell") RecipeItem mShell;
    @SerializedName("seasoning") RecipeItem mSeasoning;
    @SerializedName("mixin") RecipeItem mMixin;
    @SerializedName("condiment") RecipeItem mCondiment;

    public RecipeItem getBaseLayer() {
        return mBaseLayer;
    }

    public RecipeItem getShell() {
        return mShell;
    }

    public RecipeItem getSeasoning() {
        return mSeasoning;
    }

    public RecipeItem getMixin() {
        return mMixin;
    }

    public RecipeItem getCondiment() {
        return mCondiment;
    }
}