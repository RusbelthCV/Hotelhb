/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;

import hotelbh2.controller.LoginFXMLController;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hernando
 */
public class Reserva {
    private int id_reserva;
    private SimpleStringProperty fecha_ingreso;
    private SimpleStringProperty fecha_salida;
    private SimpleIntegerProperty cantidad_personas;
    private SimpleStringProperty Trabajador;
    private SimpleStringProperty documento_cliente;
    private SimpleIntegerProperty num_hab;
        private SimpleIntegerProperty piso;

    
    
   public Reserva(String fecha_ingreso,String fecha_salida,int cantidad,String Trabajador,String documento,int num_hab){
        this.fecha_ingreso= new SimpleStringProperty(fecha_ingreso);
        this.fecha_salida= new SimpleStringProperty(fecha_salida);
        this.Trabajador=new SimpleStringProperty(Trabajador);
        this.documento_cliente=new SimpleStringProperty(documento);
        this.cantidad_personas=new SimpleIntegerProperty(cantidad);
        this.num_hab=new SimpleIntegerProperty(num_hab);
    }
      public Reserva(int id_reserva, int num_hab,int piso) {
        this.id_reserva = id_reserva;
        this.num_hab = new SimpleIntegerProperty(num_hab);
        this.piso = new SimpleIntegerProperty(piso);
    }
      
      
public static void llenarInfo(ObservableList reservas)
    {
        try 
        {
            conexion con = new conexion();
            ResultSet rs = con.consulta("SELECT r.id_reserva,r.fk_numero_hab,h.piso FROM Reserva  r INNER JOIN Habitacion h ON h.Numero_habitacion = r.fk_numero_hab");
            while(rs.next())
            {
                reservas.add(
                        new Reserva(
                                rs.getInt("id_reserva"),
                                rs.getInt("fk_numero_hab"),
                                rs.getInt("piso")
                        )
                );
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Habitacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
     public void insertReserva() throws SQLException{
            conexion con = new conexion();
            con.consultaINSERT("INSERT INTO `Reserva`(`fecha_ingreso`, `fecha_salida`, `cantidad_personas`, `fk_User_empleado`, `fk_documento_cliente`, `fk_numero_hab`) VALUES ('"+this.fecha_ingreso.get()+"','"+this.fecha_salida.get()+"','"+this.cantidad_personas.get()+"','"+this.Trabajador.get()+"','"+this.documento_cliente.get()+"','"+this.num_hab.get()+"')");
        }
@FXML 
        public static void listaReserva(ObservableList<Reserva> lista) throws SQLException
        {
            conexion con = new conexion();
            ResultSet rs = con.consulta("SELECT * FROM reserva");
            while(rs.next())
            {
                lista.add(
                        new Reserva(
                                rs.getString("fecha_ingreso"),
                                rs.getString("fecha_salida"),
                                rs.getInt("cantidad_personas"),
                                rs.getString("fk_User_empleado"),
                                rs.getString("fk_documento_cliente"),
                                rs.getInt("fk_numero_hab")
                        )
                );
            }
        }     
    @Override
    public String toString()
    {
        return "ID reserva: "+this.getId_reserva()+", Piso: "+this.piso.getValue()+" Numero: "+this.getNum_hab();
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso.get();
    }

    public void setFecha_ingreso(SimpleStringProperty fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_salida() {
        return fecha_salida.get();
    }

    public void setFecha_salida(SimpleStringProperty fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getCantidad_personas() {
        return cantidad_personas.getValue();
    }

    public void setCantidad_personas(SimpleIntegerProperty cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public String getTrabajador() {
        return Trabajador.get();
    }

    public void setTrabajador(SimpleStringProperty Trabajador) {
        this.Trabajador = Trabajador;
    }

    public String getDocumento_cliente() {
        return documento_cliente.get();
    }   

    public void setDocumento_cliente(SimpleStringProperty documento_cliente) {
        this.documento_cliente = documento_cliente;
    }

    public int getNum_hab() {
        return num_hab.getValue();
    }

    public void setNum_hab(SimpleIntegerProperty num_hab) {
        this.num_hab = num_hab;
    }

    public int getPiso() {
        return piso.getValue();
    }

    public void setPiso(SimpleIntegerProperty piso) {
        this.piso = piso;
    }
     public void showFacturaDetails() {
    
        
        try
        {
           // ((Node) (window.getSource())).getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader();
            //  AnchorPane editClient=loader.setLocation(MainApp.class.getResource("/hotelbh2/view/mod_clienteFXML2.fxml"));      
            AnchorPane Factura_window =loader.load(getClass().getResource("/hotelbh2/view/FacturaFXML.fxml"));
            Stage dialogStage_edit_hab = new Stage();
            dialogStage_edit_hab.setTitle("Editar Habitacion");
            Scene scene = new Scene(Factura_window);
            dialogStage_edit_hab.setScene(scene);
            dialogStage_edit_hab.show();
           
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
}
    
}
