package com.example.retrofit_fetchdata;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {
    @GET("users")
    Call<List<Mymodule>> getdata();
}
