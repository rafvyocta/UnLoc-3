package com.example.tbptb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tbptb.R;
import com.example.tbptb.modul.kelas;

import java.util.ArrayList;

public class kelasAdapter extends RecyclerView.Adapter<kelasAdapter.kelasViewHolder> {

    //VIEW HOLDER
    public class kelasViewHolder extends RecyclerView.ViewHolder {
        TextView textLokasi;
        public kelasViewHolder(@NonNull View itemView) {
            super(itemView);
            textLokasi = itemView.findViewById(R.id.textLokasi);
        }
    }

    //UNTUK DATA YANG AKAN DITAMPILKAN
    ArrayList<kelas> listKelas = new ArrayList<>();
    public void setListKelas(ArrayList<kelas> listKelas) {
        this.listKelas = listKelas;
        notifyDataSetChanged();
    }

    //METHOD ADAPTER
    @NonNull

    //Method untuk membuat viewholder-nya atau list itemnya
    @Override
    public kelasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bookmark, parent, false);
        kelasViewHolder viewHolder = new kelasViewHolder(view);
        return viewHolder;
    }

    //Method untuk memasukkan data ke dalam view holder di atas
    @Override
    public void onBindViewHolder(@NonNull kelasViewHolder viewHolder, int position) {
        kelas kelas = listKelas.get(position);
        viewHolder.textLokasi.setText(kelas.lokasi);
    }

    //Method untuk menghitung jumlah data
    @Override
    public int getItemCount() {
        return listKelas.size();
    }


}
