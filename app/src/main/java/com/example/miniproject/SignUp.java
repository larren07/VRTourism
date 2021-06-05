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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {


    public static final String TAG = "TAG";
    private EditText email,pass,conPass;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button submit = findViewById(R.id.signUpButton);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        email = findViewById(R.id.name);
        pass = findViewById(R.id.signUpPassword);
        conPass = findViewById(R.id.signUpConfirmPassword);

        TextView signInPage = findViewById(R.id.signInPage);

        signInPage.setOnClickListener(v->{
            Intent intent = new Intent(SignUp.this , MainActivity.class);
            startActivity(intent);
            finish();
        });

        submit.setOnClickListener(v ->{
            String Email = email.getText().toString();
            String Pass = pass.getText().toString();
            String ConPass = conPass.getText().toString();
            String name = "";
            String age = "";
            String preference = "";


            if(TextUtils.isEmpty(Email)){
                Toast.makeText(this,"Enter the email Address", Toast.LENGTH_SHORT).show();
            }else if(TextUtils.isEmpty(Pass)){
                Toast.makeText(this,"Enter the password", Toast.LENGTH_SHORT).show();
            }else if( !Pass.equals(ConPass)){
                Toast.makeText(this,"Password and Confirm Password Doesn't Match", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            userID = mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("name",name);
                            user.put("age",age);
                            user.put("preference",preference);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"onSuccess: user Profile is created for " + userID);
                                }
                            });


                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(SignUp.this, "Sign-Up Done" , Toast.LENGTH_SHORT).show();
                        }else{
                            String error = task.getException().getMessage();
                            Toast.makeText(SignUp.this,error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });




    }
}