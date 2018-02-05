package com.example.supriya.androlife1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.supriya.androlife1.R.layout.versiondetail10;

/**
 * Created by Supriya on 12/28/2017.
 */

public class DetailActivity10 extends AppCompatActivity {

    String input10="https://www.android.com/versions/lollipop-5-0/";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.versiondetail10);
        Button bt=findViewById(R.id.bt1);
        TextView textView=findViewById(R.id.tV2);
        ImageView imageView=findViewById(R.id.imageView);
        Intent intent =getIntent();


    }

    public void linkme(View view) {
        Intent intent = new Intent(this, Webview.class);
        intent.putExtra("NAME", input10);
        startActivity(intent);

    }
}
