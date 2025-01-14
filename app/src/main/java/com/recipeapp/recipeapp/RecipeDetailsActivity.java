package com.recipeapp.recipeapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.adapters.IngredientsAdapter;
import com.recipeapp.recipeapp.adapters.InstructionsAdapter;
import com.recipeapp.recipeapp.adapters.SimilarRecipeAdapter;
import com.recipeapp.recipeapp.databinding.ActivityRecipeDetailsBinding;
import com.recipeapp.recipeapp.listeners.IRecipeDetailsListener;
import com.recipeapp.recipeapp.listeners.ISimilarRecipesListener;
import com.recipeapp.recipeapp.listeners.IinstructionsListener;
import com.recipeapp.recipeapp.models.InstructionsResponse;
import com.recipeapp.recipeapp.models.RecipeDetailsResponse;
import com.recipeapp.recipeapp.models.SimilarRecipeResponse;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class RecipeDetailsActivity extends AppCompatActivity {
    ActivityRecipeDetailsBinding binding;

    RequestManager requestManager;
    ProgressDialog dialog;
    Context context;

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        init();

        var toolbar = binding.myToolBar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        requestManager = new RequestManager(this);
        requestManager.getRecipeDetails(recipeDetailsListener, getId());
        requestManager.getSimilarRecipes(similarRecipesListener, getId());
        requestManager.getInstructions(instructionsListener, getId());

        dialog = new ProgressDialog(this);
        dialog.setTitle(getString(R.string.loading_details));
        dialog.show();
    }




    ISimilarRecipesListener similarRecipesListener = new ISimilarRecipesListener() {
        @Override
        public void didFetch(List<SimilarRecipeResponse> response, String message) {
            RecyclerView recyclerView = binding.recyclerMealSimilar;
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new SimilarRecipeAdapter(response, (id) -> startActivity(new Intent(context, RecipeDetailsActivity.class).putExtra("id", id))));
        }

        @Override
        public void didError(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    };

    IRecipeDetailsListener recipeDetailsListener = new IRecipeDetailsListener() {
        @Override
        public void didFetch(RecipeDetailsResponse response, String message) {

            dialog.dismiss();
            populateMeal(response);
            Picasso.get()
                    .load(response.getImage())
                    .into(binding.imgMeal);

            RecyclerView recyclerView = binding.recyclerMealIngredients;
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new IngredientsAdapter(response.getExtendedIngredients()));
        }

        private void populateMeal(RecipeDetailsResponse response) {
            binding.tvMealName.setText(response.getTitle());
            binding.tvMealSource.setText(response.getSourceName());
            binding.tvMealSummary.setText(response.getSummary());
        }

        @Override
        public void didError(String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    };

    private int getId() {
        return Integer.parseInt(Objects.requireNonNull(getIntent().getStringExtra("id")));
    }


    private void init() {
        binding = ActivityRecipeDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    IinstructionsListener instructionsListener = new IinstructionsListener() {
        @Override
        public void didFetch(List<InstructionsResponse> response, String message) {
            RecyclerView recyclerView = binding.recyclerMealInstructions;
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(new InstructionsAdapter(response));
        }

        @Override
        public void didError(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    };

}