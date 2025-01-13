package com.recipeapp.recipeapp.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListSimilarRecipeBinding;
import com.recipeapp.recipeapp.models.SimilarRecipeResponse;
import com.recipeapp.recipeapp.utils.Typography;
import com.squareup.picasso.Picasso;

public class SimilarRecipeViewHolder extends RecyclerView.ViewHolder {
    private CardView container;

    private TextView tvSimilarTitle;
    private TextView tvSimilarServing;

    private ImageView imgSimilar;
    private final Typography typography;


    public CardView getContainer() {
        return container;
    }

    public SimilarRecipeViewHolder(@NonNull ListSimilarRecipeBinding binding) {
        super(binding.getRoot());
        container = binding.layoutContainer;
        tvSimilarTitle = binding.tvSimilarTitle;
        imgSimilar = binding.imgSimilar;
        tvSimilarServing = binding.tvSimilarServing;
        typography = new Typography(binding.getRoot().getContext());
    }

    public void showDetails(SimilarRecipeResponse recipe) {
//        https://spoonacular.com/food-api/docs#Show-Images
        final String IMAGE_THUMBNAIL_SIZE = "636x393";
        tvSimilarTitle.setText(recipe.getTitle());
        tvSimilarTitle.setSelected(true);
        tvSimilarServing.setText(typography.iconText(recipe.getServings(), "Persons"));
        Picasso.get().load(getImageUrl(recipe, IMAGE_THUMBNAIL_SIZE)).into(imgSimilar);
    }

    private String getImageUrl(SimilarRecipeResponse recipe, String imgThumbnailSize) {
        return String.format("https://img.spoonacular.com/recipes/%s-%s.%s", String.valueOf(recipe.getId()), imgThumbnailSize, recipe.getImageType());

    }


}