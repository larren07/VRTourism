package com.example.miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    EditText email,password;
    Button submit;

    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.name);
        password = findViewById(R.id.signUpPassword);
        submit = findViewById(R.id.signUpButton);

        TextView signUpPage = findViewById(R.id.signInPage);

        signUpPage.setOnClickListener(v -> {
            Intent intent = new Intent( MainActivity.this, SignUp.class);
            startActivity(intent);
            finish();
        });

        mAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(v-> {
            String em = email.getText().toString();
            String pass = password.getText().toString();


            if(TextUtils.isEmpty(em)){
                Toast.makeText(this,"Enter Login Email",Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(pass)){
                Toast.makeText(this,"Enter Login Password",Toast.LENGTH_SHORT).show();
            }
            else{

                mAuth.signInWithEmailAndPassword(em,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();




                            Intent logS = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(logS);
                            finish();

                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if(firebaseUser!=null){
            Intent logS = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(logS);
            finish();
        }
    }
}