package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void kembali(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void daftar(View view) {
        startActivity(new Intent(this, login.class));
        finish();
    }

    public void masuk(View view) {
        startActivity(new Intent(this, login.class));
        finish();
    }
}