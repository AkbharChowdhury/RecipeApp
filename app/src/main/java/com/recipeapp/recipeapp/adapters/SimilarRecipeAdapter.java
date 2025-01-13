package com.recipeapp.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListSimilarRecipeBinding;
import com.recipeapp.recipeapp.listeners.IRecipeClickListener;
import com.recipeapp.recipeapp.models.SimilarRecipeResponse;
import com.recipeapp.recipeapp.viewholders.SimilarRecipeViewHolder;

import java.util.List;

public class SimilarRecipeAdapter extends RecyclerView.Adapter<SimilarRecipeViewHolder> {

    private final List<SimilarRecipeResponse> list;
    private IRecipeClickListener listener;


    public SimilarRecipeAdapter(List<SimilarRecipeResponse> list, IRecipeClickListener listener) {
        this.list = list;
        this.listener = listener;

    }


    @NonNull
    @Override
    public SimilarRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimilarRecipeViewHolder(ListSimilarRecipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarRecipeViewHolder holder, int position) {
        SimilarRecipeResponse recipe = list.get(position);
        holder.showDetails(recipe);
        holder.getContainer().setOnClickListener(v -> listener.onRecipeClicked(String.valueOf(recipe.getId())));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

