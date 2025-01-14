package com.recipeapp.recipeapp.interface_listeners;

import com.recipeapp.recipeapp.models.RecipeDetailsResponse;

public interface IRecipeDetailsListener extends IError {
    void didFetch(RecipeDetailsResponse response, String message);
}
