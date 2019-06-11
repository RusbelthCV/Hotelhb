/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daw2
 */
public class Servicio {

       private SimpleIntegerProperty id_servicio;
        private SimpleStringProperty nombre_servicio;
        private SimpleIntegerProperty precio;
        private SimpleIntegerProperty reserva ;
        
             
            
      public  Servicio(String nombre_servicio,int precio,int reserva){
              this.nombre_servicio= new SimpleStringProperty(nombre_servicio);
              this.precio=new SimpleIntegerProperty(precio);
              this.reserva=new SimpleIntegerProperty(reserva);
        }
      
        public void insertServ() throws SQLException{
            conexion con = new conexion();
            con.consultaINSERT("INSERT INTO `servicios`( `nombre_servicio`, `precio`, `fk_id_reserva`) VALUES ('"+this.nombre_servicio.get()+"','"+this.precio.get()+"','"+this.reserva.get()+"')");
        }
        
        public static void modificarServ(String nombre_servicio,int precio,int id) throws SQLException{
            conexion con = new conexion();            
            con.consultaINSERT("UPDATE `Servicios` SET `nombre_servicio`='"+nombre_servicio+"',`precio`='"+precio+"'  WHERE  `id_servicio`='"+id+"'");

        }
        
       
    
}
