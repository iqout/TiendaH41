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
            String menu = "MENU PRINCIPAL \n" +
                          "1. Ingrese Producto \n" +
                          "2. Mostrar Productos \n" +
                          "3. Buscar Productos \n" +
                          "0. Salir";
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
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias", "Salir", JOptionPane.INFORMATION_MESSAGE);
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
        int codigo = a.getSiguienteCodigo();
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, " Ingrese la presentacion del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String [] tipos = {"Aseo", "Alimentos"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer. parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantida del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipos[tipo]);
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
    
    
}
