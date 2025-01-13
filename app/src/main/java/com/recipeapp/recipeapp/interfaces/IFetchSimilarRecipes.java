package com.recipeapp.recipeapp.interfaces;

import com.recipeapp.recipeapp.models.SimilarRecipeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IFetchSimilarRecipes {
    @GET("recipes/{id}/similar")
    Call<List<SimilarRecipeResponse>> fetchSimilarRecipes(
            @Path("id") int id,
            @Query("number") String number,
            @Query("apiKey") String apiKey
    );

}
