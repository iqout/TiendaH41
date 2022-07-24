import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Almacen 
{
    private List<Producto> listaProductos;
    
    public Almacen() 
    {
        listaProductos = new ArrayList<Producto>();
    }
    
    public List<Producto> getListaProductos()
    {
        this.listaProductos.clear();
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        try
        {
            String sql = "SELECT codigo, nombre, marca, presentacion, tipo, precio, cantidad "+
                         "FROM Productos ";
            ResultSet rs = bd.consultar(sql);
            while(rs.next())
            {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String marca = rs.getString(3);
                String presentacion = rs.getString(4);
                String tipo = rs.getString(5);
                int precio = rs.getInt(6);
                int cantidad = rs.getInt(7);
                Producto p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipo);
                this.listaProductos.add(p);
            }
        }
        catch(Exception e)
        {
            return null;
        }
        bd.cerrarConexion();
        return this.listaProductos;
    }
    
    public void agregarProducto(Producto p) 
    {
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        String sql = "INSERT INTO Productos (nombre, marca, presentacion, tipo, precio, cantidad) "+
                     "VALUES (\""+p.getNombre()+"\", \""+p.getMarca()+"\", \""+p.getPresentacion()+"\", \""+p.getTipo()+"\", "+p.getPrecio()+", "+p.getCantidad()+")";
        ResultSet rs = bd.insertar(sql);
        bd.cerrarConexion();
    }
  
    public Producto buscarProducto(int codigoBuscar) 
    {
        Producto p = null;
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        try
        {
            String sql = "SELECT codigo, nombre, marca, presentacion, tipo, precio, cantidad "+
                         "FROM Productos " + 
                         "WHERE codigo = "+codigoBuscar;
            ResultSet rs = bd.consultar(sql);
            while(rs.next())
            {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String marca = rs.getString(3);
                String presentacion = rs.getString(4);
                String tipo = rs.getString(5);
                int precio = rs.getInt(6);
                int cantidad = rs.getInt(7);
                p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipo);
            }
        }
        catch(Exception e)
        {
            p = null;
        }
        bd.cerrarConexion();
        return p;
    }
    
    public List<Producto> buscarProductos(String criterio) 
    {
        this.listaProductos.clear();
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        try
        {
            String sql = "SELECT codigo, nombre, marca, presentacion, tipo, precio, cantidad "+
                         "FROM Productos "+
                         "WHERE nombre LIKE \"%"+criterio+"%\" "+
                         "OR marca LIKE \"%"+criterio+"%\" " +
                         "OR presentacion LIKE \"%"+criterio+"%\" " +
                         "OR tipo LIKE \"%"+criterio+"%\" ";
            ResultSet rs = bd.consultar(sql);
            while(rs.next())
            {
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                String marca = rs.getString(3);
                String presentacion = rs.getString(4);
                String tipo = rs.getString(5);
                int precio = rs.getInt(6);
                int cantidad = rs.getInt(7);
                Producto p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipo);
                this.listaProductos.add(p);
            }
        }
        catch(Exception e)
        {
            return null;
        }
        bd.cerrarConexion();
        return this.listaProductos;
    }
    
    public void eliminarProducto(int codigo) 
    {
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        String sql = "DELETE FROM Productos " +
                     "WHERE codigo = " + codigo;
        System.out.println(sql);
        bd.borrar(sql);
        bd.cerrarConexion();
    }

    public void surtirProducto(int codigo, int cant, int nuevoPrecio) 
    {
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        String sql = "UPDATE Productos " +
                     "SET cantidad = cantidad  + " + cant + ", precio = " + nuevoPrecio + " " +
                     "WHERE codigo = " + codigo;
        System.out.println(sql);
        bd.actualizar(sql);
        bd.cerrarConexion();
    }

    public void disminuirCantProducto(int codigo, int cant) 
    {
        BasedDatos bd = new BasedDatos();
        bd.crearConexion();
        String sql = "UPDATE Productos " +
                     "SET cantidad = cantidad  - " + cant + " " +
                     "WHERE codigo = " + codigo;
        System.out.println(sql);
        bd.actualizar(sql);
        bd.cerrarConexion();
    }
    

}

