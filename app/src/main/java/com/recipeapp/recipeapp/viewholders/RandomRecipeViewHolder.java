package com.recipeapp.recipeapp.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListRandomRecipeBinding;
import com.recipeapp.recipeapp.models.Recipe;
import com.recipeapp.recipeapp.utils.Typography;
import com.squareup.picasso.Picasso;

public class RandomRecipeViewHolder extends RecyclerView.ViewHolder {
    private final Typography typography;
    public CardView getRandomListContainer() {
        return randomListContainer;
    }

    private CardView randomListContainer;
    private TextView tvTitle;
    private TextView tvServings;
    private TextView tvLikes;
    private TextView tvTime;
    private ImageView imgFood;

    public RandomRecipeViewHolder(@NonNull ListRandomRecipeBinding binding) {
        super(binding.getRoot());
        randomListContainer =  binding.randomListContainer;
        tvTitle =  binding.tvTitle;
        tvServings = binding.tvServings;
        tvLikes = binding.tvLikes;
        tvTime = binding.tvTime;
        imgFood = binding.imgFood;
        typography = new Typography(binding.getRoot().getContext());
    }

    public void populateRecipeCard(Recipe recipe){
        tvTitle.setText(recipe.getTitle());
        tvTitle.setSelected(true);
        tvLikes.setText(typography.iconText(recipe.getAggregateLikes(),"Likes"));
        tvServings.setText(typography.iconText(recipe.getServings(),"Servings"));
        tvTime.setText(typography.iconText(recipe.getReadyInMinutes(),"Minutes"));
        Picasso.get().load(recipe.getImage()).into(imgFood);
    }

}