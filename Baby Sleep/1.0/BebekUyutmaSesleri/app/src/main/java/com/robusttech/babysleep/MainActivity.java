package com.robusttech.babysleep;

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
}
