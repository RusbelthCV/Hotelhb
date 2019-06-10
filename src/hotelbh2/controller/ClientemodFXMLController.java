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
public class ClientemodFXMLController implements Initializable 
{
    @FXML AnchorPane mod_cliente;
    @FXML TextField documentos_modificar;
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
        String[] datos=AddClient.getdatos();        
        documentos_modificar.setEditable(false);
        documentos_modificar.setMouseTransparent(true);
        documentos_modificar.setFocusTraversable(false);
        nombre_modificar.setText(datos[0]); 
        nacionalidad_modificar.setText(datos[1]);
        estado_civil_modificar.setText(datos[2]);
        telefono_modificar.setText(datos[3]);
        ocupacion_modificar.setText(datos[4]);
        email_modificar.setText(datos[5]);
        documentos_modificar.setText(datos[6]);
               
    }    
    @FXML
    
    public void updateC() throws SQLException{
        String[] datos=AddClient.getdatos();
        AddClient.modificarClient(datos[6],nombre_modificar.getText(), nacionalidad_modificar.getText(),estado_civil_modificar.getText(),telefono_modificar.getText(),ocupacion_modificar.getText(),email_modificar.getText());

    }
   
}
