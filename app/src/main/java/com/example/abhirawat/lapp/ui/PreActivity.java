package com.example.abhirawat.lapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.abhirawat.lapp.R;

public class PreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre);
    }
    public void Sign(View view)
    {
        startActivity(new Intent(this,LoginActivity.class));
    }
    public void Join(View view)
    {
        startActivity(new Intent(this,JoinNowActivity.class));

    }
}
