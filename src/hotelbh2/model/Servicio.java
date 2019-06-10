/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;
import hotelbh2.controller.FacturaFXMLController;
import hotelbh2.controller.LoginFXMLController;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author daw2
 */
public class Servicio {

        private SimpleIntegerProperty id_servicio;
        private SimpleStringProperty nombre_servicio;
        private SimpleIntegerProperty precio;
        private SimpleIntegerProperty reserva ;
        
             
            
      /*public  Servicio(int id,String nombre_servicio,int precio,int reserva){
              this.nombre_servicio= new SimpleStringProperty(nombre_servicio);
              this.precio=new SimpleIntegerProperty(precio);
              this.reserva=new SimpleIntegerProperty(reserva);
        }*/
      public  Servicio(String nombre_servicio,int precio,int reserva){
              this.nombre_servicio= new SimpleStringProperty(nombre_servicio);
              this.precio=new SimpleIntegerProperty(precio);
              this.reserva=new SimpleIntegerProperty(reserva);
        }
      
        public void insertServ() throws SQLException{
            conexion con = new conexion();
            con.consultaINSERT("INSERT INTO `servicios`( `nombre_servicio`, `precio`, `fk_id_reserva`) VALUES ('"+this.nombre_servicio.get()+"','"+this.precio.get()+"','"+this.reserva.get()+"')");
            SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd");
            java.util.Date fecha = new java.util.Date();
            Reporte report = new Reporte(df.format(fecha),"Servicio de "+this.nombre_servicio.get()+" añadido a la reserva numero "+this.reserva.get());
            report.insert();
        }
        
        public static void modificarServ(String nombre_servicio,int precio,int id) throws SQLException{
            conexion con = new conexion();            
            con.consultaINSERT("UPDATE `servicios` SET `nombre_servicio`='"+nombre_servicio+"',`precio`='"+precio+"'  WHERE  `id_servicio`='"+id+"'");

        }
        public static void lista(ObservableList lista)
        {
            
            
           try 
           {
               conexion con = new conexion();
               ResultSet rs = con.consulta("SELECT * FROM servicios");
               while(rs.next())
               {
                   lista.add(
                           new Servicio(
                                   //rs.getInt("id_servicio"),
                                   rs.getString("nombre_servicio"),
                                   rs.getInt("precio"),
                                   rs.getInt("fk_id_reserva")
                                   
                           )
                   );
               }
               
           } 
           catch (SQLException ex) 
           {
               Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

    public Integer getId_servicio() {
        return id_servicio.get();
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = new SimpleIntegerProperty(id_servicio);
    }

    public String getNombre_servicio() {
        return nombre_servicio.get();
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = new SimpleStringProperty(nombre_servicio);
    }

    public Integer getPrecio() {
        return precio.get();
    }

    public void setPrecio(int precio) {
        this.precio = new SimpleIntegerProperty(precio);
    }

    public Integer getReserva() {
        return reserva.get();
    }

    public void setReserva(int reserva) {
        this.reserva = new SimpleIntegerProperty(reserva);
    }
         public void showHServiceDetails() {
    
        
        try
        {
           // ((Node) (window.getSource())).getScene().getWindow().hide();
    
            FXMLLoader loader = new FXMLLoader();
            //  AnchorPane editClient=loader.setLocation(MainApp.class.getResource("/hotelbh2/view/mod_clienteFXML2.fxml"));      
            AnchorPane editHab =loader.load(getClass().getResource("/hotelbh2/view/mod_serviceFXML2.fxml"));
            Stage dialogStage_edit_hab = new Stage();
            dialogStage_edit_hab.setTitle("Editar Servicio");
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
         public static  int ObtenerID(String nombre ,int reserva_id,int precio){
             conexion con=new conexion();
       ResultSet rs;
       int id=0;
       String sql=("SELECT `id_servicio` FROM `servicios` WHERE `nombre_servicio`='"+nombre+"' AND `precio`="+precio+" AND `fk_id_reserva`="+reserva_id);


        try {
            rs=con.consulta(sql);
            //String a =rs.getString("Nombre");
            //System.out.println(a);
            while(rs.next()){
                 id=rs.getInt("id_servicio");

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaFXMLController.class.getName()).log(Level.SEVERE, null, ex);

            

        }
        return id;
         }
       
    
}
