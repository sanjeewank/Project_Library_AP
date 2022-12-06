/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import GUI.LoginForm;
import GUI.Splash;
/**
 *
 * @author Muhammad Adil FAYYAZ
 */
public class SplashController {
    private Splash Splash;
    private LoginForm Login;
    
    public SplashController(){
        this.Splash=new Splash();
        this.Login=new LoginForm();
        LoadPlash();
        Login();
    }
    public void LoadPlash(){
        Splash.setVisible(true);
        try{
            for(int i=0;i<100;i++){
                Thread.sleep(40);
                Splash.getProgressBar().setValue(i);
                Splash.getProcess().setText(Integer.toString(i)+"%");
                if(i==0){
                    Splash.getLoad().setText("Loading....");
                }
                if(i==10){
                    Splash.getLoad().setText("Turning On Modules....");
                }
                if(i==20){
                    Splash.getLoad().setText("Loading Modules....");
                }
                if(i==50){
                    Splash.getLoad().setText("Connecting To Database....");
                }
                if(i==70){
                    Splash.getLoad().setText("Connection Successful....");
                }
                if(i==80){
                    Splash.getLoad().setText("Launching Application....");
                }
            }
        }catch(Exception e){}
        Splash.setVisible(false);
    }
    
    private void Login() {
        LoginController login = new LoginController();
    }
    
    public Splash getSplash() {
        return Splash;
    }

    public LoginForm getLogin() {
        return Login;
    }

    
    
    
}
