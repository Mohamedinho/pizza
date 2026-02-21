package com.example.pizzaapp.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzaapp.model.MarrakeshItem;
import com.example.pizzaapp.service.MarrakeshService;
import com.example.pizzaapp.R;

import java.util.Locale;

public class MarrakeshVault extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        long refId = getIntent().getLongExtra("target_id", -1);
        MarrakeshItem selection = MarrakeshService.getAccess().getById(refId);

        ImageView mainBanner = findViewById(R.id.img_recipe_banner);
        TextView mainTitle = findViewById(R.id.txt_recipe_title);
        TextView metadata = findViewById(R.id.txt_recipe_meta);
        TextView componentsList = findViewById(R.id.txt_recipe_ingredients);
        TextView briefText = findViewById(R.id.txt_recipe_description);
        RatingBar scoreBar = findViewById(R.id.detail_rating_bar);
        Button orderTrigger = findViewById(R.id.btn_order);

        if (selection != null) {
            mainBanner.setImageResource(selection.getVisualResource());
            mainTitle.setText(selection.getLabel());
            metadata.setText(String.format(Locale.getDefault(), "%s • %.2f €", selection.getPrepTime(), selection.getUnitPrice()));
            componentsList.setText(selection.getComponents());
            briefText.setText(selection.getBriefInfo());
            if (scoreBar != null) scoreBar.setRating(selection.getUserRating());

            orderTrigger.setOnClickListener(v -> {
                Toast.makeText(this, "Envoi de la commande : " + selection.getLabel() + " 🍕🇲🇦", Toast.LENGTH_LONG).show();
            });
        }
    }
}
