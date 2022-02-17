/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.News;
import Service.ServiceNews;
import Utils.UserSession;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author essia
 */
public class FXMLNews0Controller implements Initializable {

    @FXML
    private ComboBox TypeSport;
    @FXML
    private TextArea msg;
    @FXML
    private TextArea Titre;
    @FXML
    private TextArea Contenu;
    @FXML
    private Button Ajout;
    @FXML
    private TextArea ImgPath;
    @FXML
    private Button BoutonAjoutImage;
    @FXML
    private ImageView imagenews;
      private Image image;
    private File file;
      private FileChooser fileChooser;
    private final Desktop desktop = Desktop.getDesktop();
    @FXML
    private ImageView MatchIMG;
    @FXML
    private ImageView UserIMG;
    @FXML
    private ImageView NewsIMG;
    @FXML
    private ImageView EventIMG;
    @FXML
    private ImageView RecIMG;
    @FXML
    private ImageView TerrainIMG;
    @FXML
    private ImageView CoachIMG;
    @FXML
    private ImageView ArbitreIMG;
    @FXML
    private ImageView GymIMG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // les bouttons de la navigation a gauche 
        
        
        
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        
        
        File MatchFile = new File("image/MatchTXT.png");
        Image MatchIcon = new Image(MatchFile.toURI().toString());
        MatchIMG.setImage(MatchIcon);
        
       
        UserIMG.setImage(UserIcon);
        
         File NewsFile = new File("image/NewsTXT.png");
        Image NewsIcon = new Image(NewsFile.toURI().toString());
        NewsIMG.setImage(NewsIcon);
        
         File EventFile = new File("image/EventTXT.png");
        Image EventIcon = new Image(EventFile.toURI().toString());
        EventIMG.setImage(EventIcon);
        
        File RecFile = new File("image/RecTXT.png");
        Image RecIcon = new Image(RecFile.toURI().toString());
        RecIMG.setImage(RecIcon);
        
        File TerrainFile = new File("image/Terrain.png");
        Image TerrainIcon = new Image(TerrainFile.toURI().toString());
        TerrainIMG.setImage(TerrainIcon);
        
        File CoachFile = new File("image/CoachIcon.png");
        Image CoachIcon = new Image(CoachFile.toURI().toString());
        CoachIMG.setImage(CoachIcon);
        
        File ArbitreFile = new File("image/ArbitreIcon.png");
        Image ArbitreIcon = new Image(ArbitreFile.toURI().toString());
        ArbitreIMG.setImage(ArbitreIcon);
        
        File GymFile = new File("image/GymIcon.png");
        Image GymIcon = new Image(GymFile.toURI().toString());
        GymIMG.setImage(GymIcon);
        
        //
        // TODO
                     TypeSport.setStyle("  -fx-background-color:#90ee90 ;-fx-selection-bar: #90ee90; ");
        
        fileChooser = new FileChooser();
        new FileChooser.ExtensionFilter("Images", "*.png","*.jpg","*.gif");
ServiceNews sn= new ServiceNews();
        News n = new News();
         ObservableList<String> list =FXCollections.observableArrayList
        ("TENNIS","BASKETBALL","FOOTBALL","VOLLEYBALL","BASEBALL","RUGBY","HANDBALL");
        
        TypeSport.setItems(list);

      BoutonAjoutImage.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        file = fileChooser.showOpenDialog(BoutonAjoutImage.getScene().getWindow());
        String path = file.getAbsolutePath();
        
        path= path.substring(21, path.length());
        path ="http://localhost/pijava/" +path;
        ImgPath.setText(path);
        n.setURLImg(path);
        
