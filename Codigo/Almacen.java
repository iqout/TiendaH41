import java.util.List;
import java.util.ArrayList;

public class Almacen
{
    private List<Producto> listaProductos;
    
    
    public Almacen()
    {
           
    }
    
    public List<Producto> getListaProductos()
    {
        return this.listaProductos;
    }
    
       
    public void agregarProducto(Producto p)
    {
       
    }
    
    
    
    public Producto buscarProducto(int codigo)
    {
        /*for(Producto p: this.listaProductos)
        {
            if(p.getCodigo() == codigo)
            {
             return p;   
            }
        }*/
        return null;
    }
    
    public ArrayList<Producto> buscarProducto(String criterio)
    {
        ArrayList<Producto> listaResultado = new ArrayList<Producto>();
        /*for(Producto p: this.listaProductos)
        {
            if(p.getNombre().equals(criterio) || p.getMarca().equals(criterio) || p.getPresentacion().equals(criterio) || p.getTipo().equals(criterio));
            {
                listaResultado.add(p);
            }
        }*/
        
        return listaResultado;
    }
    
    public void eliminarProducto(int codigo)
    {
        //opcion 1
        /*int indiceABorrar = this.buscarIndiceProducto(codigo);
        if(indiceABorrar != -1)
        {
            this.listaProductos.remove(indiceABorrar);
        }*/
        
        //opcion 2
        /*Producto productoABorrar = this.buscarProducto(codigo);
        if(productoABorrar != null)
        {
            this.listaProductos.remove(productoABorrar);
        }*/
    }
    
    public void aumentarCantProducto(int codigo, int cant)
    {
        /*int indiceAAumentarCantidad = this.buscarIndiceProducto(codigo);
        if (indiceAAumentarCantidad != 1)
        {
            int nuevaCantidad = this.listaProductos.get(indiceAAumentarCantidad).getCantidad() + cant;
            this.listaProductos.get(indiceAAumentarCantidad).setCantidad(nuevaCantidad);
        }*/
    }
    
    public void disminuirCantProducto(int codigo, int cant)
    {
        /*int indiceAAumentarCantidad = this.buscarIndiceProducto(codigo);
        if (indiceAAumentarCantidad != 1)
        {
            int nuevaCantidad = this.listaProductos.get(indiceAAumentarCantidad).getCantidad() - cant;
            if(nuevaCantidad >= 0)
            {
                this.listaProductos.get(indiceAAumentarCantidad).setCantidad(nuevaCantidad);    
            }
            
        }*/
    }
    
    /*public void actualizarArchivo()
    {
        archivo.guardarProductos(this.listaProductos);
    }*/
    
    public void modificarPrecio(int codigo, int precio)
    {
        /*int indiceAModificarPrecio = this.buscarIndiceProducto(codigo);
        if (indiceAModificarPrecio != -1)
        {
            this.listaProductos.get(indiceAModificarPrecio).setPrecio(precio);
        }*/
    }
    
        
    
    
}
