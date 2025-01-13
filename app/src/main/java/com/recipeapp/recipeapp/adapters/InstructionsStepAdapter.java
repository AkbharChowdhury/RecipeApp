package com.recipeapp.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListInstructionsStepsBinding;
import com.recipeapp.recipeapp.models.Step;
import com.recipeapp.recipeapp.viewholders.InstructionsStepViewHolder;

import java.util.ArrayList;

public class InstructionsStepAdapter extends RecyclerView.Adapter<InstructionsStepViewHolder> {

    private final ArrayList<Step> list;

    public InstructionsStepAdapter(ArrayList<Step> list) {
        this.list = list;

    }


    @NonNull
    @Override
    public InstructionsStepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsStepViewHolder(ListInstructionsStepsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsStepViewHolder holder, int position) {
        holder.showDetails(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

