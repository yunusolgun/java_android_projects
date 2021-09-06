package com.robusttech.trafikisaretlerifree;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.InterstitialAd;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;


    Intent shareIntent;
    String shareBody= "https://play.google.com/store/apps/details?id=com.robusttech.trafikisaretlerifree";


    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        firstTimeUse();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new StartQuiz()).commit();


    }

    public void firstTimeUse() {
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            drawer.openDrawer(Gravity.LEFT);
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_paylas) {

            paylas();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void paylas() {

        shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Trafik işaretleri testi. 20 soruyu da doğru cevaplıyabilir misin?");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(shareIntent,"Paylaş"));

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_test) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new StartQuiz()).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new QuizActivity()).commit();
        } else if (id == R.id.nav_uyari) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IsaretlerTehlikeUyari()).commit();
        } else if (id == R.id.nav_tanzim) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IsaretlerTrafikTanzim()).commit();
        } else if (id == R.id.nav_bilgi) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IsaretlerBilgi()).commit();
        } else if (id == R.id.nav_parketme) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IsaretlerDurmaVeParketme()).commit();
        } else if (id == R.id.nav_yatay) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IsaretlerYatay()).commit();
        } else if (id == R.id.nav_yeniisaretler) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new IsaretlerYeni()).commit();
        } else if (id == R.id.nav_ayarlar) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Ayarlar()).commit();
        } else if (id == R.id.nav_reklamsiz) {
            satinAl();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void satinAl() {
        Uri uri = Uri.parse("market://details?id=com.robusttech.trafikisaretleri");
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
                    Uri.parse("http://play.google.com/store/apps/details?id=market://details?id=com.robusttech.trafikisaretleri")));
        }
    }
}
