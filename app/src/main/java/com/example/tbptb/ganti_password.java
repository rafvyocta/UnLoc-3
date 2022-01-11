package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tbptb.modul.AuthClass;
import com.example.tbptb.modul.MessageClass;
import com.example.tbptb.retrofit.InterfaceClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ganti_password extends AppCompatActivity {
    EditText editpasswordBaru;
    EditText editconfirmPassBaru;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganti_password);

        editpasswordBaru = findViewById(R.id.editTextTextPersonName2);
        editconfirmPassBaru = findViewById(R.id.editTextTextPersonName3);

        sharedPreferences = getSharedPreferences("com.example.tbptb.PREFS",MODE_PRIVATE);
    }

    public void gantipassword(View view) {
        String passwordBaru = editpasswordBaru.getText().toString();
        String confirmPassBaru = editconfirmPassBaru.getText().toString();
        if(validasi(passwordBaru, confirmPassBaru).equals(1)){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://unlockelompok3.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            InterfaceClient interfaceClient = retrofit.create(InterfaceClient.class);
            String token = sharedPreferences.getString("token", null);
            Call<MessageClass> message = interfaceClient.gantipassword(token, passwordBaru);
            progressGanti(true);
            message.enqueue(new Callback<MessageClass>() {
                @Override
                public void onResponse(Call<MessageClass> call, Response<MessageClass> response) {
                    if(response.code() == 200){
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            Intent suksesGanti = new Intent(ganti_password.this, profil.class);
                            startActivity(suksesGanti);
                            progressGanti(false);
                            finish();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MessageClass> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Gagal mengganti password", Toast.LENGTH_SHORT).show();
                    progressGanti(false);
                }
            });
        }
    }

    public Integer validasi(String passwordBaru, String confirmPassBaru){
        Integer valid = 1;
        if(!passwordBaru.isEmpty() && !confirmPassBaru.isEmpty()){
            if(!passwordBaru.equals(confirmPassBaru)){
                Toast.makeText(getApplicationContext(), "Password dan Konfirmasi Password Tidak Sama", Toast.LENGTH_SHORT).show();
                valid = 0;
            }
        }
        return valid;
    }

    public void progressGanti(Boolean active){
        EditText editPass = findViewById(R.id.editTextTextPersonName2);
        EditText editPass2 = findViewById(R.id.editTextTextPersonName3);
        Button buttonSimpan = findViewById(R.id.button7);
        ProgressBar progressGanti = findViewById(R.id.progressBar4);

        if(active){
            editPass.setEnabled(false);
            editPass2.setEnabled(false);
            buttonSimpan.setEnabled(true);
            progressGanti.setVisibility(View.VISIBLE);
        }
        else{
            editPass.setEnabled(true);
            editPass2.setEnabled(true);
            buttonSimpan.setEnabled(true);
            progressGanti.setVisibility(View.GONE);
        }
    }

    public void back_profil(View view) {
        startActivity(new Intent(this, profil.class));
        finish();
    }
}
