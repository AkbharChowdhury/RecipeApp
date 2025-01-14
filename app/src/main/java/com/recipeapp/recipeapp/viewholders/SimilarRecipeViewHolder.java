package com.recipeapp.recipeapp.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListSimilarRecipesBinding;
import com.recipeapp.recipeapp.models.SimilarRecipeResponse;
import com.recipeapp.recipeapp.utils.Typography;
import com.squareup.picasso.Picasso;

import java.text.MessageFormat;

public class SimilarRecipeViewHolder extends RecyclerView.ViewHolder {
    private CardView container;

    private TextView tvTitle;
    private TextView tvDescription;

    private ImageView imageView;
    private final Typography typography;
    private final ListSimilarRecipesBinding binding;


    public CardView getContainer() {
        return container;
    }

    public SimilarRecipeViewHolder(@NonNull ListSimilarRecipesBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        container = binding.layout;
        tvTitle = binding.tvTitle;
        imageView = binding.imageView;

        tvDescription = binding.tvDescription;
        typography = new Typography(binding.getRoot().getContext());
    }

    public void showDetails(SimilarRecipeResponse recipe) {
//        https://spoonacular.com/food-api/docs#Show-Images
        final String IMAGE_THUMBNAIL_SIZE = "636x393";
        tvTitle.setText(recipe.getTitle());
        tvTitle.setSelected(true);
        int servings = recipe.getServings();


        String serving = servings == 1 ? "Serves 1 person" : String.valueOf(servings) + " servings";
        String desc = MessageFormat.format("{0} | {1} minutes", serving, String.valueOf(recipe.getReadyInMinutes()));
        tvDescription.setText(desc);
        Picasso.get().load(getImageUrl(recipe, IMAGE_THUMBNAIL_SIZE)).into(imageView);

//        binding.tvServings.setText(serving);
//        binding.tvTime.setText(String.valueOf(recipe.getReadyInMinutes() + " minutes"));


    }

    private String getImageUrl(SimilarRecipeResponse recipe, String imgThumbnailSize) {
        return String.format("https://img.spoonacular.com/recipes/%s-%s.%s", String.valueOf(recipe.getId()), imgThumbnailSize, recipe.getImageType());

    }


}