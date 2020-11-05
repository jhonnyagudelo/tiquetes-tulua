package com.tiquetes.Vistas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

    public class ConduceVista extends JFrame {
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try{
                        ConduceVista frame = new ConduceVista();
                        frame.setVisible(true);
                    }catch (Exception e){
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

        public ConduceVista(){
            setTitle("Registro de conduce");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(200,100,800,380);

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

            registrarPanel = new JDesktopPane();
            registrarPanel.setBounds(20,20,320,240);
            
            registrarPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
            registrarPanel.setBorder(BorderFactory.createTitledBorder("Guardar conduce"));
            registrarPanel.setBackground(SystemColor.control);
            contentPane.add(registrarPanel);

            lblVehiculo = new JLabel("Vehiculo:");
            lblVehiculo.setBounds(50,60,80,50);
            registrarPanel.add(lblVehiculo);

            lblConduce = new JLabel("Conduce:");
            lblConduce.setBounds(50,100,80,50);
            registrarPanel.add(lblConduce);

            tfConduce = new JTextField();
            tfConduce.setBounds(120,113,150,25);
            registrarPanel.add(tfConduce);

            vehiculo = new JComboBox();
            vehiculo.setBounds(120,72,150,25);
            registrarPanel.add(vehiculo);
            dcVehiculo = new DefaultComboBoxModel();
            vehiculo.addItem("--Seleccione--");


            btnGuardar = new JButton("Guardar");
            btnGuardar.setBounds(30,180,120,25);
            registrarPanel.add(btnGuardar);

            btnLimpiar = new JButton("Limpiar");
            btnLimpiar.setBounds(180,180,120,25);
            registrarPanel.add(btnLimpiar);

            //Tabla
            scroll = new JScrollPane();
            headBoard = new String[]{"Vehiculo", "Conduce"};
            dtm = new DefaultTableModel(data, headBoard);
            scroll.setBounds(346, 28, 400, 230);

            getContentPane().add(scroll);
            table = new JTable(dtm);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            scroll.setViewportView(table);
            contentPane.add(scroll);

            btnEliminar = new JButton("Eliminar");
            btnEliminar.setBounds(500, 269, 120, 25);
            contentPane.add(btnEliminar);

        }


}
