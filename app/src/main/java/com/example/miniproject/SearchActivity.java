package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String s = getIntent().getStringExtra("keySearch");

        textViewResult = findViewById(R.id.search_view_result);

        Button back = findViewById(R.id.Back1);
        back.setOnClickListener(v->{
            Intent intent = new Intent(SearchActivity.this, RecommendActivity.class);
            startActivity(intent);
            finish();
        });

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("https://search-li.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SearchApi searchApi = retrofit1.create(SearchApi.class);

        Call<List<VideoName>> call = searchApi.getVideoNames(s);
        call.enqueue(new Callback<List<VideoName>>() {
            @Override
            public void onResponse(Call<List<VideoName>> call, Response<List<VideoName>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<VideoName> videoNames = response.body();

                for(VideoName videoName:videoNames){
                    String content = "";
                    content+=videoName.getVideoName() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<VideoName>> call, Throwable t) {

                textViewResult.setText(t.getMessage());

            }
        });


    }
}