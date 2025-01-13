package com.recipeapp.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListInstructionsStepItemsBinding;
import com.recipeapp.recipeapp.models.Equipment;
import com.recipeapp.recipeapp.models.InstructionsModel;
import com.recipeapp.recipeapp.viewholders.InstructionsEquipmentViewHolder;
import com.recipeapp.recipeapp.viewholders.InstructionsModelViewHolder;

import java.util.ArrayList;
import java.util.List;

public class InstructionsModelAdapter extends RecyclerView.Adapter<InstructionsModelViewHolder> {

    private final List<InstructionsModel> list;

    public InstructionsModelAdapter(List<InstructionsModel> list) {
        this.list = list;

    }
    @NonNull
    @Override
    public InstructionsModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsModelViewHolder(ListInstructionsStepItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsModelViewHolder holder, int position) {
        holder.showDetails(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

