package com.recipeapp.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListInstructionsStepItemsBinding;
import com.recipeapp.recipeapp.models.Ingredient;
import com.recipeapp.recipeapp.viewholders.InstructionsIngredientViewHolder;

import java.util.ArrayList;

public class InstructionsIngredientAdapter extends RecyclerView.Adapter<InstructionsIngredientViewHolder> {

    private final ArrayList<Ingredient> list;

    public InstructionsIngredientAdapter(ArrayList<Ingredient> list) {
        this.list = list;

    }


    @NonNull
    @Override
    public InstructionsIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsIngredientViewHolder(ListInstructionsStepItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsIngredientViewHolder holder, int position) {
        holder.showDetails(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

