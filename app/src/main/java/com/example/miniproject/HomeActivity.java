package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        TextView SignOut = findViewById(R.id.signOut);
        SignOut.setOnClickListener(v->{

            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signOut();

            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        TextView Browse = findViewById(R.id.browse);
        Browse.setOnClickListener(v->{
            Intent intent1 = new Intent(HomeActivity.this,BrowseActivity.class);
            startActivity(intent1);
            finish();
        });

        TextView Profile = findViewById(R.id.profile);
        Profile.setOnClickListener(v->{
            Intent intent2 = new Intent(HomeActivity.this,ProfileActivity.class);
            startActivity(intent2);
            finish();
        });

        Button Recommend = findViewById(R.id.Recommend);
        Recommend.setOnClickListener(v->{
            Intent intent3 = new Intent(HomeActivity.this,RecommendActivity.class);
            startActivity(intent3);
            finish();
        });
    }
}