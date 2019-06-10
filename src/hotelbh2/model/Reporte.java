/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Rusbelth
 */
public class Reporte 
{
    private SimpleStringProperty fecha;
    private SimpleStringProperty tipo;
    
    Reporte(String fecha,String tipo)
    {
        this.fecha = new SimpleStringProperty(fecha);
        this.tipo = new SimpleStringProperty(tipo);
    }

    /*Reporte(java.util.Date fecha, String cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public void insert()
    {
        conexion con = new conexion();
        
        
            try 
            {
                con.consultaINSERT("INSERT INTO `reportes`(`tipo`,`fecha`) VALUES ('"+this.getTipo()+"','"+this.getFecha()+"')");
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public static void lista(ObservableList<Reporte> lista,String f1,String f2) throws SQLException
    {
        conexion con = new conexion();
        ResultSet rs = con.consulta("SELECT * FROM `reportes` WHERE fecha >= '"+f1+"' AND fecha <= '"+f2+"'");
        while(rs.next())
        {
            lista.add(
                    new Reporte(
                            rs.getString("fecha"),
                            rs.getString("tipo")
                    )
            );
                    
        }
    }
    public String getFecha() 
    {
        return fecha.get();
    }

    public void setFecha(String fecha) 
    {
        this.fecha = new SimpleStringProperty(fecha);
    }

    public String getTipo() 
    {
        return tipo.get();
    }

    public void setTipo(String tipo) 
    {
        this.tipo = new SimpleStringProperty(tipo);
    }
    
}
