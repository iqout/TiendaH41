import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Graphics;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class PantallaGUI extends JFrame
{
        JTextField txtId, txtNombre, txtMarca, txtPresentacion, txtPrecio, txtCantidad, txtFiltro;
        JComboBox comboTipo;
        JButton btnIngresar, btnModificar, btnEliminar, btnLimpiar, btnFiltrar, btnQuitarFiltro;
        DefaultTableModel dtm;
        
      
    public PantallaGUI()
    {
        
        setTitle("Tienda H41");
        setBounds(100, 40, 1100, 600);
        setLayout(null);
        
        JPanel  panelFormulario = new JPanel();
        panelFormulario.setBounds(5, 5, 405, 600);
        panelFormulario.setBackground(new Color(170, 50, 255));
        panelFormulario.setLayout(null);
        getContentPane().add(panelFormulario);
        
        JPanel  panelTabla = new JPanel();
        panelTabla.setBounds(415, 5, 700, 600);
        panelTabla.setBackground(new Color(70, 170, 255));
        panelTabla.setLayout(null);
        getContentPane().add(panelTabla);
        
        //ID
        JLabel labelId = new JLabel("Id");
        labelId.setBounds(10, 20, 100, 30);
        panelFormulario.add(labelId);
        
        txtId = new JTextField();
        txtId.setBounds(120, 20, 200, 30);
        panelFormulario.add(txtId);
        
        //Nombre
        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(10, 70, 100, 30);
        panelFormulario.add(labelNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(120, 70, 200, 30);
        panelFormulario.add(txtNombre);
        
        //Marca
        JLabel labelMarca = new JLabel("Marca");
        labelMarca.setBounds(10, 120, 100, 30);
        panelFormulario.add(labelMarca);
        
        txtMarca = new JTextField();
        txtMarca.setBounds(120, 120, 200, 30);
        panelFormulario.add(txtMarca);
        
        //Presentacion
        JLabel labelPresentacion = new JLabel("Presentación");
        //se suma de  labelMarca = 120+30+20de marjen
        labelPresentacion.setBounds(10, 170, 100, 30);
        panelFormulario.add(labelPresentacion);
        
        txtPresentacion = new JTextField();
        txtPresentacion.setBounds(120, 170, 200, 30);
        panelFormulario.add(txtPresentacion);
        
        //Tipo
        JLabel labelTipo = new JLabel("Tipo");
        //se suma de  labelMarca = 170+30+20de marjen
        labelTipo.setBounds(10, 220, 100, 30);
        panelFormulario.add(labelTipo);
        
        comboTipo = new JComboBox();
        comboTipo.setBounds(120, 220, 200, 30);
        comboTipo.addItem("Aseo");
        comboTipo.addItem("Alimento");
        panelFormulario.add(comboTipo);
               
        //Cantidad
        JLabel labelCantidad = new JLabel("Cantidad");
        //se suma de  labelMarca = 220+30+20de marjen
        labelCantidad.setBounds(10, 270, 100, 30);
        panelFormulario.add(labelCantidad);
        
        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 270, 200, 30);
        panelFormulario.add(txtCantidad);
        
        //Precio
        JLabel labelPrecio = new JLabel("Precio     $");
        //se suma de  labelMarca = 270+30+20de marjen
        labelPrecio.setBounds(10, 320, 100, 30);
        panelFormulario.add(labelPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 320, 200, 30);
        panelFormulario.add(txtPrecio);
        
        ////BOTONES
        //INGRESAR
        btnIngresar = new JButton();
        btnIngresar.setBounds(10, 500, 90, 30);
        btnIngresar.setText("Ingresar");
        panelFormulario.add(btnIngresar);
        btnIngresar.setBackground(Color.white);
        btnIngresar.setForeground(Color.gray); 
        btnIngresar.setEnabled(true);
        
        //MODIFICAR
        btnModificar = new JButton("Modificar");
        //se suma de  btnIngresar = 10+90+10 de marjen
        btnModificar.setBounds(110, 500, 90, 30);
        panelFormulario.add(btnModificar);
        btnModificar.setBackground(Color.white);
        btnModificar.setEnabled(true);
        
        //ELIMINAR
        btnEliminar = new JButton("Eliminar");
        //se suma de  btnIngresar = 110+90+10 de marjen
        btnEliminar.setBounds(210, 500, 90, 30);
        panelFormulario.add(btnEliminar);
        btnEliminar.setBackground(Color.white);
        btnEliminar.setEnabled(true);
        
        //LIMPIAR
        btnLimpiar = new JButton("Limpiar");
        //se suma de  btnIngresar = 210+90+10 de marjen
        btnLimpiar.setBounds(310, 500, 90, 30);
        panelFormulario.add(btnLimpiar);
        btnLimpiar.setBackground(Color.white);
        btnLimpiar.setEnabled(true);
        
        //filtro
        JLabel labelFiltro  = new JLabel("Filtra por:");
        labelFiltro.setBounds(10, 500, 90, 30);
        panelTabla.add(labelFiltro);
        txtFiltro = new JTextField();
        txtFiltro.setBounds(100, 500, 300, 30);
        panelTabla.add(txtFiltro);
        
        //BOTON - FILTRAR
        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBackground(Color.cyan);
        btnFiltrar.setEnabled(true);
        this.add(btnFiltrar);
        
        //se suma de  txtFiltro = 100+300+10 de marjen
        btnFiltrar.setBounds(410, 500, 90, 30);
        panelTabla.add(btnFiltrar);
        
        //BOTON - QUITAR_FILTRAR
        btnQuitarFiltro = new JButton("Quitar Filtro");
        //se suma de  txtFiltro = 410+90+10 de marjen
        btnQuitarFiltro.setBounds(510, 500, 100, 30);
        btnQuitarFiltro.setBackground(Color.cyan);
        btnQuitarFiltro.setEnabled(true);
        panelTabla.add(btnQuitarFiltro);
        
        //.....................................................
        //crear el DTM
        Object[][] datos  = null;
        String[] columnas = {"Codigo", "Nombre", "Marca", "Presentacion", "Tipo", "Cant", "Precio"};
        dtm = new DefaultTableModel(datos, columnas);
        
        JTable tablaProductos = new JTable(dtm);
        tablaProductos.setPreferredScrollableViewportSize(new Dimension(650, 290));
        tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tablaProductos);
        
        JPanel contenidoTabla = new JPanel();
        contenidoTabla.setBounds(10, 10, 650, 290);
        contenidoTabla.setLayout(new GridLayout(1, 0));
        contenidoTabla.add(scroll);
        panelTabla.add(contenidoTabla);
        
        setVisible(true);
    }
    
}
