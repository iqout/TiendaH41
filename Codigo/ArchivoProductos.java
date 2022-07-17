import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class ArchivoProductos
{
    private File archivo;
    
    public ArchivoProductos()
    {
        this.archivo = new File("productos.csv");
    }
    
    public void guardarProducto(String dato)
    {
        //String dato = "Hola mundo";
        try
        {
            FileWriter writer = new FileWriter(this.archivo, true);
            PrintWriter cursor = new PrintWriter(writer);
            cursor.println(dato);
            cursor.flush();
            cursor.close();
            writer.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public List<Producto> leerArchivo()
    {
        List<Producto> lista = new ArrayList<Producto>();
        try
        {
            FileReader reader  = new FileReader(this.archivo);  
            BufferedReader cursor = new BufferedReader(reader);
            while(cursor.ready())
            {
                String linea = cursor.readLine();
                String [] datos =  linea.split(":");
                int codigo = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String marca = datos[2] ;
                String presentacion = datos[3];
                String tipo = datos[4];
                int precio = Integer.parseInt(datos[5]);
                int cantidad = Integer.parseInt(datos[6]);
                Producto p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipo);
                lista.add(p);
            }
            cursor.close();
            reader.close();
        }
        catch(Exception e)
        {
            
        }
        return lista;
    }
}
