package com.recipeapp.recipeapp.viewholders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.adapters.InstructionsStepAdapter;
import com.recipeapp.recipeapp.databinding.ListInstructionsBinding;
import com.recipeapp.recipeapp.models.InstructionsResponse;

public class InstructionsViewHolder extends RecyclerView.ViewHolder {

    private final ListInstructionsBinding binding;


    public InstructionsViewHolder(@NonNull ListInstructionsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }

    public void showDetails(InstructionsResponse instruction) {
        binding.tvInstructionsName.setText(instruction.getName());
        createRecyclerView(instruction);
    }

    private void createRecyclerView(InstructionsResponse instruction) {
        RecyclerView recyclerView = binding.recyclerInstructionSteps;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new InstructionsStepAdapter(instruction.getSteps()));
    }

}