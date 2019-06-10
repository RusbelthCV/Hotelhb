/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;

import java.sql.SQLException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rusbelth
 */
public class Recepcionista 
{
    private SimpleStringProperty nombre;
    private SimpleStringProperty contra;
    private SimpleIntegerProperty admin;
    
    public Recepcionista(String nombre,String contra,int admin)
    {
        this.nombre = new SimpleStringProperty(nombre);
        this.contra = new SimpleStringProperty(contra);
        this.admin = new SimpleIntegerProperty(admin);
    }
    public void insert() throws SQLException
    {
        conexion con = new conexion();
        con.consultaINSERT("INSERT INTO `usuario_sistema` VALUES('"+this.getNombre()+"','"+this.getContra()+"',0)");
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getContra() {
        return contra.get();
    }

    public void setContra(String contra) {
        this.contra = new SimpleStringProperty(contra);
    }

    public int getAdmin() {
        return admin.getValue();
    }

    public void setAdmin(int admin) {
        this.admin = new SimpleIntegerProperty(admin);
    }
    
}
