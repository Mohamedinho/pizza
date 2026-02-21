package com.example.pizzaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzaapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logo = findViewById(R.id.img_logo);
        
        // Petite animation de fondu pour le logo
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeIn.setDuration(2000);
        logo.startAnimation(fadeIn);

        // Délai de 10 secondes (10000ms) avant de passer à la liste
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, RecipeListActivity.class);
            startActivity(intent);
            finish();
        }, 10000);
    }
}
