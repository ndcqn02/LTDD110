package com.example.sqlitesinhvien;

public class SinhVien {
    private String maSV110;
    private String tenSV110;
    private String mota110;

    public SinhVien(String maSV110, String tenSV110, String mota110) {
        this.maSV110 = maSV110;
        this.tenSV110 = tenSV110;
        this.mota110 = mota110;
    }

    public String getMaSV110() {
        return maSV110;
    }

    public void setMaSV110(String maSV110) {
        this.maSV110 = maSV110;
    }

    public String getTenSV110() {
        return tenSV110;
    }

    public void setTenSV110(String tenSV110) {
        this.tenSV110 = tenSV110;
    }

    public String getMota110() {
        return mota110;
    }

    public void setMota110(String mota110) {
        this.mota110 = mota110;
    }
}
