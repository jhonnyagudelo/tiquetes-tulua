package com.tiquetes.Vistas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConfigUsuarios extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    ConfigUsuarios frame = new ConfigUsuarios();
                    frame.setVisible(true);
                }catch (Exception e){
                }
            }
        });
    }

    private JPanel contentPane;
    public JButton btnAgregar,btnEliminar,btnModificar;
    private JScrollPane scroll;
    public  Object[][] data;
    public String[] headBoard;
    public DefaultTableModel dtm;
    public JTable table;


    public ConfigUsuarios (){
        setTitle("Usuarios configuracion");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(340,100,700,300);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);




        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(20,200,100,30);
        contentPane.add(btnAgregar);

//        btnModificar = new JButton("Modificar");
//        btnModificar.setBounds(130,200,100,30);
//        contentPane.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(240,200,100,30);
        contentPane.add(btnEliminar);

        //Tabla
        scroll = new JScrollPane();
        headBoard = new String[] {"Nombres", "Apellidos", "UserName","Tipo","Status","Control"};
        dtm = new DefaultTableModel(data,headBoard);
        scroll.setBounds(20, 20, 642, 175);

        getContentPane().add(scroll);
        table = new JTable(dtm);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        scroll.setViewportView(table);
        contentPane.add(scroll);

    }
}
