/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.News;
import Service.ServiceNews;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author essia
 */
public class ModificationNewsController implements Initializable {

    @FXML
    private TextArea Contenu;
    @FXML
    private TextArea Titre;
    @FXML
    private TextArea ImgPath;
    @FXML
    private Button BoutonAjoutImage;
    @FXML
    private ImageView imagenews;
    @FXML
    private ComboBox TypeSport;
    @FXML
    private Button Enregistrer;
          private Image image;
          private File file;
           private FileChooser fileChooser;
    private final Desktop desktop = Desktop.getDesktop();
    @FXML
    private JFXTextField idtodeleteupdate;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        path= path.substring(23, path.length());
        path ="http://localhost/Images/" +path;
        ImgPath.setText(path);
        n.setURLImg(path);
        if(file!=null){
            
            try {
                System.out.println(""+file.getAbsolutePath());
                image =new Image(file.getAbsoluteFile().toURL().toString());
               image = new Image(path);
                imagenews.setImage(image);
            } catch(Exception ex)  {
                Logger.getLogger(ModificationNewsController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }}
      });}
    public void AffichNewsDet(News n){  
        Titre.setText(n.getTitre());
            Contenu.setText(n.getContenu());

            ImgPath.setText(n.getURLImg());
        ImgPath.setText(n.getURLImg());
         image =new Image(n.getURLImg());
                imagenews.setImage(image);
                TypeSport.setValue(n.getTypeSport());
                idtodeleteupdate.setText(String.valueOf(n.getId()));
        

        
        
    }

 
    @FXML
    private void Enregistrer(ActionEvent event) {
       ServiceNews sn= new ServiceNews(); 
        News n = new News();
            java.util.Date d1 = new java.util.Date();
            java.sql.Date dateToday = new java.sql.Date(d1.getTime());
         n.setDate(dateToday);
      n.setTitre(Titre.getText());
        n.setContenu(Contenu.getText());
        n.setId(Integer.valueOf(idtodeleteupdate.getText()));
        System.out.println(n.getId());
        n.setURLImg(ImgPath.getText());
        sn.ModifierNews(n);
          Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
     public void Modifier(News n){  
       
 
     }}
     
    
    
              
    

