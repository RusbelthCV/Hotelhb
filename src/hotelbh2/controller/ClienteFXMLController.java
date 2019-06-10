/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Login;
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
public class ClienteFXMLController implements Initializable 
{
    @FXML AnchorPane hola;
    @FXML AnchorPane mod_cliente;
    @FXML TextField documentos;
    @FXML TextField documentos_modificar;
    @FXML TextField nombre;
    @FXML TextField nacionalidad;
    @FXML TextField estado_civil;
    @FXML TextField telefono;
    @FXML TextField ocupacion;
    @FXML TextField email;
     @FXML TextField nombre_modificar;
    @FXML TextField nacionalidad_modificar;
    @FXML TextField estado_civil_modificar;
    @FXML TextField telefono_modificar;
    @FXML TextField ocupacion_modificar;
    @FXML TextField email_modificar;
    @FXML Button enviar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      
    }    
    @FXML
    public void insertC() throws SQLException{
         AddClient cliente = new AddClient (documentos.getText(),nombre.getText(), nacionalidad.getText(),telefono.getText(),email.getText(),ocupacion.getText(),estado_civil.getText(),Login.getuser_login());
         cliente.insertClient();
         
    }
    @FXML
    public void insertCR() throws SQLException{
         AddClient cliente = new AddClient (documentos.getText(),nombre.getText(), nacionalidad.getText(),telefono.getText(),email.getText(),ocupacion.getText(),estado_civil.getText(),Login.getuser_login());
         cliente.insertClient();
         ReservaFXMLController.setClientR(cliente);
         
    }
    @FXML
    public void volverMenu()
    {
       try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResource("/hotelbh2/view/menuRecepcionistaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Principal");
            stage.initOwner(hola.getScene().getWindow());
            ((Stage)hola.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
