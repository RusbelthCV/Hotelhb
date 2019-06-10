/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Habitacion;
import hotelbh2.model.Reserva;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class ListaReservaFXMLController implements Initializable {
    @FXML TableView<Reserva>tabla_reserva;
    private static Reserva factura_reserva;
    @FXML AnchorPane lista_Reserva;
    @FXML Button menu;
    @FXML TableColumn<Reserva,String> clmFechaIngreso;
    @FXML TableColumn<Reserva,String> clmFechaSalida;
    @FXML TableColumn<Reserva,Number> clmCantidadP;
    @FXML TableColumn<Reserva,String> clmTrabajador;
    @FXML TableColumn<Reserva,String> clmDocumento;
    @FXML TableColumn<Reserva,Number> clmNumeroHab;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        ObservableList<Reserva> lista = FXCollections.observableArrayList();
        try 
        {
            Reserva.listaReserva(lista);
            tabla_reserva.setItems(lista);
            clmFechaIngreso.setCellValueFactory(new PropertyValueFactory<Reserva,String>("fecha_ingreso"));
            clmCantidadP.setCellValueFactory(new PropertyValueFactory<Reserva,Number>("cantidad_personas"));
            clmFechaSalida.setCellValueFactory(new PropertyValueFactory<Reserva,String>("fecha_salida"));
            clmTrabajador.setCellValueFactory(new PropertyValueFactory<Reserva,String>("Trabajador"));
            clmNumeroHab.setCellValueFactory(new PropertyValueFactory<Reserva,Number>("num_hab"));
            clmDocumento.setCellValueFactory(new PropertyValueFactory<Reserva,String>("documento_cliente"));

     
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ListaReservaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
       @FXML
     void clickon(){
          Reserva reservaclicked=tabla_reserva.getSelectionModel().getSelectedItem();
        factura_reserva=reservaclicked;
        tabla_reserva.getSelectionModel().getSelectedItem().showFacturaDetails();


    }
    public static Reserva getfactura_reserva(){
        return factura_reserva;
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
            stage.initOwner(lista_Reserva.getScene().getWindow());
            ((Stage)lista_Reserva.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
