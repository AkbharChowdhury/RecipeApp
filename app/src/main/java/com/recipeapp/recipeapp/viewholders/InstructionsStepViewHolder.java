package com.recipeapp.recipeapp.viewholders;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.adapters.InstructionsModelAdapter;
import com.recipeapp.recipeapp.databinding.ListInstructionsStepsBinding;
import com.recipeapp.recipeapp.models.InstructionsModel;
import com.recipeapp.recipeapp.models.Step;

import java.text.MessageFormat;
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
        tvStepNum.setText( formatStepNumber(step.getNumber(), "."));
        tvTitle.setText(step.getStep());
        binding.tvIngredient.setVisibility(step.getIngredients().isEmpty() ? RecyclerView.GONE : RecyclerView.VISIBLE);
        binding.tvEquipment.setVisibility(step.getEquipment().isEmpty() ? RecyclerView.GONE : RecyclerView.VISIBLE);

        String ingredientImageUrl = context.getString(R.string.ingredient_img_url);

        List<InstructionsModel> ingredientsModel = step.getIngredients().stream().map(ingredient -> new InstructionsModel(ingredient.getName(), ingredientImageUrl + ingredient.getImage())).collect(Collectors.toList());
        List<InstructionsModel> equipmentModel = step.getEquipment().stream().map(equipment -> new InstructionsModel(equipment.getName(), equipment.getImage())).collect(Collectors.toList());

        createRecyclerView(binding.recyclerInstructionIngredients, ingredientsModel);
        createRecyclerView(binding.recyclerInstructionEquipment, equipmentModel);
    }

    private String formatStepNumber(Number number, String style) {
        return number.toString() + style;
    }

    private void createRecyclerView(RecyclerView recyclerView, List<InstructionsModel> list) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new InstructionsModelAdapter(list));
    }


}