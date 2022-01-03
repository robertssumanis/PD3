package com.example.pd3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button read = (Button) findViewById(R.id.read);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView savedText;
                savedText = findViewById(R.id.savedText);

                SharedPreferences sp = getApplicationContext().getSharedPreferences("SomeText", Context.MODE_PRIVATE);
                String texts = sp.getString("text", "");

                if(texts.length() == 0){
                    Toast.makeText(getApplicationContext(), "Nothing found", Toast.LENGTH_SHORT).show();
                }

                savedText.setText(texts);
            }
        });


        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "GOING BACK", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}