package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class peminjaman_gedung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peminjaman_gedung);
    }
    public void dashboard(View view) {
        startActivity(new Intent(this, dashboard.class));
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

    public void back(View view) {
        startActivity(new Intent(this, dashboard.class));
        finish();
    }

    public void pemesanan_gedung(View view) {
        startActivity(new Intent(this, pemesanan_gedung.class));
        finish();
    }
}
