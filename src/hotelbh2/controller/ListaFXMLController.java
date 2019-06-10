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
import hotelbh2.model.Reserva;
import hotelbh2.model.conexion;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
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
import javafx.scene.control.Button;
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
    @FXML AnchorPane lista_client;
    @FXML Button menu;
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
    @FXML 
    public void pdf()
    {
        Document document = new Document();
        try
        {
           PdfWriter.getInstance(document, new FileOutputStream("ListaClientes.pdf"));
           document.open();
           PdfPTable table = new PdfPTable(8);
           table.addCell("Documentos");
           table.addCell("Nombre");
           table.addCell("Nacionalidad");
           table.addCell("Telefono");
           table.addCell("Email");
           table.addCell("Ocupacion");
           table.addCell("Estado Civil");
           table.addCell("Trabajador");
           for (int i = 0; i < tablaCliente.getItems().size(); i++)
           {
               table.addCell(clmDoc.getCellData(i));
               table.addCell(clmNombre.getCellData(i));
               table.addCell(clmNac.getCellData(i));
               table.addCell(clmTlf.getCellData(i));
               table.addCell(clmEmail.getCellData(i));
               table.addCell(clmOcup.getCellData(i));
               table.addCell(clmEC.getCellData(i));
               table.addCell(clmEmpl.getCellData(i));
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
            stage.initOwner(lista_client.getScene().getWindow());
            ((Stage)lista_client.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}