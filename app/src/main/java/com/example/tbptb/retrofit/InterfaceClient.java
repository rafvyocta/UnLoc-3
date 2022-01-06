package com.example.tbptb.retrofit;

import com.example.tbptb.modul.AuthClass;
import com.example.tbptb.modul.MessageClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceClient {
    @FormUrlEncoded
    @POST("/login")
    Call<AuthClass> menu_utama(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("/register")
    Call<MessageClass> daftar(@Field("nama") String nama, @Field("username") String username, @Field("email") String email, @Field("no_hp") String no_hp, @Field("password") String password);
}
