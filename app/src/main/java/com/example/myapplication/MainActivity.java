package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAddImage.setOnClickListener(v -> {
            new Thread() {
                @Override
                public void run() {

                    runOnUiThread(() -> {
                        binding.ivImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.image,null));
                    });
                }
            }.start();
        });

    }
}