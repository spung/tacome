package stevenp.com.tacome.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import stevenp.com.tacome.R;
import stevenp.com.tacome.model.RecipeItem;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public class RecipeItemAdapter extends RecyclerView.Adapter<RecipeItemViewHolder> {
    List<RecipeItem> mRecipeItems;

    @Override
    public RecipeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipeItemViewHolder(
            LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecipeItemViewHolder holder, int position) {
        holder.bind(mRecipeItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipeItems == null ? 0 : mRecipeItems.size();
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        mRecipeItems = recipeItems;
        notifyDataSetChanged();
    }
}
