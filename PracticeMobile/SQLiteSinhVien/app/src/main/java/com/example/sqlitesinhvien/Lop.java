package com.example.sqlitesinhvien;

import java.io.Serializable;

public class Lop implements Serializable {
    String malop;
    String tenLop;
    int siSo;

    public Lop(String malop, String tenLop, int siSo) {
        this.malop = malop;
        this.tenLop = tenLop;
        this.siSo = siSo;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }
}
