/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class MenuFXMLController implements Initializable 
{

    @FXML AnchorPane ventana;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
    
    
    
    
    @FXML
    public void addClientes()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/clienteFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Añadir Cliente");
            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 @FXML
    public void add_reserva()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/reservaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Añadir Reserva");

            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     public void addHabitacion()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/habitacionFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Añadir Habitacion");


            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          public void addService()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/add_serviceFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Añadir Servicio");

            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
     public void mod_Habitaciones()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/habitacionFXML3.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modificar Habitacion");

            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     public void mod_Clientes()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/mod_clienteFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modificar Cliente");

            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void mod_Servicio()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/mod_serviceFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Modificar Servicio");
            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void lista() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/ListaFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
                    stage.setTitle("Lista de  Clientes");

        stage.initOwner(ventana.getScene().getWindow());
        ((Stage)ventana.getScene().getWindow()).close();
        stage.show();
    }
   
     @FXML 
    public void listaHab()
    {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root;
        try 
        {
            root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/ListaHabFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Lista de  Habitaciones");
            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
@FXML 
    public void lista_reserva()
    {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root;
        try 
        {
            root = loader.load(getClass().getResourceAsStream("/hotelbh2/view/ListaReservaFXML.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Lista de  Reservas");
            stage.initOwner(ventana.getScene().getWindow());
            ((Stage)ventana.getScene().getWindow()).close();
            stage.show();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MenuFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
