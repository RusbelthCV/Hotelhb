/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;

import hotelbh2.controller.ClienteFXMLController;
import hotelbh2.controller.LoginFXMLController;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author daw2
 */
public class AddClient {
        private SimpleStringProperty Documentos;
        private SimpleStringProperty Nombre;
        private SimpleStringProperty Nacionalidad;
        private SimpleStringProperty Telefono;
        private SimpleStringProperty Email;
        private SimpleStringProperty Ocupacion;
        private SimpleStringProperty Estado_civil;
        private String Trabajador;
        private static String datos[]=new String[7];

        @FXML AnchorPane editClient;
        @FXML AnchorPane ventana;@FXML TableView<AddClient> tablaCliente;
      
        @FXML Button enviar;
        
        public  AddClient(String Documentos,String Nombre,String Nacionalidad,String Telefono,String Email,String Ocupacion,String Estado_civil,String Trabajador){
          
            this.Documentos = new SimpleStringProperty(Documentos);
            this.Nombre = new SimpleStringProperty(Nombre);
            this.Nacionalidad = new SimpleStringProperty(Nacionalidad);
            this.Telefono = new SimpleStringProperty(Telefono);
            this.Email = new SimpleStringProperty(Email);
            this.Ocupacion = new SimpleStringProperty(Ocupacion);
            this.Estado_civil = new SimpleStringProperty(Estado_civil);
            this.Trabajador=Trabajador;
        }
        public void insertClient() throws SQLException{
            conexion con = new conexion();
            con.consultaINSERT("INSERT INTO `Cliente`(`Documentos`, `Nombre`, `Nacionalidad`, `Telefono`, `Email`, `Ocupacion`, `Estado_civil`, `fk_User_empleado`) VALUES ('"+this.Documentos.get()+"','"+this.Nombre.get()+"','"+this.Nacionalidad.get()+"','"+this.Telefono.get()+"','"+this.Email.get()+"','"+this.Ocupacion.get()+"','"+this.Estado_civil.get()+"','"+this.Trabajador+"')");
        }
        
        public static void modificarClient(String documentos,String nombre,String nacionalidad,String telefono,String email,String ocupacion,String estado_civil) throws SQLException{
            conexion con = new conexion();            
            con.consultaINSERT("UPDATE `Cliente` SET `Nombre`='"+nombre+"',`Nacionalidad`='"+nacionalidad+"',`Telefono`='"+telefono+"',`Email`='"+email+"' ,`Ocupacion`='"+ocupacion+"',`Estado_civil`='"+estado_civil+"' WHERE  `Documentos`='"+documentos+"'");

        }
        
        //Solo el nombre promesa de futuro 
        public static void modificarClient(String documentos,String nombre) throws SQLException{
            conexion con = new conexion();            
            con.consultaINSERT("UPDATE `Cliente` SET `Nombre`='"+nombre+" WHERE  `Documentos`='"+documentos+"'");

        }
        public static void listClient(ObservableList<AddClient> lista) throws SQLException
        {
            conexion con = new conexion();
            ResultSet rs = con.consulta("SELECT * FROM Cliente");
            while(rs.next())
            {
                lista.add(
                        new AddClient(
                                rs.getString("Documentos"),
                                rs.getString("Nombre"),
                                rs.getString("Nacionalidad"),
                                rs.getString("Telefono"),
                                rs.getString("Email"),
                                rs.getString("Ocupacion"),
                                rs.getString("Estado_civil"),
                                rs.getString("fk_User_empleado")
                        )
                );
            }
        }
        public void editarClient(){
            
        }
  public void showPersonDetails() {
    
        
        try
        {
           // ((Node) (window.getSource())).getScene().getWindow().hide();
            datos[0]=this.Nombre.get();
            datos[1]= this.Estado_civil.get();
            datos[2]=this.Telefono.get();
            datos[3]=this.Nacionalidad.get();
            datos[4]=this.Ocupacion.get();
            datos[5]=this.Email.get();
            datos[6]=this.Documentos.get();    
            FXMLLoader loader = new FXMLLoader();
            //  AnchorPane editClient=loader.setLocation(MainApp.class.getResource("/hotelbh2/view/mod_clienteFXML2.fxml"));      
            AnchorPane editClient =loader.load(getClass().getResource("/hotelbh2/view/mod_clienteFXML2.fxml"));
            Stage dialogStage_edit_client = new Stage();

            //dialogStage_edit_client.initModality(Modality.WINDOW_MODAL);
            //dialogStage_edit_client.initOwner(ventana.getScene().getWindow());
            Scene scene = new Scene(editClient);

            dialogStage_edit_client.setScene(scene);
            dialogStage_edit_client.show();

                                   

            
            
            
            
           
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
}
   public static String[] getdatos(){
       return datos;
   }
    
    public String getDocumentos() {
        return Documentos.get();
    }

    public void setDocumentos(SimpleStringProperty Documentos) {
        this.Documentos = Documentos;
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(SimpleStringProperty Nombre) {
        this.Nombre = Nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad.get();
    }

    public void setNacionalidad(SimpleStringProperty Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public String getTelefono() {
        return Telefono.get();
    }

    public void setTelefono(SimpleStringProperty Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email.get();
    }

    public void setEmail(SimpleStringProperty Email) {
        this.Email = Email;
    }

    public String getOcupacion() {
        return Ocupacion.get();
    }

    public void setOcupacion(SimpleStringProperty Ocupacion) {
        this.Ocupacion = Ocupacion;
    }

    public String getEstado_civil() {
        return Estado_civil.get();
    }

    public void setEstado_civil(SimpleStringProperty Estado_civil) {
        this.Estado_civil = Estado_civil;
    }

    public String getTrabajador() {
        return Trabajador;
    }

    public void setTrabajador(String Trabajador) {
        this.Trabajador = Trabajador;
    }
    
  
        
        
        
}
