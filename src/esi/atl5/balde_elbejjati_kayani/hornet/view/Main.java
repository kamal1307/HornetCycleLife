package esi.atl5.balde_elbejjati_kayani.hornet.view;

import esi.alt5.balde_elbejjati_kayani.hornet.business.FacadeDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launch Application
 * @author Alpha,Mohamed,Kamal
 */
public class Main extends Application {
     /**
     * Main methode.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FacadeDB.connexion();
    FacadeDB.createTables();
        Parent root = FXMLLoader.load(getClass().getResource("WindowGame.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hornet's Life");
        stage.setResizable(false); 
        stage.setScene(scene);
        stage.show();
        
   
    }

}
