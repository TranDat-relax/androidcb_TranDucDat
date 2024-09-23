package com.example.maytinh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
    }
    public void onDigitClick(View view) {
        Button button = (Button) view;
        input.append(button.getText().toString());
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(input.getText().toString());
            performCalculation();
        } else {
            valueOne = Double.parseDouble(input.getText().toString());
        }
        CURRENT_ACTION = button.getText().toString().charAt(0);
        input.setText("");
    }

    public void onEqualClick(View view) {
        valueTwo = Double.parseDouble(input.getText().toString());
        performCalculation();
        input.setText(String.valueOf(valueOne));
        valueOne = Double.NaN;
    }

    public void onClearClick(View view) {
        input.setText("");
        valueOne = Double.NaN;
        valueTwo = 0;
    }

    private void performCalculation() {
        switch (CURRENT_ACTION) {
            case '+':
                valueOne = valueOne + valueTwo;
                break;
            case '-':
                valueOne = valueOne - valueTwo;
                break;
            case '*':
                valueOne = valueOne * valueTwo;
                break;
            case '/':
                if (valueTwo != 0) {
                    valueOne = valueOne / valueTwo;
                }
                break;
        }
    }

}