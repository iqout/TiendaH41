import javax.swing.JOptionPane;
import java.util.List;

public class Interaccion
{
    private Almacen a;
    
    public Interaccion()
    {
        a = new Almacen();
    }
    
    public void presentarMenuPrincipal()
    {
        int opcion = 0;
        do
        {
             String menu = "PROGRAMA DE TIENDA \n" +
                          "1. Productos \n" +
                          "2. ventas \n" +
                          "0. Salir \n";
             opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione un opcion", JOptionPane.QUESTION_MESSAGE));
             switch(opcion)
             {
                 case 1:
                     this.presentarMenuProductos();
                     break;
                 case 2:
                     this.generarVenta();
                     break;
                 case 0:
                     JOptionPane.showMessageDialog(null, "Gracias", "Salir", JOptionPane.INFORMATION_MESSAGE);
                     break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                
             }
        }
        while(opcion != 0);
    }
    
    public void presentarMenuProductos()
    {
        int opcion = 0;
        do
        {
            String menu = "MENU PRODUCTOS \n" +
                          "1. Ingresar Producto \n" +
                          "2. Mostrar Productos \n" +
                          "3. Buscar Productos \n" +
                          "4. Surtir Productos \n" +
                          "0. Volver al menu principal";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione un opcion", JOptionPane.QUESTION_MESSAGE));
            switch(opcion)
            {
                case 1:
                    this.ingresaProducto();
                    break;
                case 2:
                    this.mostarProductos();
                    break;
                case 3:
                    this.buscarProductos();
                    break;
                case 4:
                    this.surtirProducto();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 0);
    }
    public void ingresaProducto()
    {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        //int codigo = a.getSiguienteCodigo();
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, " Ingrese la presentacion del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String [] tipos = {"Aseo", "Alimentos"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer. parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantida del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(nombre,precio, presentacion, cantidad, marca, tipos[tipo]);
        a.agregarProducto(p);
        JOptionPane.showMessageDialog(null, "Se ha añadido el producto al almacen", "Producto al almacen", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostarProductos()
    {
        List<Producto> listaProductos = a.getListaProductos();
        String lista = "";
        for(Producto p: listaProductos)
        {
            lista = lista +p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista, "Productos en el almacén", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void buscarProductos()
    {
        String criterio = JOptionPane.showInputDialog(null, "Ingrese dato de producto a buscar (nombre, marca, presentacion o tipo)", "Buscar Productos", JOptionPane.QUESTION_MESSAGE);
        List<Producto> listaProductos = a.buscarProducto(criterio);
        String lista = "";
        for(Producto p: listaProductos)
        {
            lista = lista + p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);
    
        
    }
    
    public void surtirProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        Producto p = a.buscarProducto(codigo);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cantidad de "+p.getNombre()+ " " +p.getMarca() + "a surtir. Actual: "+p.getMarca(), "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo precio  de " +p.getNombre()+ " " +p.getMarca() + "a surtir. Actual: " +p.getPrecio(), "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        a.aumentarCantProducto(codigo, cantidad);
        a.modificarPrecio(codigo, nuevoPrecio);
        //a.actualizarArchivo();
        JOptionPane.showInputDialog(null, "Producto surtido exitosamente", "Producto surtido", JOptionPane.QUESTION_MESSAGE);
    }
    
    
    public void generarVenta()
    {
        Venta v = new Venta();
        int opcion;
        do
        {
            this.buscarProductos();
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del producto asurtir", "Vender producto", JOptionPane.QUESTION_MESSAGE));
            Producto p = a.buscarProducto(codigo);
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el cantidad del producto a vender", "Vender producto", JOptionPane.QUESTION_MESSAGE));
            boolean agregado = v.agregarACarrito(p, cantidad);
            if (agregado)
            {
                JOptionPane.showInputDialog(null, "Prodcutor agregado al  carrito", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
               JOptionPane.showInputDialog(null, "Prodcutor agregado al  carrito", "Producto NO agregado", JOptionPane.WARNING_MESSAGE); 
            }
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar agregando productos?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        }
        while(opcion == JOptionPane.YES_OPTION);
        int total = v.calcularVenta();
        opcion = JOptionPane.showConfirmDialog(null, "El total de la venta es: $"+total+"\n¿Desea pagar?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if(opcion == JOptionPane.YES_OPTION)
        {
            v.finalizarVenta();
            JOptionPane.showInputDialog(null, "Gracias por su compra", "Venta realizada", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showInputDialog(null, "No se realizo la venta", "Venta no realizada", JOptionPane.WARNING_MESSAGE);
        }
    }
}
