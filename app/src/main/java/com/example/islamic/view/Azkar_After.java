package com.example.islamic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.islamic.R;
import com.example.islamic.adapter.Sabah_Adapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Azkar_After extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> zekr;
    ArrayList<Integer> repeat;
    Sabah_Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_after);

        zekr = new ArrayList<>();
        repeat = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);

        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("content");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                zekr.add(data.getString("zekr"));
                repeat.add(data.getInt("repeat"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new Sabah_Adapter(repeat, zekr, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private String JsonDataFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("Azkar After-prayer.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStream.close();
            json = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}