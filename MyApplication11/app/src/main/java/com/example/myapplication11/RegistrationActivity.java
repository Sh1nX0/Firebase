package com.example.myapplication11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button btnreg;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email=findViewById(R.id.EmailReg);
        password=findViewById(R.id.passwordReg);
        btnreg=findViewById(R.id.btnReg);
        mAuth=FirebaseAuth.getInstance();
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().isEmpty()&& !password.getText().toString().isEmpty()){
                    mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>(){
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                                }

                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(Exception e) {
                                    Toast.makeText(RegistrationActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });
                }else  Toast.makeText(RegistrationActivity.this,"Заполните поля",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
