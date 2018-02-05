package com.example.supriya.androlife1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Supriya on 12/28/2017.
 */

public class Webview extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detailxml);
            WebView wb=findViewById(R.id.webView1);
            Intent intent =getIntent();
            String receivedValue = intent.getStringExtra("NAME");
            wb.loadUrl(receivedValue);
        }
    }


