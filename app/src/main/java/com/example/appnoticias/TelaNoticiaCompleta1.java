package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TelaNoticiaCompleta1 extends AppCompatActivity {

    WebView webViewNoticia1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele_noticia_completa1);

        webViewNoticia1 = (WebView)findViewById(R.id.webViewNoticia1);
        webViewNoticia1.setWebViewClient(new WebViewClient());
        webViewNoticia1.getSettings().setJavaScriptEnabled(true);
        webViewNoticia1.getSettings().setDomStorageEnabled(true);
        webViewNoticia1.loadUrl("https://g1.globo.com/es/espirito-santo/noticia/2021/06/13/viana-vacina-populacao-de-18-a-49-anos-em-estudo-de-imunizacao-em-massa-no-es.ghtml");
    }
}