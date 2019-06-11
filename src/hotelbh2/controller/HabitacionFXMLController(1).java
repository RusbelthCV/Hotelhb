/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Habitacion;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    @FXML TextField tipo_hab;
    @FXML TextArea caracteristicas;
    @FXML Button enviar_hab;
    @FXML Button enviar_modhab;



    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         String[] datos=Habitacion.getdatos();
                caracteristicas.setText(datos[0]); 
                precio.setText(datos[1]);
                estado.setText(datos[2]);
                tipo_hab.setText(datos[3]);
                piso.setText(datos[4]);
                caracteristicas.setText(datos[5]);
    }    
    @FXML
    public void insertHab() throws SQLException{
        
        int num_habitacion=Integer.parseInt(num_hab.getText());
        int num_precio=Integer.parseInt(precio.getText());
        int  num_piso=Integer.parseInt(piso.getText());        
        Habitacion hab = new Habitacion (num_habitacion,caracteristicas.getText(),num_precio,estado.getText(),tipo_hab.getText(),num_piso);
        hab.insertHab();
         
    }
        public void modHab() throws SQLException{
        String[] datos=Habitacion.getdatos();
        int num_precio=Integer.parseInt(precio.getText());
        
        Habitacion.modificaHab(caracteristicas.getText(), num_precio, estado.getText(), tipo_hab.getText(), Integer.parseInt(datos[6]));


        }

}
