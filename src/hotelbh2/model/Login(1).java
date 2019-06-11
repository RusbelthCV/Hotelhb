/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

/**
 *
 * @author Rusbelth
 */
public class Login 
{
    private StringProperty name;  
    private StringProperty password;
    private static String user_login;
    
    
    /**
     *
     * @param trim
     * @param trim
     */
    public Login(String name, String password) 
    {
        this.name = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(password);
    }
    public boolean comprobarUsuario(Label error) throws SQLException
    {
        boolean nextStep = false;
        System.out.println(this.name.get());
        System.out.println(this.password.get());
        conexion con = new conexion();
        ResultSet rs = con.consulta("SELECT * FROM Usuario_Sistema WHERE Nombre_usuario LIKE '"+this.name.get()+"' AND Password LIKE '"+this.password.get()+"'");
        if(rs.next())
        {
            nextStep = true;
        }
        else
        {
            error.setVisible(true);
            nextStep = false;
        }
        return nextStep;
    }
    public static void setuser_login(String username){
            user_login=username;
    }
    public static  String getuser_login(){
        return user_login;
    }
    
    
    
    
    
    
    public String getname(){
        return this.name.get();
    }
}
