package stevenp.com.tacome.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import stevenp.com.tacome.R;
import stevenp.com.tacome.model.RecipeItem;

/**
 * Created by stevenpungdumri on 7/24/17.
 */

public class RecipeItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.name) TextView mName;
    @BindView(R.id.recipe) TextView mRecipe;

    public RecipeItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(RecipeItem item) {
        mName.setText(item.getName());
        mRecipe.setText(item.getRecipe());
    }
}
