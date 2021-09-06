package com.robusttech.bebekuyutmasesleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Data> listCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
