/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Grade;
import Repository.GradeRepository;
import java.util.ArrayList;

public class GradeService {
    GradeRepository gr = new GradeRepository();
    
    public boolean insert(Grade g) {
        if(gr.insert(g)) {
            return true;
        } 
        return false;
    }
    
    public void update(String masv, Grade g) {
        gr.update(masv, g);
    }
    
    public void delete(String masv) {
        gr.delete(masv);
    }
    
    public ArrayList<Grade> getList() {
        return gr.selectAll();
    }
    
    public ArrayList<Grade> getTop3List() {
        return gr.selectTop3();
    }
    
    public int find(String masv) {
        for (int i = 0; i < gr.selectAll().size(); i++) {
            if (gr.selectAll().get(i).getMaSV().equals(masv)) {
                return i;
            }
        }
        return -1;
    }
    
    public double TinhDiemTB(double a, double b, double c) {
        double tb = 0;
        tb = (double) Math.round(((a + b + c) / 3) * 10) / 10;
        return tb;
    }
    
    public String Ten(String masv) {
        return gr.Ten(masv);
    }
    
}
