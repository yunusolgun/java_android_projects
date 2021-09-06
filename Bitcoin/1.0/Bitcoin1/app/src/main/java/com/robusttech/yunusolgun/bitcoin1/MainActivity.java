package com.robusttech.yunusolgun.bitcoin1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewBtcturk1,textViewBtcturk2,textViewBtcturk3,textViewBtcturk4;
    TextView textViewKoineks1,textViewKoineks2,textViewKoineks3,textViewKoineks4;
    TextView textViewParibu1,textViewParibu2,textViewParibu3,textViewParibu4;
    TextView textViewKoinim1,textViewKoinim2,textViewKoinim3,textViewKoinim4;

    ImageView bitcoin1;

    public void getAgain(View view) {

        Random random = new Random();
        float f = random.nextInt(400);

        bitcoin1 = (ImageView) findViewById(R.id.bitcoinImageView1);
        bitcoin1.setTranslationX(f);
        bitcoin1.setTranslationY(-200f);
        bitcoin1.setVisibility(View.VISIBLE);
        bitcoin1.animate()
                .translationYBy(1000f).rotationBy(720).setDuration(2000);

        DownloadTask btcturk = new DownloadTask();
        btcturk.execute("https://www.btcturk.com/api/ticker","btcturk");

        DownloadTask koineks = new DownloadTask();
        koineks.execute("https://koineks.com/ticker","koineks");

        DownloadTask paribu = new DownloadTask();
        paribu.execute("https://www.paribu.com/ticker","paribu");

        DownloadTask koinim = new DownloadTask();
        koinim.execute("https://koinim.com/ticker", "koinim");


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DownloadTask btcturk = new DownloadTask();
        btcturk.execute("https://www.btcturk.com/api/ticker","btcturk");

        DownloadTask koineks = new DownloadTask();
        koineks.execute("https://koineks.com/ticker","koineks");

        DownloadTask paribu = new DownloadTask();
        paribu.execute("https://www.paribu.com/ticker","paribu");

        DownloadTask koinim = new DownloadTask();
        koinim.execute("https://koinim.com/ticker", "koinim");


    }


 /*   public void getAgain(View view) {
        Log.i("cikti","deneme");
        animasyon();
    }*/


    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                //Log.i("cikti",urls[1]+"AAA"+result);
                return urls[1]+"AAA"+result;


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            String [] site = result.split("AAA");
            //Log.i("cikti5",site[0]);
            //Log.i("cikti6",site[1]);

            String sell = null,high= null,low= null,volume = null;


            switch (site[0]) {
                case "koinim":
                    //Log.i("cikti site adi", "koinim");
                    try {
                        //Log.i("cikti-koinum",result);
                        JSONObject jsonObject = new JSONObject(site[1]);
                        sell = jsonObject.getString("sell");
                        high = jsonObject.getString("high");
                        low = jsonObject.getString("low");
                        volume = jsonObject.getString("volume");

                        textViewKoinim1 = (TextView) findViewById(R.id.textViewKoinim1);
                        textViewKoinim2 = (TextView) findViewById(R.id.textViewKoinim2);
                        textViewKoinim3 = (TextView) findViewById(R.id.textViewKoinim3);
                        textViewKoinim4 = (TextView) findViewById(R.id.textViewKoinim4);

                        textViewKoinim1.setText(sell + " TL");
                        textViewKoinim2.setText(high);
                        textViewKoinim3.setText(low);
                        textViewKoinim4.setText(volume);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "btcturk":
                    //Log.i("cikti site adi", "btcturk");
                    try {
                        //Log.i("cikti-btcturk",result);
                        JSONArray arr = new JSONArray(site[1]);

                        JSONObject jsonPart = arr.getJSONObject(0); //0=BTCTRY , 1=ETHBTC, 2=ETHTRY
                        sell=jsonPart.getString("last");
                        high=jsonPart.getString("high");
                        low=jsonPart.getString("low");
                        volume=jsonPart.getString("volume");

                        textViewBtcturk1 = (TextView) findViewById(R.id.textViewBtcturk1);
                        textViewBtcturk2 = (TextView) findViewById(R.id.textViewBtcturk2);
                        textViewBtcturk3 = (TextView) findViewById(R.id.textViewBtcturk3);
                        textViewBtcturk4 = (TextView) findViewById(R.id.textViewBtcturk4);

                        textViewBtcturk1.setText(sell + " TL");
                        textViewBtcturk2.setText(high);
                        textViewBtcturk3.setText(low);
                        textViewBtcturk4.setText(volume);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "paribu":
                    //Log.i("cikti site adi", "paribu");
                    try {

                        JSONObject jsonObject = new JSONObject(site[1]);
                        String altsite = jsonObject.getString("BTC_TL");
                        JSONObject jsonObject2 = new JSONObject(altsite);
                        sell = jsonObject2.getString("last");
                        high = jsonObject2.getString("high24hr");
                        low = jsonObject2.getString("low24hr");
                        volume = jsonObject2.getString("volume");

                        textViewParibu1 = (TextView) findViewById(R.id.textViewParibu1);
                        textViewParibu2 = (TextView) findViewById(R.id.textViewParibu2);
                        textViewParibu3 = (TextView) findViewById(R.id.textViewParibu3);
                        textViewParibu4 = (TextView) findViewById(R.id.textViewParibu4);

                        textViewParibu1.setText(sell + " TL");
                        textViewParibu2.setText(high);
                        textViewParibu3.setText(low);
                        textViewParibu4.setText(volume);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "koineks":
                    //Log.i("cikti site adi", "koineks");
                    try {

                        JSONObject jsonObject = new JSONObject(site[1]);
                        String altsite = jsonObject.getString("BTC");
                        JSONObject jsonObject2 = new JSONObject(altsite);
                        sell = jsonObject2.getString("current");
                        high = jsonObject2.getString("high");
                        low = jsonObject2.getString("low");
                        volume = jsonObject2.getString("volume");

                        textViewKoineks1 = (TextView) findViewById(R.id.textViewKoineks1);
                        textViewKoineks2 = (TextView) findViewById(R.id.textViewKoineks2);
                        textViewKoineks3 = (TextView) findViewById(R.id.textViewKoineks3);
                        textViewKoineks4 = (TextView) findViewById(R.id.textViewKoineks4);

                        textViewKoineks1.setText(sell + " TL");
                        textViewKoineks2.setText(high);
                        textViewKoineks3.setText(low);
                        textViewKoineks4.setText(volume);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }

            //String logcikti= sell +" *** " + high+ " *** " + low +" *** " + volume;
            //Log.i("cikti",logcikti);

        }

    }
}
