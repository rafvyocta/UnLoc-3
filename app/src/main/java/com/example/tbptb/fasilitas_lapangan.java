package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fasilitas_lapangan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fasilitas_lapangan);
    }

    public void back_info_fasilitas(View view) {
        startActivity(new Intent(this, info_fasilitas.class));
        finish();
    }
}
