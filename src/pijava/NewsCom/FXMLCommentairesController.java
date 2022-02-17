/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.Commentaire;
import Entities.News;
import Service.ServiceCommentaires;
import Service.ServiceNews;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.xml.stream.events.Comment;

/**
 * FXML Controller class
 *
 * @author guest
 */
public class FXMLCommentairesController implements Initializable {

    @FXML
    private TextArea ContenuCommentaire;
    @FXML
    private Button Valider;
    @FXML
    private Button Annuler;
    @FXML
    private Label nblikes;
    @FXML
    private ImageView Likereact;
    @FXML
    private Button Supprimer;
    @FXML
    private Button Modifier;
    private TableView<Commentaire> tvCommentaires;
    @FXML
    private TextField id;
    private TableColumn<Commentaire, Integer> Colid;
    @FXML
    private ImageView imagenews;
    @FXML
    private JFXTextArea news;
    private static News ne= new News();
    @FXML
    private Label DatePub;
    @FXML
    private ImageView DislikeReact;
    @FXML
    private JFXListView<Commentaire> listView;
    @FXML
    private VBox vBox;
    private JFXTextArea Contenu;
    @FXML
    private JFXTextArea Titre;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         news.setEditable(false);
         

//news.setMouseTransparent(true);
//news.setFocusTraversable(false);
       ServiceCommentaires sc = new ServiceCommentaires();
       Commentaire c = new Commentaire();
           ShowCommentaires();            
 
    }   
    public void AffichNewsDet2(News n){
        ServiceNews sn = new ServiceNews();
        // 
        n = sn.AfficherNewsDetails(n.getId());
        //
       ne=n;
       Titre.setText(n.getTitre());
        news.setText(n.getContenu());
        Titre.setFont(Font.font("Verdana", FontWeight.BOLD,30));
        nblikes.setText(String.valueOf(n.getNbreacts()));
         
        
       String path =n.getURLImg();
                       System.out.println(path);
                                        BufferedImage BfImg = null;
                         try {

                                URL url= new URL(path);
                                BfImg= ImageIO.read(url);
            
        } catch (Exception ex) {
           // System.out.println(path);
           
           System.out.println("Failed to load image");
           System.out.println(ex);
        }
        WritableImage wr = null;
        if (BfImg != null) {
            wr = new WritableImage(BfImg.getWidth(), BfImg.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < BfImg.getWidth(); x++) {
                for (int y = 0; y < BfImg.getHeight(); y++) {
                    pw.setArgb(x, y, BfImg.getRGB(x, y));
                }
            }
        }
        imagenews.setImage(wr);
      
    

  
    }
    @FXML
    private void ValiderCommentaire(ActionEvent event) {
        validate();
        ServiceCommentaires sc = new ServiceCommentaires();
        Commentaire c = new Commentaire();
        News ne = new News();

         java.util.Date d1 = new java.util.Date();
            Date dateToday = new java.sql.Date(d1.getTime());
         c.setDate_dajout(dateToday);
      
       // filtrage 
	 String str=ContenuCommentaire.getText();
//         String s="AA";
//         if (str.contains("AA")){
//                    Pattern rx = Pattern.compile("\\b" + s + "\\b", Pattern.CASE_INSENSITIVE);
//		str = rx.matcher(str).replaceAll(new String(new char[s.length()]).replace('\0', '*'));
//         }
  
//         str = CensoredComment(str);
	c.setContenu(str);
         sc.AjouterCommentaire(c,getNewsId());
      ShowCommentaires();
         
    }
   

