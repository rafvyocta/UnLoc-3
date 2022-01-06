package com.example.tbptb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tbptb.modul.AuthClass;
import com.example.tbptb.modul.MessageClass;
import com.example.tbptb.retrofit.InterfaceClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signup extends AppCompatActivity {
    EditText editNama;
    EditText editUsername;
    EditText editEmail;
    EditText editNohp;
    EditText editPassword;
    EditText editConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editNama = findViewById(R.id.editTextTextNama);
        editUsername = findViewById(R.id.editTextUsername);
        editEmail = findViewById(R.id.editTextEmail);
        editNohp = findViewById(R.id.editTextTextNohp);
        editPassword = findViewById(R.id.editTextTextPassword2);
        editConfirmPassword = findViewById(R.id.editTextTextPassword3);
    }

    public void kembali(View view) {
        startActivity(new Intent(this, front.class));
        finish();
    }

    public void daftar(View view) {

        String nama = editNama.getText().toString();
        String username = editUsername.getText().toString();
        String email = editEmail.getText().toString();
        String no_hp = editNohp.getText().toString();
        String password = editPassword.getText().toString();
        String confirmpassword = editConfirmPassword.getText().toString();

        if(validasi(password, confirmpassword).equals(1)){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://unlockelompok3.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            InterfaceClient interfaceClient = retrofit.create(InterfaceClient.class);
            Call<MessageClass> message = interfaceClient.daftar(nama, username, email, no_hp, password);
            progressRegister(true);
            message.enqueue(new Callback<MessageClass>() {
                @Override
                public void onResponse(Call<MessageClass> call, Response<MessageClass> response) {

                    if(response.code() == 200){
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            Intent suksesRegister = new Intent(signup.this, login.class);
                            startActivity(suksesRegister);
                            progressRegister(false);
                            finish();
                        }
                    }
                    else{

                        Log.i("pesan",String.valueOf(response.errorBody()));
                        try {
                            JSONObject jsonObject = new JSONObject(response.errorBody().string());
                            System.out.println(jsonObject.getString("message"));
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                        }
                    }
//                MessageClass messageClass = response.body();

                }

                @Override
                public void onFailure(Call<MessageClass> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Gagal menghubungi server", Toast.LENGTH_SHORT).show();
                    progressRegister(false);
                }
            });
        }
    }

    public void progressRegister(Boolean active){
        EditText editNama = findViewById(R.id.editTextTextNama);
        EditText editUsername = findViewById(R.id.editTextUsername);
        EditText editEmail = findViewById(R.id.editTextEmail);
        EditText editNohp = findViewById(R.id.editTextTextNohp);
        EditText editPassword = findViewById(R.id.editTextTextPassword2);
        EditText editConfirmPassword = findViewById(R.id.editTextTextPassword3);
        Button buttonRegister = findViewById(R.id.button5);
        Button buttonBack = findViewById(R.id.button6);
        ProgressBar progressRegis = findViewById(R.id.progressBar3);

        if(active){
            editNama.setEnabled(false);
            editUsername.setEnabled(false);
            editEmail.setEnabled(false);
            editNohp.setEnabled(false);
            editPassword.setEnabled(false);
            editConfirmPassword.setEnabled(false);
            buttonRegister.setEnabled(false);
            buttonRegister.setEnabled(false);
            progressRegis.setVisibility(View.VISIBLE);
        }
        else{
            editNama.setEnabled(true);
            editUsername.setEnabled(true);
            editEmail.setEnabled(true);
            editNohp.setEnabled(true);
            editPassword.setEnabled(true);
            editConfirmPassword.setEnabled(true);
            buttonRegister.setEnabled(true);
            buttonRegister.setEnabled(true);
            progressRegis.setVisibility(View.GONE);
        }
    }

    public Integer validasi(String password, String confirmpassword){
        Integer valid = 1;
        if(!password.isEmpty() && !confirmpassword.isEmpty()){
            if(!password.equals(confirmpassword)){
                Toast.makeText(getApplicationContext(), "Password dan Konfirmasi Password Tidak Sama", Toast.LENGTH_SHORT).show();
                valid = 0;
            }
        }
        return valid;
    }

    public void masuk(View view) {
        startActivity(new Intent(this, login.class));
        finish();
    }
}