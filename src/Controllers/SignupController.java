/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.Signup;
import GUI.SignupForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class SignupController {
    private SignupForm SignupForm;
    private Signup Signup;
    
    public SignupController(){
        this.SignupForm=new SignupForm();
        SignupForm.setVisible(true);
        this.SignupForm.addSignupListener(new SignupListener());
        this.SignupForm.addBackListener(new BackListener());
    }
    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new LoginController();
            SignupForm.dispose();
        }
    }
    class SignupListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           String UserFirstName=SignupForm.getTxtUserFName().getText();
           String UserLastName=SignupForm.getTxtUserLName().getText();
           String UserEmail=SignupForm.getTxtUserEmail().getText();
           String UserPassword=SignupForm.getTxtUserPassword().getText();
           
           if(!"".equals(UserFirstName)&& !"".equals(UserLastName) && !"".equals(UserEmail) && !"".equals(UserPassword)){
               Signup signup = new Signup(UserFirstName,UserLastName,UserEmail,UserPassword);
               if(signup.isValidEmail()){
                   if(!signup.isEmailExsits()){
                       signup.SignupUser();
                       SignupForm.DisplayInfo("Registration Completed Successfully");
                       new LoginController();
                       SignupForm.setVisible(false);
                   }else{
                       SignupForm.DisplayError("Email Already Registered");
                   }
               }else{
                   SignupForm.DisplayError("Email Validation Failed");
               }
           }else{
               SignupForm.DisplayError("Please Fill All Required Fields");
           }
        }
    
    }
}
