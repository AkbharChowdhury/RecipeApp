package com.recipeapp.recipeapp.models;

import android.content.Context;

import com.recipeapp.recipeapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tags {
    public static List<String> getTags(Context context){
        return  Arrays.stream(context.getResources().getStringArray(R.array.tags_array)).sorted().collect(Collectors.toList());
    }
}
