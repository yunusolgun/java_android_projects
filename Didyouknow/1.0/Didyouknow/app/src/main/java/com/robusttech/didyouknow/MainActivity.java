package com.robusttech.didyouknow;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton soundButton,leftButton,rightButton,shareButton;
    int volume=0;

    Random r = new Random();
    ArrayList str = new ArrayList();
    int max=986;
    String s;


    int mevcut=0;
    int mevcut1,max1;

    TextView tv,tvMevcut;
    SharedPreferences sharedPreferences;


    MediaPlayer mySound;


    Intent shareIntent;
    String shareBody= "This is great app";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton leftButton = findViewById(R.id.imageButton3);
        ImageButton rightButton = findViewById(R.id.imageButton4);
        ImageButton shareButton = findViewById(R.id.imageButton5);

        final ImageButton soundButton = findViewById(R.id.imageButton2);
        tv = findViewById(R.id.textView);
        tvMevcut = findViewById(R.id.textView3);



        sharedPreferences = this.getSharedPreferences("com.robusttech.didyouknow",MODE_PRIVATE);
        mevcut=sharedPreferences.getInt("mevcut",0);
        volume=sharedPreferences.getInt("volume",1);

        if (volume == 0) {
            soundButton.setImageResource(R.drawable.volumeoff);
        }
        mySound = MediaPlayer.create(MainActivity.this, R.raw.ding);


        BufferedReader reader;

        //Dosya Project görünümünde app-->src-->main-->assets altında
        try {
            final InputStream file = getAssets().open("didyouknow.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while (line != null) {
                str.add(line);
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        setMevcut(mevcut);

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (volume==1) {
                    soundButton.setImageResource(R.drawable.volumeoff);
                    volume = 0;
                } else {
                    soundButton.setImageResource(R.drawable.volumeon);
                    volume=1;
                }

                sharedPreferences.edit().putInt("volume", volume).apply();

            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mevcut -=1;
                if (mevcut <0) { mevcut = 0; }
                setMevcut(mevcut);

            }
        });


        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mevcut +=1;
                if (mevcut > max) { mevcut = max; }
                setMevcut(mevcut);
            }
        });


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Did you know");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent,"Share via"));


            }
        });


    }

    public void setMevcut(int mevcut) {



        if (volume == 1) {

            if (mySound.isPlaying()) {
                mySound.pause();
                mySound.seekTo(0);
            }
            mySound.start();

        }


        s = (String) str.get(mevcut);
        tv.setText(s);
        shareBody="Did you know " + s+"\n\nGet the app from Google play store : https://play.google.com/store/apps/details?id=com.robusttech.didyouknow";
        mevcut1=mevcut+1;max1=max+1;
        tvMevcut.setText(""+mevcut1+"/"+max1);

        sharedPreferences.edit().putInt("mevcut", this.mevcut).apply();

    }


}
