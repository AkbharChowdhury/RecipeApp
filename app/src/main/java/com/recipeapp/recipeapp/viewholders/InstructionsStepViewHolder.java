package com.recipeapp.recipeapp.viewholders;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.adapters.InstructionsEquipmentAdapter;
import com.recipeapp.recipeapp.adapters.InstructionsIngredientAdapter;
import com.recipeapp.recipeapp.adapters.InstructionsModelAdapter;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepsBinding;
import com.recipeapp.recipeapp.models.Equipment;
import com.recipeapp.recipeapp.models.Ingredient;
import com.recipeapp.recipeapp.models.InstructionsModel;
import com.recipeapp.recipeapp.models.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        String ingredientImageUrl = getImageUrl(R.string.ingredient_img_url);
        String equipmentImageUrl = binding.getRoot().getContext().getString(R.string.equipment_img_url);
        Log.d("IMAGE_I", equipmentImageUrl);


        List<InstructionsModel> ingredientsModel = step.getIngredients().stream().map(ingredient -> new InstructionsModel(ingredient.getName(), ingredientImageUrl + ingredient.getImage())).collect(Collectors.toList());
        List<InstructionsModel> equipmentModel = step.getEquipment().stream().map(equipment -> new InstructionsModel(equipment.getName(), equipment.getImage())).collect(Collectors.toList());

        List<String> equipmentImages = step.getEquipment().stream().map(equipment ->  equipment.getImage()).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("Equipments:").append(System.lineSeparator());
        equipmentImages.forEach(s -> sb.append(s).append(System.lineSeparator()));

        Log.d("Equipment_Images", sb.toString());
        createRecyclerView(binding.recyclerInstructionIngredients, ingredientsModel);
        createRecyclerView(binding.recyclerInstructionEquipment, equipmentModel);

    }

    private String getImageUrl(int resID) {
        return binding.getRoot().getContext().getString(resID);

    }

    private void createRecyclerView(RecyclerView recyclerView, List<InstructionsModel> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new InstructionsModelAdapter(list));

    }

//    private void recyclerViewEquipment(ArrayList<Equipment> equipments) {
//        RecyclerView recyclerView = binding.recyclerInstructionEquipment;
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(new InstructionsEquipmentAdapter(equipments));
//    }
//
//    private void recyclerViewIngredients(ArrayList<Ingredient> ingredients) {
//        RecyclerView recyclerView = binding.recyclerInstructionIngredients;
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setAdapter(new InstructionsIngredientAdapter(ingredients));
//
//    }

}