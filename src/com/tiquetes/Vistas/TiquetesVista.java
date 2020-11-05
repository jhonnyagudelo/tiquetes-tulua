package com.tiquetes.Vistas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TiquetesVista extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TiquetesVista frame = new TiquetesVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private JPanel contentPane;
    private JDesktopPane registrarPanel;
    private JLabel lblOrigen, lblDestino, lblCantidad, lblVehiculo;
    public JComboBox s_destino, s_origen ,selectVehicle;
    public JTextField tfVehiculo, tfCantidad;
    public JButton btnComprar, btnUpdate, btnEliminar, btnLimpiar;
    public DefaultComboBoxModel dcbm, dcbmD;
    public DefaultTableModel dtm;
    private JScrollPane scroll;
    public Object[][] data;
    public String[] headBoard;
    public JTable table;
    //Menu
    private JMenuBar menuBar;
    public JMenu ulFile, ulTiquetes, ulVehiculos, ulHelp, ulConfig, ulRodamiento;
    public JMenuItem liCerrar, liUsuario, liRodamiento, liCompra, liAbout, liConsulta, liExport,liRegistro,liConduce;

    public TiquetesVista() {
        setTitle("Venta de tiquetes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1000, 450);

        contentPane = new JPanel();
        //getContentPane().add(contentPane);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Barra Menu
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        ulFile = new JMenu("Archivo");
        menuBar.add(ulFile);

        ulTiquetes = new JMenu("Tiquetes");
        menuBar.add(ulTiquetes);

        ulRodamiento = new JMenu("Rodamientos");
        menuBar.add(ulRodamiento);

        ulVehiculos = new JMenu("Vehiculos");
        menuBar.add(ulVehiculos);

        ulConfig = new JMenu("Configuracion");
        menuBar.add(ulConfig);

        ulHelp = new JMenu("Ayuda");
        menuBar.add(ulHelp);

        //item Menu
        //item Menu Archivo
        liCerrar = new JMenuItem("Cerrar");
        ulFile.add(liCerrar);
        //item menu venta

        liCompra = new JMenuItem("Venta tiquetes");
        ulTiquetes.add(liCompra);

        liExport = new JMenuItem("Historial vehicular");
        ulTiquetes.add(liExport);

        //Config
        liUsuario = new JMenuItem("Usuarios");
        ulConfig.add(liUsuario);

        //Rodamientos
        liRodamiento = new JMenuItem("Registro rodamiento");
        ulRodamiento.add(liRodamiento);

        liConduce = new JMenuItem("Guardar conduce");
        ulRodamiento.add(liConduce);
        
        //item menu vehiculos
        liRegistro = new JMenuItem("Registro vehicular");
        ulVehiculos.add(liRegistro);

        liConsulta = new JMenuItem("Consulta");
        ulVehiculos.add(liConsulta);
        //acerca de
        liAbout = new JMenuItem("Acerca de.");
        ulHelp.add(liAbout);

        registrarPanel = new JDesktopPane();
        registrarPanel.setBounds(20, 20, 320, 350);
        registrarPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        registrarPanel.setBorder(BorderFactory.createTitledBorder("Venta de tiquetes"));
        registrarPanel.setBackground(SystemColor.control);
        contentPane.add(registrarPanel);

        lblOrigen = new JLabel("Origen");
        lblOrigen.setBounds(50, 60, 80, 50);
        registrarPanel.add(lblOrigen);

        lblDestino = new JLabel("Destino");
        lblDestino.setBounds(50, 100, 80, 50);
        registrarPanel.add(lblDestino);

        lblVehiculo = new JLabel("Vehiculo");
        lblVehiculo.setBounds(50, 140, 80, 50);
        registrarPanel.add(lblVehiculo);

        lblCantidad = new JLabel("Cantidad");
        lblCantidad.setBounds(50, 180, 80, 50);
        registrarPanel.add(lblCantidad);



        tfCantidad = new JTextField();
        tfCantidad.setBounds(120, 193, 150, 25);
        registrarPanel.add(tfCantidad);
//
//        tfVehiculo = new JTextField();
//        tfVehiculo.setBounds(120, 153, 150, 25);
//        registrarPanel.add(tfVehiculo);


        //JcomboBox
        s_origen = new JComboBox();
        s_origen.setBounds(120, 73, 150, 25);
        registrarPanel.add(s_origen);
        dcbm = new DefaultComboBoxModel();
        s_origen.addItem("--Seleccionar--");


        s_destino = new JComboBox();
        s_destino.setBounds(120, 113, 150, 25);
        registrarPanel.add(s_destino);
        dcbmD = new DefaultComboBoxModel();
        s_destino.addItem("--Seleccionar--");


        selectVehicle = new JComboBox();
        selectVehicle.setBounds(120, 153, 150, 25);
        registrarPanel.add(selectVehicle);
//        dcbmV = new DefaultComboBoxModel();
        selectVehicle.addItem("--Seleccionar--");


        //Button
        btnComprar = new JButton("Venta");
        btnComprar.setBounds(10, 280, 120, 25);
        registrarPanel.add(btnComprar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(180, 280, 120, 25);
        registrarPanel.add(btnLimpiar);

        //Tabla
        scroll = new JScrollPane();
        headBoard = new String[]{"Vehiculo","Salida","Destino", "Cantidad"};
        dtm = new DefaultTableModel(data, headBoard);
        scroll.setBounds(346, 28, 600, 230);

        getContentPane().add(scroll);
        table = new JTable(dtm);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        scroll.setViewportView(table);
        contentPane.add(scroll);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(580, 269, 120, 25);
        contentPane.add(btnEliminar);
    }
}