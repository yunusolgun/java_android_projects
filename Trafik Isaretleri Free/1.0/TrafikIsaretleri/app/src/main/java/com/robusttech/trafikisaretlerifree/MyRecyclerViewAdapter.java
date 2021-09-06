package com.robusttech.trafikisaretlerifree;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Question> mData;

    private AdView mAdView;
    private AdRequest adRequest;

    public MyRecyclerViewAdapter(Context mContext, List<Question> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.cardview_item,parent,false);





        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Question currentQuestion = mData.get(position);
        switch (currentQuestion.getAnswerNr()) {
            case 1:
                holder.card_baslik.setText(currentQuestion.getOption1());
                break;
            case 2:
                holder.card_baslik.setText(currentQuestion.getOption2());
                break;
            case 3:
                holder.card_baslik.setText(currentQuestion.getOption3());
                break;
            case 4:
                holder.card_baslik.setText(currentQuestion.getOption4());
                break;
        }

        holder.card_image.setImageResource(currentQuestion.getResim());


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView card_baslik;
        ImageView card_image;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);

            card_baslik = view.findViewById(R.id.card_text_id);
            card_image = view.findViewById(R.id.card_image_id);
            cardView = view.findViewById(R.id.cardview_id);

        }
    }
}
