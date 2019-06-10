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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class ListaServFXMLController implements Initializable {

    @FXML TableView<Habitacion> tabla;
    @FXML TableColumn<Habitacion,Number> clmNumHab;
    @FXML TableColumn<Habitacion,String> clmCarac;
    @FXML TableColumn<Habitacion,Number> clmPrecio;
    @FXML TableColumn<Habitacion,String> clmEstado;
    @FXML TableColumn<Habitacion,String> clmTipo;
    @FXML TableColumn<Habitacion,Number> clmPiso;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        ObservableList<Habitacion> lista = FXCollections.observableArrayList();
        try 
        {
            Habitacion.listaHab(lista);
            tabla.setItems(lista);
            clmNumHab.setCellValueFactory(new PropertyValueFactory<Habitacion,Number>("num_hab"));
            clmCarac.setCellValueFactory(new PropertyValueFactory<Habitacion,String>("caracteristicas"));
            clmPrecio.setCellValueFactory(new PropertyValueFactory<Habitacion,Number>("precio"));
            clmEstado.setCellValueFactory(new PropertyValueFactory<Habitacion,String>("estado"));
            clmTipo.setCellValueFactory(new PropertyValueFactory<Habitacion,String>("tipo_hab"));
            clmPiso.setCellValueFactory(new PropertyValueFactory<Habitacion,Number>("piso"));
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ListaServFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
       @FXML
     void clickon(){
         
        tabla.getSelectionModel().getSelectedItem().showHabDetails();


    }
}
