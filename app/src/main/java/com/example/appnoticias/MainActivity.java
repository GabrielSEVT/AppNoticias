package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtEmail;
    Button btnAcessar, btnCadastrar;
    SharedPreferences sharedPreferences;
    private Type type;

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
        btnCadastrar = findViewById(R.id.btnCadastrar);
        type = (Type) getIntent().getSerializableExtra(Constantes.STORAGE_TYPE);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NOME , MODE_PRIVATE);

        String nome = sharedPreferences.getString(KEY_NOME, null);

        if(nome != null){
            Intent intent = new Intent(MainActivity.this, TelaRecentes.class);
            startActivity(intent);
        }

        btnAcessar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nome = txtNome.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NOME, txtNome.getText().toString());
                    editor.putString(KEY_EMAIL, txtEmail.getText().toString());
                    editor.apply();
                    try {
                        lerInterno();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent (MainActivity.this, TelaRecentes.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Acesso realizado", Toast.LENGTH_SHORT).show();

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String nome = txtNome.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();
                if(nome.isEmpty() || email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Preencha os campos acima para ter acesso", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NOME, txtNome.getText().toString());
                    editor.putString(KEY_EMAIL, txtEmail.getText().toString());
                    editor.apply();
                    salvarLogin();

                    Intent intent = new Intent (MainActivity.this, TelaRecentes.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "Acesso realizado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void salvarLogin(){
        String nome = txtNome.getText().toString();
        String email = txtEmail.getText().toString();
        String path;

        try{
            path = salvarInterno(nome);
            path = salvarInterno(email);
            Toast.makeText(this, "Arquivo gravado em" + path, Toast.LENGTH_SHORT).show();
            finish();
        } catch (IOException e) {
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private String salvarInterno(String dado) throws FileNotFoundException {
        FileOutputStream fos = openFileOutput(Constantes.FILE_NAME, MODE_PRIVATE);
        PrintWriter pw = new PrintWriter(fos);
        try {
            pw.print(dado);
            return getFilesDir().getPath() + File.separator + Constantes.FILE_NAME;
        } finally {
            pw.close();
        }
    }

    private void lerInterno() throws FileNotFoundException {
        FileInputStream fis = openFileInput(Constantes.FILE_NAME);
        Scanner scanner = new Scanner(fis);
        try{
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sb.append(line).append("\n");
            }
            txtEmail.setText(sb.toString());
            txtNome.setText(sb.toString());
        } finally {
            scanner.close();
        }
    }

}