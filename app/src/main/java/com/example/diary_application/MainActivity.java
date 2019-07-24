package com.example.diary_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import spencerstudios.com.bungeelib.Bungee;

public class MainActivity extends AppCompatActivity {
    EditText edtEnterCode;
    Button btnUnlock,btnForgotCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setTitle("Sharesd Pref");
        edtEnterCode=findViewById(R.id.edt_enter_code);
        btnUnlock=findViewById(R.id.btn_unlock);
        btnForgotCode=findViewById(R.id.btn_forgot);

        btnUnlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=edtEnterCode.getText().toString();

                if (code.equals("123"))
                {
                    Intent i=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);
                   // Bungee.slideUp(MainActivity.this);
                    Bungee.zoom(MainActivity.this);
                }
                else
                {
                    edtEnterCode.setText("");
                    Toast.makeText(MainActivity.this, "Please Enter Valid Code", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnForgotCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Enter 123", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
