package com.example.sqlitesinhvien;

public class Lop {
    private String malop;
    private String tenlop;
    private String siso;

    public Lop(String malop, String tenlop, String siso) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.siso = siso;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getSiso() {
        return siso;
    }

    public void setSiso(String siso) {
        this.siso = siso;
    }
}
