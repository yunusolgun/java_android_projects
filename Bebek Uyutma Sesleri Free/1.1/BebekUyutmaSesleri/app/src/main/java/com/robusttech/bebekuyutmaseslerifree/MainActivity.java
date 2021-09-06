package com.robusttech.bebekuyutmaseslerifree;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    List<Data> listCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");      //sample
        MobileAds.initialize(this,"ca-app-pub-7258268445764657~7460517776");
        mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");    //sample
        mInterstitialAd.setAdUnitId("ca-app-pub-7258268445764657/1617890506");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }


        });

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }

        listCards = new ArrayList<>();
        listCards.add(new Data("Saç kurutma makinesi",R.raw.hairdryer,R.drawable.hairdryer));
        listCards.add(new Data("Çamaşır makinesi",R.raw.washingmachine,R.drawable.washingmachine));
        listCards.add(new Data("Blender",R.raw.blender,R.drawable.blender));
        listCards.add(new Data("Araba",R.raw.car,R.drawable.car));
        listCards.add(new Data("Pııışş pışş",R.raw.motherhood,R.drawable.motherhood));
        listCards.add(new Data("Elektrik süpürgesi",R.raw.vacuum,R.drawable.vacuum));
        listCards.add(new Data("Vantilator",R.raw.ventilator,R.drawable.ventilator));
        listCards.add(new Data("Televizyon",R.raw.television,R.drawable.television));
        listCards.add(new Data("Kuş",R.raw.bird,R.drawable.bird));
        listCards.add(new Data("Kamp ateşi",R.raw.bonfire,R.drawable.bonfire));
        listCards.add(new Data("Çeşme",R.raw.faucet,R.drawable.faucet));
        listCards.add(new Data("Kalp ateşi",R.raw.heart,R.drawable.heart));
        listCards.add(new Data("Yağmur",R.raw.rain,R.drawable.rain));
        listCards.add(new Data("Fırtına",R.raw.storm,R.drawable.storm));
        listCards.add(new Data("Çöp poşeti",R.raw.trashbag,R.drawable.trash));
        listCards.add(new Data("Su altı",R.raw.underwater,R.drawable.underwater));
        listCards.add(new Data("Dalgalar",R.raw.waves,R.drawable.waves));


        RecyclerView recyclerView = findViewById(R.id.recyclerview_id);
        MyRecyclerViewAdapter myAdapter = new MyRecyclerViewAdapter(this,listCards);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }



    public void satinAl(View view) {
        Uri uri = Uri.parse("market://details?id=com.robusttech.bebekuyutmasesleri");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=market://details?id=com.robusttech.bebekuyutmasesleri")));
        }
    }




}
