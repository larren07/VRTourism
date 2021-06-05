package com.example.miniproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApi {

    @GET("videoname")
    Call<List<VideoName>> getVideoNames(@Query("title") String search);
}
