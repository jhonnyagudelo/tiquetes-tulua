package com.tiquetes.Vistas;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class AgregarUsuarioVista extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    AgregarUsuarioVista frame = new AgregarUsuarioVista();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


    private JPanel contentPane;
    private JDesktopPane regUsuario, generalDato;
    public JTextField tfUsername, tfNombre, tfApellidos;
    public JPasswordField tfPassword, tfConfiPassword;
    public JButton btnAgregar, btnCancel;
    public JComboBox selectControl,selectTipo;
    public DefaultComboBoxModel dcbm, dcbmC, dcbmT;
    public ButtonGroup type;
    public JLabel lblUsername, lblPassword, lblConfiPassword, lblNombre, lblApellidos, lblControl, lblTipo;


    public AgregarUsuarioVista(){
        setTitle("Agregar usuarios");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(500,250,540,450);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);



        //Formulario de usuarios

        regUsuario = new JDesktopPane();
        regUsuario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,null));
        regUsuario.setBackground(SystemColor.control);
        regUsuario.setBounds(20,20,480,150);
        regUsuario.setBorder(BorderFactory.createTitledBorder("Registro de usuario"));
        contentPane.add(regUsuario);

        lblUsername = new JLabel("UserName: ");
        lblUsername.setBounds(10,10,100,80);
        regUsuario.add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(200,10,100,80);
        regUsuario.add(lblPassword);

        lblConfiPassword = new JLabel("Confirmar password:");
        lblConfiPassword.setBounds(143,50,130,80);
        regUsuario.add(lblConfiPassword);

        tfUsername = new JTextField();
        tfUsername.setBounds(80,40,100,21);
        regUsuario.add(tfUsername);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(270,40,100,21);
        regUsuario.add(tfPassword);

        tfConfiPassword = new JPasswordField();
        tfConfiPassword.setBounds(270,80,100,21);
        regUsuario.add(tfConfiPassword);

        generalDato = new JDesktopPane();
        generalDato.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        generalDato.setBackground(SystemColor.control);
        generalDato.setBorder(BorderFactory.createTitledBorder("Datos generales"));
        generalDato.setBounds(20,180,480,150);
        contentPane.add(generalDato);

        lblNombre = new JLabel("Nombres: ");
        lblNombre.setBounds(50,10,100,80);
        generalDato.add(lblNombre);

        lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(240,10,100,80);
        generalDato.add(lblApellidos);
        

        lblControl = new JLabel("Tipo:");
        lblControl.setBounds(60,50,100,80);
        generalDato.add(lblControl);

        lblTipo = new JLabel("Control:");
        lblTipo.setBounds(360,50,100,80);
        generalDato.add(lblTipo);

        tfNombre = new JTextField();
        tfNombre.setBounds(110,40,110,21);
        generalDato.add(tfNombre);

        tfApellidos = new JTextField();
        tfApellidos.setBounds(300,40,110,21);
        generalDato.add(tfApellidos);

        selectTipo = new JComboBox();
        selectTipo.setBounds(20,100,140,21);
        dcbmT = new DefaultComboBoxModel();
        selectTipo.addItem("Elige una opción");
        generalDato.add(selectTipo);

        selectControl = new JComboBox();
        selectControl.setBounds(320,100,140,21);
        dcbmC = new DefaultComboBoxModel();
        selectControl.addItem("Elige una opción");
        generalDato.add(selectControl);

        
        
        btnAgregar = new JButton("Guardar");
        btnAgregar.setBounds(22,340,80,30);
        contentPane.add(btnAgregar);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(108,340,80,30);
        contentPane.add(btnCancel);

    }
}
