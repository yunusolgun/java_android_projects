package com.robusttech.ehliyet2016;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialogFragment extends DialogFragment {

    MediaPlayer mySoundSinavBitti;
    private int dogruSay;
    private boolean sonuc;
    private int puan;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_sample_dialog,container,false);
        getDialog().setTitle("SINAV BITTI");

        if (getArguments() != null) {
            dogruSay = getArguments().getInt("dogrular");
            puan = getArguments().getInt("puan");
            sonuc = getArguments().getBoolean("sonuc",false);
        }
        TextView textView = rootView.findViewById(R.id.textViewDogruSayisi);
        TextView textViewBaslik = rootView.findViewById(R.id.baslik);
        ImageView imageView = rootView.findViewById(R.id.image_fragment);

        if (sonuc) {
            imageView.setImageResource(R.drawable.smileyface);
            mySoundSinavBitti = MediaPlayer.create(getContext(),R.raw.gectin);
            textViewBaslik.setText("SINAVI GEÇTİNİZ");
            textView.setTextColor(Color.GREEN);
        } else {
            imageView.setImageResource(R.drawable.sadface);
            mySoundSinavBitti = MediaPlayer.create(getContext(),R.raw.kaldin);
            textViewBaslik.setText("SINAVDAN KALDINIZ");
            textView.setTextColor(Color.RED);
        }

        textView.setText("Doğru sayısı: " + dogruSay + "   -   Puan: "+puan);
        mySoundSinavBitti.start();


        Button dismiss = rootView.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

}
