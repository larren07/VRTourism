package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RecommendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        TextView place = findViewById(R.id.input);

        Button recommend = findViewById(R.id.recommend);
        recommend.setOnClickListener(v->{

            String Place = place.getText().toString();
            Intent intent = new Intent(RecommendActivity.this,ListActivity.class);
            intent.putExtra("keyPlace", Place);
            startActivity(intent);
            finish();
        });

        Button back = findViewById(R.id.back2);
        back.setOnClickListener(v->{
            Intent intent1 = new Intent(RecommendActivity.this,HomeActivity.class);
            startActivity(intent1);
            finish();
        });

        Button search = findViewById(R.id.search);
        search.setOnClickListener(v->{
            String s = place.getText().toString();
            Intent intent1 = new Intent(RecommendActivity.this, SearchActivity.class);
            intent1.putExtra("keySearch",s);
            startActivity(intent1);
            finish();


        });


    }
}