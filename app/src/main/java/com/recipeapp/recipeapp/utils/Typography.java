package com.recipeapp.recipeapp.utils;

import android.content.Context;

import com.recipeapp.recipeapp.R;

public class Typography {
    private final Context context;

    public Typography(Context context) {
        this.context = context;
    }

    public String iconText(long number, String text) {
        return context.getString(R.string.icon_text, number, text);

    }
    public static String formatStepNumber(Number number, String style) {
        return number.toString() + style;
    }
}
