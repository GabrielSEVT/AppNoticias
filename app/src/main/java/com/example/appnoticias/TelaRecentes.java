package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TelaRecentes extends AppCompatActivity {

    ImageView imgView_MenuHamburguer;
    Button btnSaibaMais;
    Button btnSaibaMais2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_recentes);

        imgView_MenuHamburguer = (ImageView)findViewById(R.id.imgView_MenuHamburguer);
        imgView_MenuHamburguer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), TelaMenuPrincipal.class);
                startActivity(intent);
            }
        });

        btnSaibaMais = (Button)findViewById(R.id.btnSaibaMais);
        btnSaibaMais.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), TelaSaibaMais1.class);
                startActivity(intent);
            }
        });

        btnSaibaMais2 = (Button)findViewById(R.id.btnSaibaMais2);
        btnSaibaMais2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), TelaSaibaMais2.class);
                startActivity(intent);
            }
        });
    }
}