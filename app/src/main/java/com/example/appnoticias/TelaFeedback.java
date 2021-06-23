package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaFeedback extends AppCompatActivity {

    EditText destinatario;
    EditText assunto;
    EditText mensagem;
    Button btnEnviarEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_feedback);

        destinatario = findViewById(R.id.destinatario);
        assunto = findViewById(R.id.assunto);
        mensagem = findViewById(R.id.mesangem);
        btnEnviarEmail = findViewById(R.id.btnEnviarEmail);

        btnEnviarEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String destinatario_email = destinatario.getText().toString().trim();
                String assunto_email = assunto.getText().toString().trim();
                String mensagem_email = mensagem.getText().toString().trim();

                sendEmail(destinatario_email, assunto_email, mensagem_email);
            }
        });
    }

    private void sendEmail(String destinatario_email, String assunto_email, String mensagem_email) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{destinatario_email});
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto_email);
        intent.putExtra(Intent.EXTRA_TEXT, mensagem_email);

        try {
            startActivity(Intent.createChooser(intent, "Escolha um cliente de email"));
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}