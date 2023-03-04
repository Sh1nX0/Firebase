package com.example.myapplication11;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class imbActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout manlayout2;
    private Layout womanlayout;
    private float  result;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private Button btnCalc;
    private LinearLayout lman;
    private LinearLayout lwoman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imb);

        edit1 = findViewById(R.id.Edit1);
        manlayout2 = findViewById(R.id.manlayout);
        edit2 = findViewById(R.id.Edit2);
        edit3 = findViewById(R.id.Edit3);

        btnCalc = findViewById(R.id.Button1);
        lman = findViewById(R.id.manlayout);
        lwoman = findViewById(R.id.womanlayout);

        btnCalc.setOnClickListener(this);
        lman.setOnClickListener(this);
        lwoman.setOnClickListener(this);



    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Button1:
                int ves = Integer.parseInt(edit1.getText().toString());
                int rost = Integer.parseInt(edit2.getText().toString());
                int age = Integer.parseInt(edit3.getText().toString());
                result = ves/((rost/100f)*(rost/100f));
                Intent intent = new Intent();
                intent.setClass(imbActivity.this,ResultActivity.class);
                intent.putExtra("res",result);
                intent.putExtra("age",age);
                startActivity(intent);
                break;
            case R.id.manlayout:
                lman.setBackgroundColor(Color.RED);
                lwoman.setBackgroundColor(Color.TRANSPARENT);
                break;
            case R.id.womanlayout:
                lwoman.setBackgroundColor(Color.BLUE);
                lman.setBackgroundColor(Color.TRANSPARENT);
                break;
        }
    }
}