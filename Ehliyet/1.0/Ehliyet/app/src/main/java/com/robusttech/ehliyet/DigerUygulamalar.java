package com.robusttech.ehliyet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class DigerUygulamalar extends Fragment {

    View view;
    private List<Question> questionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cardview,container,false);

        questionList = new ArrayList<>();

        //public Question(int resim, int gecerliSoru, int answerNr, int sinavNo)
        questionList.add(new Question(R.drawable.trafikisaretleriapp,"Trafik İşaretleri","Trafik işaretlerininin anlamını biliyor musun?\n Testte kaçta kaç yapabilirsin?\n Ücretsiz bu uygulama ile kendini ölç"));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_id);
        MyRecyclerViewAdapter myAdapter = new MyRecyclerViewAdapter(getContext(),questionList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(myAdapter);


        return view;
    }


}
