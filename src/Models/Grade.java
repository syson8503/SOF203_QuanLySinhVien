/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Service.GradeService;

public class Grade {
    
    GradeService gradeService = new GradeService();
    
    private int id;
    private String maSV;
    private double diemTA;
    private double diemTH;
    private double diemGDTC;

    public Grade() {
    }

    public Grade(String maSV, double diemTA, double diemTH, double diemGDTC) {
        this.maSV = maSV;
        this.diemTA = diemTA;
        this.diemTH = diemTH;
        this.diemGDTC = diemGDTC;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getDiemTA() {
        return diemTA;
    }

    public void setDiemTA(double diemTA) {
        this.diemTA = diemTA;
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(double diemTH) {
        this.diemTH = diemTH;
    }

    public double getDiemGDTC() {
        return diemGDTC;
    }

    public void setDiemGDTC(double diemGDTC) {
        this.diemGDTC = diemGDTC;
    }
    
    public String getTen(String MaSV) {
        return gradeService.Ten(MaSV);
    }
    
    public double getDiemTB(double TA, double TH, double GDTC) {
        return gradeService.TinhDiemTB(TA, TH, GDTC);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Grade(int id, String maSV, double diemTA, double diemTH, double diemGDTC) {
        this.id = id;
        this.maSV = maSV;
        this.diemTA = diemTA;
        this.diemTH = diemTH;
        this.diemGDTC = diemGDTC;
    }
    
    
}
