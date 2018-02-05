package com.example.supriya.githubapp;

import org.json.JSONObject;


        import android.content.Context;
        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.Scanner;

        import okhttp3.Call;
        import okhttp3.Callback;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Callback {

    Context context;
    EditText editText;
    RecyclerView recyclerView;

    public static String BASE_URL = "https://api.github.com/search/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et1);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Button btn = findViewById(R.id.bt);

        final OkHttpClient client = new OkHttpClient();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputString = editText.getText().toString();


                final Request request = new Request.Builder()
                        .url("https://api.github.com/search/users?q=" + inputString)
                        .build();
                client.newCall(request).enqueue(MainActivity.this);

            }
        });
    }


    @Override
    public void onFailure(Call call, IOException e) {

        Toast.makeText(context, "Failed Loading", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        ArrayList<GithubUser> users = new ArrayList<>();
        final String s = response.body().string();
        try {
            users = parseJson(s);
        } catch (JSONException e) {
            e.printStackTrace();

        }
        final GithubAdapter recylerViewAdapter = new GithubAdapter(users);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(recylerViewAdapter);

            }
        });


    }

    public ArrayList<GithubUser> parseJson(String s) throws JSONException {
        //Log.e(TAG, "parseJson: ", );
        ArrayList<GithubUser> users = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(s);
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            String url = jsonObject.getString("url");
            String id = jsonObject.getString("id");
            String login = jsonObject.getString("login");
            Double score = jsonObject.getDouble("score");
            String avatar_url = jsonObject.getString("avatar_url");
            //users.add(url,id, score, login);
            GithubUser githubUsers = new GithubUser(url, login, avatar_url, id, this, score);
            users.add(githubUsers);
        }

        return users;
    }

}
