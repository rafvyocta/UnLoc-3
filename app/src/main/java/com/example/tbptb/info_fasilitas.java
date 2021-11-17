package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class info_fasilitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_fasilitas);
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

    public void fasilitas_gedung_kuliah(View view) {
        startActivity(new Intent(this, fasilitas_gedung_kuliah.class));
        finish();
    }

    public void fasilitas_gedung_fakultas(View view) {
        startActivity(new Intent(this, fasilitas_gedung_fakultas.class));
        finish();
    }
    public void fasilitas_jurusan(View view) {
        startActivity(new Intent(this, fasilitas_jurusan.class));
        finish();
    }
    public void fasilitas_kantin(View view) {
        startActivity(new Intent(this, fasilitas_kantin.class));
        finish();
    }
    public void fasilitas_lapangan(View view) {
        startActivity(new Intent(this, fasilitas_lapangan.class));
        finish();
    }

    public void fasilitas_umum_lain(View view) {
        startActivity(new Intent(this, fasilitas_umum_lain.class));
        finish();
    }
}
