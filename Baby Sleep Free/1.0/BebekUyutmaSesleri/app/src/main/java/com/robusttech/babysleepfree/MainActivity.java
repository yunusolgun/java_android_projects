package com.robusttech.babysleepfree;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
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
        MobileAds.initialize(this,"ca-app-pub-7258268445764657~6473905015");
        mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");    //sample
        mInterstitialAd.setAdUnitId("ca-app-pub-7258268445764657/2287974345");
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
        listCards.add(new Data("Hair dryer",R.raw.hairdryer,R.drawable.hairdryer));
        listCards.add(new Data("Washing Machine",R.raw.washingmachine,R.drawable.washingmachine));
        listCards.add(new Data("Blender",R.raw.blender,R.drawable.blender));
        listCards.add(new Data("Car",R.raw.car,R.drawable.car));
        listCards.add(new Data("Ssshhhhh",R.raw.motherhood,R.drawable.motherhood));
        listCards.add(new Data("Vacuum cleaner",R.raw.vacuum,R.drawable.vacuum));
        listCards.add(new Data("Ventilator",R.raw.ventilator,R.drawable.ventilator));
        listCards.add(new Data("TV",R.raw.television,R.drawable.television));
        listCards.add(new Data("Bird",R.raw.bird,R.drawable.bird));
        listCards.add(new Data("Campfire",R.raw.bonfire,R.drawable.bonfire));
        listCards.add(new Data("Faucet",R.raw.faucet,R.drawable.faucet));
        listCards.add(new Data("Heart",R.raw.heart,R.drawable.heart));
        listCards.add(new Data("Rain",R.raw.rain,R.drawable.rain));
        listCards.add(new Data("Storm",R.raw.storm,R.drawable.storm));
        listCards.add(new Data("Trash bag",R.raw.trashbag,R.drawable.trash));
        listCards.add(new Data("Underwater",R.raw.underwater,R.drawable.underwater));
        listCards.add(new Data("Waves",R.raw.waves,R.drawable.waves));


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
        Uri uri = Uri.parse("market://details?id=com.robusttech.babysleep");
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
                    Uri.parse("http://play.google.com/store/apps/details?id=market://details?id=com.robusttech.babysleep")));
        }
    }



}

