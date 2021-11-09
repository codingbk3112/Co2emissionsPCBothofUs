package com.bothofus.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.bothofus.assignment.databinding.ActivityMainBinding;
import com.bothofus.assignment.model.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Response response = new Gson().fromJson(loadJSONFile(), Response.class);
        Log.d("main",response.toString());
        CountryAdapter countryAdapter= new CountryAdapter(response.getCountries(),MainActivity.this);
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        binding.rvCountries.setAdapter(countryAdapter);

    }


    public String loadJSONFile() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] byteArray = new byte[size];
            inputStream.read(byteArray);
            inputStream.close();
            json = new String(byteArray, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
//        Log.d("Main",json);
        return json;
    }

}