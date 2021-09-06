package com.robusttech.tvizle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tvizle extends AppCompatActivity {

    WebView webview;




    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
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
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"İnternet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();
                return "Failed";
            }




        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvizle);






        webview = new WebView(this);
        setContentView(webview);

        final WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setPluginState(WebSettings.PluginState.ON);


        webview.setWebViewClient(new WebViewClient() {
            // autoplay when finished loading via javascript injection
            public void onPageFinished(WebView view, String url) { webview.loadUrl("javascript:(function() { document.getElementsByTagName('video')[0].play(); })()"); }
        });
        webview.setWebChromeClient(new WebChromeClient());

        //  ESKI  webview.loadUrl("http://kanal.canlitvlive.io/trt1/live.m3u8?tkn=35dbhPlUkZyCTFcpNHNKCA&tms=1520698198");




        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            // ESKI Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();


            //***************

            DownloadTask task = new DownloadTask();
            String result = null;
            try {
                result = task.execute(info).get();
                //ESKI String[] splitResult = result.split("file : \"");
                Pattern p = Pattern.compile("file : \"(.*?)\"");
                Matcher m = p.matcher(result);
                while (m.find()) {

                    if (m.group(1) != null) {
                        webview.loadUrl(m.group(1));
                    } else {
                        Toast.makeText(getApplicationContext(),"Daha sonra deneyiniz", Toast.LENGTH_LONG).show();
                    }


                }

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"İnternet bağlantınızı kontrol ediniz", Toast.LENGTH_LONG).show();

            }



        }





    }
}
