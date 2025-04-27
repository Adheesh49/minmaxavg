package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Clear any default text in EditText fields
        EditText et1 = (EditText) findViewById(R.id.FirstNumber);
        EditText et2 = (EditText) findViewById(R.id.SecondNumber);
        EditText et3 = (EditText) findViewById(R.id.ThirdNumber);
        et1.setText("");
        et2.setText("");
        et3.setText("");
    }

    // Helper method to check if a string is a valid number
    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        // Check if the string matches a number pattern (allows decimals)
        return str.matches("-?\\d*\\.?\\d+");
    }

    public void Min(View v) {
        EditText et1 = (EditText) findViewById(R.id.FirstNumber);
        EditText et2 = (EditText) findViewById(R.id.SecondNumber);
        EditText et3 = (EditText) findViewById(R.id.ThirdNumber);
        TextView tv = (TextView) findViewById(R.id.txtOutput);

        String num1Str = et1.getText().toString().trim();
        String num2Str = et2.getText().toString().trim();
        String num3Str = et3.getText().toString().trim();

        // Check for empty or invalid inputs
        if (num1Str.isEmpty() || num2Str.isEmpty() || num3Str.isEmpty()) {
            tv.setText("Output: Please enter all numbers");
            return;
        }

        if (!isNumeric(num1Str) || !isNumeric(num2Str) || !isNumeric(num3Str)) {
            tv.setText("Output: Please enter valid numbers");
            return;
        }

        double n1 = Double.parseDouble(num1Str);
        double n2 = Double.parseDouble(num2Str);
        double n3 = Double.parseDouble(num3Str);

        double min = n1;
        if (n2 < min) min = n2;
        if (n3 < min) min = n3;

        tv.setText("Output: Min = " + min);
    }

    public void Max(View v) {
        EditText et1 = (EditText) findViewById(R.id.FirstNumber);
        EditText et2 = (EditText) findViewById(R.id.SecondNumber);
        EditText et3 = (EditText) findViewById(R.id.ThirdNumber);
        TextView tv = (TextView) findViewById(R.id.txtOutput);

        String num1Str = et1.getText().toString().trim();
        String num2Str = et2.getText().toString().trim();
        String num3Str = et3.getText().toString().trim();

        // Check for empty or invalid inputs
        if (num1Str.isEmpty() || num2Str.isEmpty() || num3Str.isEmpty()) {
            tv.setText("Output: Please enter all numbers");
            return;
        }

        if (!isNumeric(num1Str) || !isNumeric(num2Str) || !isNumeric(num3Str)) {
            tv.setText("Output: Please enter valid numbers");
            return;
        }

        double n1 = Double.parseDouble(num1Str);
        double n2 = Double.parseDouble(num2Str);
        double n3 = Double.parseDouble(num3Str);

        double max = n1;
        if (n2 > max) max = n2;
        if (n3 > max) max = n3;

        tv.setText("Output: Max = " + max);
    }

    public void Average(View v) {
        EditText et1 = (EditText) findViewById(R.id.FirstNumber);
        EditText et2 = (EditText) findViewById(R.id.SecondNumber);
        EditText et3 = (EditText) findViewById(R.id.ThirdNumber);
        TextView tv = (TextView) findViewById(R.id.txtOutput);

        String num1Str = et1.getText().toString().trim();
        String num2Str = et2.getText().toString().trim();
        String num3Str = et3.getText().toString().trim();

        // Check for empty or invalid inputs
        if (num1Str.isEmpty() || num2Str.isEmpty() || num3Str.isEmpty()) {
            tv.setText("Output: Please enter all numbers");
            return;
        }

        if (!isNumeric(num1Str) || !isNumeric(num2Str) || !isNumeric(num3Str)) {
            tv.setText("Output: Please enter valid numbers");
            return;
        }

        double n1 = Double.parseDouble(num1Str);
        double n2 = Double.parseDouble(num2Str);
        double n3 = Double.parseDouble(num3Str);

        double average = (n1 + n2 + n3) / 3;

        tv.setText("Output: Average = " + average);
    }
}