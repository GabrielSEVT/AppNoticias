package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPerfil extends AppCompatActivity {

    TextView txtNome, txtEmail;
    Button btnSair;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NOME = "idenficacaoUsuario";
    private static final String KEY_NOME = "nome";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        btnSair = findViewById(R.id.btnSair);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NOME, MODE_PRIVATE);
        String nome = sharedPreferences.getString(KEY_NOME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if(nome != null || email != null) {
            txtNome.setText("Nome completo: " +nome);
            txtEmail.setText("E-mail: " +email);

        }

        btnSair.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               SharedPreferences.Editor editor = sharedPreferences.edit();
               editor.clear();
               editor.commit();
               finish();

               Intent intent = new Intent (TelaPerfil.this, MainActivity.class);
               startActivity(intent);

               Toast.makeText(TelaPerfil.this, "Deslogado com sucesso", Toast.LENGTH_SHORT).show();
           }
        });


    }
}