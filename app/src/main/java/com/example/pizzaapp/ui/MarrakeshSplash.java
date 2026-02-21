package com.example.pizzaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzaapp.R;

public class MarrakeshSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView visual = findViewById(R.id.img_logo);
        Animation animFade = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animFade.setDuration(2500);
        visual.startAnimation(animFade);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(MarrakeshSplash.this, MarrakeshMenu.class));
            finish();
        }, 10000);
    }
}
