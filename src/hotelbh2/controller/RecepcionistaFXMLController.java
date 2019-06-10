/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.Recepcionista;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class RecepcionistaFXMLController implements Initializable {

    @FXML TextField nombre;
    @FXML TextField contra;
    @FXML Button ingresar;
    @FXML AnchorPane recepcionista;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    @FXML 
    public void insertRecepcionista()
    {
        try 
        {
            Recepcionista recep = new Recepcionista(nombre.getText(),contra.getText(),0);
            recep.insert();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(RecepcionistaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void volverMenu()
    {
       try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResource("/hotelbh2/view/menuFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Principal");
            stage.initOwner(recepcionista.getScene().getWindow());
            ((Stage)recepcionista.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}