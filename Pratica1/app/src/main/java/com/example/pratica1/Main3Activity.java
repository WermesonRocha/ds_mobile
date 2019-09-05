package com.example.pratica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main3Activity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText age;
    EditText gender;
    Spinner spinner;
    CheckBox notice;
    Button cadastrar;
    String profession = "";
    int not = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        age = (EditText) findViewById(R.id.age);
        gender = (EditText) findViewById(R.id.gender);
        notice = (CheckBox) findViewById(R.id.notice);
        spinner = (Spinner) findViewById(R.id.spinner);
        final String[] work = { "Desenvolvedor", "Professor", "Médico", "Dançarino", "Cozinheiro", "Advogado"};
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, work);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                profession = work[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cadastrar = (Button) findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notice.isChecked())
                    not = 1;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String url = "https://almada-mobile.herokuapp.com/api/users/add?nome="+name.getText().toString()+"&email="+email.getText().toString()+
                        "&profissao="+profession+"&idade="+Integer.parseInt(age.getText().toString())+
                        "&genero="+gender.getText().toString()+"&aviso="+not;
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
