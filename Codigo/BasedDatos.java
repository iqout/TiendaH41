
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class BasedDatos
{
    private String conector = "jdbc:sqlite:";
    private String basedatos = "..\\BD\\base_datos_tienda.db";
    private Connection conexion;
    private Statement ejecutor;
    
    public boolean crearConexion()
    {
        try
        {
            conexion = DriverManager.getConnection(conector + basedatos);
            ejecutor = conexion.createStatement();
            ejecutor.setQueryTimeout(30);
            return true;
        }
        catch (Exception e)
        {
            return false; 
        }
    }
    
    public boolean cerrarConexion()
    {
        try
        {
            conexion.close();
            return true;
        }
        catch (Exception e)
        {
            return false; 
        }
    }
    
    public ResultSet insertar(String sql)
    {
        try
        {
            int cant = ejecutor.executeUpdate(sql);
            if(cant > 0)
            {
                ResultSet rs = ejecutor.getGeneratedKeys();
                return rs;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }
    
    public ResultSet consultar(String sql)
    {
         try
         {
             ResultSet rs = ejecutor.executeQuery(sql);
             return rs;
         }
         catch (Exception e)
         {
             return null;
         }
    }
    
    public int actualizar(String sql)
    {
        try
        {
            int cant = ejecutor.executeUpdate(sql);
            return cant;
        }
        catch (Exception e)
        {
            return 0;
        } 
    }
    
    public int borrar(String sql)
    {
        try
        {
            int cant = ejecutor.executeUpdate(sql);
            return cant;
        }
        catch (Exception e)
        {
            return 0;
        } 
    }
}

