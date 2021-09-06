package com.robusttech.tvizle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    //private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    int reklamatla = 0;
    boolean ilkacilis = true;

    Map<String, String> map = new HashMap<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        MobileAds.initialize(this, "ca-app-pub-7258268445764657~6161133539");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7258268445764657/2399295578");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });





        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);


        if (ilkacilis) {
            // ******** FIREBASE READ  ************
            DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("kanallar");
            dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                        map.put("ucyuzaltmis",(String) snap.child("ucyuzaltmis").getValue());
                        map.put("a2",(String) snap.child("a2").getValue());
                        map.put("ahaber",(String) snap.child("ahaber").getValue());
                        map.put("trtbelgesel",(String) snap.child("trtbelgesel").getValue());
                        map.put("aspor",(String) snap.child("aspor").getValue());
                        map.put("atv",(String) snap.child("atv").getValue());
                        map.put("atvavrupa",(String) snap.child("atvavrupa").getValue());
                        map.put("beinsport",(String) snap.child("beinsport").getValue());
                        map.put("beyaz",(String) snap.child("beyaz").getValue());
                        map.put("eurostar",(String) snap.child("eurostar").getValue());
                        map.put("flash",(String) snap.child("flash").getValue());
                        map.put("fox",(String) snap.child("fox").getValue());
                        map.put("haberturk",(String) snap.child("haberturk").getValue());
                        map.put("halk",(String) snap.child("halk").getValue());
                        map.put("kanal7",(String) snap.child("kanal7").getValue());
                        map.put("kanal24",(String) snap.child("kanal24").getValue());
                        map.put("ntv",(String) snap.child("ntv").getValue());
                        map.put("ntvspor",(String) snap.child("ntvspor").getValue());
                        map.put("show",(String) snap.child("show").getValue());
                        map.put("star",(String) snap.child("star").getValue());
                        map.put("tgrthaber",(String) snap.child("tgrthaber").getValue());
                        map.put("trt1",(String) snap.child("trt1").getValue());
                        map.put("trthaber",(String) snap.child("trthaber").getValue());
                        map.put("trtspor",(String) snap.child("trtspor").getValue());
                        map.put("tv8",(String) snap.child("tv8").getValue());
                        map.put("tv85",(String) snap.child("tv85").getValue());
                        map.put("tvnet",(String) snap.child("tvnet").getValue());
                        map.put("ulke",(String) snap.child("ulke").getValue());
                        map.put("ulusal",(String) snap.child("ulusal").getValue());
                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }

    }


    private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (mInterstitialAd.isLoaded()) {

                        if (reklamatla == 2) {
                            mInterstitialAd.show();
                            reklamatla = 0;
                        }

                        if (ilkacilis) {
                            mInterstitialAd.show();
                            ilkacilis = false;
                            reklamatla = 0;
                        }

                        reklamatla += 1;

                        Intent intent = new Intent(MainActivity.this,Tvizle.class);
                        String kanalstr = kanalsec(finalI);
                        intent.putExtra("info",kanalstr);
                        startActivity(intent);
                    }



                }
            });
        }
    }


    public String kanalsec(int kanal) {
        String myString = "";
        switch (kanal) {
            case 0:
                myString = map.get("ucyuzaltmis");
                break;
            case 1:
                myString = map.get("a2");
                break;
            case 2:
                myString = map.get("ahaber");
                break;
            case 3:
                myString = map.get("trtbelgesel");
                break;
            case 4:
                myString = map.get("aspor");
                break;
            case 5:
                myString = map.get("atv");
                break;
            case 6:
                myString = map.get("atvavrupa");
                break;
            case 7:
                myString = map.get("beinsport");
                break;
            case 8:
                myString = map.get("beyaz");
                break;
            case 9:
                myString = map.get("eurostar");
                break;
            case 10:
                myString = map.get("flash");
                break;
            case 11:
                myString = map.get("fox");
                break;
            case 12:
                myString = map.get("haberturk");
                break;
            case 13:
                myString = map.get("halk");
                break;
            case 14:
                myString = map.get("kanal7");
                break;
            case 15:
                myString = map.get("kanal24");
                break;
            case 16:
                myString = map.get("ntv");
                break;
            case 17:
                myString = map.get("ntvspor");
                break;
            case 18:
                myString = map.get("show");
                break;
            case 19:
                myString = map.get("star");
                break;
            case 20:
                myString = map.get("tgrthaber");
                break;
            case 21:
                myString = map.get("trt1");
                break;
            case 22:
                myString = map.get("trthaber");
                break;
            case 23:
                myString = map.get("trtspor");
                break;
            case 24:
                myString = map.get("tv8");
                break;
            case 25:
                myString = map.get("tv85");
                break;
            case 26:
                myString = map.get("tvnet");
                break;
            case 27:
                myString = map.get("ulke");
                break;
            case 28:
                myString = map.get("ulusal");
                break;
            default:
        }

        return myString;

    }


}
