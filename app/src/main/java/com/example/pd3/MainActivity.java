package com.example.pd3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText text;
    Button save;
    SharedPreferences sp;
    String textStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.input);
        save = findViewById(R.id.save);

        sp = getSharedPreferences("SomeText", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textStr = text.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("text", textStr);
                editor.commit();

            }
        });

        SharedPreferences sp = getApplicationContext().getSharedPreferences("SomeText", Context.MODE_PRIVATE);
        String texts = sp.getString("text", "");
        text.setText(texts);

        Button on_Second = (Button) findViewById(R.id.on_second);
        on_Second.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "GOING TO SECOND PAGE", Toast.LENGTH_SHORT).show();
                Intent tosecond = new Intent (getApplicationContext(), SecondActivity.class);
                startActivity(tosecond);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case 2:
                // Whatever you want to happen when the third item gets selected
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}