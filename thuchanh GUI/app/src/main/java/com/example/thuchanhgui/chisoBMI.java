package com.example.thuchanhgui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class chisoBMI extends AppCompatActivity {
    private EditText editTextHeight, editTextWeight, editTextName;
    private TextView textViewBMIResult, textViewDiagnosis;
    private Button buttonCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chiso_bmi);
        editTextName = findViewById(R.id.editTextName);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        textViewBMIResult = findViewById(R.id.textViewBMIResult);
        textViewDiagnosis = findViewById(R.id.textViewDiagnosis);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Hành động khi bấm nút TÍNH BMI
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    // Phương thức tính BMI
    private void calculateBMI() {
        String heightStr = editTextHeight.getText().toString();
        String weightStr = editTextWeight.getText().toString();

        if (TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ chiều cao và cân nặng!", Toast.LENGTH_SHORT).show();
            return;
        }

        double height = Double.parseDouble(heightStr);
        double weight = Double.parseDouble(weightStr);

        if (height <= 0 || weight <= 0) {
            Toast.makeText(this, "Vui lòng nhập giá trị hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tính BMI
        double bmi = weight / (height * height);
        textViewBMIResult.setText("BMI = " + String.format("%.2f", bmi));

        // Chẩn đoán dựa trên giá trị BMI
        String diagnosis;
        if (bmi < 18) {
            diagnosis = "Người gầy";
        } else if (bmi >= 18 && bmi <= 24.9) {
            diagnosis = "Người bình thường";
        } else if (bmi >= 25 && bmi <= 29.9) {
            diagnosis = "Người béo phì độ I";
        } else if (bmi >= 30 && bmi <= 34.9) {
            diagnosis = "Người béo phì độ II";
        } else {
            diagnosis = "Người béo phì độ III";
        }

        textViewDiagnosis.setText("Chẩn đoán: " + diagnosis);
    }
}
