package com.robusttech.okulsayaci;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView txtTimerDay2, txtTimerHour2, txtTimerMinute2, txtTimerSecond2;
    private TextView tvEvent,tvEvent2;
    private Handler handler;
    private Runnable runnable;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        countDownStartOnbesTatil();
        countDownStartYilSonu();

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-7258268445764657~9347219988");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



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
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            Date futureDate = dateFormat.parse("2017-01-22 00:00");
                            Date currentDate = new Date();
                            if (!currentDate.after(futureDate)) {
                                long diff = futureDate.getTime() - currentDate.getTime();
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
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            Date futureDate = dateFormat.parse("2018-06-08 00:00");
                            Date currentDate = new Date();
                            if (!currentDate.after(futureDate)) {
                                long diff = futureDate.getTime() - currentDate.getTime();
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

                            } else {

                                //textViewGone2();
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

    }

    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(),ResmiTatiller.class);
        //intent.putExtra("name", "1234");
        startActivity(intent);


    }

}
