/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Login;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
   
   
}
