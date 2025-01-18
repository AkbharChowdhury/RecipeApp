package com.recipeapp.recipeapp.utils;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.recipeapp.recipeapp.R;

import java.util.List;

public class MySpinner {
    private Context context;
    private Spinner spinner;

    public MySpinner(Context context, Spinner spinner) {
        this.context = context;
        this.spinner = spinner;
    }



    public void initSpinner(List<String> meals, AdapterView.OnItemSelectedListener spinnerSelectedListener){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_text, meals);
        adapter.setDropDownViewResource(R.layout.spinner_inner_text);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(spinnerSelectedListener);
    }
}
