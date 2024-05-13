package com.example.islamic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.islamic.R;
import com.example.islamic.adapter.SurahDetail_Adapter;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class SurahDetail extends AppCompatActivity {
    TextView surah_name;
    RecyclerView surah_detail_rv;
    ArrayList<Integer> index;
    ArrayList<String> nname;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);
        surah_name=findViewById(R.id.surah_name);
        surah_detail_rv=findViewById(R.id.surah_detail_rv);
        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        surah_name.setText(name);
        index=new ArrayList<>();
        nname=new ArrayList<>();
        surah_detail_rv.setLayoutManager(new LinearLayoutManager(this));
        surah_detail_rv.setHasFixedSize(true);
        try {
            JSONObject jsonObject = new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("surah");
            int targetIndex = bundle.getInt("index");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                if (targetIndex == data.getInt("index")) {
                    JSONArray jsonArray1 = data.getJSONArray("aya");
                    for (int j = 0; j < jsonArray1.length(); j++) {
                        JSONObject data1 = jsonArray1.getJSONObject(j);
                        index.add(data1.getInt("index"));
                        nname.add(data1.getString("text"));
                    }
                    // No need to continue looping once the target index is found
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SurahDetail_Adapter adapter=new SurahDetail_Adapter(index,nname,this);
        surah_detail_rv.setAdapter(adapter);
    }

    private String JsonDataFromAsset() {
        String json=null ;
        try{
            InputStream inputStream=getAssets().open("QuranDetails.json");
            int sizeOfFile = inputStream.available();
            byte[]bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            return null ;}
        return json ; }
    }
