package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaSaibaMais2 extends AppCompatActivity {

    Button btnLerNoticiaCompleta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_saiba_mais2);

        btnLerNoticiaCompleta2 = (Button)findViewById(R.id.btnLerNoticiaCompleta2);
        btnLerNoticiaCompleta2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TelaNoticiaCompleta2.class);
                startActivity(intent);
            }
        });
    }
}