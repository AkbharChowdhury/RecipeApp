package com.recipeapp.recipeapp.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepItemsBinding;
import com.recipeapp.recipeapp.models.Ingredient;
import com.recipeapp.recipeapp.utils.ImageHandler;
import com.squareup.picasso.Picasso;

public class InstructionsIngredientViewHolder extends RecyclerView.ViewHolder {

    private TextView tvInstruction;
    private ImageView imageView;
    private ListInstructionsStepItemsBinding binding;

    public InstructionsIngredientViewHolder(@NonNull ListInstructionsStepItemsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        imageView = binding.imgInstructionsStepItem;
        tvInstruction = binding.tvInstructionsStepItem;
    }

    public void showDetails(Ingredient ingredient) {
        tvInstruction.setText(ingredient.getName());
        tvInstruction.setSelected(true);
        ImageHandler.loadImage(binding.getRoot().getContext().getString(R.string.ingredient_img_url) + ingredient.getImage(), imageView);
    }




}