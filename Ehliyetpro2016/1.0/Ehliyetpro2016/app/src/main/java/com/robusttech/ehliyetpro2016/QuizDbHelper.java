package com.robusttech.ehliyetpro2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.robusttech.ehliyetpro2016.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Ehliyetpro2016.db";
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

        // ********************* ARALIK 2016 (sinavNo=1) ********************
        question = new Question(R.drawable.aralik201601,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201602,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201603,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201604,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201605,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201606,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201607,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201608,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201609,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201610,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201611,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201612,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201613,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201614,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201615,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201616,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201617,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201618,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201619,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201620,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201621,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201622,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201623,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201624,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201625,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201626,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201627,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201628,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201629,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201630,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201631,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201632,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201633,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201634,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201635,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201636,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201637,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201638,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201639,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201640,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201641,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201642,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201643,1, 3,1); addQuestion(question);
        question = new Question(R.drawable.aralik201644,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201645,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201646,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201647,1, 2,1); addQuestion(question);
        question = new Question(R.drawable.aralik201648,1, 1,1); addQuestion(question);
        question = new Question(R.drawable.aralik201649,1, 4,1); addQuestion(question);
        question = new Question(R.drawable.aralik201650,1, 3,1); addQuestion(question);



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
