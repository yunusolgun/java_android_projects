package com.robusttech.trafikisaretleri;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class IsaretlerDurmaVeParketme extends Fragment {

    View view;
    private List<Question> questionList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cardview,container,false);



        QuizDbHelper dbHelper = new QuizDbHelper(getContext());
        questionList = dbHelper.getIsaretler(4);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_id);
        MyRecyclerViewAdapter myAdapter = new MyRecyclerViewAdapter(getContext(),questionList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(myAdapter);


        return view;
    }
}

