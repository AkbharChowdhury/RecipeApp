package com.recipeapp.recipeapp.utils;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.recipeapp.recipeapp.R;
import com.recipeapp.recipeapp.models.Tags;

import java.util.List;

public class MySpinner2 {
    private Context context;
    private AutoCompleteTextView autoCompleteTextViewMeal;
    public MySpinner2(Context context, AutoCompleteTextView autoCompleteTextViewMeal) {
        this.context = context;
        this.autoCompleteTextViewMeal = autoCompleteTextViewMeal;
    }
    public void configAdapter(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, R.layout.dropdown_item, Tags.getTags(context));
        arrayAdapter.setDropDownViewResource(R.layout.spinner_inner_text);
        autoCompleteTextViewMeal.setAdapter(arrayAdapter);
    }
    public String getItem(int position){
        return autoCompleteTextViewMeal.getAdapter().getItem(position).toString();
    }

    public void setText(String text) {
        autoCompleteTextViewMeal.setText(text, false);
    }
}
