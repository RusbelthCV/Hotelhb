/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;

import hotelbh2.model.AddClient;
import hotelbh2.model.Factura;
import hotelbh2.model.Reserva;
import hotelbh2.model.conexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class FacturaFXMLController implements Initializable 
{
    @FXML AnchorPane Factura_window;
    @FXML TextField Nombre_Cliente;
    @FXML TextField Documentos_cliente;
    @FXML TextField fecha;
    @FXML TextField PrecioTotal;
    @FXML TextArea area_Descripcion;

   



  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        int dias=0;
        ArrayList<String> Descripcion = new ArrayList<String>();
        Reserva reserva_factura =ListaReservaFXMLController.getfactura_reserva();      
        Documentos_cliente.setText(reserva_factura.getDocumento_cliente());
        String nombre=Factura.ObtenerNombre();
        Descripcion= Factura.ObtenerServicios();
        int precioS=Factura.getprecioSend();
        Nombre_Cliente.setText(nombre);
        int precioHab=Factura.ObtenerPrecioHab();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        fecha.setText(dateFormat.format(date)); 

         SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicial = dateFormat1.parse(reserva_factura.getFecha_ingreso());
            Date fechaFinal=dateFormat1.parse(reserva_factura.getFecha_salida());
             dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
            precioHab*=dias;




        } catch (ParseException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String DescripcionText="Has estado un total de "+Integer.toString(dias)+" dias en la habitacion numero "+reserva_factura.getNum_hab()+"         Costo: "+precioHab+"€\n";

        for(int i=1;i<Descripcion.size();i++){
           DescripcionText+=Descripcion.get(i);
           DescripcionText+="\n";

        }
        area_Descripcion.setText(DescripcionText);
        Nombre_Cliente.setEditable(false);
        Documentos_cliente.setEditable(false);
        fecha.setEditable(false);
        area_Descripcion.setEditable(false);
        PrecioTotal.setEditable(false);


        precioS+=precioHab;

        PrecioTotal.setText(Integer.toString(precioS)+"€");


 

		

     
    }    
   
   
   
}
