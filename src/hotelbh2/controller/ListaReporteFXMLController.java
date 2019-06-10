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
public class ListaReporteFXMLController implements Initializable {

    @FXML DatePicker fechaIn;
    @FXML DatePicker fechaFin;
    @FXML TableView<Reporte> tablaReportes;
    @FXML TableColumn<Reporte, String> clmTipo;
    @FXML TableColumn<Reporte, String> clmFecha;
    @FXML AnchorPane Reportes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        String fecha1 = CalendarioFXMLController.fechaI;
        String fecha2 = CalendarioFXMLController.fechaF;
        ObservableList<Reporte> reporte = FXCollections.observableArrayList();
        try 
        {
            Reporte.lista(reporte,fecha1,fecha2);
            tablaReportes.setItems(reporte);
            clmTipo.setCellValueFactory(new PropertyValueFactory<Reporte, String>("tipo"));
            clmFecha.setCellValueFactory(new PropertyValueFactory<Reporte, String>("fecha"));
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ListaReporteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            stage.initOwner(Reportes.getScene().getWindow());
            ((Stage)Reportes.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
