package com.recipeapp.recipeapp.listeners;

import com.recipeapp.recipeapp.models.InstructionsResponse;
import com.recipeapp.recipeapp.models.RecipeDetailsResponse;

import java.util.List;

public interface IinstructionsListener extends IError {
    void didFetch(List<InstructionsResponse> response, String message);
}
