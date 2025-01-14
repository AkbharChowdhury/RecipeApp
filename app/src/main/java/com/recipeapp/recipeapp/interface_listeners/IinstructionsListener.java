package com.recipeapp.recipeapp.interface_listeners;

import com.recipeapp.recipeapp.models.InstructionsResponse;

import java.util.List;

public interface IinstructionsListener extends IError {
    void didFetch(List<InstructionsResponse> response, String message);
}
