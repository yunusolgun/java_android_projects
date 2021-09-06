package com.robusttech.babysleepfree;

public class Data {
    private String baslik;
    private int muzikId;
    private int resimId;

    public Data(String baslik, int muzikId, int resimId) {
        this.baslik = baslik;
        this.muzikId = muzikId;
        this.resimId = resimId;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public int getMuzikId() {
        return muzikId;
    }

    public void setMuzikId(int muzikId) {
        this.muzikId = muzikId;
    }

    public int getResimId() {
        return resimId;
    }

    public void setResimId(int resimId) {
        this.resimId = resimId;
    }
}
