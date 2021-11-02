package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUsername = findViewById(R.id.input_username);
        EditText edtPassword = findViewById(R.id.input_password);
        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(!username.isEmpty() && !password.isEmpty()){
                    if(username.equals("test")){
                        if(password.equals("123456")){
                            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(homeIntent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Gagal, Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal, Username Salah", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    if(username.isEmpty() && password.isEmpty()){
                        edtUsername.setError("Username tidak boleh kosong");
                        edtPassword.setError("Password tidak boleh kosong");
                    } else if (username.isEmpty()) {
                        edtUsername.setError("Username tidak boleh kosong");
                    } else {
                        edtPassword.setError("Password tidak boleh kosong");
                    }
                }
            }
        });
    }
}