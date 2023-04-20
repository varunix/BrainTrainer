package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class StartActivity extends AppCompatActivity {
    Button button;
    Intent intent;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2000);
        ImageView imageView = findViewById(R.id.imageView);

        /*from raw folder*/
        Glide.with(this)
                .load(R.drawable.image)
                .into(imageView);
    }
}
