package com.example.islamic.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.islamic.R;

public class Azkar extends AppCompatActivity {
Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);
        button1=findViewById(R.id.button_Azkar_Alsabah);
        button2=findViewById(R.id.button_Azkar_Almassa);
        button3=findViewById(R.id.button_Azkar_After);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Azkar.this,Azkar_Sabah.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Azkar.this,Azkar_Massa.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Azkar.this,Azkar_After.class);
                startActivity(intent);
            }
        });
    }
}