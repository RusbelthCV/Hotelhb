/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.model;
import java.sql.*;
/**
 *
 * @author Rusbelth
 */
public class conexion 
{
    Connection con;
    Statement s;
    static  ResultSet rs;

    public conexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
           // con = DriverManager.getConnection("jdbc:mysql://192.168.12.167/hotalhb","Bryan","123");          
           con = DriverManager.getConnection("jdbc:mysql://localhost/hotalhb","root","");
            s = con.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }
    public ResultSet consulta(String sql) throws SQLException
    {
                System.out.println("Query apunto de ser  ejecutada");

        try
        {
            rs = this.s.executeQuery(sql);
                       System.out.println("Query ejecutada");

        }
        catch(SQLException e){
            e.getMessage();
                        System.out.println("Query NO ejecutada "+"\n"+sql);

        }
        
        return rs;

        
    }
    public void consultaINSERT(String sql) throws SQLException
    {
        System.out.println("Query apunto de ser  ejecutada");
        try
        {
           this.s.execute(sql);
           System.out.println("Query ejecutada");
           s.close();
        }
        catch(SQLException e){
            System.out.println("Query NO ejecutada "+"\n"+sql);
 
            e.getMessage();
        }
        


        
    }
    public void closeConnection() throws SQLException
    {
        con.close();
    }
    
}
