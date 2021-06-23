package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaMenuPrincipal extends AppCompatActivity {

    Button btnPerfil;
    Button btnNoticiasRecentes;
    Button bntEscolherAssunto;
    Button btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu_principal);

        btnPerfil = (Button)findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaMenuPrincipal.this, TelaPerfil.class);
                startActivity(intent);
            }
        });

        btnNoticiasRecentes = (Button)findViewById(R.id.btnNoticiasRecentes);
        btnNoticiasRecentes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaMenuPrincipal.this, TelaRecentes.class);
                startActivity(intent);
            }
        });

        bntEscolherAssunto = (Button)findViewById(R.id.btnEscolherAssunto);
        bntEscolherAssunto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaMenuPrincipal.this, TelaEscolherAssunto.class);
                startActivity(intent);
            }
        });

        btnFeedback = (Button)findViewById(R.id.btnFeedback);
        btnFeedback.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(TelaMenuPrincipal.this, TelaFeedback.class);
               startActivity(intent);
            }
        });
    }
}