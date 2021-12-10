package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
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

    public void chat_1(View view) {
        startActivity(new Intent(this, chat_1.class));
        finish();
    }
}
