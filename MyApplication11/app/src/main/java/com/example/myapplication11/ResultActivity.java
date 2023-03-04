package com.example.myapplication11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private TextView imtTEXT;
    private TextView normaTEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res);
        imtTEXT = findViewById(R.id.TVBMI);
        normaTEXT = findViewById(R.id.nrBMI);
        Intent intent = getIntent();
        float res = intent.getFloatExtra("res", 0);
        int age = intent.getIntExtra("age", 0);
        imtTEXT.setText(String.valueOf((int) res));
        if (age <= 19) normaTEXT.setText("Норма:18-23");
        if (age >= 19 && age <= 24) normaTEXT.setText("Норма:19-24");
        if (age >= 25 && age <= 34) normaTEXT.setText("Норма:20-25");
        if (age >= 35 && age <= 44) normaTEXT.setText("Норма:21-26");
        if (age >= 45 && age <= 54) normaTEXT.setText("Норма:22-27");
        if (age >= 55 && age <= 64) normaTEXT.setText("Норма:23-28");
        if (age >= 65) normaTEXT.setText("Норма:24-29");
    }
}