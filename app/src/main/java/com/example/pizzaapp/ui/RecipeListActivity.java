package com.example.pizzaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzaapp.R;
import com.example.pizzaapp.adapter.PizzaRecipeAdapter;
import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.service.RecipeManager;
import java.util.List;

public class RecipeListActivity extends AppCompatActivity {

    private PizzaRecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_recipe_list);

            ListView listView = findViewById(R.id.lv_recipe_list);
            SearchView searchView = findViewById(R.id.search_view);

            List<Pizza> recipes = RecipeManager.getInstance().findAll();
            adapter = new PizzaRecipeAdapter(this, recipes);
            listView.setAdapter(adapter);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.filter(newText);
                    return true;
                }
            });

            listView.setOnItemClickListener((parent, view, position, id) -> {
                Pizza selectedPizza = (Pizza) adapter.getItem(position);
                Intent intent = new Intent(RecipeListActivity.this, RecipeDetailActivity.class);
                intent.putExtra("recipe_id", selectedPizza.getId());
                startActivity(intent);
            });
        } catch (Exception e) {
            Log.e("RecipeList", "Error: " + e.getMessage());
        }
    }
}
