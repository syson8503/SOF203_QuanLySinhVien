/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Students;
import Repository.StudentsRepository;
import java.util.ArrayList;

public class StudentsService {
    StudentsRepository sr = new StudentsRepository();
    
    public void insert(Students hs) {
        sr.insert(hs);
    }
    
    public void update(String masv, Students hs) {
        sr.update(masv, hs);
    }
    
    public void delete(String masv) {
        sr.delete(masv);
    }
    
    public ArrayList<Students> getList() {
        return sr.selectAll();
    }
}
