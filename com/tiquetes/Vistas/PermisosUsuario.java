package com.tiquetes.Vistas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class PermisosUsuario extends JFrame {
    public static void main(String[] arsg) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PermisosUsuario frame = new PermisosUsuario();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private JPanel contentPanel;
    private JDesktopPane permisos, controles, itemControl;
    private JLabel lblControl, lblAdmin, lblRol;
    public Checkbox chxControl, chxAdmin;
    public JComboBox selectRol;
    public DefaultComboBoxModel comboRol;

    public PermisosUsuario(){
        setTitle("Agregar permisos");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(500,250,400,400);

        contentPanel = new JPanel();
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        permisos = new JDesktopPane();
        permisos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,null));
        permisos.setBackground(SystemColor.control);
        permisos.setBounds(20,20,340,320);
        permisos.setBorder(BorderFactory.createTitledBorder("Permisos asignados"));
        contentPanel.add(permisos);

//        controles = new JDesktopPane();
//        controles.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,null));
//        controles.setBackground(SystemColor.control);
//        controles.setBounds(20,120,340,200);
//        controles.setBorder(BorderFactory.createTitledBorder("Controles asignados"));
//        contentPanel.add(controles);

        itemControl = new JDesktopPane();
        itemControl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,null));
//        itemControl.setBackground(SystemColor.white);
        itemControl.setBounds(10,90,320,220);
        permisos.add(itemControl);


        lblRol = new JLabel("Roles");
        lblRol.setBounds(30,10,180,80);
        permisos.add(lblRol);

        selectRol = new JComboBox();
        selectRol.setBounds(100,40,180,25);
        permisos.add(selectRol);

        chxControl = new Checkbox("control tulua");
        chxControl.setBounds(8  ,5,100,50);
        itemControl.add(chxControl);

    }
}
