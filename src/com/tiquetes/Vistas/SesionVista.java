package com.tiquetes.Vistas;

import javax.swing.*;
import java.awt.*;

public class SesionVista extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    SesionVista frame = new SesionVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JPanel contentPane;
    private JLabel lblUsuario, lblPassword;
    public JTextField tfUsuario;
    public JPasswordField tfPassword;
    public JButton btnLogin;



    public SesionVista() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(500, 250, 400, 250);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setBounds(90, 62, 100, 25);
        contentPane.add(lblUsuario);

        lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(75, 100, 100, 25);
        contentPane.add(lblPassword);

        tfUsuario = new JTextField();
        tfUsuario.setBounds(140, 62, 150, 30);
        contentPane.add(tfUsuario);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(140, 100, 150, 30);
        contentPane.add(tfPassword);

        btnLogin = new JButton("Ingresar");
        btnLogin.setBounds(150, 150, 100, 30);
        contentPane.add(btnLogin);
        setVisible(true);
    }
}