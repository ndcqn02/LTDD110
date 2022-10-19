package com.example.recyclerview;

public class DataShop {
    private int hinhAnh;
    private String ten;

    public DataShop(int hinhAnh, String ten) {
        this.hinhAnh = hinhAnh;
        this.ten = ten;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
