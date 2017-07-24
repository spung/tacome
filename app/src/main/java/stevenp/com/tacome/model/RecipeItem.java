package stevenp.com.tacome.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public class RecipeItem {
    @SerializedName("name") private String mName;
    @SerializedName("recipe") private String mRecipe;

    public String getName() {
        return mName;
    }

    public String getRecipe() {
        return mRecipe.substring(mRecipe.lastIndexOf('=') + 1, mRecipe.length()).trim();
    }
}
