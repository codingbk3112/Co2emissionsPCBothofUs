package com.bothofus.assignment;

import android.content.Intent;
import android.os.Bundle;
import com.bothofus.assignment.databinding.ActivitySecondBinding;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SecondActivity extends AppCompatActivity {

    Float emission;
    String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent mIntent = getIntent();
        name = mIntent.getStringExtra("name");
        emission = mIntent.getFloatExtra("co2", 0);

        Objects.requireNonNull(getSupportActionBar()).setTitle(name);
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        binding.tvEmissionCount.setText(String.valueOf(emission));

        //get trees count 20kg per tree per year
        int trees = (int) (emission*1000/20);

        binding.tvTreesCount.setText(String.format("%d/person",trees));

    }
}
