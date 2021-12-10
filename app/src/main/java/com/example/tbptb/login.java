package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void buat(View view) {
        startActivity(new Intent(this, signup.class));
        finish();
    }

    public void menu_utama(View view) {
        startActivity(new Intent(this, menu_utama.class));
        finish();
    }
}