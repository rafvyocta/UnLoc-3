package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tbptb.modul.MessageClass;
import com.example.tbptb.retrofit.InterfaceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class profil extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        sharedPreferences = getSharedPreferences("com.example.tbptb.PREFS",MODE_PRIVATE);
        token = sharedPreferences.getString("token",null);
    }

    public void ganti_password(View view) {
        startActivity(new Intent(this, ganti_password.class));
        finish();
    }

    public void logout(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://unlockelompok3.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceClient interfaceClient = retrofit.create(InterfaceClient.class);
        Call<MessageClass> message = interfaceClient.logout(token);
        message.enqueue(new Callback<MessageClass>() {
            @Override
            public void onResponse(Call<MessageClass> call, Response<MessageClass> response) {
                Log.i("respon",String.valueOf(response));
                Log.i("respon",String.valueOf(token));
                if(response.code() == 200){
                    if(response.isSuccessful()){
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        Intent suksesLogout = new Intent(profil.this, login.class);
                        startActivity(suksesLogout);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<MessageClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal menghubungi server", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void menu_utama(View view) {
        startActivity(new Intent(this, menu_utama.class));
        finish();
    }

    public void chat(View view) {
        startActivity(new Intent(this, chat.class));
        finish();
    }

    public void peminjaman_gedung(View view) {
        startActivity(new Intent(this, peminjaman_gedung.class));
        finish();
    }
    public void info_fasilitas(View view) {
        startActivity(new Intent(this, info_fasilitas.class));
        finish();
    }
    public void bookmark(View view) {
        startActivity(new Intent(this, bookmark.class));
        finish();
    }
}
