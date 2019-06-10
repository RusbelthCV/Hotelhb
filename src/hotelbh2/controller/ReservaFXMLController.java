/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Login;
import hotelbh2.model.Reserva;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hernando
 */
public class ReservaFXMLController implements Initializable  {
    @FXML AnchorPane reserva_window;
    @FXML AnchorPane  hola;
    //@FXML TextField Fecha_Ingreso;
    //@FXML TextField Fecha_salida;
    @FXML TextField Cantidad_Personas;
    @FXML DatePicker Fecha_Ingreso;
    @FXML DatePicker Fecha_salida;
    @FXML Button Selec_Hab;
    @FXML Button menu;
    @FXML Button add_client;
    @FXML Button enviar;
    @FXML Button lista_client;
    private  static AddClient clienteR;
    private static String Fecha_Ingreso_enviar;
        private static String Fecha_salida_enviar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    
  
    }
     @FXML
    public void addClientes()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/cliente_reservaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(reserva_window.getScene().getWindow());
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    public void listaHab()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/ListaHab_reservaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(reserva_window.getScene().getWindow());
            stage.setScene(scene);
            stage.show();
            Fecha_Ingreso_enviar=Fecha_Ingreso.getValue().toString();
            Fecha_salida_enviar=Fecha_salida.getValue().toString();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    public void lista_client()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/ListaClient_reservaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(reserva_window.getScene().getWindow());
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     @FXML
    public void volverMenu()
    {
       try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResource("/hotelbh2/view/menuRecepcionistaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Principal");
            stage.initOwner(reserva_window.getScene().getWindow());
            ((Stage)reserva_window.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void insertarReserva() throws SQLException, ParseException{
        int cantidad=Integer.parseInt(Cantidad_Personas.getText());
//      System.out.println(new SimpleDateFormat("yyyy/MM/dd").parse(Fecha_Ingreso.getValue().toString()));
        String IngresoTemporal=Fecha_Ingreso.getValue().toString().replaceAll("-", "/");    
        String salida_Temporal=Fecha_salida.getValue().toString().replaceAll("-", "/");        

       Date Ingreso_comparar=Ingreso_comparar = (new SimpleDateFormat("yyyy/MM/dd").parse(IngresoTemporal));
         Date Salida_comparar=(new SimpleDateFormat("yyyy/MM/dd").parse(salida_Temporal));

        
        Reserva newReserva=new Reserva(Fecha_Ingreso.getValue().toString(),Fecha_salida.getValue().toString(),cantidad,Login.getuser_login(),clienteR.getDocumentos(),ListaHabFXMLController.gethabCLick().getNum_hab());
        newReserva.insertReserva();
    }
    public static  void setClientR(AddClient client){
           clienteR=client;
    }
        public static  String getFecha_enviar(){
           return Fecha_Ingreso_enviar;
    }
    public static  String getFecha_enviar_salida(){
           return Fecha_salida_enviar;
    }
}
