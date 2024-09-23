package com.example.thuchanhgui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtSoA, edtSoB;
    TextView tvResult;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;

    private EditText editTextFahrenheit, editTextCelsius;
    private Button buttonConvertToCelsius, buttonConvertToFahrenheit, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        tvResult = findViewById(R.id.tvResult);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnThoat = findViewById(R.id.btnThoat);

        // Sự kiện cho nút Tổng
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());
                int result = a + b;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Sự kiện cho nút Hiệu
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());
                int result = a - b;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Sự kiện cho nút Tích
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());
                int result = a * b;
                tvResult.setText(String.valueOf(result));
            }
        });

        // Sự kiện cho nút Thương
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());
                if (b != 0) {
                    double result = (double) a / b;
                    tvResult.setText(String.valueOf(result));
                } else {
                    Toast.makeText(MainActivity.this, "Số B không được bằng 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Sự kiện cho nút UCLN
        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtSoA.getText().toString());
                int b = Integer.parseInt(edtSoB.getText().toString());
                int result = gcd(a, b);
                tvResult.setText(String.valueOf(result));
            }
        });

        // Sự kiện cho nút Thoát
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Hàm tính UCLN
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


}