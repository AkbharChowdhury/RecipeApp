package com.recipeapp.recipeapp.interfaces;

import com.recipeapp.recipeapp.models.InstructionsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Iinstructions {
    @GET("recipes/{id}/analyzedInstructions")
    Call<List<InstructionsResponse>> getInstructions(
            @Path("id") int id,
            @Query("apiKey") String apiKey
    );

}
