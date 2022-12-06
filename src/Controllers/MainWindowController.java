/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.Borrow;
import Core.Borrowed;
import Core.DateSync;
import Core.LoadMedia;
import Core.Media;
import Core.Person;
import Core.Graph;
import Core.getAllUsers;
import GUI.MainWindow;
import GUI.Mediadescription;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Sanjeewa Kulathunga
 */
public class MainWindowController {
    private MainWindow MainWindow;
    private ArrayList<Media> BrowseList;
    private ArrayList<Media> SuggestInnerList;
    private ArrayList<Media> SuggestDiscoveryList;
    private Mediadescription MediaShow;
    private Person User;
    private DateSync Today;
    public Graph<String> Graph;
    
    public MainWindowController(Person P){
        this.User=P;
        MainWindow=new MainWindow();
        Today = new DateSync();
        MediaShow=new Mediadescription();
        Graph = new Graph();
        DisplayUserInfo();
        DisplayDate();
        AutoReturnMedia();
        CreateGraph();
        FindInnerCircle();
        this.MainWindow.setVisible(true);
        this.MainWindow.addBRowseM0Listener(new BrowseM0Listener());
        this.MainWindow.addBRowseM1Listener(new BrowseM1Listener());
        this.MainWindow.addBRowseM2Listener(new BrowseM2Listener());
        this.MainWindow.addBRowseM3Listener(new BrowseM3Listener());
        this.MainWindow.addBRowseM4Listener(new BrowseM4Listener());
        this.MediaShow.addBorrowListener(new BorrowListener());
        this.MainWindow.addMyReservationListener(new MyReservationListener());
        this.MainWindow.addRefreshListener(new RefreshListener());
        this.MainWindow.addNexrWeekListener(new NexrWeekListener());
        this.MainWindow.addSuggestI0Listener(new SuggestI0Listener());
        this.MainWindow.addSuggestI1Listener(new SuggestI1Listener());
        this.MainWindow.addSuggestD0Listener(new SuggestD0Listener());
        this.MainWindow.addSuggestD1Listener(new SuggestD1Listener());
        this.MainWindow.addSuggestD2Listener(new SuggestD2Listener());
        
    }
    //second constructor for development purposes
    public MainWindowController(Person P,LocalDate Date){
        this.User=P;
        MainWindow=new MainWindow();
        Today = new DateSync(Date);
        MediaShow=new Mediadescription();
        Graph = new Graph();
        DisplayUserInfo();
        DisplayDate();
        AutoReturnMedia();
        CreateGraph();
        FindInnerCircle();
        this.MainWindow.setVisible(true);
        this.MainWindow.addBRowseM0Listener(new BrowseM0Listener());
        this.MainWindow.addBRowseM1Listener(new BrowseM1Listener());
        this.MainWindow.addBRowseM2Listener(new BrowseM2Listener());
        this.MainWindow.addBRowseM3Listener(new BrowseM3Listener());
        this.MainWindow.addBRowseM4Listener(new BrowseM4Listener());
        this.MediaShow.addBorrowListener(new BorrowListener());
        this.MainWindow.addMyReservationListener(new MyReservationListener());
        this.MainWindow.addRefreshListener(new RefreshListener());
        this.MainWindow.addNexrWeekListener(new NexrWeekListener());
        this.MainWindow.addSuggestI0Listener(new SuggestI0Listener());
        this.MainWindow.addSuggestI1Listener(new SuggestI1Listener());
        this.MainWindow.addSuggestD0Listener(new SuggestD0Listener());
        this.MainWindow.addSuggestD1Listener(new SuggestD1Listener());
        this.MainWindow.addSuggestD2Listener(new SuggestD2Listener());
        
    }
    
