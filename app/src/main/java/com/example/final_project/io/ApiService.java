package com.example.final_project.io;

import com.example.final_project.User;
import com.example.final_project.io.response.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("users/login")
    Call<UserResponse> postCreateUser(@Body UserResponse userResponse);

    @FormUrlEncoded
    @POST("users/login")
    Call<User> postLogin(
            @Field("email") String name,
            @Field("email") String last_name,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("users")
    Call<ArrayList<User>> getUsers(@Header("Content-Range") String contentRange);
/*
    @FormUrlEncoded
    @POST("upload/photo")
    Call<SimpleResponse> postPhoto(
            @Field("image") String base64,
            @Field("extension") String extension,
            @Field("user_id") String user_id
    );

    @GET("login")
    Call<LoginResponse> getLogin(
            @Query("username") String username,
            @Query("password") String password
    );

    @FormUrlEncoded
    @POST("product")
    Call<SimpleResponse> postNewProduct(
            @Field("code") String code,
            @Field("name") String name,
            @Field("description") String description
    );*/
}