public String CensoredComment(String comment) {
try {
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\badwords.txt"));
	String s ; 
	List<String> words = new ArrayList<String>() ;
	while (( s = br.readLine()) != null )  {
	words.add(s) ;
	}
	
	for (String word : words ) {
		Pattern rx = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
		comment = rx.matcher(comment ).replaceAll(new String(new char[word.length()]).replace('\0', '*'));
	}
	return comment ;

}catch (Exception ex) {

 System.out.println("failed to read txt") ; 
 System.out.println(ex);
}
return comment ; 
}
//    public String CensoredComment(String comment) {
//
////	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\badwords.txt"));
//	String s="AAA"; 
//	
//	
//	
//	
//		Pattern rx = Pattern.compile("\\b" + s + "\\b", Pattern.CASE_INSENSITIVE);
//		comment = rx.matcher(comment ).replaceAll(new String(new char[s.length()]).replace('\0', '*'));
//	
//
//
//
//return comment ; 
//}
    

       

    @FXML
    private void AnnulerCommentaire(ActionEvent event) {
        Parent root = null;
        try { 
    if(ne.getTypeSport().equals("FOOTBALL")){
            root = FXMLLoader.load(getClass().getResource("FootNews.fxml"));}
    else if(ne.getTypeSport().equals("BASKETBALL")){
            root = FXMLLoader.load(getClass().getResource("BasketBallNews.fxml"));}
    else  if(ne.getTypeSport().equals("HANDBALL")){
            root = FXMLLoader.load(getClass().getResource("HandNews.fxml"));}
    else  if(ne.getTypeSport().equals("TENNIS")){
            root = FXMLLoader.load(getClass().getResource("TennisNews.fxml"));}
    else  if(ne.getTypeSport().equals("RUGBY")){
            root = FXMLLoader.load(getClass().getResource("RugbyNews.fxml"));}
    else  if(ne.getTypeSport().equals("BASEBALL")){
            root = FXMLLoader.load(getClass().getResource("BaseBallNews.fxml"));}
    else  if(ne.getTypeSport().equals("VOLLEYBALL")){
            root = FXMLLoader.load(getClass().getResource("VolleyNews.fxml"));}
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            

            stage.setScene(scene);
            stage.show(); 
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

   
    private void AfficherCommentaires(ActionEvent event) throws IOException {
                ServiceCommentaires sc = new ServiceCommentaires();
                ShowCommentaires();
                
    }
                 
        

    @FXML
    private void SupprimerCommentaire(ActionEvent event) {
        ServiceCommentaires sc = new ServiceCommentaires();
            Commentaire c = new Commentaire();
       int IDValue = Integer.parseInt(id.getText());
        c.setId(IDValue);
        sc.SupprimerCommentaire(c);
        ShowCommentaires();
        
    }
    @FXML
     private void ModifierCommentaire(ActionEvent event) {

    ServiceCommentaires sc = new ServiceCommentaires();
        Commentaire c = new Commentaire();
        c.setContenu(ContenuCommentaire.getText());
         java.util.Date d1 = new java.util.Date();
            Date dateToday = new java.sql.Date(d1.getTime());
         c.setDate_dajout(dateToday);
         int IDValue = Integer.parseInt(id.getText());
        c.setId(IDValue);
        sc.ModifierCommentaire(c);
        ShowCommentaires();
   
        
    }
     public void ShowCommentaires(){
        ServiceCommentaires sc = new ServiceCommentaires();
      
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);

        ObservableList<Commentaire> NewsList = sc.AfficherCommentaire(getNewsId());
          listView.setStyle("  -fx-selection-bar: #90ee90 ; -fx-border-color:#90ee90");

        listView.setCellFactory((Callback<ListView<Commentaire>, ListCell<Commentaire>>) param -> {
            return new ListCell<Commentaire>() {
                @Override
                protected void updateItem(Commentaire c, boolean empty) {
                    super.updateItem(c, empty);

                    if (c == null || empty) {
                        setText(null);
                    } else {
                       
                        HBox Hbx = new HBox(100);
                        Hbx.setAlignment(Pos.TOP_CENTER);
                        Hbx.setPadding(new Insets(5, 10, 5, 10));
 Label Contenu= new Label(String.valueOf(c.getContenu())+"\n"+"Ajouté le : "+c.getDate_dajout());
                         Contenu.setMinWidth(100);
                        Contenu.setMinHeight(100);
                        Contenu.setCursor(Cursor.HAND);
      
Hbx.getChildren().addAll(Contenu);
                        setText(null);
                        setGraphic(Hbx);
                    }

                }
            };

        });

        listView.setItems(NewsList);

        vBox.getChildren().add(listView);

       
    }
    
     

     
     public int getNewsId() {
        NewsHolder holder = NewsHolder.getInstance();
        int t = holder.getNews();
        return t;
    }

    @FXML
    private void AffiageTextArea(MouseEvent event) {
         Commentaire c =listView.getSelectionModel().getSelectedItem();
         ContenuCommentaire.setText(c.getContenu());
          String s = String.valueOf(c.getId());
            id.setText(s); 
      ShowCommentaires();
    }
       public boolean validate(){
         if(ContenuCommentaire.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please enter into the fields");
            alert.showAndWait();
         return false   ;
        }
         return true;
    }
       int compteur=0;
    @FXML
    private void react(MouseEvent event) {
   News n=new News();
   n=ne;
        ServiceNews sn = new ServiceNews();
        ServiceCommentaires sc = new ServiceCommentaires();
        
        compteur=n.getNbreacts();
         compteur++;
       nblikes.setText(String.valueOf(compteur));
       n.setNbreacts(compteur);
       Likereact.setDisable(true);
        
        sn.ModifieNbreacts(compteur, n);
       
        }

    @FXML
    private void Dislike(MouseEvent event) {
          News n=new News();
   n=ne;
        ServiceNews sn = new ServiceNews();
        ServiceCommentaires sc = new ServiceCommentaires();
        
        compteur=n.getNbreacts();
         compteur--;
       nblikes.setText(String.valueOf(compteur));
       n.setNbreacts(compteur);
          Likereact.setDisable(true);
        
        sn.ModifieNbreacts(compteur, n);
    }
       
            
        }
    
  
    

    


  
    
    

