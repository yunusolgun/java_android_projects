package com.robusttech.ehliyet2017;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class StartQuiz extends Fragment {

    private Button startButton;
    private Spinner spinnerSecenek;

    View view;

    MediaPlayer mySoundQuizStart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mySoundQuizStart = MediaPlayer.create(getContext(),R.raw.startquiz);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_startquiz,container,false);

        startButton = view.findViewById(R.id.button_start);
        spinnerSecenek = view.findViewById(R.id.spinner_secenek);
        ((MainActivity) getActivity()).setActionBarTitle("Ehliyet 2017");

        String[] sinavKonuSecenekler=Question.getAllSecenek();

        ArrayAdapter<String> adapterSinavKonu = new ArrayAdapter<String >(getContext(),R.layout.spinner_item,sinavKonuSecenekler);
        //ArrayAdapter<String> adapterSinavKonu = new ArrayAdapter<String >(getContext(),android.R.layout.simple_spinner_item,sinavKonuSecenekler);
        adapterSinavKonu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapterSinavKonu.setDropDownViewResource(R.layout.spinner_item);
        spinnerSecenek.setAdapter(adapterSinavKonu);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mySoundQuizStart.start();

                int sinavKonu= spinnerSecenek.getSelectedItemPosition();
                Bundle bundle = new Bundle();
                bundle.putInt("konu",sinavKonu);
                QuizActivity myObj = new QuizActivity();
                myObj.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.fragment_container,myObj).commit();
            }
        });

        return view;
    }
}
