package com.tiquetes.Controlador;

import com.tiquetes.Dao.LoginDao;
import com.tiquetes.Modelos.Sesion;
import com.tiquetes.Utilidades.Hash;
import com.tiquetes.Vistas.RodamientoVista;
import com.tiquetes.Vistas.SesionVista;
import com.tiquetes.Vistas.TiquetesVista;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class SesionControllador implements ActionListener {
    java.util.Date dia = new Date();
    DateFormat diaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Sesion sesion;
    LoginDao loginDao;
    SesionVista sesionVista;
    TiquetesVista tiquetesVista;
    RodamientoVista rodamientoVista;


    public SesionControllador(Sesion sesion, LoginDao loginDao, SesionVista sesionVista, TiquetesVista tiquetesVista, RodamientoVista rodamientoVista) {
        this.sesion = sesion;
        this.loginDao = loginDao;
        this.sesionVista = sesionVista;
        this.tiquetesVista = tiquetesVista;
        this.rodamientoVista = rodamientoVista;


        this.sesionVista.btnLogin.addActionListener(this);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == sesionVista.btnLogin) {
                if (sesionVista.tfUsuario.getText().isEmpty() || sesionVista.tfPassword.getPassword().toString().isEmpty()) {
                    JOptionPane.showConfirmDialog(null, "Por favor ingresar datos", "Informacion", JOptionPane.ERROR_MESSAGE);
                } else {
                    String pass = new String(sesionVista.tfPassword.getPassword());
                    String nuevoPass = Hash.sha1(pass);
                    sesion.setUsername(sesionVista.tfUsuario.getText());
                    sesion.setContrasena(pass);
                    System.out.println(nuevoPass);

                    if (loginDao.autUsuario(sesion)) {
                        tiquetesVista.setVisible(true);
                        sesionVista.setVisible(false);
                        rodamientoVista.setVisible(true);
                        JOptionPane.showMessageDialog(null, sesion.getNombre() + " " + sesion.getApellido() + " " + sesion.getUsername());
                        LOGGER.log(Level.INFO, "Inicio de sesion");
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "Informacion", JOptionPane.ERROR_MESSAGE);
                        LOGGER.log(Level.WARNING, "Usuario o Contraseña incorrecta");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Sesion boton: " + ex.getMessage());
        }
    }

}
