package com.recipeapp.recipeapp;

import android.content.Context;

import androidx.annotation.NonNull;

import com.recipeapp.recipeapp.interfaces.IFetchRecipeDetails;
import com.recipeapp.recipeapp.interfaces.IFetchSimilarRecipes;
import com.recipeapp.recipeapp.interfaces.IRecipe;
import com.recipeapp.recipeapp.interfaces.Iinstructions;
import com.recipeapp.recipeapp.listeners.IError;
import com.recipeapp.recipeapp.listeners.IRandomRecipeResponseListener;
import com.recipeapp.recipeapp.listeners.IRecipeDetailsListener;
import com.recipeapp.recipeapp.listeners.ISimilarRecipesListener;
import com.recipeapp.recipeapp.listeners.IinstructionsListener;
import com.recipeapp.recipeapp.models.InstructionsResponse;
import com.recipeapp.recipeapp.models.RandomRecipeApiResponse;
import com.recipeapp.recipeapp.models.RecipeDetailsResponse;
import com.recipeapp.recipeapp.models.SimilarRecipeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    private final int MAX_NUM_RECIPES = 10;
    private final int MAX_NUM_SIMILAR_RECIPES = 5;
    private final String API_KEY;
    private final Context context;
    private final Retrofit retrofit;

    public RequestManager(Context context) {
        this.context = context;
        API_KEY = context.getString(R.string.api_key);
        retrofit = new Retrofit
                .Builder()
                .baseUrl(context.getString(R.string.recipe_base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void showError(IError listener, Throwable throwable) {
        listener.didError(throwable.getMessage());
    }


    public void getRecipeDetails(IRecipeDetailsListener listener, int id) {
        Call<RecipeDetailsResponse> call = retrofit.create(IFetchRecipeDetails.class).fetchRecipeDetails(id, context.getString(R.string.api_key));
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<RecipeDetailsResponse> call, Response<RecipeDetailsResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());

            }

            @Override
            public void onFailure(Call<RecipeDetailsResponse> call, Throwable throwable) {
                showError(listener, throwable);

            }
        });
    }

    public void getRandomRecipes(IRandomRecipeResponseListener listener, List<String> tags) {
        Call<RandomRecipeApiResponse> call = retrofit.create(IRecipe.class).getRandomRecipe(API_KEY, String.valueOf(MAX_NUM_RECIPES), tags);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<RandomRecipeApiResponse> call, @NonNull Response<RandomRecipeApiResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<RandomRecipeApiResponse> call, Throwable throwable) {
                showError(listener, throwable);

            }
        });
    }

    public void getSimilarRecipes(ISimilarRecipesListener listener, int id) {
        Call<List<SimilarRecipeResponse>> call = retrofit.create(IFetchSimilarRecipes.class).fetchSimilarRecipes(id, String.valueOf(MAX_NUM_SIMILAR_RECIPES), API_KEY);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<SimilarRecipeResponse>> call, Response<List<SimilarRecipeResponse>> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());

            }

            @Override
            public void onFailure(Call<List<SimilarRecipeResponse>> call, Throwable throwable) {
                showError(listener, throwable);
            }
        });
    }

    public void getInstructions(IinstructionsListener listener, int id) {
        Call<List<InstructionsResponse>> call = retrofit.create(Iinstructions.class).getInstructions(id, API_KEY);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<InstructionsResponse>> call, Response<List<InstructionsResponse>> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<List<InstructionsResponse>> call, Throwable throwable) {
                showError(listener, throwable);

            }
        });
    }


}


