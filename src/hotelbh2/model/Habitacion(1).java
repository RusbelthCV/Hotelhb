/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;
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

/**
 *
 * @author daw2
 */
public class Habitacion {
     @FXML AnchorPane mod_habitacion;
     @FXML AnchorPane editHab;


       private SimpleIntegerProperty num_hab;
        private SimpleStringProperty caracteristicas;
        private SimpleIntegerProperty precio;
        private SimpleStringProperty estado ;
        private SimpleStringProperty tipo_hab;
        private SimpleIntegerProperty piso;
        private static String datos[]=new String[7];

             
            
      public  Habitacion(int num_hab,String caracteristicas,int precio,String estado,String tipo_hab,int piso){
              this.num_hab=new SimpleIntegerProperty(num_hab);
              this.caracteristicas= new SimpleStringProperty(caracteristicas);
              this.precio=new SimpleIntegerProperty(precio);
              this.estado=new SimpleStringProperty(estado);
              this.tipo_hab=new SimpleStringProperty(tipo_hab);
              this.piso=new SimpleIntegerProperty(piso);
        }
        public void insertHab() throws SQLException{
            conexion con = new conexion();
            con.consultaINSERT("INSERT INTO `Habitacion`(`Numero_habitacion`, `caracteristicas`, `precio`, `estado`, `tipo_hab`, `piso`) VALUES ('"+this.num_hab.get()+"','"+this.caracteristicas.get()+"','"+this.precio.get()+"','"+this.estado.get()+"','"+this.tipo_hab.get()+"','"+this.piso.get()+"')");
        }
        
        public static void modificaHab(String caracteristicas,int precio,String estado,String tipo_hab,int num_hab) throws SQLException{
            conexion con = new conexion();            
            con.consultaINSERT("UPDATE `Habitacion` SET `caracteristicas`='"+caracteristicas+"',`precio`='"+precio+"',`estado`='"+estado+"',`tipo_hab`='"+tipo_hab+"'  WHERE  `Numero_habitacion`='"+num_hab+"'");

        }
        
        //Solo el estado
        public static void modificaHab(String estado,int num_hab) throws SQLException{
            conexion con = new conexion();            
            con.consultaINSERT("UPDATE `Habitacion` SET `estado`='"+estado+"' WHERE  `Numero_habitacion`='"+num_hab+"'");

        }
         @FXML 
        public static void listaHab(ObservableList<Habitacion> lista) throws SQLException
        {
            conexion con = new conexion();
            ResultSet rs = con.consulta("SELECT * FROM Habitacion");
            while(rs.next())
            {
                lista.add(
                        new Habitacion(
                                rs.getInt("Numero_habitacion"),
                                rs.getString("caracteristicas"),
                                rs.getInt("precio"),
                                rs.getString("estado"),
                                rs.getString("tipo_hab"),
                                rs.getInt("piso")
                        )
                );
            }
        }
        public static void listaHab_reserva(ObservableList<Habitacion> lista) throws SQLException
        {
            conexion con = new conexion();
            String Fecha_ini=ReservaFXMLController.getFecha_enviar();
            ResultSet rs = con.consulta("SELECT DISTINCT h.Numero_habitacion,h.caracteristicas,h.precio,h.estado,h.tipo_hab,h.piso FROM reserva r INNER JOIN habitacion h ON h.Numero_habitacion = r.fk_numero_hab WHERE fecha_ingreso >= '"+ReservaFXMLController.getFecha_enviar()+"' AND fecha_salida <= '"+ReservaFXMLController.getFecha_enviar_salida()+"'");
            while(rs.next())
            {
                lista.add(
                        new Habitacion(
                                rs.getInt("Numero_habitacion"),
                                rs.getString("caracteristicas"),
                                rs.getInt("precio"),
                                rs.getString("estado"),
                                rs.getString("tipo_hab"),
                                rs.getInt("piso")
                        )
                );
            }
        }
         public void showHabDetails() {
    
        
        try
        {
           // ((Node) (window.getSource())).getScene().getWindow().hide();
            datos[0]=this.caracteristicas.get();
            datos[1]= this.precio.getValue().toString();
            datos[2]=this.estado.get();
            datos[3]=this.tipo_hab.get();
            datos[4]=this.piso.getValue().toString();
            datos[5]=this.caracteristicas.get();
            datos[6]=this.num_hab.getValue().toString();
            FXMLLoader loader = new FXMLLoader();
            //  AnchorPane editClient=loader.setLocation(MainApp.class.getResource("/hotelbh2/view/mod_clienteFXML2.fxml"));      
            AnchorPane editHab =loader.load(getClass().getResource("/hotelbh2/view/habitacionFXML3.fxml"));
            Stage dialogStage_edit_hab = new Stage();
            dialogStage_edit_hab.setTitle("Editar Habitacion");
            //dialogStage_edit_client.initModality(Modality.WINDOW_MODAL);
            //dialogStage_edit_client.initOwner(ventana.getScene().getWindow());
            Scene scene = new Scene(editHab);
            dialogStage_edit_hab.setScene(scene);
            dialogStage_edit_hab.show();
           
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
}
    public static String[] getdatos(){
       return datos;
   }

    public Integer getNum_hab() {
        return num_hab.get();
    }

    public void setNum_hab(SimpleIntegerProperty num_hab) {
        this.num_hab = num_hab;
    }

    public String getCaracteristicas() {
        return caracteristicas.get();
    }

    public void setCaracteristicas(SimpleStringProperty caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Integer getPrecio() {
        return precio.get();
    }

    public void setPrecio(SimpleIntegerProperty precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(SimpleStringProperty estado) {
        this.estado = estado;
    }

    public String getTipo_hab() {
        return tipo_hab.get();
    }

    public void setTipo_hab(SimpleStringProperty tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    public Integer getPiso() {
        return piso.get();
    }

    public void setPiso(SimpleIntegerProperty piso) {
        this.piso = piso;
    }
        
    
}
