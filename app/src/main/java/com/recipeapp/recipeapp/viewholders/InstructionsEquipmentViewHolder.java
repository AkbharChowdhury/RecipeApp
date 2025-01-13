package com.recipeapp.recipeapp.viewholders;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepItemsBinding;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepsBinding;
import com.recipeapp.recipeapp.models.Equipment;
import com.recipeapp.recipeapp.utils.ImageHandler;
import com.squareup.picasso.Picasso;

public class InstructionsEquipmentViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvEquipmentdescription;
    private final ImageView imageView;
    private final ListInstructionsStepItemsBinding binding;


    public InstructionsEquipmentViewHolder(@NonNull ListInstructionsStepItemsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        tvEquipmentdescription = binding.tvInstructionsStepItem;
        imageView = binding.imgInstructionsStepItem;

    }

    public void showDetails(Equipment equipment) {
        tvEquipmentdescription.setText(equipment.getName());
        ImageHandler.loadImage(binding.getRoot().getContext().getString(R.string.equipment_img_url), imageView);

    }


}