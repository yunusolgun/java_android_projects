package com.robusttech.ehliyet2018;

public class Question {

    private int resim;
    private int gecerliSoru;
    private int answerNr;
    private int sinavNo;

    private String baslik;
    private String aciklama;


    public Question() {

    }

    public Question(int resim, String baslik, String aciklama) {
        this.resim = resim;
        this.baslik = baslik;
        this.aciklama= aciklama;
    }

    public Question(int resim, int gecerliSoru, int answerNr, int sinavNo) {
        this.resim = resim;
        this.gecerliSoru = gecerliSoru;
        this.answerNr = answerNr;
        this.sinavNo = sinavNo;
    }


    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getGecerliSoru() {
        return gecerliSoru;
    }

    public void setGecerliSoru(int gecerliSoru) {
        this.gecerliSoru = gecerliSoru;
    }


    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public int getSinavNo() {
        return sinavNo;
    }

    public void setSinavNo(int sinavNo) {
        this.sinavNo = sinavNo;
    }

    public static String[] getAllSecenek() {
        return new String[]{
                "Ağustos 2018",
                "Nisan 2018"
        };
    }
}
