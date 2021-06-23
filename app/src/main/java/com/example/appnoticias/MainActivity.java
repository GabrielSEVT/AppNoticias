package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnConvidado;
    Button btnLogin;
    TextView campoEmail;
    TextView campoSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}