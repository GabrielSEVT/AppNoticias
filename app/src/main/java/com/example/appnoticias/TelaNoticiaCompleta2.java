package com.example.appnoticias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TelaNoticiaCompleta2 extends AppCompatActivity {

    WebView webViewNoticia2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_noticia_completa2);

        webViewNoticia2 = (WebView)findViewById(R.id.webViewNoticia2);
        webViewNoticia2.setWebViewClient(new WebViewClient());
        webViewNoticia2.getSettings().setJavaScriptEnabled(true);
        webViewNoticia2.getSettings().setDomStorageEnabled(true);
        webViewNoticia2.loadUrl("https://g1.globo.com/economia/pme/pequenas-empresas-grandes-negocios/noticia/2021/06/13/fabrica-fatura-r-250-mil-ao-mes-com-malas-feitas-de-garrafas-pet-recicladas.ghtml");
    }
}