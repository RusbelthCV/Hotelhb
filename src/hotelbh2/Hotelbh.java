/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2;

import hotelbh2.model.conexion;
import hotelbh2.controller.LoginFXMLController;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Rusbelth
 */
public class Hotelbh extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {
        //lblError.setVisible(false);
        try 
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("view/LoginFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch (NullPointerException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hotelbh.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion con = new conexion();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}