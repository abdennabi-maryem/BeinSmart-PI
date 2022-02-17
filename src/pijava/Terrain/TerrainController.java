/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.Terrain;

import Entities.Terrain;
import Service.ServiceTerrain;
import Utils.UserSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pijava.CoachBack.AdminDemandeCoachController;
import pijava.CoachBack.AdminListeCoachController;
import pijava.Login.AccueilController;
import pijava.NewsCom.FXMLNews0Controller;

/**
 * FXML Controller class
 *
 * @author 21699
 */
public class TerrainController implements Initializable {

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
    @FXML
    private TextField tfNomt;
    @FXML
    private TextField tfAdr;
    @FXML
    private ImageView ProfilIMG;
    @FXML
    private Label UsernameADMIN;
    @FXML
    private Button btnchart;
    @FXML
    private ComboBox<String> TypeSport;
    @FXML
    private Button imgButton;
    @FXML
    private TextArea ImgPath;
    @FXML
    private TextField tfNum;
    @FXML
    private Button AjoutBTN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // insertion des sports dans combox 
              ObservableList<String> list =FXCollections.observableArrayList
        ("TENNIS","BASKETBALL","FOOTBALL","VOLLEYBALL","BASEBALL","RUGBY","HANDBALL");
        
        TypeSport.setItems(list);
             //
        
        // TODO
        
        // les boutons de navigation 
         UsernameADMIN.setText(UserSession.getUsername());
        
        File UserIconFile = new File("image/UserIcon.png");
        Image UserIcon = new Image(UserIconFile.toURI().toString());
        ProfilIMG.setImage(UserIcon);
        
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
        
        Ajouter();
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
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
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
                loader.setLocation(getClass().getResource("BackMenuCoach.fxml"));
                try {
                        loader.load();
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
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
                        Logger.getLogger(AdminListeCoachController.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("failed to load");
                        System.out.println(ex);
                    }
            
                    Parent parent = loader.getRoot();
                    stage.setScene(new Scene(parent));
                    stage.show(); 
    }

    
    @FXML
    private void Ajouter() {
         Terrain t =new Terrain();
             ServiceTerrain st=new ServiceTerrain();
             
             // Ajout de l'image
             
             FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif"));
      
        imgButton.setOnAction((ActionEvent e) -> {
         File   file = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
            String path = file.getAbsolutePath();
            ImgPath.setText(path);
        //   String From  = path ;
           
            path = path.substring(21,path.length());
            
          //  String To = "C:\\wamp64\\www\\PiJava\\" + path;
            
            
            path = "http://localhost/PiJava/" + path ;
            
            t.setURLImg(path);
        });
             //
              AjoutBTN.setOnAction((ActionEvent event) -> {
        String Num = tfNum.getText();
     String nom=tfNomt.getText();
     String adresse=tfAdr.getText();
        String type_sport=TypeSport.getSelectionModel().getSelectedItem();
    // String ressources=tfressources.getText();
      t.setNomT(nom);
      t.setAdresse(adresse);
    //  t.setRessources(ressources);
      t.setType_sport(type_sport);
      t.setNumTel(Integer.parseInt(Num));
      
      if (nom.isEmpty()||adresse.isEmpty()||type_sport.isEmpty()){
     
     Alert alert =new Alert(Alert.AlertType.ERROR);
     alert.setHeaderText(null);
     alert.setContentText("veuillez insérer toutes les données nécéssaires");
     alert.showAndWait();
     
     }else{
    
     st.AjoutTerrain(t);
   
     }
              });
    }


    @FXML
    private void AffichChart(ActionEvent event) {
              FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/pijava/Terrain/Stat.fxml"));
                        try {
                            loader.load();
                           
                              } catch (IOException ex) {
                            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
//            XYChart.Series series=new XYChart.Series();
//        series.getData().add(new XYChart.Data("Club des Princes",2));
//series.getData().add(new XYChart.Data("Terrain Lake Club",7));
//series.getData().add(new XYChart.Data("The Hills Academy",8));
//series.getData().add(new XYChart.Data("Star Sport Academy",1));
//series.getData().add(new XYChart.Data("Olympico Staduim",5));
//series.getData().add(new XYChart.Data("Olympysky Club",10));
//series.getData().add(new XYChart.Data("Marselone",3));
//
//
//        LineChart.getData().addAll(series);

                 
    


//
                 //PieChart dataset=new PieChart();

    //     JFreeChart chart=createChart(dataset);
         
         
     /*   try{
            String query ="SELECT `type_sport`, `nomT` FROM `terrain` ";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset(MaConnexion.getInstance(),query);
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }*/
        
    }

    @FXML
    private void AfficherTerrain(ActionEvent event) {
        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("AfficherTerrain.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(TerrainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
    }
    
}
