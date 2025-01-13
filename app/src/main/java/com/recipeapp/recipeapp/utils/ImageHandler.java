package com.recipeapp.recipeapp.utils;

import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class ImageHandler {
    public static void loadImage(String imageUrl, ImageView imageView){
            Picasso.get()
                    .load(imageUrl)
                    .into(imageView);


    }
}
