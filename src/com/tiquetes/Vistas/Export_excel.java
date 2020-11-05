package com.tiquetes.Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Export_excel extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    Export_excel frame = new Export_excel();
                    frame.setVisible(true);
                }catch (Exception e) {
                    System.out.println("Jframe: " + e.getMessage());
                }
            }
        });
    }
    private JPanel contentPane;
    private JDesktopPane registrarPanel;
    private JLabel lblVehiculo, lblConduce;
    public JTextField tfConduce;
    public JComboBox vehiculo;

    public JButton btnGuardar,btnEliminar,btnLimpiar;

    public DefaultComboBoxModel dcVehiculo;
    public DefaultTableModel dtm;
    public JScrollPane scroll;
    public Object[][] data;
    public String[] headBoard;
    public JTable table;

    //menu
    private JMenuBar menuBar;
    public JMenu ulFile, ulTiquetes, ulVehiculos, ulHelp, ulConfig, ulRodamiento;
    public JMenuItem liCerrar, liUsuario, liRodamiento, liCompra, liAbout, liConsulta, liExport,liRegistro,liConduce;

    public Export_excel() {
        setTitle("Registro de conduce");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 800, 380);

        contentPane = new JPanel();
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

    }
}
