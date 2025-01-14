package com.recipeapp.recipeapp.interface_listeners;

import com.recipeapp.recipeapp.models.SimilarRecipeResponse;

import java.util.List;

public interface ISimilarRecipesListener extends IError {
    void didFetch(List<SimilarRecipeResponse> response, String message);
}
