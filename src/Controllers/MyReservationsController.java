/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.Borrowed;
import Core.LoadMedia;
import Core.Media;
import Core.Person;
import GUI.MyReservations;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class MyReservationsController {
    private MyReservations ReservationForm;
    private LoadMedia LoadMedia;
    private Person User;
    private ArrayList<Media> UserList;
    
    public MyReservationsController(Person User){
        this.ReservationForm=new MyReservations();
        this.LoadMedia=new LoadMedia();
        this.User=User;
        ReservationForm.setVisible(true);
        DisplayMedia();
        ReservationForm.addReturnM1Listener(new ReturnM1Listener());
        ReservationForm.addReturnM2Listener(new ReturnM2Listener());
        ReservationForm.addReturnM3Listener(new ReturnM3Listener());
        ReservationForm.addMediaListener(new MediaListiener());
        ReservationForm.addExtend1Listener(new Extend1Listener());
        ReservationForm.addExtend2Listener(new Extend2Listener());
        ReservationForm.addExtend3Listener(new Extend3Listener());
    }
    class Extend1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int result=ReservationForm.DisplayConfirmBox("Do you want to extend return date");
            if(result==0){
                Borrowed BorrowedM1= new Borrowed(User,new Media(UserList.get(0).getMediaID()));
                BorrowedM1.ExtendTime();
                ReservationForm.DisplayInfo("Return Date Extended Successfully");
                ReservationForm.dispose();
                new MyReservationsController(User);
            }
        }
    }
    class Extend2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int result=ReservationForm.DisplayConfirmBox("Do you want to extend return date");
            if(result==0){
                Borrowed BorrowedM2= new Borrowed(User,new Media(UserList.get(1).getMediaID()));
                BorrowedM2.ExtendTime();
                ReservationForm.DisplayInfo("Return Date Extended Successfully");
                ReservationForm.dispose();
                new MyReservationsController(User);
            }
        }
    }
    class Extend3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int result=ReservationForm.DisplayConfirmBox("Do you want to extend return date");
            if(result==0){
                Borrowed BorrowedM3= new Borrowed(User,new Media(UserList.get(2).getMediaID()));
                BorrowedM3.ExtendTime();
                ReservationForm.DisplayInfo("Return Date Extended Successfully");
                ReservationForm.dispose();
                new MyReservationsController(User);
            }
        }
    }
    class MediaListiener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(UserList.size()>0){
                if (Desktop.isDesktopSupported()) {
                    try {
                        URL url = getClass().getResource("/Media/demo.pdf");
                        File myFile = new File(url.toURI());
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException | URISyntaxException ex) {

                    }
                }
            }
        }
    }
    class ReturnM1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int result=ReservationForm.DisplayConfirmBox("Do you want to return this media");
            if(result==0){
                Borrowed BorrowedM1= new Borrowed(User,new Media(UserList.get(0).getMediaID()));
                BorrowedM1.ReturnMedia();
                ReservationForm.DisplayInfo("Media Returned Successfully");
                ReservationForm.dispose();
                new MyReservationsController(User);
            }
        }
    }
    class ReturnM2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int result=ReservationForm.DisplayConfirmBox("Do you want to return this media");
            if(result==0){
                Borrowed BorrowedM1= new Borrowed(User,new Media(UserList.get(1).getMediaID()));
                BorrowedM1.ReturnMedia();
                ReservationForm.DisplayInfo("Media Returned Successfully");
                ReservationForm.dispose();
                new MyReservationsController(User);
            }
        }
    }
    class ReturnM3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int result=ReservationForm.DisplayConfirmBox("Do you want to return this media");
            if(result==0){
                Borrowed BorrowedM1= new Borrowed(User,new Media(UserList.get(2).getMediaID()));
                BorrowedM1.ReturnMedia();
                ReservationForm.DisplayInfo("Media Returned Successfully");
                ReservationForm.dispose();
                new MyReservationsController(User);
            }
        }
    }
    public void DisplayMedia(){
        HideObjects();
        LoadMedia.LoadUserList(User);
        UserList=LoadMedia.getMediaList();
        if(UserList.size()==1){
            setFirstMedia();
        }else if (UserList.size()==2){
            setFirstMedia();
            setSecondMedia();
        }else if(UserList.size()==3){
            setFirstMedia();
            setSecondMedia();
            setThirdMedia();
        }
    }
    public void setFirstMedia(){
            Borrowed BorrowedM1= new Borrowed(User,new Media(UserList.get(0).getMediaID()));
            ReservationForm.getLblAvailableM1().setText("Available until "+BorrowedM1.getReturnDate());
            ReservationForm.getLblAvailableM1().setVisible(true);
            String Temptext="/Media/"+UserList.get(0).getMediaID()+".jpg";
            ReservationForm.getBtnmedia1().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            ReservationForm.getBtnexm1().setVisible(true);
            ReservationForm.getBtnrtm1().setVisible(true);
            if(BorrowedM1.isExtended()){
                 ReservationForm.getBtnexm1().setEnabled(false);
            }
    }
    public void setSecondMedia(){
            Borrowed BorrowedM2= new Borrowed(User,new Media(UserList.get(1).getMediaID()));
            ReservationForm.getLblAvailableM2().setText("Available until "+BorrowedM2.getReturnDate());
            ReservationForm.getLblAvailableM2().setVisible(true);
            String Temptext="/Media/"+UserList.get(1).getMediaID()+".jpg";
            ReservationForm.getBtnmedia2().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            ReservationForm.getBtnexm2().setVisible(true);
            ReservationForm.getBtnrtm2().setVisible(true);
            if(BorrowedM2.isExtended()){
                 ReservationForm.getBtnexm2().setEnabled(false);
            }
    }
    public void setThirdMedia(){
            Borrowed BorrowedM3= new Borrowed(User,new Media(UserList.get(2).getMediaID()));
            ReservationForm.getLblAvailableM3().setText("Available until "+BorrowedM3.getReturnDate());
            ReservationForm.getLblAvailableM3().setVisible(true);
            String Temptext="/Media/"+UserList.get(2).getMediaID()+".jpg";
            ReservationForm.getBtnmedia3().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            ReservationForm.getBtnexm3().setVisible(true);
            ReservationForm.getBtnrtm3().setVisible(true);
            if(BorrowedM3.isExtended()){
                 ReservationForm.getBtnexm3().setEnabled(false);
            }
    }
    public void HideObjects(){
        ReservationForm.getBtnexm1().setVisible(false);
        ReservationForm.getBtnexm2().setVisible(false);
        ReservationForm.getBtnexm3().setVisible(false);
        ReservationForm.getBtnrtm1().setVisible(false);
        ReservationForm.getBtnrtm2().setVisible(false);
        ReservationForm.getBtnrtm3().setVisible(false);
        ReservationForm.getLblAvailableM1().setVisible(false);
        ReservationForm.getLblAvailableM2().setVisible(false);
        ReservationForm.getLblAvailableM3().setVisible(false);
    }
}
