package com.robusttech.trafikisaretleri;

public class Question {
    private String question;


    private int resim;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;
    private int isaretTipi;


    public Question() {

    }

    public Question(String question, int resim, String option1, String option2, String option3, String option4, int answerNr, int isaretTipi) {
        this.question = question;
        this.resim = resim;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.isaretTipi = isaretTipi;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public int getIsaretTipi() {
        return isaretTipi;
    }

    public void setIsaretTipi(int isaretTipi) {
        this.isaretTipi = isaretTipi;
    }

    public static String[] getAllSecenek() {
        return new String[]{
                "Karışık",
                "Tehlike Uyarı İşaretleri",
                "Trafik Tanzim İşaretleri",
                "Bilgi İşaretleri",
                "Durma ve Parketme İşaretleri",
                "Yatay İşaretleri",
                "Yeni İşaretler"
        };
    }
}