package com.example.appnoticias;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Scanner;

public class TelaPerfil extends AppCompatActivity {

    TextView txtNome, txtEmail;
    EditText txtMensagemSuporte;
    Button btnSair, btnEnviarMensagemSuporte, btnVisualizarMensagemSuporte;
    private Type type;



    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NOME = "idenficacaoUsuario";
    private static final String KEY_NOME = "nome";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        //btnSair = findViewById(R.id.btnSair);
        this.type = (Type)this.getIntent().getSerializableExtra("storage_type");
        txtMensagemSuporte = findViewById(R.id.txtMensagemSuporte);

        /*sharedPreferences = getSharedPreferences(SHARED_PREF_NOME, MODE_PRIVATE);
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
        });*/

        btnEnviarMensagemSuporte.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view){
                String mensagem = txtMensagemSuporte.getText().toString();
                salvarMensagem();
            }
        });

        btnVisualizarMensagemSuporte.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view){
                String mensagem = txtMensagemSuporte.getText().toString();
                try {
                    lerExterno();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void salvarMensagem() {
        String mensagem = txtMensagemSuporte.getText().toString();
        String path;

        try {
            path = salvarExterno(mensagem);
            Toast.makeText(this, "Arquivo gravado em" + path, Toast.LENGTH_SHORT).show();
            finish();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String salvarExterno(String mensagem) throws IOException {
        String status = Environment.getExternalStorageState();
        if (!status.equals("mounted")) {
            throw new IOException("O SD Card não montado ou não disponível!!!");
        } else {
            File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File file = new File(dir, "login.txt");
            PrintWriter pw = new PrintWriter(file);

            String var7;
            try {
                pw.print(mensagem);
                var7 = file.getPath();
            } finally {
                pw.close();
            }

            return var7;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void lerExterno() throws IOException {
        String status = Environment.getExternalStorageState();
        if (!status.equals("mounted")) {
            throw new IOException("O SD Card não montado ou encontrado");
        } else {
            File dir = this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            Scanner scanner = new Scanner(new File(dir, "login.txt"));

            try {
                StringBuilder sb = new StringBuilder();

                while(scanner.hasNext()) {
                    String line = scanner.nextLine();
                    sb.append(line).append("\n");
                }

                this.txtMensagemSuporte.setText(sb.toString());
            } finally {
                scanner.close();
            }
        }
    }
}