package view;

import Controller.Consultas;

import model.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.util.Scanner;


public class Insert  extends JDialog{
    private JLabel lcodigo, lnombre, ltipo, lcantidad, lDisponibilidad,lImg;
    private JTextField tcodigo, tnombre, ttipo, tcantidad, tdisiponibilidad;
    private JButton bGuardar,bsubir;
    private Container contenedor;
    private JPanel panelDatos, panelBotones;

    private String subir;

    Scanner scanner = new Scanner(System.in);

    public Insert(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("Formulario Registro de Jugadores - V1");
        //this.setSize(400, 500);
        this.iniciarComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelDatos();
        this.inicializarPanelBotones();
    }

    public void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(9, 2, 15, 15));

        this.lcodigo = new JLabel("codigo:");
        this.lnombre = new JLabel("nombre : ");
        this.ltipo = new JLabel("tipo: ");
        this.lcantidad = new JLabel("cantidad: ");
        this.lDisponibilidad = new JLabel("Disponibilidad: ");
        this.lImg = new JLabel("Imagen");

        this.tcodigo = new JTextField(null);
        this.tnombre = new JTextField(null);
        this.ttipo = new JTextField(null);
        this.tcantidad = new JTextField(null);
        this.tdisiponibilidad = new JTextField(null);


        this.panelDatos.add(this.lcodigo);
        this.panelDatos.add(this.tcodigo);

        this.panelDatos.add(this.lnombre);
        this.panelDatos.add(this.tnombre);

        this.panelDatos.add(this.ltipo);
        this.panelDatos.add(this.ttipo);

        this.panelDatos.add(this.lcantidad);
        this.panelDatos.add(this.tcantidad);

        this.panelDatos.add(this.lDisponibilidad);
        this.panelDatos.add(this.tdisiponibilidad);

        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);

    }

    public void inicializarPanelBotones(){
        this.bsubir = new JButton("subir");
        this.bsubir.addActionListener(new clickBotonsubir());
        this.bsubir.setEnabled(true);
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(true);
        this.panelBotones = new JPanel();
        this.panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.panelBotones.setLayout(new GridLayout(2, 1, 5, 5));
        this.panelBotones.add(this.bsubir);
        this.panelBotones.add(this.bGuardar);
        this.contenedor.add(this.panelBotones, BorderLayout.SOUTH);
    }

    public String subirImagen(){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        subir = file.getAbsolutePath();
        return subir;
    }

    public Producto leerComponentes() {

        int codigo = Integer.parseInt(this.tcodigo.getText());
        String nombre = this.tnombre.getText();
        String tipo = this.ttipo.getText();
        int cantidad = Integer.parseInt(this.tcantidad.getText());
        String disponibilidad = this.tdisiponibilidad.getText();
        String imagen = this.subir;
        Producto producto = new Producto(codigo,nombre,tipo,cantidad,disponibilidad,imagen);
        return producto;
    }
    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    public void guardarVehiculo() {
        Producto producto = this.leerComponentes();
        new Consultas().llenar(producto);
        this.ventanaMsg("Datos guardados con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
    }


    class ClickBotonGuardar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            guardarVehiculo();
        }
    }

    class clickBotonsubir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            subirImagen();
        }
    }
}
