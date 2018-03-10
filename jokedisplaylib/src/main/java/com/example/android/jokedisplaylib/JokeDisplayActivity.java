package com.example.android.jokedisplaylib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    private static final String JOKE_TEXT = "JOKE_TEXT";
    String mJoke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        if(savedInstanceState!=null) {
            mJoke = savedInstanceState.getString(JOKE_TEXT);
        } else{
            mJoke = getIntent().getStringExtra(JOKE_TEXT);
        }

        TextView textView = findViewById(R.id.textview_joke);
        textView.setText(mJoke);

        ImageView imageView = findViewById(R.id.imageview_joke);
        imageView.setImageResource(R.drawable.minions_smiling);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE_TEXT, mJoke);
    }

}
