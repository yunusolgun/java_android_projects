package com.robusttech.ehliyetpro2017;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.robusttech.ehliyetpro2017.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Ehliyetpro2017.db";
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

        // ********************* ARALIK 2017 (sinavNo=1) ********************
        question = new Question(R.drawable.aralik201701,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201702,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201703,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201704,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201705,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201706,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201707,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201708,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201709,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201710,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201711,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201712,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201713,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201714,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201715,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201716,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201717,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201718,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201719,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201720,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201721,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201722,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201723,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201724,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201725,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201726,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201727,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201728,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201729,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201730,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201731,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201732,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201733,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201734,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201735,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201736,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201737,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201738,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201739,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201740,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201741,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201742,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201743,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201744,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201745,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201746,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201747,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201748,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201749,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201750,1, 4,1); addQuestion(question);


        // ********************* EKIM 2017 (sinavNo=2) ********************
        question = new Question(R.drawable.ekim201701,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201702,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201703,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201704,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201705,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201706,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201707,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201708,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201709,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201710,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201711,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201712,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201713,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201714,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201715,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201716,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201717,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201718,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201719,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201720,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201721,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201722,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201723,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201724,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201725,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201726,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201727,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201728,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201729,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201730,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201731,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201732,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201733,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201734,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201735,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201736,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201737,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201738,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201739,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201740,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201741,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201742,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201743,0, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201744,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201745,1, 3,2); addQuestion(question);
        question = new Question(R.drawable.ekim201746,1, 2,2); addQuestion(question);
        question = new Question(R.drawable.ekim201747,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201748,1, 4,2); addQuestion(question);
        question = new Question(R.drawable.ekim201749,1, 1,2); addQuestion(question);
        question = new Question(R.drawable.ekim201750,1, 3,2); addQuestion(question);


        // ********************* TEMMUZ 2017 (sinavNo=3) ********************
        question = new Question(R.drawable.temmuz201701,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201702,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201703,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201704,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201705,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201706,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201707,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201708,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201709,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201710,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201711,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201712,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201713,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201714,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201715,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201716,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201717,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201718,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201719,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201720,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201721,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201722,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201723,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201724,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201725,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201726,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201727,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201728,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201729,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201730,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201731,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201732,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201733,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201734,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201735,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201736,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201737,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201738,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201739,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201740,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201741,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201742,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201743,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201744,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201745,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201746,1, 2,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201747,1, 4,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201748,1, 1,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201749,1, 3,3); addQuestion(question);
        question = new Question(R.drawable.temmuz201750,1, 2,3); addQuestion(question);


        // ********************* MAYIS 2017 (sinavNo=4) ********************
        question = new Question(R.drawable.mayis201701,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201702,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201703,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201704,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201705,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201706,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201707,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201708,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201709,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201710,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201711,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201712,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201713,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201714,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201715,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201716,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201717,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201718,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201719,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201720,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201721,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201722,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201723,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201724,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201725,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201726,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201727,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201728,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201729,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201730,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201731,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201732,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201733,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201734,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201735,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201736,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201737,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201738,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201739,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201740,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201741,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201742,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201743,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201744,1, 4,4); addQuestion(question);
        question = new Question(R.drawable.mayis201745,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201746,1, 1,4); addQuestion(question);
        question = new Question(R.drawable.mayis201747,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201748,1, 2,4); addQuestion(question);
        question = new Question(R.drawable.mayis201749,1, 3,4); addQuestion(question);
        question = new Question(R.drawable.mayis201750,1, 2,4); addQuestion(question);

        // ********************* SUBAT 2017 (sinavNo=5) ********************
        question = new Question(R.drawable.subat201701,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201702,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201703,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201704,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201705,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201706,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201707,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201708,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201709,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201710,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201711,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201712,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201713,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201714,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201715,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201716,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201717,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201718,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201719,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201720,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201721,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201722,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201723,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201724,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201725,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201726,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201727,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201728,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201729,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201730,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201731,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201732,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201733,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201734,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201735,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201736,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201737,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201738,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201739,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201740,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201741,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201742,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201743,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201744,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201745,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201746,1, 2,5); addQuestion(question);
        question = new Question(R.drawable.subat201747,1, 1,5); addQuestion(question);
        question = new Question(R.drawable.subat201748,1, 3,5); addQuestion(question);
        question = new Question(R.drawable.subat201749,1, 4,5); addQuestion(question);
        question = new Question(R.drawable.subat201750,1, 2,5); addQuestion(question);


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
