import java.util.List;
import java.util.ArrayList;

public class Almacen
{
    private List<Producto> listaProductos;
    private ArchivoProductos archivo;
    
    public Almacen()
    {
        archivo = new ArchivoProductos();
        this.listaProductos = archivo.leerArchivo();     
    }
    
    public List<Producto> getListaProductos()
    {
        this.listaProductos = archivo.leerArchivo();
        return this.listaProductos;
    }
    
    public int getSiguienteCodigo()
    {
        int size = this.listaProductos.size();
        if (size > 0)
        {
            return this.listaProductos.get(size - 1).getCodigo() + 1;    
        }
        else
        {
            return 1;
        }
        
    }
    
    public void agregarProducto(Producto p)
    {
        this.listaProductos.add(p);
        archivo.guardarProducto(p.toCSV());
    }
    
    public int buscarIndiceProducto(int codigo)
    {
        int posicion = -1;
        for(int i = 0; i < this.listaProductos.size(); i++)
        {
            if(this.listaProductos.get(i).getCodigo() == codigo)
            {
               return  i;
            }
        }
        return -1;
    }
    
    public Producto buscarProducto(int codigo)
    {
        for(Producto p: this.listaProductos)
        {
            if(p.getCodigo() == codigo)
            {
             return p;   
            }
        }
        return null;
    }
    
    public ArrayList<Producto> buscarProducto(String criterio)
    {
        ArrayList<Producto> listaResultado = new ArrayList<Producto>();
        for(Producto p: this.listaProductos)
        {
            if(p.getNombre().equals(criterio) || p.getMarca().equals(criterio) || p.getPresentacion().equals(criterio) || p.getTipo().equals(criterio));
            {
                listaResultado.add(p);
            }
        }
        
        return null;
    }
    
    public void eliminarProducto(int codigo)
    {
        //opcion 1
        int indiceABorrar = this.buscarIndiceProducto(codigo);
        if(indiceABorrar != -1)
        {
            this.listaProductos.remove(indiceABorrar);
        }
        
        //opcion 2
        /*Producto productoABorrar = this.buscarProducto(codigo);
        if(productoABorrar != null)
        {
            this.listaProductos.remove(productoABorrar);
        }*/
    }
    
    public void aumentarCantProducto(int codigo, int cant)
    {
        int indiceAAumentarCantidad = this.buscarIndiceProducto(codigo);
        if (indiceAAumentarCantidad != 1)
        {
            int nuevaCantidad = this.listaProductos.get(indiceAAumentarCantidad).getCantidad() + cant;
            this.listaProductos.get(indiceAAumentarCantidad).setCantidad(nuevaCantidad);
        }
    }
    
    public void disminuirCantProducto(int codigo, int cant)
    {
        int indiceAAumentarCantidad = this.buscarIndiceProducto(codigo);
        if (indiceAAumentarCantidad != 1)
        {
            int nuevaCantidad = this.listaProductos.get(indiceAAumentarCantidad).getCantidad() - cant;
            if(nuevaCantidad >= 0)
            {
                this.listaProductos.get(indiceAAumentarCantidad).setCantidad(nuevaCantidad);    
            }
            
        }
    }
    
    public void actualizarArchivo()
    {
        archivo.guardarProductos(this.listaProductos);
    }
    
    public void modificarPrecio(int codigo, int precio)
    {
        int indiceAModificarPrecio = this.buscarIndiceProducto(codigo);
        if (indiceAModificarPrecio != -1)
        {
            this.listaProductos.get(indiceAModificarPrecio).setPrecio(precio);
        }
    }
    
        
    
    
}
