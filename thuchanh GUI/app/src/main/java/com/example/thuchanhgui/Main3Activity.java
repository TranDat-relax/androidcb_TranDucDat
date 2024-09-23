package com.example.thuchanhgui;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText editTextFahrenheit, editTextCelsius;
    private Button buttonConvertToCelsius, buttonConvertToFahrenheit, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        initViews();
        setupEventHandlers();
    }

    private void initViews() {
        // Khởi tạo các views từ layout
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonConvertToCelsius = findViewById(R.id.buttonConvertToCelsius);
        buttonConvertToFahrenheit = findViewById(R.id.buttonConvertToFahrenheit);
        buttonClear = findViewById(R.id.buttonClear);
    }

    private void setupEventHandlers() {

        buttonConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    editTextCelsius.setText(String.format("%.2f", celsius));
                } catch (NumberFormatException e) {
                    Toast.makeText(Main3Activity.this, "Invalid Fahrenheit input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double celsius = Double.parseDouble(editTextCelsius.getText().toString());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    editTextFahrenheit.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException e) {
                    Toast.makeText(Main3Activity.this, "Invalid Celsius input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFahrenheit.setText("");
                editTextCelsius.setText("");
            }
        });
    }
}