package com.recipeapp.recipeapp.viewholders;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.adapters.InstructionsEquipmentAdapter;
import com.recipeapp.recipeapp.adapters.InstructionsIngredientAdapter;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepsBinding;
import com.recipeapp.recipeapp.models.Equipment;
import com.recipeapp.recipeapp.models.Ingredient;
import com.recipeapp.recipeapp.models.Step;

import java.util.ArrayList;

public class InstructionsStepViewHolder extends RecyclerView.ViewHolder {

    private final TextView tvTitle;
    private final TextView tvStepNum;
    private final Context context;
    private final ListInstructionsStepsBinding binding;


    public InstructionsStepViewHolder(@NonNull ListInstructionsStepsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        context = binding.getRoot().getContext();
        tvTitle = binding.tvInstructionsStepTitle;
        tvStepNum = binding.tvInstructionsStepNumber;


    }

    public void showDetails(Step step) {
        tvStepNum.setText(String.valueOf(step.getNumber()));
        tvTitle.setText(step.getStep());
        binding.tvIngredient.setVisibility(step.getIngredients().isEmpty() ? RecyclerView.GONE : RecyclerView.VISIBLE);
        binding.tvEquipment.setVisibility(step.getEquipment().isEmpty() ? RecyclerView.GONE : RecyclerView.VISIBLE);
        recyclerViewIngredients(step.getIngredients());
        recyclerViewEquipment(step.getEquipment());

    }

    private void recyclerViewEquipment(ArrayList<Equipment> equipments) {
        RecyclerView recyclerView = binding.recyclerInstructionEquipment;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new InstructionsEquipmentAdapter(equipments));
    }

    private void recyclerViewIngredients(ArrayList<Ingredient> ingredients) {
        RecyclerView recyclerView = binding.recyclerInstructionIngredients;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new InstructionsIngredientAdapter(ingredients));

    }

}