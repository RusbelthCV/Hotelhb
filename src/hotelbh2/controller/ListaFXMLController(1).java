/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Habitacion;
import hotelbh2.model.Reserva;
import hotelbh2.model.conexion;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class ListaFXMLController implements Initializable
{
    public static  AddClient ClientClick;
    @FXML TableView<AddClient> tablaCliente;
    @FXML TableColumn<AddClient,String> clmDoc;
    @FXML TableColumn<AddClient,String> clmNombre;
    @FXML TableColumn<AddClient,String> clmNac;
    @FXML TableColumn<AddClient,String> clmTlf;
    @FXML TableColumn<AddClient,String> clmEmail;
    @FXML TableColumn<AddClient,String> clmOcup;
    @FXML TableColumn<AddClient,String> clmEC;
    @FXML TableColumn<AddClient,String> clmEmpl;
    /**
     * Initializes the controller class.
     */
    @FXML AnchorPane editClient;
    @FXML AnchorPane ventana;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
           
        ObservableList<AddClient> lista = FXCollections.observableArrayList();
        try
        {
           
            AddClient.listClient(lista);
            tablaCliente.setItems(lista);
            clmDoc.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Documentos"));
            clmNombre.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Nombre"));
            clmNac.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Nacionalidad"));
            clmTlf.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Telefono"));
            clmEmail.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Email"));
            clmOcup.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Ocupacion"));
            clmEC.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Estado_civil"));
            clmEmpl.setCellValueFactory(new PropertyValueFactory<AddClient,String>("Trabajador"));
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ListaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
    }
    
    @FXML
     void clickon(){
         
        tablaCliente.getSelectionModel().getSelectedItem().showPersonDetails();
        AddClient client=tablaCliente.getSelectionModel().getSelectedItem(); 
        ClientClick=client;
        
    }
        @FXML
    void clickon_reserva(){
         
       AddClient client=tablaCliente.getSelectionModel().getSelectedItem(); 
        ClientClick=client;
        ReservaFXMLController.setClientR(client);
        System.out.println(client.getDocumentos());


    }
     public static  AddClient gethabCLick(){
         return ClientClick;
     }     
   
    

}
