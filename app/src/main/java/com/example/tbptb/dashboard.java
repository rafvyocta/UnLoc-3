package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class dashboard extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap){
        map = googleMap;

        LatLng fti = new LatLng(-0.915665, 100.461321);
        map.addMarker(new MarkerOptions().position(fti).title("FTI"));
        map.moveCamera(CameraUpdateFactory.newLatLng(fti));
    }

    public void rute(View view) {
        startActivity(new Intent(this, rute.class));
        finish();
    }

    public void profil(View view) {
        startActivity(new Intent(this, profil.class));
        finish();
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        
    }
}
