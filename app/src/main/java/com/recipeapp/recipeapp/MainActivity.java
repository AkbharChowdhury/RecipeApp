package com.recipeapp.recipeapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.recipeapp.recipeapp.adapters.RandomRecipeAdapter;
import com.recipeapp.recipeapp.databinding.ActivityMainBinding;
import com.recipeapp.recipeapp.listeners.IRandomRecipeResponseListener;
import com.recipeapp.recipeapp.models.RandomRecipeApiResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    List<String> tags = new ArrayList<>();
    ActivityMainBinding binding;
    ProgressDialog dialog;
    RequestManager requestManager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        init();
        binding.searchViewHome.setOnQueryTextListener(searchListener);
        dialog = new ProgressDialog(context);
        dialog.setTitle(getString(R.string.loading));
        requestManager = new RequestManager(context);
        initSpinnerTags();
    }

    SearchView.OnQueryTextListener searchListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            addTags(query);
            requestManager.getRandomRecipes(randRecipeResListener, tags);
            dialog.show();
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    AdapterView.OnItemSelectedListener spinnerSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            addTags(parent.getSelectedItem().toString());
            requestManager.getRandomRecipes(randRecipeResListener, tags);
            dialog.show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    void addTags(String text) {
        tags.clear();
        tags.add(text);
    }

    void initSpinnerTags() {
        Spinner spinner = binding.spinnerTags;
        List<String> meals = Arrays.stream(getResources().getStringArray(R.array.tags_array)).sorted().collect(Collectors.toList());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.spinner_text, meals);
        adapter.setDropDownViewResource(R.layout.spinner_inner_text);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(spinnerSelectedListener);
    }

    IRandomRecipeResponseListener randRecipeResListener = new IRandomRecipeResponseListener() {
        @Override
        public void didFetch(RandomRecipeApiResponse response, String message) {
            dialog.dismiss();
            RecyclerView recyclerView = binding.recyclerRandom;
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
            recyclerView.setAdapter(new RandomRecipeAdapter(response.getRecipes(), (id) -> startActivity(new Intent(getApplicationContext(), RecipeDetailsActivity.class).putExtra("id", id))));
        }

        @Override
        public void didError(String message) {
            dialog.dismiss();
            Toast.makeText(getApplicationContext(), "An error has occurred fetching recipes " + message, Toast.LENGTH_LONG).show();
            Log.d("Error_log", "An error has occurred fetching recipes " + message);
        }
    };


    private void init() {
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}