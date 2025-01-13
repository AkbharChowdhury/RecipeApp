package com.recipeapp.recipeapp.interfaces;

import com.recipeapp.recipeapp.models.RandomRecipeApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRecipe {
    @GET("recipes/random")
    Call<RandomRecipeApiResponse> getRandomRecipe(
            @Query("apiKey") String apiKey,
            @Query("number") String number,
            @Query("include-tags") List<String> tags

    );

}
