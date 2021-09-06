package com.robusttech.ehliyetpro;

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


import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Question> mData;


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
        final Question currentQuestion = mData.get(position);
        holder.card_baslik.setText(currentQuestion.getBaslik());
        holder.card_aciklama.setText(currentQuestion.getAciklama());
        holder.card_image.setImageResource(currentQuestion.getResim());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uygulama="";
                switch (position) {
                    case 0:
                        uygulama="trafikisaretlerifree";
                        break;
                }

                Intent intent = new Intent(mContext,DigerUygulamarCagir.class);
                intent.putExtra("uygulama",uygulama);
                mContext.startActivity(intent);
            }
        });

    }





    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView card_baslik,card_aciklama;
        ImageView card_image;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);

            card_baslik = view.findViewById(R.id.card_text_id);
            card_aciklama = view.findViewById(R.id.card_text_id2);
            card_image = view.findViewById(R.id.card_image_id);
            cardView = view.findViewById(R.id.cardview_id);

        }
    }


}
