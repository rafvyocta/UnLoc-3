package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tbptb.adapter.kelasAdapter;
import com.example.tbptb.modul.kelas;

import java.util.ArrayList;

public class bookmark_data extends AppCompatActivity {

    RecyclerView rvKelas;
    kelasAdapter kelasadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark_data);

        kelasadapter = new kelasAdapter();
        kelasadapter.setListKelas(generateData());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvKelas = findViewById(R.id.rvBookmark);
        rvKelas.setAdapter(kelasadapter);
        rvKelas.setLayoutManager(layoutManager);

    }

    public void back_bookmark(View view) {
        startActivity(new Intent(this, bookmark.class));
        finish();
    }

    public ArrayList<kelas> generateData(){
        ArrayList<kelas> listkelas = new ArrayList<>();
        listkelas.add(new kelas("Gedung A");
        listkelas.add(new kelas("Gedung B");
        listkelas.add(new kelas("Gedung C");
        listkelas.add(new kelas("Gedung D");
        listkelas.add(new kelas("Gedung E");
        listkelas.add(new kelas("Gedung F");
        listkelas.add(new kelas("Gedung G");
        listkelas.add(new kelas("Gedung H");
        listkelas.add(new kelas("Gedung I");

        return listkelas;

    }
}
