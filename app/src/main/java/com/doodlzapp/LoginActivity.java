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
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContrasena = findViewById(R.id.editTextContrasena);
        buttonIngresar = findViewById(R.id.buttonIngresar);
        buttonRegistrar =findViewById(R.id.buttonRegistrar);
        DB=new DBHelper(this);

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
                if(user1 == pass1 || user2 == pass2){
                    Toast.makeText(getApplicationContext(), "Te logueaste correctamente", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Aun no creas el usuario", Toast.LENGTH_LONG).show();
                }
            }
        });


        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= editTextUsuario.getText().toString();
                String pass = editTextContrasena.getText().toString();
                Boolean checkuser=DB.checkusername(user);
                if(checkuser==false){
                    Boolean insert = DB.insertData(user,pass);
                    if (insert==true){
                        Toast.makeText(getApplicationContext(), "Se inserto correctamente", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "ya existe el usuario", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}