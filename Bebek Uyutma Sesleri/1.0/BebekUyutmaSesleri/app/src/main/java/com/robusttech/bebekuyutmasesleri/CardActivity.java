package com.robusttech.bebekuyutmasesleri;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {

    private TextView txt_baslik;
    private ImageView img_resim;
    private ImageButton img_button;
    private View view;

    public MediaPlayer mySound;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        txt_baslik = findViewById(R.id.baslik_id);
        img_resim = findViewById(R.id.image_id);
        img_button= findViewById(R.id.img_button);

        Intent intent = getIntent();
        String Baslik = intent.getExtras().getString("baslik");
        int resim= intent.getExtras().getInt("resim");
        final int muzik= intent.getExtras().getInt("muzik");

        txt_baslik.setText(Baslik);
        img_resim.setImageResource(resim);

        playOrStop(view,muzik);   // Tıklandiginda hemen calmaya basla

        img_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playOrStop(v,muzik);
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAll(view);
    }

    public void playOrStop(View view, int muzik) {
        if (mySound == null) {
            img_button.setImageResource(R.drawable.pause);
            mySound = MediaPlayer.create(this,muzik);
            mySound.setLooping(true);
            mySound.start();
        } else if (mySound.isPlaying()){
            img_button.setImageResource(R.drawable.play);
            mySound.release();
            mySound = null;
        }

    }

    public void stopAll(View view) {
        if (mySound != null) {
            if (mySound.isPlaying()) {
                mySound.release();
                mySound = null;
            }
        }
    }

/*
    public void play(View view) {
        if (mySound == null) {
            mySound = MediaPlayer.create(this,R.raw.hairdryer);
            mySound.setLooping(true);
            mySound.start();
        } else if (!mySound.isPlaying()){
            mySound.seekTo(paused);
            mySound.start();
        }

    }

    public void pause(View view) {
        mySound.pause();
        paused = mySound.getCurrentPosition();

    }

    public void stop(View view) {
        mySound.release();
        mySound = null;
    }

    */
}
