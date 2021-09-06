package com.robusttech.ehliyetpro2017;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "ehliyetpro2017";
        public static final String COLUMN_RESIM = "resim";
        public static final String COLUMN_GECERLISORU = "gecerlisoru";
        public static final String COLUMN_ANSWER_NR = "cevapno";
        public static final String COLUMN_SINAV_NO = "sinavno";
    }
}
