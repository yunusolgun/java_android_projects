package com.robusttech.ehliyet2018;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.robusttech.ehliyet2018.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Ehliyet2018.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_RESIM + " INTEGER, " +
                QuestionsTable.COLUMN_GECERLISORU + " INTEGER, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_SINAV_NO + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {

        /*
        //gecerliSoru=0 --> soru iptal

        sinavNo=1 --> Agustos 2018
        sinavNo=2 --> Nisan 2018
         */

        Question question;

        // ********************* AGUSTOS 2018 (sinavNo=1) ********************
        question = new Question(R.drawable.agustos201801,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201802,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201803,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201804,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201805,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201806,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201807,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201808,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201809,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201810,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201811,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201812,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201813,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201814,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201815,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201816,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201817,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201818,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201819,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201820,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201821,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201822,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201823,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201824,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201825,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201826,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201827,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201828,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201829,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201830,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201831,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201832,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201833,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201834,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201835,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201836,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201837,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201838,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201839,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201840,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201841,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201842,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201843,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201844,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201845,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201846,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.agustos201847,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.agustos201848,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.agustos201849,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.agustos201850,1, 4,1); addQuestion(question);


        // ********************* NISAN 2018 (sinavNo=2) ********************
        question = new Question(R.drawable.nisan201801,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201802,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201803,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201804,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201805,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201806,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201807,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201808,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201809,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201810,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201811,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201812,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201813,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201814,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201815,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201816,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201817,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201818,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201819,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201820,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201821,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201822,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201823,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201824,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201825,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201826,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201827,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201828,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201829,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201830,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201831,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201832,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201833,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201834,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201835,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201836,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201837,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201838,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201839,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201840,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201841,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201842,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201843,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201844,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201845,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201846,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.nisan201847,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.nisan201848,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.nisan201849,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.nisan201850,1, 4,2); addQuestion(question);


    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_RESIM, question.getResim());
        cv.put(QuestionsTable.COLUMN_GECERLISORU, question.getGecerliSoru());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_SINAV_NO, question.getSinavNo());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    public List<Question> getAllQuestions(int sinavNo) {

        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c;

        sinavNo++;
        c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_SINAV_NO + " = ?", new String[]{sinavNo + ""});

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setResim(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_RESIM)));
                question.setGecerliSoru(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_GECERLISORU)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();

        //Collections.shuffle(questionList);
        //return questionList.subList(0,sinavSoruAdedi);


        return questionList;
    }


    public List<Question> getIsaretler(int isaretTipi) {

        /*
        isaretTipi=1    ->  Tehlike Uyari İşaretleri
        isaretTipi=2    ->  Trafik Tanzim İşaretleri
        isaretTipi=3    ->  Bilgi İşaretleri
        isaretTipi=4    ->  Durma ve Parketme İşaretleri
        isaretTipi=5    ->  Yatay İşaretleme
        isaretTipi=6    ->  Yeni İşaretler
         */

        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE "+ QuestionsTable.COLUMN_SINAV_NO + " = ?", new String[]{isaretTipi+""});

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setResim(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_RESIM)));
                question.setGecerliSoru(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_GECERLISORU)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}
