package com.doodlzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUsuario, editTextContrasena;
    private Button buttonIngresar,buttonRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        buttonIngresar = findViewById(R.id.buttonIngresar);



        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= editTextUsuario.getText().toString();
                String pass = editTextContrasena.getText().toString();
                String user1 = "paul";
                String pass1 = "paul";
                String user2 = "bernardo";
                String pass2 = "bernardo";
                ;
                if((user.equals(user1) && pass.equals(pass1) )||( user.equals(user2) && pass.equals(pass2))){
                    Toast.makeText(getApplicationContext(), "Te logueaste correctamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(getApplicationContext(), user, Toast.LENGTH_LONG).show();
            }
        });



    }
}