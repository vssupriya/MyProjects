package com.example.supriya.androlife1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



    public class MainActivity extends AppCompatActivity {
        ArrayList<App> apps = new ArrayList<>();
        String[] name;
        int[] images;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ListView listView = findViewById(R.id.listView);
            name = new String[]{" ANDROID 1.5 CUPCAKE ", " ANDROID 1.6 DONUT ", " ANDROID 2.1 ECLAIR ",
                    " ANDROID 2.2 FROYO ", " ANDROID 2.3 GINGERBREAD ", " ANDROID 3.0 HONEYCOMB ", " ANDROID 4.0 ICE CREAM SANDWICH ", " ANDROID 4.1 JELLYBEAN ",
                    " ANDROID 4.4 KITKAT ", " ANDROID 5.0 LOLLIPOP ", " ANDROID 6.0 MARSHMALLOW", " ANDROID 7.0 NOUGAT ", " ANDROID 8.0 OREO "};
            images = new int[]{R.drawable.cupcake,
                    R.drawable.donut,
                    R.drawable.eclair,
                    R.drawable.froyo,
                    R.drawable.ginger,
                    R.drawable.honey,
                    R.drawable.icecream,
                    R.drawable.jelly,
                    R.drawable.kitkat,
                    R.drawable.lollipop,
                    R.drawable.marsh,
                    R.drawable.nougat,
                    R.drawable.oreo};
            VersionAdapter versionAdapter = new VersionAdapter(this, name, images);
            listView.setAdapter(versionAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    switch (position) {
                        case 0:
                            Intent newActivity = new Intent(MainActivity.this, DetailActivity.class);
                            startActivity(newActivity);
                            break;
                        case 1:
                            Intent newActivity2 = new Intent(MainActivity.this, DetailActivity2.class);
                            startActivity(newActivity2);
                            break;
                        case 2:
                            Intent newActivity3 = new Intent(MainActivity.this, DetailActivity3.class);
                            startActivity(newActivity3);
                            break;
                        case 3:
                            Intent newActivity4 = new Intent(MainActivity.this, DetailActivity4.class);
                            startActivity(newActivity4);
                            break;
                        case 4:
                            Intent newActivity5 = new Intent(MainActivity.this, DetailActivity5.class);
                            startActivity(newActivity5);
                            break;
                        case 5:
                            Intent newActivity6 = new Intent(MainActivity.this, DetailActivity6.class);
                            startActivity(newActivity6);
                            break;
                        case 6:
                            Intent newActivity7 = new Intent(MainActivity.this, DetailActivity7.class);
                            startActivity(newActivity7);
                            break;
                        case 7:
                            Intent newActivity8 = new Intent(MainActivity.this, DetailActivity8.class);
                            startActivity(newActivity8);
                            break;
                        case 8:
                            Intent newActivity9 = new Intent(MainActivity.this, DetailActivity9.class);
                            startActivity(newActivity9);
                            break;
                        case 9:
                            Intent newActivity10 = new Intent(MainActivity.this, DetailActivity10.class);
                            startActivity(newActivity10);
                            break;
                        case 10:
                            Intent newActivity11 = new Intent(MainActivity.this, DetailActivity11.class);
                            startActivity(newActivity11);
                            break;
                        case 11:
                            Intent newActivity12 = new Intent(MainActivity.this, DetailActivity12.class);
                            startActivity(newActivity12);
                            break;
                        case 12:
                            Intent newActivity13 = new Intent(MainActivity.this, DetailActivity13.class);
                            startActivity(newActivity13);
                            break;
                    }
                }
            });
        }
    }




