package stevenp.com.tacome.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import stevenp.com.tacome.R;
import stevenp.com.tacome.model.RecipeItem;
import stevenp.com.tacome.model.network.TacoApiClient;
import stevenp.com.tacome.viewmodel.RandomTacoViewModel;

public class RandomTacoActivity extends AppCompatActivity {
    private RandomTacoViewModel mRandomTacoViewModel;

    @BindView(R.id.recipeItemsRecyclerView) RecyclerView mRecipeItemsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_taco);
        ButterKnife.bind(this);
        mRandomTacoViewModel = new RandomTacoViewModel(new TacoApiClient());
        final RecipeItemAdapter adapter = new RecipeItemAdapter();
        mRecipeItemsRecyclerView.setAdapter(adapter);
        mRecipeItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mRandomTacoViewModel.bindTacoRecipeItems().subscribe(new Observer<List<RecipeItem>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {}

            @Override
            public void onNext(@NonNull List<RecipeItem> recipeItems) {
                adapter.setRecipeItems(recipeItems);
            }

            @Override
            public void onError(@NonNull Throwable e) {}

            @Override
            public void onComplete() {}
        });
    }

    @OnClick(R.id.randomButton) public void onRandomClicked() {
        mRandomTacoViewModel.onRandomButtonClicked();
    }
}
