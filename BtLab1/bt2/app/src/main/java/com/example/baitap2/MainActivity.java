package com.example.baitap2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
     TextView txtRandomNumber;
     ImageView imgDice;
     Button btnGenerate;
    Random random;
    private void initcontrol(){
        txtRandomNumber = findViewById(R.id.txtRandomNumber);
        imgDice = findViewById(R.id.imgDice);
        btnGenerate = findViewById(R.id.btnGenerate);
        random = new Random();
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = random.nextInt(6) + 1;
                txtRandomNumber.setText(String.valueOf(randomNumber));
                switch (randomNumber) {
                    case 1:
                        imgDice.setImageResource(R.drawable.xs1);
                        break;
                    case 2:
                        imgDice.setImageResource(R.drawable.xs2);
                        break;
                    case 3:
                        imgDice.setImageResource(R.drawable.xs3);
                        break;
                    case 4:
                        imgDice.setImageResource(R.drawable.xs4);
                        break;
                    case 5:
                        imgDice.setImageResource(R.drawable.xs5);
                        break;
                    case 6:
                        imgDice.setImageResource(R.drawable.xs6);
                        break;
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initcontrol();
        };
    }