package com.robusttech.schoolcounterus;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView txtTimerDay2, txtTimerHour2, txtTimerMinute2, txtTimerSecond2;
    private TextView txtUyari;
    private TextView txtTatilAdi1;
    private TextView tvEvent,tvEvent2;
    private Handler handler;
    private Runnable runnable;
    private InterstitialAd mInterstitialAd;

    Intent shareIntent;
    String shareBody= "Nice app :)";
    String onbestatil="Nearest holiday= 0:0:0:0\n";
    String okultatil="Last day of school= 0:0:0:0\n";

    Date [] holidayDates = {
            fromString("2018-09-06 00:00"),
            fromString("2018-09-10 00:00"),
            fromString("2018-11-22 00:00"),
            fromString("2018-12-24 00:00"),
            fromString("2019-02-18 00:00"),
            fromString("2019-04-19 00:00"),
            fromString("2019-06-26 00:00")
    };

    String [] holidayNames = {
            "First Day of School",
            "Rosh Hashanah Break",
            "Thanksgiving Break",
            "Christmas Break",
            "Mid Winter Break",
            "Spring Break",
            "Last Day of School"
    };


    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date nextHolidayDate;
    String tatilAdi1,tatilAdi2;


    private static final Date fromString( String spec ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return dateFormat.parse( spec );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton shareButton = findViewById(R.id.imageButton);


        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView) findViewById(R.id.tvhappyevent);

        txtTimerDay2 = (TextView) findViewById(R.id.txtTimerDay2);
        txtTimerHour2 = (TextView) findViewById(R.id.txtTimerHour2);
        txtTimerMinute2 = (TextView) findViewById(R.id.txtTimerMinute2);
        txtTimerSecond2 = (TextView) findViewById(R.id.txtTimerSecond2);
        tvEvent2 = (TextView) findViewById(R.id.tvhappyevent2);

        txtTatilAdi1 = (TextView) findViewById(R.id.textView7);

        txtUyari = findViewById(R.id.textView6);

        //MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");      //sample
        MobileAds.initialize(this,"ca-app-pub-7258268445764657~2043783648");
        mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");    //sample
        mInterstitialAd.setAdUnitId("ca-app-pub-7258268445764657/4095231916");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial.
//                mInterstitialAd.loadAd(new AdRequest.Builder().build());
//            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        MainActivity.this.mInterstitialAd.show();
                    }
                }, 5000);
            }

        });


        countDownStartOnbesTatil();
        countDownStartYilSonu();







//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial.
//                mInterstitialAd.loadAd(new AdRequest.Builder().build());
//            }
//
//        });

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
//        MobileAds.initialize(this, "ca-app-pub-7258268445764657~9347219988");
//        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);



        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                shareBody="School counter \n\n" + onbestatil + okultatil + "\nDownload from Google Play Store:  https://play.google.com/store/apps/details?id=com.robusttech.schoolcounterus";
                shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"School Counter");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent,"Share"));


            }
        });

    }

    public void countDownStartOnbesTatil() {

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // If you want to modify a view in your Activity
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            Date currentDate = new Date();

                            for (int i=0;i< holidayDates.length;i++) {
                                nextHolidayDate=holidayDates[i];
                                tatilAdi1 = holidayNames[i];
                                if (currentDate.before(holidayDates[i])) {
                                    break;
                                }
                            }

                            txtTatilAdi1.setText("Nearest holiday: " + tatilAdi1);



                            if (!currentDate.after(nextHolidayDate)) {
                                long diff = nextHolidayDate.getTime() - currentDate.getTime();
                                long days = diff / (24 * 60 * 60 * 1000);
                                diff -= days * (24 * 60 * 60 * 1000);
                                long hours = diff / (60 * 60 * 1000);
                                diff -= hours * (60 * 60 * 1000);
                                long minutes = diff / (60 * 1000);
                                diff -= minutes * (60 * 1000);
                                long seconds = diff / 1000;
                                txtTimerDay.setText("" + String.format("%02d", days));
                                txtTimerHour.setText("" + String.format("%02d", hours));
                                txtTimerMinute.setText("" + String.format("%02d", minutes));
                                txtTimerSecond.setText("" + String.format("%02d", seconds));
                                onbestatil=String.format("Nearest holiday of school countdown= %02d Days: %02d Hours: %02d Minutes: %02d Seconds\n",days,hours,minutes,seconds);

                            } else {

                                textViewGone();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, 1000, 1000); // initial delay 1 second, interval 1 second
    }
    public void countDownStartYilSonu() {
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // If you want to modify a view in your Activity
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            nextHolidayDate = dateFormat.parse("2019-06-14 00:00");
                            Date currentDate = new Date();


                            nextHolidayDate=holidayDates[holidayDates.length-1];




                            if (!currentDate.after(nextHolidayDate)) {
                                long diff = nextHolidayDate.getTime() - currentDate.getTime();
                                long days = diff / (24 * 60 * 60 * 1000);
                                diff -= days * (24 * 60 * 60 * 1000);
                                long hours = diff / (60 * 60 * 1000);
                                diff -= hours * (60 * 60 * 1000);
                                long minutes = diff / (60 * 1000);
                                diff -= minutes * (60 * 1000);
                                long seconds = diff / 1000;
                                txtTimerDay2.setText("" + String.format("%02d", days));
                                txtTimerHour2.setText("" + String.format("%02d", hours));
                                txtTimerMinute2.setText("" + String.format("%02d", minutes));
                                txtTimerSecond2.setText("" + String.format("%02d", seconds));
                                okultatil=String.format("Lastday of school countdown= %02d Days: %02d Hours: %02d Minutes: %02d Seconds\n",days,hours,minutes,seconds);

                            } else {


                                textViewGone2();


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, 1000, 1000); // initial delay 1 second, interval 1 second
    }




    public void textViewGone() {
        /*
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
       findViewById(R.id.textView1).setVisibility(View.GONE);
        tvEvent.setVisibility(View.VISIBLE);
        tvEvent.setText("İyi Tatiller !");
        */
        txtTimerDay.setText("" + String.format("%02d", 0));
        txtTimerHour.setText("" + String.format("%02d", 0));
        txtTimerMinute.setText("" + String.format("%02d", 0));
        txtTimerSecond.setText("" + String.format("%02d", 0));



    }

    public void textViewGone2() {
        /*
        findViewById(R.id.LinearLayout20).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout21).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout22).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout23).setVisibility(View.GONE);
        findViewById(R.id.textView1).setVisibility(View.GONE);
        tvEvent2.setVisibility(View.VISIBLE);
        tvEvent2.setText("İyi Tatiller !");
        */
        txtTimerDay2.setText("" + String.format("%02d", 0));
        txtTimerHour2.setText("" + String.format("%02d", 0));
        txtTimerMinute2.setText("" + String.format("%02d", 0));
        txtTimerSecond2.setText("" + String.format("%02d", 0));

        txtUyari.setVisibility(View.VISIBLE);

    }

    public void onClick(View v) {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }


        Intent intent = new Intent(getApplicationContext(),ResmiTatiller.class);
        //intent.putExtra("name", "1234");
        startActivity(intent);


    }

}
