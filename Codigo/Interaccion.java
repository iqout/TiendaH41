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
            String menu = "PROGRAMA DEL TENDERO DE MI BARRIO \n" +
                          "1. Productos \n" + 
                          "2. Ventas \n" + 
                          "0. Salir del programa";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione opción", JOptionPane.QUESTION_MESSAGE));
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
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                          
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
                          "1. Ingresar un producto \n" + 
                          "2. Mostrar productos \n" + 
                          "3. Buscar productos \n" +
                          "4. Surtir producto \n" +
                          "5. Eliminar producto \n" +
                          "0. Volver al menú principal";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione opción", JOptionPane.QUESTION_MESSAGE));
            switch(opcion)
            {
                case 1:
                    this.ingresarProducto();
                    break;
                case 2:
                    this.mostrarProductos();
                    break;
                case 3:
                    this.buscarProductos();
                    break;
                case 4:
                    this.surtirProducto();
                    break;
                case 5:
                    this.eliminarProducto();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 0);
    }
    
    public void ingresarProducto()
    {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String marca = JOptionPane.showInputDialog(null, "Ingrese marca de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, "Ingrese presentacion de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String [] tipos = {"Aseo", "Alimento"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione tipo de producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese precio de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(nombre, precio, presentacion, cantidad, marca, tipos[tipo]);
        a.agregarProducto(p);
        JOptionPane.showMessageDialog(null, "Se ha añadido el producto al almacén", "Producto creado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarProductos()
    {
        List<Producto> listaProductos = a.getListaProductos();
        String lista = "";
        for (Producto p: listaProductos)
        {
            lista = lista + p.toString() + "\n";
        }
         JOptionPane.showMessageDialog(null, lista, "Productos en el almacén", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void buscarProductos()
    {
        String criterio = JOptionPane.showInputDialog(null, "Ingrese dato de producto a buscar (nombre, marca, present o tipo)", "Buscar productos", JOptionPane.QUESTION_MESSAGE);
        List<Producto> listaProductos = a.buscarProductos(criterio);
        String lista = "";
        for (Producto p: listaProductos)
        {
            lista = lista + p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, lista, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void surtirProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo de producto a surtir", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        Producto p = a.buscarProducto(codigo);
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de "+p.getNombre()+" "+p.getMarca()+" a surtir. Actual: "+p.getCantidad(), "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese precio de "+p.getNombre()+" "+p.getMarca()+" a surtir. Actual: "+p.getPrecio(), "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        a.surtirProducto(codigo, cantidad, nuevoPrecio);
        JOptionPane.showMessageDialog(null, "Producto surtido exitosamente", "Producto surtido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void eliminarProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo de producto a eliminar", "Eliminar producto", JOptionPane.QUESTION_MESSAGE));
        Producto p = a.buscarProducto(codigo);
        int opcion = JOptionPane.showConfirmDialog(null, "Desea realmente eliminar el producto "+p.getNombre()+" "+p.getMarca()+"?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION)
        {
            a.eliminarProducto(codigo);
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente", "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void generarVenta()
    {
        Venta v = new Venta();
        int opcion;
        do 
        {
            this.buscarProductos();
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo de producto a surtir", "Vender producto", JOptionPane.QUESTION_MESSAGE));
            Producto p = a.buscarProducto(codigo);
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto a vender", "Vender producto", JOptionPane.QUESTION_MESSAGE));
            boolean agregado = v.agregarACarrito(p, cantidad);
            if (agregado)
            {
                JOptionPane.showMessageDialog(null, "Producto agregado al carrito", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No hay cantidad suficiente para este producto", "Producto NO agregado", JOptionPane.WARNING_MESSAGE);
            }
            opcion = JOptionPane.showConfirmDialog(null, "Desea continuar agregando productos?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        while(opcion == JOptionPane.YES_OPTION);
        int total = v.calcularVenta();
        opcion = JOptionPane.showConfirmDialog(null, "El total de la venta es: $"+total+"\nDesea pagar?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION)
        {
            v.finalizarVenta();
            JOptionPane.showMessageDialog(null, "Gracias por su compra", "Venta realizada", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se realizó venta", "Venta no realizada", JOptionPane.WARNING_MESSAGE);
        }
    }
}




