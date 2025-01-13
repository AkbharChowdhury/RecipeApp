package com.recipeapp.recipeapp.interfaces;

import com.recipeapp.recipeapp.models.RecipeDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IFetchRecipeDetails {
    @GET("recipes/{id}/information")
    Call<RecipeDetailsResponse> fetchRecipeDetails (
            @Path("id") int id,
            @Query("apiKey") String apiKey
    );

}
