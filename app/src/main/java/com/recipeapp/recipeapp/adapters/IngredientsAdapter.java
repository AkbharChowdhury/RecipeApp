package com.recipeapp.recipeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListMealIngredientsBinding;
import com.recipeapp.recipeapp.models.ExtendedIngredient;
import com.recipeapp.recipeapp.viewholders.IngredientsViewHolder;

import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {

    private final List<ExtendedIngredient> list;

    public IngredientsAdapter(List<ExtendedIngredient> list) {
        this.list = list;

    }


    @NonNull
    @Override
    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new IngredientsViewHolder(ListMealIngredientsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder holder, int position) {
        holder.showDetails(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

