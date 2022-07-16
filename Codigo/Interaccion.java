import javax.swing.JOptionPane;
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
                          "0. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Seleccione un opcion", JOptionPane.QUESTION_MESSAGE));
            switch(opcion)
            {
                case 1:
                    this.ingresaProducto();
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
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese codigo del producto", "Nurvo producto", JOptionPane.QUESTION_MESSAGE));
        String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, " Ingrese la presentacion del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el precio del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer. parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantida del producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(nombre, codigo, precio, presentacion, cantidad, marca, tipo);
        a.agregarProducto(p);
        JOptionPane.showMessageDialog(null, "Se ha añadido el producto al almacen", "Producto al almacen", JOptionPane.INFORMATION_MESSAGE);
    }
     
    
}
