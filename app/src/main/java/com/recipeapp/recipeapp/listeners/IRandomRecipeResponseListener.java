package com.recipeapp.recipeapp.listeners;

import com.recipeapp.recipeapp.models.RandomRecipeApiResponse;
public interface IRandomRecipeResponseListener extends  IError {
    void didFetch(RandomRecipeApiResponse response, String message);
}
