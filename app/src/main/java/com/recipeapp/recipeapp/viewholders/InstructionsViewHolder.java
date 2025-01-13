package com.recipeapp.recipeapp.viewholders;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.adapters.InstructionsStepAdapter;
import com.recipeapp.recipeapp.databinding.ListInstructionsBinding;
import com.recipeapp.recipeapp.models.InstructionsResponse;

public class InstructionsViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView recyclerInstructionSteps;
    private final ListInstructionsBinding binding;


    public InstructionsViewHolder(@NonNull ListInstructionsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        recyclerInstructionSteps = binding.recyclerInstructionSteps;

    }

    public void showDetails(InstructionsResponse instruction) {
        Context context = binding.getRoot().getContext();
        binding.tvInstructionsName.setText(instruction.getName());
        createRecyclerInstructionSteps(context, instruction);
    }

    private void createRecyclerInstructionSteps(Context context, InstructionsResponse instruction) {
        recyclerInstructionSteps.setHasFixedSize(true);
        recyclerInstructionSteps.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerInstructionSteps.setAdapter(new InstructionsStepAdapter(instruction.getSteps()));
    }

}