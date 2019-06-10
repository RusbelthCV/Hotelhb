/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.Reporte;
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
import javafx.scene.control.DatePicker;
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
public class CalendarioFXMLController implements Initializable {
    
    @FXML AnchorPane ventana;
    @FXML DatePicker fechaIn;
    @FXML DatePicker fechaFin;
    @FXML TableView<Reporte> tablaReportes;
    @FXML TableColumn<Reporte, String> clmTipo;
    
    static String fechaI;
    static String fechaF;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    public void reporte() throws SQLException    
    {
        fechaI = fechaIn.getValue().toString();
        fechaF = fechaFin.getValue().toString();
        /*String fecha1 = fechaIn.getValue().toString();
        String fecha2 = fechaFin.getValue().toString();
        ObservableList<Reporte> reporte = FXCollections.observableArrayList();
        Reporte.lista(reporte,fecha1,fecha2);
        tablaReportes.setItems(reporte);*/
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/ListaReporteFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Reportes");
            stage.setScene(scene);
            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
            
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //clmTipo.setCellValueFactory(new PropertyValueFactory<Reporte, String>("tipo"));
    }
    public void reservas()
    {
        
    }
    public DatePicker getFechain()
    {
        return this.fechaFin;
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
            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
