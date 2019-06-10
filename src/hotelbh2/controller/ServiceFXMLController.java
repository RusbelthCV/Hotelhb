/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Habitacion;
import hotelbh2.model.Reserva;
import hotelbh2.model.Servicio;
import hotelbh2.model.conexion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class ServiceFXMLController implements Initializable 
{
    @FXML AnchorPane add_service;
    @FXML AnchorPane mod_service;
    @FXML TextField nombre;
    @FXML TextField id;
        @FXML TextField id_reserva;

    @FXML TextField precio;
    @FXML ComboBox<Reserva> select;
    @FXML Button enviar_add_service;
    @FXML Button menu;
    @FXML Button enviar_modserv;
    private ObservableList<Reserva> ids; 



    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        ids = FXCollections.observableArrayList();
        Reserva.llenarInfo(ids);
        select.setItems(ids);
    }    
    @FXML
    public void insertServ() throws SQLException{
        
   
        int num_precio=Integer.parseInt(precio.getText());
        String id_reserva=select.getValue().toString();
        int pos_puntos= id_reserva.indexOf(':');
        int pos_coma= id_reserva.indexOf(',');
        id_reserva=(id_reserva.substring((pos_puntos+2),pos_coma));
        int id_reserva_int=Integer.parseInt(id_reserva);
        Servicio servicio = new Servicio (nombre.getText(), num_precio,id_reserva_int);
        servicio.insertServ();
         
    }
    @FXML
    public void modServ() throws SQLException{
        
        int num_id=Integer.parseInt(id.getText());
        int num_precio=Integer.parseInt(precio.getText());
        Servicio.modificarServ(nombre.getText(), num_precio,num_id);

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
            stage.initOwner(add_service.getScene().getWindow());
            ((Stage)add_service.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
