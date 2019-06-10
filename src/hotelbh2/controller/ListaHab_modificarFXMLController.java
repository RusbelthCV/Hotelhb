/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import hotelbh2.model.AddClient;
import hotelbh2.model.Habitacion;
import java.io.FileOutputStream;
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
public class ListaHab_modificarFXMLController implements Initializable {
    static private Habitacion habCLick;
    @FXML TableView<Habitacion> tabla;
    @FXML TableColumn<Habitacion,Number> clmNumHab;
    @FXML TableColumn<Habitacion,String> clmCarac;
    @FXML TableColumn<Habitacion,Number> clmPrecio;
    @FXML TableColumn<Habitacion,String> clmEstado;
    @FXML TableColumn<Habitacion,String> clmTipo;
    @FXML TableColumn<Habitacion,Number> clmPiso;
    @FXML AnchorPane ventana;
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
            Logger.getLogger(ListaHab_modificarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
       @FXML
     void clickon(){
         
        tabla.getSelectionModel().getSelectedItem().showHabDetails();

    }
    @FXML
    void clickon_reserva(){
         
        Habitacion hab=tabla.getSelectionModel().getSelectedItem(); 
        habCLick = hab;


    }
     public static  Habitacion gethabCLick(){
         return habCLick;
     }
     @FXML 
     public void pdf()
     {
         Document document = new Document();
         try
         {
            PdfWriter.getInstance(document, new FileOutputStream("ListaHabitaciones.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(6);
            table.addCell("Numero");
            table.addCell("Caracteristicas");
            table.addCell("Precio");
            table.addCell("Estado");
            table.addCell("Tipo");
            table.addCell("Piso");
            for (int i = 0; i < tabla.getItems().size(); i++)
            {
                table.addCell(clmNumHab.getCellData(i).toString());
                table.addCell(clmCarac.getCellData(i));
                table.addCell(clmPrecio.getCellData(i).toString());
                table.addCell(clmEstado.getCellData(i));
                table.addCell(clmTipo.getCellData(i));
                table.addCell(clmPiso.getCellData(i).toString());
            }
            document.add(table);
            document.close();
         }
         catch(Exception e)
         {
            System.err.println("Ocurrio un error al crear el archivo");
            System.exit(-1);
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
