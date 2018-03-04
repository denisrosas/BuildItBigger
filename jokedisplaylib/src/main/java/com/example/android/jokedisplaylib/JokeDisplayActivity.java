package com.example.android.jokedisplaylib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    private static final String JOKE_TEXT = "JOKE_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String joke = getIntent().getStringExtra(JOKE_TEXT);

        TextView textView = findViewById(R.id.textview_joke);
        textView.setText(joke);
    }

}
