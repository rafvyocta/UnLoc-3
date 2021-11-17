package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detail_pemesanan_gedung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pemesanan_gedung);
    }

    public void back_pemesanan_gedung(View view) {
        startActivity(new Intent(this, pemesanan_gedung.class));
        finish();
    }

    public void chat(View view) {
        startActivity(new Intent(this, chat.class));
        finish();
    }
}
