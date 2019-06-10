/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;
import hotelbh2.controller.FacturaFXMLController;
import hotelbh2.controller.ListaReservaFXMLController;
import hotelbh2.controller.LoginFXMLController;
import hotelbh2.controller.ReservaFXMLController;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 *
 * @author daw2
 */
public class Factura {
     @FXML AnchorPane Factura_window;


       private SimpleIntegerProperty Precio_total;
        private SimpleStringProperty Nombre_cliente;
        private SimpleStringProperty Documentos_cliente ;
       // private SimpleStringProperty[] Descripcion;
        private SimpleStringProperty fecha;
        private static int precioSend;
        //ArrayList<String> Descripcion = new ArrayList<String>();

             
            
      public  Factura(String Nombre_cliente,String Documentos_cliente,String fecha){
              this.Nombre_cliente=new SimpleStringProperty(Nombre_cliente);
              this.Documentos_cliente= new SimpleStringProperty(Documentos_cliente);
              this.fecha=new SimpleStringProperty(fecha);
        }
      
      
     public static String ObtenerNombre() {
       Reserva reserva_factura =ListaReservaFXMLController.getfactura_reserva();      
       conexion con=new conexion();
       ResultSet rs;
       String nombre="";
       String sql=("SELECT `Nombre` FROM `cliente` WHERE `Documentos` LIKE '"+reserva_factura.getDocumento_cliente()+"'");

        try {
            rs=con.consulta(sql);
            //String a =rs.getString("Nombre");
            //System.out.println(a);
            while(rs.next()){
                 nombre=rs.getString("Nombre");

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            nombre="no encontrado";

        }
        return nombre;
     }
     
           public static int ObtenerPrecioHab() {
       Reserva reserva_factura =ListaReservaFXMLController.getfactura_reserva();      
       conexion con=new conexion();
       ResultSet rs;
       int precio=0;
       String sql=("SELECT `precio` FROM `habitacion` WHERE `Numero_habitacion`="+reserva_factura.getNum_hab());

        try {
            rs=con.consulta(sql);
            //String a =rs.getString("Nombre");
            //System.out.println(a);
            while(rs.next()){
                 precio=rs.getInt("precio");

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            

        }
        return precio;
     }
      
      
      
      
    public static ArrayList ObtenerServicios() {
        ArrayList<String> Descripcion = new ArrayList<String>();
       Reserva reserva_factura =ListaReservaFXMLController.getfactura_reserva();      
       conexion con=new conexion();
       ResultSet rs;
       String nombre="";
       int number=0;
       int precio=0;
       String sql="SELECT `id_reserva` FROM `reserva` WHERE `fecha_ingreso`='"+reserva_factura.getFecha_ingreso()+"' AND `fecha_salida`='"+reserva_factura.getFecha_salida()+"' AND `fk_numero_hab`='"+reserva_factura.getNum_hab()+"'";

        try {
            rs=con.consulta(sql);
            //String a =rs.getString("Nombre");
            //System.out.println(a);
                            

            while(rs.next()){
                 number=rs.getInt("id_reserva");


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);



        }
        sql=("SELECT `nombre_servicio` ,`precio` FROM `servicios` s INNER JOIN `reserva` r ON s.`fk_id_reserva`=r.`id_reserva` WHERE r.`id_reserva`="+number);

        try {
            rs=con.consulta(sql);
            //String a =rs.getString("Nombre");
            //System.out.println(a);
                            

            while(rs.next()){
                 nombre=nombre=rs.getString("nombre_servicio");
                 nombre+=": "+rs.getInt("precio")+"€";
                 Descripcion.add(nombre);


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);



        }
        
        sql=("SELECT `precio` FROM `servicios` s INNER JOIN `reserva` r ON s.`fk_id_reserva`=r.`id_reserva` WHERE r.`id_reserva`="+number);

        try {
            rs=con.consulta(sql);
            //String a =rs.getString("Nombre");
            //System.out.println(a);
                            

            while(rs.next()){
                 precio+=rs.getInt("precio");


            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            nombre="no encontrado";



        }        
        precioSend=precio;
        //System.out.println(Descripcion.get(0));
        return Descripcion;


     }     
     
      
     public static int getprecioSend(){
         return precioSend;
     }
}
   