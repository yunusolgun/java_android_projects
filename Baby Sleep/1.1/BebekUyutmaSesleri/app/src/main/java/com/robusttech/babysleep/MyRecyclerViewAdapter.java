package com.robusttech.babysleep;

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

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Data> mData;

    public MyRecyclerViewAdapter(Context mContext, List<Data> mData) {
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
        Data data = mData.get(position);
        holder.card_baslik.setText(data.getBaslik());
        Glide.with(mContext).load(data.getResimId()).into(holder.card_image);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,CardActivity.class);
                intent.putExtra("baslik",mData.get(position).getBaslik());
                intent.putExtra("resim",mData.get(position).getResimId());
                intent.putExtra("muzik",mData.get(position).getMuzikId());
                mContext.startActivity(intent);

            }
        });
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
