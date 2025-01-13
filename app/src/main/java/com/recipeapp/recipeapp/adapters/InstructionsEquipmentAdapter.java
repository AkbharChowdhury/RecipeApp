package com.recipeapp.recipeapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.databinding.ListInstructionsStepItemsBinding;
import com.recipeapp.recipeapp.models.Equipment;
import com.recipeapp.recipeapp.viewholders.InstructionsEquipmentViewHolder;

import java.util.ArrayList;

public class InstructionsEquipmentAdapter extends RecyclerView.Adapter<InstructionsEquipmentViewHolder> {

    private final ArrayList<Equipment> list;

    public InstructionsEquipmentAdapter(ArrayList<Equipment> list) {
        this.list = list;

    }
    @NonNull
    @Override
    public InstructionsEquipmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsEquipmentViewHolder(ListInstructionsStepItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsEquipmentViewHolder holder, int position) {
        holder.showDetails(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

