package com.example.listviewcontent;

public class sinhvien {
    String tenSinhvien;
    String sdtSinhvien;
    int avatar;


    public sinhvien() {
    }

    public sinhvien(String tenSinhvien, String sdtSinhvien, int avatar) {
        this.tenSinhvien = tenSinhvien;
        this.sdtSinhvien = sdtSinhvien;
        this.avatar = avatar;
    }

    public String getTenSinhvien() {
        return tenSinhvien;
    }

    public void setTenSinhvien(String tenSinhvien) {
        this.tenSinhvien = tenSinhvien;
    }

    public String getSdtSinhvien() {
        return sdtSinhvien;
    }

    public void setSdtSinhvien(String sdtSinhvien) {
        this.sdtSinhvien = sdtSinhvien;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
