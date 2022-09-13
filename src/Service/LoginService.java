/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Login;
import Repository.LoginRepository;

public class LoginService {
    
    LoginRepository lr = new LoginRepository();
    
    public boolean timkiem(String name, String pw) {
        for (Login login : lr.selectAll()) {
            if(login.getName().equals(name) && login.getPw().equals(pw)) {
                return true;
            }
        }
        
        return false;
    }
}
