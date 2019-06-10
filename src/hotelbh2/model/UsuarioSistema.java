package hotelbh2.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsuarioSistema 
{
    private IntegerProperty id;
    private StringProperty Nombre;
    private StringProperty Contra;

    public UsuarioSistema() 
    {
    }

    public int getId() 
    {
        return this.id.get();
    }

    public String getNombre() 
    {
        return this.Nombre.get();
    }

    public String getContra() 
    {
        return this.Contra.get();
    }

    public void setId(int id) 
    {
        this.id = new SimpleIntegerProperty(id);
    }

    public void setNombre(String Nombre) 
    {
        this.Nombre = new SimpleStringProperty(Nombre);
    }

    public void setContra(String Contra) 
    {
        this.Contra = new SimpleStringProperty(Contra);
    }
    
    
}
