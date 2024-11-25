package com.example.bmi_calc;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText, heightEditText;
    private TextView bmiResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        bmiResultTextView = findViewById(R.id.bmi_result);
        Button calculateButton = findViewById(R.id.calculate_button);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(v -> calculateBMI());
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void calculateBMI() {
        // Get input values
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        // Validate inputs
        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert inputs to double
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        // Check for valid height value (height must be greater than 0)
        if (height <= 0) {
            Toast.makeText(MainActivity.this, "Height must be greater than zero", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calculate BMI: BMI = weight / (height * height)
        double bmi = weight / (height * height);

        // Display BMI result
        bmiResultTextView.setText("BMI: " + String.format("%.2f", bmi));
    }
}
