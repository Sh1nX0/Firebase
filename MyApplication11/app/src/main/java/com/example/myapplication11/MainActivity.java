package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity  {

    private EditText Email;
    private EditText password;
    private Button Btn;
    private TextView Registr;
    private TextView zabilpassword;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        Btn = findViewById(R.id.button);
        Registr = findViewById(R.id.text1);
        zabilpassword = findViewById(R.id.text2);

        auth = FirebaseAuth.getInstance();

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailstr = Email.getText().toString();
                String passStr = password.getText().toString();
                if (!emailstr.isEmpty() && !passStr.isEmpty()) {
                    auth.signInWithEmailAndPassword(emailstr.trim(), passStr.trim())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity.this, imbActivity.class));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NotNull Exception e) {
                                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                                }
                            });
                }
                else Toast.makeText(MainActivity.this, "Email field is empty", Toast.LENGTH_SHORT).show();
            }
        });


        Registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });
        zabilpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Email.getText().toString().isEmpty())  {
                    auth.sendPasswordResetEmail(Email.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(MainActivity.this, "Email send", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(Exception e) {
                                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                else Toast.makeText(MainActivity.this, "Email field is empty", Toast.LENGTH_SHORT).show();


            }
        });
    }
}