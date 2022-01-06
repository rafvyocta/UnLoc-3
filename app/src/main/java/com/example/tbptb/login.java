package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tbptb.modul.AuthClass;
import com.example.tbptb.retrofit.InterfaceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void kembali(View view) {
        startActivity(new Intent(this, front.class));
        finish();
    }

    public void menu_utama(View view){
        EditText editUsername;
        EditText editPassword;

        editUsername = findViewById(R.id.editTextNumber);
        editPassword = findViewById(R.id.editTextTextPassword);

        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://unlockelompok3.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceClient interfaceClient = retrofit.create(InterfaceClient.class);
        Call<AuthClass> call = interfaceClient.menu_utama(username, password);
        progressLogin(true);
        call.enqueue(new Callback<AuthClass>() {
            @Override
            public void onResponse(Call<AuthClass> call, Response<AuthClass> response) {
                AuthClass authClass = response.body();
                if(authClass != null){
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent menu_utama = new Intent(getApplicationContext(), menu_utama.class);
                    startActivity(menu_utama);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Username/Password Salah", Toast.LENGTH_SHORT).show();
                }
                progressLogin(false);
            }

            @Override
            public void onFailure(Call<AuthClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal menghubungi server", Toast.LENGTH_SHORT).show();
                progressLogin(false);
            }
        });
    }

    public void progressLogin(Boolean active){
        EditText editUsername = findViewById(R.id.editTextNumber);
        EditText editPassword = findViewById(R.id.editTextTextPassword);
        Button buttonLogin = findViewById(R.id.button3);
        ProgressBar progressBar = findViewById(R.id.progressBar2);

        if(active){
            editUsername.setEnabled(false);
            editPassword.setEnabled(false);
            buttonLogin.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            editUsername.setEnabled(true);
            editPassword.setEnabled(true);
            buttonLogin.setEnabled(true);
            progressBar.setVisibility(View.GONE);
        }
    }

    public void buat(View view) {
        startActivity(new Intent(this, signup.class));
        finish();
    }

//    public void menu_utama(View view) {
//        startActivity(new Intent(this, menu_utama.class));
//        finish();
//    }
}