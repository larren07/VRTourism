package com.example.miniproject;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("video")
    Call<List<Post>> getPosts(@Query("title") String Name);



}
