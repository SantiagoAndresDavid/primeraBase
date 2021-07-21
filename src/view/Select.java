package view;

import Controller.Consultas;
import model.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import java.util.Scanner;

public class Select extends JDialog{
    private JLabel lCodigo, lNombre, lTipo, lCantidad, lstock, lImg,tTipo, tCodigo, tNombre,tCantidad, tstock;
    private JPanel panelDatos,panelInfo;
    private JPanel panelImg;
    private ImageIcon imagen;

    Scanner scanner = new Scanner(System.in);

    private Container Contenedor;

    public Select(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setSize(500, 500);
        this.setTitle("Mostrar");
        Producto producto = buscar();
        iniciarComponentes(producto);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    public Producto buscar(){
        System.out.println("Ingrese el codigo del producto que desea buscar");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Consultas consultas = new Consultas();
        Producto producto = consultas.buscar(codigo);
        return producto;
    }

    public void iniciarComponentes(Producto producto) {
        this.Contenedor = this.getContentPane();
        this.Contenedor.setLayout(new BorderLayout());
        this.Contenedor.setBackground(Color.WHITE);
        iniciarPanelDatos(producto);
    }

    public void iniciarPanelDatos(Producto producto) {
        this.panelDatos = new JPanel();
        this.panelImg = new JPanel();
        this.panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.panelInfo.setBackground(Color.WHITE);
        this.panelDatos.setLayout(new GridLayout(7, 2, 10, 10));

        this.lCodigo = new JLabel("codigo: ");
        this.lNombre = new JLabel("Nombre: ");
        this.lTipo = new JLabel("tipo: ");
        this.lCantidad = new JLabel("Cantidad: ");
        this.lstock = new JLabel("Stock: ");
        ImageIcon imageIcon = new ImageIcon(producto.getImagen());
        this.lImg = new JLabel(imageIcon);

        this.tCodigo = new JLabel(String.valueOf(producto.getCodigo()));
        this.tNombre = new JLabel(producto.getNombre());
        this.tTipo = new JLabel(producto.getTipo());
        this.tCantidad = new JLabel(String.valueOf(producto.getCantidad()));
        this.tstock = new JLabel(producto.getStock());


        this.panelDatos.add(this.lCodigo);
        this.panelDatos.add(this.tCodigo);

        this.panelDatos.add(this.lNombre);
        this.panelDatos.add(this.tNombre);

        this.panelDatos.add(this.lCantidad);
        this.panelDatos.add(this.tCantidad);

        this.panelDatos.add(this.lTipo);
        this.panelDatos.add(this.tTipo);

        this.panelDatos.add(this.lstock);
        this.panelDatos.add(this.tstock);

        panelDatos.setBackground(Color.WHITE);
        panelInfo.add(panelDatos);

        this.panelImg.add(lImg);
        panelImg.setBackground(Color.WHITE);
        panelImg.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.Contenedor.add(this.panelInfo, BorderLayout.NORTH);
        this.Contenedor.add(this.panelImg, BorderLayout.EAST);
    }


}
