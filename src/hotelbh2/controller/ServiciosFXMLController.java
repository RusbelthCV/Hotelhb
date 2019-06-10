/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.Servicio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
public class ServiciosFXMLController implements Initializable {
    private static Servicio ServCLick;
    @FXML TableView<Servicio> tablaServicio;
    //@FXML TableColumn<Servicio, Number> id;
    @FXML TableColumn<Servicio, String> nombreS;
    @FXML TableColumn<Servicio, Number> precio;
    @FXML TableColumn<Servicio, Number> idR;
    @FXML AnchorPane Servicios;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        ObservableList<Servicio> list = FXCollections.observableArrayList();
        Servicio.lista(list);
        tablaServicio.setItems(list);
        //id.setCellValueFactory(new PropertyValueFactory<Servicio, Number>("id_servicio"));
        nombreS.setCellValueFactory(new PropertyValueFactory<Servicio, String>("nombre_servicio"));
        precio.setCellValueFactory(new PropertyValueFactory<Servicio, Number>("precio"));
        idR.setCellValueFactory(new PropertyValueFactory<Servicio, Number>("reserva"));
    }
       @FXML
     void clickon(){
                 Servicio serv=tablaServicio.getSelectionModel().getSelectedItem(); 
        ServCLick = serv;
        tablaServicio.getSelectionModel().getSelectedItem().showHServiceDetails();


    }    
    public static Servicio getServicioClicked(){
        return ServCLick;
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
            stage.initOwner(Servicios.getScene().getWindow());
            ((Stage)Servicios.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
