package com.polinema.smartkos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.polinema.smartkos.R;

public class Login extends AppCompatActivity {
    private EditText edLogin;
    private Button btLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        edLogin = findViewById(R.id.edtLogin);
        btLogin = findViewById(R.id.btnLogin);
        
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String password = edLogin.getText().toString();
                if (!password.trim().isEmpty()) {
                    if (password.equals("123456")) {
                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(Login.this, "Pin Keamanan Salah", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(Login.this, "Masukkan Pin Keamanan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
