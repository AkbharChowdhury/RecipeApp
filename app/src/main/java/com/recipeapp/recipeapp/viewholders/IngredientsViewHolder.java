package com.recipeapp.recipeapp.viewholders;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.databinding.ListMealIngredientsBinding;
import com.recipeapp.recipeapp.models.ExtendedIngredient;
import com.squareup.picasso.Picasso;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvIngredientsQty;
    private TextView tvIngredientsName;

    private ImageView imgIngredients;
    private final ListMealIngredientsBinding binding;

    public IngredientsViewHolder(@NonNull ListMealIngredientsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        tvIngredientsName = binding.tvIngredientsName;
        tvIngredientsQty = binding.tvIngredientsQty;
        imgIngredients = binding.imgIngredients;

    }

    public void showDetails(ExtendedIngredient ingredient) {

        tvIngredientsName.setText(ingredient.getName());
        tvIngredientsName.setSelected(true);
        tvIngredientsQty.setSelected(true);
        tvIngredientsQty.setText(ingredient.getOriginal());
        String imgUrl = binding.getRoot().getContext().getString(R.string.ingredient_img_url);
        Picasso.get()
                .load(imgUrl + ingredient.getImage())
                .into(imgIngredients);


    }

}