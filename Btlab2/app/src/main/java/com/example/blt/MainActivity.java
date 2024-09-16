package com.example.blt;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imgview);
        LinearLayout layout = findViewById(R.id.main);
        int[] icons = {R.drawable.ic_penguin, R.drawable.ic_launcher};
        int[] backgroundColors = {R.color.purple_200, R.color.purple_500, R.color.black, R.color.purple_700, R.color.teal_200};

        Random random = new Random();
        int randomIndex = random.nextInt(2);
        imageView.setImageResource(icons[randomIndex]);
        layout.setBackgroundColor(getResources().getColor(backgroundColors[randomIndex]));

        LinearLayout loading = findViewById(R.id.loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setVisibility(View.GONE);
            }
        }, 2000);
    }
}