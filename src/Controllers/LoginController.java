/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.Login;
import Core.Person;
import GUI.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class LoginController {
    private Login Login;
    private LoginForm LoginForm;

    public LoginController() {
        this.LoginForm=new LoginForm();
        LoginForm.setVisible(true);
        this.LoginForm.addLoginListener(new LoginListener());
        this.LoginForm.addCreateAccoutListener(new CreateAccountListener());
    }
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Email=LoginForm.getTxtUserEmail().getText();
            String Password=LoginForm.getTxtUserPassword().getText();
            Login = new Login(Email,Password);
            if(Login.isValidEmail()){
                if(Login.isValidPassword()){
                    MainWindowController mainWindowController = new MainWindowController(new Person(String.valueOf(Login.getValidUser()))); 
                    mainWindowController.DisplayBrowseMedia();
                    LoginForm.setVisible(false);
                }else{
                    LoginForm.DisplayError("Invalid Password");
                    }
            }else{
                LoginForm.DisplayError("Invalid Email");
            }
        }
    }
     class CreateAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            LoginForm.setVisible(false);
            new SignupController();
        }
         
     }
}
