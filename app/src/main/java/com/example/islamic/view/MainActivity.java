package com.example.islamic.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.islamic.R;

public class MainActivity extends AppCompatActivity {
Button button_quran,button_azkar ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_quran=findViewById(R.id.button_quran);
        button_azkar=findViewById(R.id.button2);
        button_quran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Surah.class);
                startActivity(intent);
            }
        });
        button_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Azkar.class);
                startActivity(intent);
            }
        });
    }
}