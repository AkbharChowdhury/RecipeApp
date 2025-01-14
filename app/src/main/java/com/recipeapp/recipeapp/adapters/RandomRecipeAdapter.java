package com.recipeapp.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListRandomRecipeBinding;
import com.recipeapp.recipeapp.interface_listeners.IRecipeClickListener;
import com.recipeapp.recipeapp.models.Recipe;
import com.recipeapp.recipeapp.viewholders.RandomRecipeViewHolder;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder> {

    private final List<Recipe> list;
    private IRecipeClickListener listener;

    public RandomRecipeAdapter(List<Recipe> list, IRecipeClickListener listener) {
        this.list = list;
        this.listener = listener;
    }



    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(ListRandomRecipeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.populateRecipeCard(list.get(position));
        holder.getRandomListContainer().setOnClickListener(v -> {
            long id = list.get(holder.getAdapterPosition()).getID();
            listener.onRecipeClicked(String.valueOf(id));
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

