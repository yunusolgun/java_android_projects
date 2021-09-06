package com.robusttech.trafikisaretleri;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "trafik_sorular";
        public static final String COLUMN_QUESTION = "soru";
        public static final String COLUMN_RESIM = "resim";
        public static final String COLUMN_OPTION1 = "secenek1";
        public static final String COLUMN_OPTION2 = "secenek2";
        public static final String COLUMN_OPTION3 = "secenek3";
        public static final String COLUMN_OPTION4 = "secenek4";
        public static final String COLUMN_ANSWER_NR = "cevapno";
        public static final String COLUMN_ISARET_TIPI = "isarettipi";
    }
}
