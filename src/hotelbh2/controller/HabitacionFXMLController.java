/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import com.jfoenix.controls.JFXButton;
import hotelbh2.model.AddClient;
import hotelbh2.model.Habitacion;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class HabitacionFXMLController implements Initializable 
{
    @FXML AnchorPane habitacion;
     @FXML AnchorPane mod_habitacion;
    @FXML TextField num_hab;
    @FXML TextField piso;
    @FXML TextField precio;
    @FXML TextField estado;
    @FXML ComboBox<String> state;
    @FXML TextField tipo_hab;
    @FXML TextArea caracteristicas;
    @FXML JFXButton enviar_hab;
    @FXML JFXButton enviar_modhab;
    private ObservableList<String> estados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         String[] datos=Habitacion.getdatos();
                num_hab.setText(datos[6]);
                //num_hab.setEditable(false);
                caracteristicas.setText(datos[0]); 
                precio.setText(datos[1]);
                state.getSelectionModel().select(datos[2]);
                tipo_hab.setText(datos[3]);
                piso.setText(datos[4]);
                caracteristicas.setText(datos[5]);
                estados = FXCollections.observableArrayList();
                estados.add("Ocupado");
                estados.add("Libre");
                estados.add("Cerrado por mantenimiento");
                state.setItems(estados);
    }    
    @FXML
    public void insertHab() throws SQLException{
        int num_habitacion=Integer.parseInt(num_hab.getText());
        int num_precio=Integer.parseInt(precio.getText());
        int  num_piso=Integer.parseInt(piso.getText());        
        Habitacion hab = new Habitacion (num_habitacion,caracteristicas.getText(),num_precio,state.getValue().toString(),tipo_hab.getText(),num_piso);
        hab.insertHab(); 
    }
        public void modHab() throws SQLException{
        String[] datos=Habitacion.getdatos();
        int num_precio=Integer.parseInt(precio.getText());        
        Habitacion.modificaHab(caracteristicas.getText(), num_precio, state.getValue(), tipo_hab.getText(), Integer.parseInt(datos[6]));
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
            stage.initOwner(habitacion.getScene().getWindow());
            ((Stage)habitacion.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
}
