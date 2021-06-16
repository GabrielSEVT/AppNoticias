package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSaibaMais1 extends AppCompatActivity {

    Button btnLerNoticiaCompleta;
    Button btnLerNoticiaCompleta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_saiba_mais1);

        btnLerNoticiaCompleta = (Button)findViewById(R.id.btnLerNoticiaCompleta);
        btnLerNoticiaCompleta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TelaNoticiaCompleta1.class);
                startActivity(intent);
            }
        });
    }
}