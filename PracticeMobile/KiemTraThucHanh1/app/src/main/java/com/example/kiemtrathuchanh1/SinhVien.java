package com.example.kiemtrathuchanh1;

public class SinhVien {
    private String ten;
    private String msv;
    private String quequan;

    public SinhVien(String ten, String msv, String quequan) {
        this.ten = ten;
        this.msv = msv;
        this.quequan = quequan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}
