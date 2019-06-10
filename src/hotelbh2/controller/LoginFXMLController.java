/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelbh2.controller;


import hotelbh2.model.Login;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JPasswordField;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author Rusbelth
 */
public class LoginFXMLController implements Initializable 
{
    @FXML TextField inpName;
    @FXML TextField inpPass;
    @FXML Button btnSession;
    @FXML Label lblNombre;
    @FXML Label lblPassword;
    @FXML Label linea;

    @FXML Label lblError;
    @FXML AnchorPane window;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        lblError.setVisible(false);
    }    
    @FXML
    public void iniciarSession(ActionEvent evt) throws SQLException
    {
        boolean logued;
        Login login = new Login(inpName.getText().trim(),inpPass.getText().trim());
        logued = login.comprobarUsuario(lblError);
        if(logued)
        {
            Login();
            Login.setuser_login(login.getname());
            
        }
        else
        {
            lblError.setVisible(true);
        }
    }
    public void Login() throws SQLException
    {
        boolean admin;
        AnchorPane root;
         Login login = new Login(inpName.getText().trim(),inpPass.getText().trim());
        try
        {
            admin = login.comprobarAdmin();
            FXMLLoader loader = new FXMLLoader();
            if(admin)
            {
                root = loader.load(getClass().getResource("/hotelbh2/view/menuFXML.fxml"));
            }
            else
            {
                root = loader.load(getClass().getResource("/hotelbh2/view/menuRecepcionistaFXML.fxml"));
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            

            stage.initOwner(window.getScene().getWindow());
            ((Stage)window.getScene().getWindow()).close();
            stage.show();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
