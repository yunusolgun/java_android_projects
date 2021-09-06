package com.robusttech.ehliyet2017;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.List;
import java.util.Locale;

public class QuizActivity extends Fragment {
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 3600300;

    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button buttonNext;
    private ImageView resim;
    private ImageView iptalResmi;


    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private int iptalSoruSayisi;
    private boolean answered;

    private boolean sinavBitti;


    private int sinavKonusu;
    public MediaPlayer mySoundTrue,mySoundFalse,mySoundCountdown;
    public boolean geriSayimUyariSesi;

    View view;

    private InterstitialAd mInterstitialAd;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //MobileAds.initialize(getContext(),"ca-app-pub-3940256099942544~3347511713");      //sample
        MobileAds.initialize(getContext(),"ca-app-pub-7258268445764657~1062853124");

        mInterstitialAd = new InterstitialAd(getContext());
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");    //sample
        mInterstitialAd.setAdUnitId("ca-app-pub-7258268445764657/4655447925");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });



        if (getArguments() != null) {
            sinavKonusu = getArguments().getInt("konu");
        }

        if (sinavKonusu==0) {
            ((MainActivity) getActivity()).setActionBarTitle("Ehliyet 2017 - Aralık");
        } else if (sinavKonusu==1) {
            ((MainActivity) getActivity()).setActionBarTitle("Ehliyet 2017 - Ekim");
        } else if (sinavKonusu==2) {
            ((MainActivity) getActivity()).setActionBarTitle("Ehliyet 2017 - Temmuz");
        } else if (sinavKonusu==3) {
            ((MainActivity) getActivity()).setActionBarTitle("Ehliyet 2017 - Mayıs");
        } else if (sinavKonusu==4) {
            ((MainActivity) getActivity()).setActionBarTitle("Ehliyet 2017 - Şubat");
        }

        if (mySoundTrue == null) {
            mySoundTrue = MediaPlayer.create(getContext(),R.raw.dogru);
        }
        if (mySoundFalse == null) {
            mySoundFalse = MediaPlayer.create(getContext(),R.raw.yanlis);
        }
        if (mySoundCountdown== null) {
            mySoundCountdown = MediaPlayer.create(getContext(),R.raw.gerisay5);
        }
        geriSayimUyariSesi=false;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_quiz,container,false);

        sinavBitti=false;
        answered =false;

        textViewScore =view.findViewById(R.id.text_view_score);
        textViewQuestionCount=view.findViewById(R.id.text_view_question_count);
        textViewCountDown=view.findViewById(R.id.text_view_countdown);
        rbGroup = view.findViewById(R.id.radio_group);
        rb1=view.findViewById(R.id.radio_button1);
        rb2=view.findViewById(R.id.radio_button2);
        rb3=view.findViewById(R.id.radio_button3);
        rb4=view.findViewById(R.id.radio_button4);
        buttonNext = view.findViewById(R.id.button_sonraki);
        resim = view.findViewById(R.id.imageView);
        iptalResmi = view.findViewById(R.id.imageView2);


        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        QuizDbHelper dbHelper = new QuizDbHelper(getContext());
        questionList = dbHelper.getAllQuestions(sinavKonusu);
        questionCountTotal = questionList.size();

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();

        showNextQuestion();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (answered) {
                    showNextQuestion();
                    radioButtonsEnabled();
                } else {
                    if (currentQuestion.getGecerliSoru() == 1) {
                        if (!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) {
                            Toast.makeText(getContext(), "Lütfen cevabı seçiniz", Toast.LENGTH_SHORT).show();
                        }
                    }  else if (currentQuestion.getGecerliSoru() == 0) {
                        showNextQuestion();
                        radioButtonsEnabled();
                    }
                }


                if (sinavBitti) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,new StartQuiz()).commit();
                }


            }
        });



        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                    radioButtonsDisabled();
                    checkAnswer();
                }


            }
        });



        return view;
    }




    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            resim.setImageResource(currentQuestion.getResim());
            if (currentQuestion.getGecerliSoru() == 0) {
                iptalResmi.setVisibility(View.VISIBLE);
                radioButtonsDisabled();
                iptalSoruSayisi++;
            } else {
                iptalResmi.setVisibility(View.INVISIBLE);
            }

            questionCounter++;
            textViewQuestionCount.setText("Soru: " + questionCounter + "/" + questionCountTotal);
            answered = false;

            //timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            //startCountDown();
        } else {
            finishQuiz();
        }

        reklamGoster();
    }


    private void reklamGoster() {

        if (questionCounter%9 == 0) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }

    }


    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                //checkAnswer();
            }
        }.start();
    }


    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis > 5500 && timeLeftInMillis < 300300) {
            textViewCountDown.setTextColor(Color.YELLOW);
        } else if (timeLeftInMillis < 5400) {
            textViewCountDown.setTextColor(Color.RED);
            geriSayimUyariSesi=true;
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }


        if (geriSayimUyariSesi) {

           if (!mySoundCountdown.isPlaying()) {
                mySoundCountdown.start();
            }

        }


    }


    private void checkAnswer() {
        answered = true;

        if (mySoundCountdown.isPlaying()) {
            mySoundCountdown.pause();
        }


        geriSayimUyariSesi=false;

        RadioButton rbSelected = view.findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (currentQuestion.getGecerliSoru() == 1) {
            if (answerNr == currentQuestion.getAnswerNr()) {
                score++;
                textViewScore.setText("Dogru: " + score);
                mySoundTrue.start();
            } else {
                mySoundFalse.start();
            }
        }

        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        if (currentQuestion.getGecerliSoru() == 1) {
            switch (currentQuestion.getAnswerNr()) {
                case 1:
                    rb1.setTextColor(Color.GREEN);
                    break;
                case 2:
                    rb2.setTextColor(Color.GREEN);
                    break;
                case 3:
                    rb3.setTextColor(Color.GREEN);
                    break;
                case 4:
                    rb4.setTextColor(Color.GREEN);
                    break;
            }
        }

        if (questionCounter < questionCountTotal) {
            buttonNext.setText("Sonraki Soru");
        } else {
            buttonNext.setText("..::SINAV BİTTİ. Yeni Test::..");
            sinavBitti=true;

            mySoundTrue.release();
            mySoundFalse.release();
            mySoundCountdown.release();
            mySoundTrue=null;
            mySoundFalse=null;
            mySoundCountdown=null;


            Bundle bundle = new Bundle();
            bundle.putInt("dogrular",score);

            double puan = ((double)score /(double)(questionCountTotal - iptalSoruSayisi)) * 100;
            int puanint = (int) (puan + 0.5);

            if (puanint > 69) {
                bundle.putBoolean("sonuc",true);
            } else {
                bundle.putBoolean("sonuc",false);
            }

            bundle.putInt("puan",puanint);

            FragmentManager fm= getFragmentManager();
            MyDialogFragment dialogFragment = new MyDialogFragment();
            dialogFragment.setArguments(bundle);
            dialogFragment.show(fm,"SINAV BITTI");

        }

        radioButtonsDisabled();

    }


    private void radioButtonsEnabled() {
        rb1.setEnabled(true);rb2.setEnabled(true);rb3.setEnabled(true);rb4.setEnabled(true);
    }

    private void radioButtonsDisabled() {
        rb1.setEnabled(false);rb2.setEnabled(false);rb3.setEnabled(false);rb4.setEnabled(false);
    }


    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }


        if (mySoundTrue != null) {
            mySoundTrue.release();
        }
        if (mySoundFalse != null) {
            mySoundTrue.release();
        }
        if (mySoundCountdown != null) {
            mySoundCountdown.release();
        }

    }
}
