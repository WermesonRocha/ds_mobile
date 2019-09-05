package com.example.segundoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String texto = intent.getStringExtra("texto");
        String texto2 = intent.getStringExtra("texto2");
        if(isStr(texto) && isStr(texto2)){
            textView.setText(texto+texto2);
        }
        else if(isDouble(texto) && isDouble(texto2)){
            textView.setText(""+(Double.parseDouble(texto)+Double.parseDouble(texto2)));
        }
        else
            Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_SHORT).show();
    }

    private boolean isDouble(String str){
        int len = str.length();
        int count = 0;
        for(int i = 0; i < len; i++){
            if(Character.isDigit(str.charAt(i)))
                count += 1;
        }
        return count == len;
    }

    private boolean isStr(String str){
        int len = str.length();
        int count = 0;
        for(int i = 0; i < len; i++){
            if(Character.isAlphabetic(str.charAt(i)))
                count += 1;
        }
        return count == len;
    }
}