    class SuggestI0Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(SuggestInnerList.get(0).getMediaID());
            Temptext="<html> "+ SuggestInnerList.get(0).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ SuggestInnerList.get(0).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ SuggestInnerList.get(0).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+SuggestInnerList.get(0).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(SuggestInnerList.get(0).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class SuggestI1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(SuggestInnerList.get(1).getMediaID());
            Temptext="<html> "+ SuggestInnerList.get(1).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ SuggestInnerList.get(1).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ SuggestInnerList.get(1).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+SuggestInnerList.get(1).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(SuggestInnerList.get(1).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class SuggestD0Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(SuggestDiscoveryList.get(0).getMediaID());
            Temptext="<html> "+ SuggestDiscoveryList.get(0).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ SuggestDiscoveryList.get(0).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ SuggestDiscoveryList.get(0).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+SuggestDiscoveryList.get(0).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(SuggestDiscoveryList.get(0).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class SuggestD1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(SuggestDiscoveryList.get(1).getMediaID());
            Temptext="<html> "+ SuggestDiscoveryList.get(1).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ SuggestDiscoveryList.get(1).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ SuggestDiscoveryList.get(1).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+SuggestDiscoveryList.get(1).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(SuggestDiscoveryList.get(1).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class SuggestD2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(SuggestDiscoveryList.get(2).getMediaID());
            Temptext="<html> "+ SuggestDiscoveryList.get(2).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ SuggestDiscoveryList.get(2).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ SuggestDiscoveryList.get(2).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+SuggestDiscoveryList.get(2).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(SuggestDiscoveryList.get(2).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    
    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            DisplayBrowseMedia();
            CreateGraph();
            FindInnerCircle();
        }
    }
    class NexrWeekListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Today = new DateSync(Today.getToday());
            MainWindow.dispose();
            MainWindowController mainWindowController = new MainWindowController(new Person(String.valueOf(User.getUserID())),Today.getToday().plusWeeks(1));
            mainWindowController.DisplayBrowseMedia();
        }
    }
    class MyReservationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            new MyReservationsController(User);
        }
    }
    class BorrowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String MediaID=MediaShow.getMediaID().getText();
            BorrowMedia(User,new Media(MediaID));
            MediaShow.setVisible(false);
            DisplayBrowseMedia();
        }
    }
    class BrowseM0Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(BrowseList.get(0).getMediaID());
            Temptext="<html> "+ BrowseList.get(0).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(0).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(0).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+BrowseList.get(0).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(BrowseList.get(0).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class BrowseM1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String Temptext;
            MediaShow.getMediaID().setText(BrowseList.get(1).getMediaID());
            Temptext="<html> "+ BrowseList.get(1).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(1).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(1).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+BrowseList.get(1).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(BrowseList.get(1).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class BrowseM2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           String Temptext;
            MediaShow.getMediaID().setText(BrowseList.get(2).getMediaID());
            Temptext="<html> "+ BrowseList.get(2).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(2).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(2).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+BrowseList.get(2).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(BrowseList.get(2).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class BrowseM3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           String Temptext;
            MediaShow.getMediaID().setText(BrowseList.get(3).getMediaID());
            Temptext="<html> "+ BrowseList.get(3).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(3).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(3).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+BrowseList.get(3).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(BrowseList.get(3).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    class BrowseM4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
           String Temptext;
            MediaShow.getMediaID().setText(BrowseList.get(4).getMediaID());
            Temptext="<html> "+ BrowseList.get(4).getMediaName() +" </html>";
            MediaShow.getMediaTitle().setText(Temptext);
            MediaShow.getMediaName().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(4).getMediaAuthor() +" </html>";
            MediaShow.getMediaAuthor().setText(Temptext);
            Temptext="<html> "+ BrowseList.get(4).getMediaDesciption() +" </html>";
            MediaShow.getMediaDescription().setText(Temptext);
            Temptext="/Media/"+BrowseList.get(4).getMediaID()+".jpg";
            MediaShow.getMediaIcon().setIcon(new ImageIcon(getClass().getResource(Temptext)));
            if(BrowseList.get(4).isAvailable()){
                MediaShow.getLblAvailable().setText("Available");
                MediaShow.getBtnBorrow().setEnabled(true);
                MediaShow.getBtnBorrow().setBackground(Color.GREEN);
            }else{
                MediaShow.getLblAvailable().setText("Not Available");
                MediaShow.getBtnBorrow().setEnabled(false);
                MediaShow.getBtnBorrow().setText("Not Available");
                MediaShow.getBtnBorrow().setBackground(Color.GRAY);
            }
            
            MediaShow.setVisible(true);
        }
    }
    public void BorrowMedia(Person p,Media m){
        Borrow NBorrow=new Borrow(p,m);
        if(!NBorrow.isAlreadyBorrowed()) {
            if(NBorrow.isFullList()) {
                NBorrow.UpdateDB();
                MainWindow.DisplayInfo("Reservation Successful. Please visit My Reservation Section.");
            } else {
                MainWindow.DisplayError("Maximum Borrowing Limit Reached");
            }
        }else{
            MainWindow.DisplayError("You Already Borrowed this Media. Please Visit My Reservation Section");
        }
    }
    public void DisplayUserInfo(){
        String Temptext;
        Temptext="ID: "+User.getUserID();
        MainWindow.getUserID().setText(Temptext);
        Temptext=""+User.getFirstName()+" "+User.getLastName();
        MainWindow.getUserName().setText(Temptext);
    }
    public void DisplayDate(){
        MainWindow.getLblDate().setText(Today.getToday().toString());
    }
    public void AutoReturnMedia(){
        LoadMedia MediaLoad=new LoadMedia();
        MediaLoad.LoadUserList(User);
        ArrayList<Media> UserList;
        UserList=MediaLoad.getMediaList();
        for(int i=0;i<UserList.size();i++){
            Borrowed borrowed = new Borrowed(User,new Media(UserList.get(i).getMediaID()));
            if(borrowed.getReturnDate().isBefore(Today.getToday())){
                borrowed.ReturnMedia();
            }
        }
    }
    
    public void FindInnerCircle(){
        
        List<String> Neighbors = new ArrayList<>();
        Neighbors=Graph.neighborsOf(String.valueOf(User.getUserID()));
        if(Neighbors.size()>0){
            Random R=new Random();
            String NaighborUser=Neighbors.get(R.nextInt(Neighbors.size()));
            List<Media> SuggestionMediaList = new ArrayList<>();
            LoadMedia NeighborMedia= new LoadMedia();
            NeighborMedia.LoadUserHistoryList(new Person(NaighborUser));
            SuggestionMediaList=NeighborMedia.getMediaList();
            if(SuggestionMediaList.size()>1){
                LoadMedia UserMedia= new LoadMedia();
                UserMedia.LoadUserHistoryList(User);
                List<Media> UserList = new ArrayList<>();
                UserList=UserMedia.getMediaList();
                try{
                    for(int i=0;i<SuggestionMediaList.size();i++){
                        for(int j=0;j<UserList.size();j++){       
                            if(Integer.parseInt(SuggestionMediaList.get(i).getMediaID())==Integer.parseInt(UserList.get(j).getMediaID())){
                                SuggestionMediaList.remove(i);
                            }
                        }
                    }
                }
                catch(Exception e){ 
                    String ImagePath="/Media/Demo.jpg";
                    MainWindow.getBtnSI0().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
                    MainWindow.getBtnSI1().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
                    MainWindow.getBtnSI0().setEnabled(false);
                    MainWindow.getBtnSI1().setEnabled(false);
                }
                if(SuggestionMediaList.size()>1){
                    DisplayInnerCircle(new Media(SuggestionMediaList.get(0).getMediaID()),new Media(SuggestionMediaList.get(1).getMediaID()));
                    MainWindow.getBtnSI0().setEnabled(true);
                    MainWindow.getBtnSI1().setEnabled(true);
                }else{
                    String ImagePath="/Media/Demo.jpg";
                    MainWindow.getBtnSI0().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
                    MainWindow.getBtnSI1().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
                    MainWindow.getBtnSI0().setEnabled(false);
                    MainWindow.getBtnSI1().setEnabled(false);
                }
            }else{
                String ImagePath="/Media/Demo.jpg";
                MainWindow.getBtnSI0().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
                MainWindow.getBtnSI1().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
                MainWindow.getBtnSI0().setEnabled(false);
                MainWindow.getBtnSI1().setEnabled(false);
            }
        }else{
            String ImagePath="/Media/Demo.jpg";
            MainWindow.getBtnSI0().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
            MainWindow.getBtnSI1().setIcon(new ImageIcon(getClass().getResource(ImagePath)));
            MainWindow.getBtnSI0().setEnabled(false);
            MainWindow.getBtnSI1().setEnabled(false);
        }
    }
     
    public void DisplayBrowseMedia(){
        LoadMedia Browse = new LoadMedia();
        Browse.LoadRandom();
        BrowseList=Browse.getMediaList();
        ArrayList<JButton> btnBooklist=new ArrayList();
        btnBooklist.add(MainWindow.getBtnB0());
        btnBooklist.add(MainWindow.getBtnB1());
        btnBooklist.add(MainWindow.getBtnB2());
        btnBooklist.add(MainWindow.getBtnB3());
        btnBooklist.add(MainWindow.getBtnB4());
        for(int i=0;i<5;i++){
            String ImagePath="/Media/"+BrowseList.get(i).getMediaID()+"_T.jpg";
            btnBooklist.get(i).setIcon(new ImageIcon(getClass().getResource(ImagePath)));
        }
    }
    
    public void CreateGraph(){
        
        ArrayList<Media> UserMediaList=new ArrayList();
        ArrayList<Person> UserList=new ArrayList();
        LoadMedia UserMList = new LoadMedia();
        UserMList.LoadUserHistoryList(User);
        UserMediaList=UserMList.getMediaList();
        getAllUsers All = new getAllUsers();
        UserList = All.getUserList();
        for (int i = 0; i < UserList.size(); i++) {
            String vt=UserList.get(i).toString();
            Graph.addVertex(vt);
        }
        for (int i = 0; i < UserList.size(); i++) {
            LoadMedia EachUserList = new LoadMedia();
            EachUserList.LoadUserHistoryList(UserList.get(i));
            ArrayList < Media > MediaList = new ArrayList();
            MediaList = EachUserList.getMediaList();
            for (int j = 0; j < UserList.size(); j++) {
                LoadMedia EachUserListOther = new LoadMedia();
                EachUserListOther.LoadUserHistoryList(UserList.get(j));
                ArrayList < Media > MediaListOther = new ArrayList();
                MediaListOther = EachUserListOther.getMediaList();
                for (int k = 0; k < MediaList.size(); k++) {
                    for (int l = 0; l < MediaListOther.size(); l++) {
                        if (MediaList.get(k).getMediaID().equals(MediaListOther.get(l).getMediaID())) {
                            if (UserList.get(i).getUserID() != UserList.get(j).getUserID()) {
                                Graph.addEdge(UserList.get(i).toString(),UserList.get(j).toString());
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    public void DisplayInnerCircle(Media M1,Media M2){
        LoadMedia Browse = new LoadMedia();
        Browse.LoadInnerCircle(M1,M2);
        SuggestInnerList=Browse.getMediaList();
        ArrayList<JButton> btnBooklist=new ArrayList();
        btnBooklist.add(MainWindow.getBtnSI0());
        btnBooklist.add(MainWindow.getBtnSI1());
        for(int i=0;i<2;i++){
            String ImagePath="/Media/"+SuggestInnerList.get(i).getMediaID()+"_T.jpg";
            btnBooklist.get(i).setIcon(new ImageIcon(getClass().getResource(ImagePath)));
        }
    }
    public void DisplayDiscovery(Media M1,Media M2,Media M3){
        LoadMedia Browse = new LoadMedia();
        Browse.LoadDiscovery(M1,M2,M3);
        SuggestDiscoveryList=Browse.getMediaList();
        ArrayList<JButton> btnBooklist=new ArrayList();
        btnBooklist.add(MainWindow.getBtnSD1());
        btnBooklist.add(MainWindow.getBtnSD2());
        btnBooklist.add(MainWindow.getBtnSD3());
        for(int i=0;i<3;i++){
            String ImagePath="/Media/"+SuggestDiscoveryList.get(i).getMediaID()+"_T.jpg";
            btnBooklist.get(i).setIcon(new ImageIcon(getClass().getResource(ImagePath)));
        }
    }
}
