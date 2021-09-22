package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtEmail;
    Button btnAcessar;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NOME = "idenficacaoUsuario";
    private static final String KEY_NOME = "nome";
    private static final String KEY_EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        btnAcessar = findViewById(R.id.btnAcessar);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NOME , MODE_PRIVATE);

        String nome = sharedPreferences.getString(KEY_NOME, null);

        if(nome != null){
            Intent intent = new Intent(MainActivity.this, TelaRecentes.class);
            startActivity(intent);
        }

        btnAcessar = (Button)findViewById(R.id.btnAcessar);
        btnAcessar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nome = txtNome.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                if(nome.equals("") || email.equals("")){
                    Toast.makeText(MainActivity.this, "Preencha os campos acima para ter acesso", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NOME, txtNome.getText().toString());
                    editor.putString(KEY_EMAIL, txtEmail.getText().toString());
                    editor.apply();

                    Intent intent = new Intent (MainActivity.this, TelaRecentes.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Acesso realizado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                campoEmail = (TextView)findViewById(R.id.campoEmail);
                campoSenha = (TextView)findViewById(R.id.campoSenha);
                String email = campoEmail.getText().toString().trim();
                String senha = campoSenha.getText().toString().trim();
                if(email.equals("cotidiano@gmail.com") && senha.equals("admin")){
                    Intent intent = new Intent (MainActivity.this, TelaRecentes.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login ou senha inválida",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnConvidado = (Button)findViewById(R.id.btnConvidado);
        btnConvidado.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TelaRecentes.class);
                startActivity(intent);
           }
        });

        */

    }
}