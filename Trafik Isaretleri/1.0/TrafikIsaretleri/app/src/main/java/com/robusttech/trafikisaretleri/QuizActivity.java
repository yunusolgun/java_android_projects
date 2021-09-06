package com.robusttech.trafikisaretleri;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends Fragment {
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 15100;

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


    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;

    private boolean sinavBitti;

    private long backPressedTime;

    private int sinavKonusu;
    public MediaPlayer mySoundTrue,mySoundFalse,mySoundCountdown;
    public boolean geriSayimUyariSesi;

    View view;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sinavKonusu = getArguments().getInt("konu");
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


        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        QuizDbHelper dbHelper = new QuizDbHelper(getContext());
        questionList = dbHelper.getAllQuestions(sinavKonusu);
        questionCountTotal = questionList.size();
        //Collections.shuffle(questionList);

        showNextQuestion();

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered) {
                    showNextQuestion();
                    radioButtonsEnabled();
                } else {
                    if (!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) {
                        Toast.makeText(getContext(), "Lütfen cevabı seçiniz", Toast.LENGTH_SHORT).show();
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

            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            resim.setImageResource(currentQuestion.getResim());

            questionCounter++;
            textViewQuestionCount.setText("Soru: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            //buttonNext.setText("Onayla");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
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
                checkAnswer();
            }
        }.start();
    }


    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 5100) {
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

        countDownTimer.cancel();

        if (mySoundCountdown.isPlaying()) {
            mySoundCountdown.pause();
        }


        geriSayimUyariSesi=false;

        RadioButton rbSelected = view.findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
            textViewScore.setText("Skor: " + score);
            mySoundTrue.start();
        } else {
            mySoundFalse.start();
        }

        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

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


            FragmentManager fm= getFragmentManager();
            MyDialogFragment dialogFragment = new MyDialogFragment();
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
