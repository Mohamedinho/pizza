package com.example.pizzaapp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.service.RecipeManager;
import com.example.pizzaapp.R;

import java.util.Locale;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        long id = getIntent().getLongExtra("recipe_id", -1);
        Pizza pizza = RecipeManager.getInstance().findById(id);

        ImageView pizzaImage = findViewById(R.id.img_recipe_banner);
        TextView pizzaTitle = findViewById(R.id.txt_recipe_title);
        TextView pizzaInfo = findViewById(R.id.txt_recipe_meta);
        TextView pizzaIngredients = findViewById(R.id.txt_recipe_ingredients);
        TextView pizzaDescription = findViewById(R.id.txt_recipe_description);
        RatingBar ratingBar = findViewById(R.id.detail_rating_bar);
        Button btnOrder = findViewById(R.id.btn_order);

        if (pizza != null) {
            pizzaImage.setImageResource(pizza.getImageRes());
            pizzaTitle.setText(pizza.getName());
            pizzaInfo.setText(String.format(Locale.getDefault(), "%s • %.2f €", pizza.getDuration(), pizza.getPrice()));
            pizzaIngredients.setText(pizza.getIngredients());
            pizzaDescription.setText(pizza.getDescription());
            if (ratingBar != null) ratingBar.setRating(pizza.getRating());

            if (btnOrder != null) {
                btnOrder.setOnClickListener(v -> {
                    Toast.makeText(this, "Commande envoyée pour " + pizza.getName() + " ! 🍕", Toast.LENGTH_LONG).show();
                });
            }
        }
    }
}