       if(file!=null){
            
            try {
                System.out.println(""+file.getAbsolutePath());
                image =new Image(file.getAbsoluteFile().toURL().toString());
               image = new Image(path);
                imagenews.setImage(image);
            } catch(Exception ex)  {
                Logger.getLogger(FXMLNews0Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            

    }}
    });
      
    }    

    

    @FXML
    private void NewsControlOnAction(ActionEvent event) {
        Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader ();
                loader.setLocation(getClass().getResource("/pijava/NewsCom/FXMLNews0.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLNews0Controller.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }
    
    
        @FXML
            private void UserControlOnAction(ActionEvent event) {
                Node node = (Node) event.getSource();
                       Stage stage = (Stage) node.getScene().getWindow();
                       FXMLLoader loader = new FXMLLoader ();
                       loader.setLocation(getClass().getResource("/pijava/AdminUser/BackUserList.fxml"));
                       try {
                               loader.load();


                           } catch (IOException ex) {
                               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
                               System.out.println("failed to load");
                               System.out.println(ex);
                           }
                           Parent parent = loader.getRoot();
                           stage.setScene(new Scene(parent));
                           stage.show(); 
           }

           @FXML
           private void RecControlOnAction(ActionEvent event) {
                Node node = (Node) event.getSource();
                       Stage stage = (Stage) node.getScene().getWindow();
                       FXMLLoader loader = new FXMLLoader ();
                       loader.setLocation(getClass().getResource("/pijava/AdminReclamation/BackReclamation.fxml"));
                       try {
                               loader.load();


                           } catch (IOException ex) {
                               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
                               System.out.println("failed to load");
                               System.out.println(ex);
                           }

                           Parent parent = loader.getRoot();
                           stage.setScene(new Scene(parent));
                           stage.show(); 
           }

           @FXML
           private void DashboardOnAction(ActionEvent event) {
                   // direction interface admin 
               Node node = (Node) event.getSource();
               Stage stage = (Stage) node.getScene().getWindow();
               FXMLLoader loader = new FXMLLoader ();
               loader.setLocation(getClass().getResource("/pijava/AdminInterface/AdminInterface.fxml"));
               try {
               loader.load();


               } catch (IOException ex) {
               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("failed to load");
               System.out.println(ex);
               }
               Parent parent = loader.getRoot();
               stage.setScene(new Scene(parent));
               stage.show();
           }

           @FXML
           private void CoachControlOnAction(ActionEvent event) {
               Node node = (Node) event.getSource();
                       Stage stage = (Stage) node.getScene().getWindow();
                       FXMLLoader loader = new FXMLLoader ();
                       loader.setLocation(getClass().getResource("/pijava/CoachBack/BackMenuCoach.fxml"));
                       try {
                               loader.load();


                           } catch (IOException ex) {
                               Logger.getLogger(ListNewsController.class.getName()).log(Level.SEVERE, null, ex);
                               System.out.println("failed to load");
                               System.out.println(ex);
                           }

                           Parent parent = loader.getRoot();
                           stage.setScene(new Scene(parent));
                           stage.show(); 
           }
       public static final  String ACCOUNT_SID = "AC5855f26f1d059fcf73911900db0f5647";
    public static final String  AUTH_TOKEN = "6db5b9f5a4fd8d7471fdc4e58f25e042";

    @FXML
    private void AjouterNews(ActionEvent event) {
        

ServiceNews sn= new ServiceNews();
        News n = new News();
    java.util.Date d1 = new java.util.Date();
            java.sql.Date dateToday = new java.sql.Date(d1.getTime());
         n.setDate(dateToday);
      n.setTitre(Titre.getText());
        n.setContenu(Contenu.getText());
        n.setTypeSport(TypeSport.getSelectionModel().getSelectedItem().toString());
        n.setURLImg(ImgPath.getText());
//try{
//            Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
//            String msgs="un nouvel article a été ajouté, veuillez consulter notre application pour plus de détails";
//           
//            Message message = Message.creator(new PhoneNumber("+21650660838"),
//                    new PhoneNumber("+18649528596"), msg.getText().toString()).create();
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Success");
//            alert.setHeaderText("");
//            alert.setContentText("SMS Send Successfully");
//            alert.show(); } catch (Exception e){
//
//    Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Failed");
//            alert.setHeaderText("");
//            alert.setContentText("Something went wrong:"+e.toString());
//            e.printStackTrace();
//            alert.show();
//        }
        sn.AjouterNews(n);
    }

 

    @FXML
    private void ShowStat(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("Statistic.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(FXMLNews0Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }
    

    @FXML
    private void AfficherNews(ActionEvent event) {
         Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("ListNews.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(FXMLNews0Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }

    
}
