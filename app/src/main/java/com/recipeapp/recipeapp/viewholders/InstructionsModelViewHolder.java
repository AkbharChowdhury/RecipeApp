package com.recipeapp.recipeapp.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepItemsBinding;
import com.recipeapp.recipeapp.models.Equipment;
import com.recipeapp.recipeapp.models.InstructionsModel;
import com.recipeapp.recipeapp.utils.ImageHandler;

public class InstructionsModelViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvTitle;
    private final ImageView imageView;


    public InstructionsModelViewHolder(@NonNull ListInstructionsStepItemsBinding binding) {
        super(binding.getRoot());
        tvTitle = binding.tvInstructionsStepItem;
        imageView = binding.imgInstructionsStepItem;
    }

    public void showDetails(InstructionsModel model) {
        tvTitle.setText(model.getTitle());
        if (!model.getImage().isBlank()) ImageHandler.loadImage(model.getImage(), imageView);


    }


}