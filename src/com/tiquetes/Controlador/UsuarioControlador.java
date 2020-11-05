package com.tiquetes.Controlador;

import com.tiquetes.Dao.UsuarioDao;
import com.tiquetes.Modelos.Usuario;
import com.tiquetes.Vistas.AgregarUsuarioVista;
import com.tiquetes.Vistas.ConfigUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioControlador  implements ActionListener, Implementos {
    Usuario usuario;
    UsuarioDao usuarioDao;
    ConfigUsuarios configUsuarios;
    AgregarUsuarioVista agregarUsuario;

    public UsuarioControlador(Usuario usuario, UsuarioDao usuarioDao, ConfigUsuarios configUsuarios, AgregarUsuarioVista agregarUsuario) {
        this.usuario = usuario;
        this.usuarioDao = usuarioDao;
        this.configUsuarios = configUsuarios;
        this.agregarUsuario = agregarUsuario;

        this.agregarUsuario.btnAgregar.addActionListener(this);
        this.agregarUsuario.btnCancel.addActionListener(this);
        this.agregarUsuario.selectControl.addActionListener(this);
        this.agregarUsuario.selectTipo.addActionListener(this);
        this.configUsuarios.btnAgregar.addActionListener(this);
        this.configUsuarios.btnEliminar.addActionListener(this);
        this.configUsuarios.btnModificar.addActionListener(this);

    }

    @Override
    public void tfClear() {
        this.agregarUsuario.tfNombre.setText("");
        this.agregarUsuario.tfApellidos.setText("");
        this.agregarUsuario.tfPassword.setText("");
        this.agregarUsuario.tfConfiPassword.setText("");
        this.agregarUsuario.tfUsername.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == configUsuarios.btnAgregar) {
            agregarUsuario.setVisible(true);
        }
        if(e.getSource() == configUsuarios.btnEliminar) {
            JOptionPane.showMessageDialog(null,"¿Eliminar usuario?", "Si/No", JOptionPane.YES_NO_CANCEL_OPTION);
            int fila = configUsuarios.table.getSelectedRow();
            String userName = configUsuarios.table.getValueAt(fila,2).toString();
            System.out.println("Dato: " + userName);
            if(usuarioDao.eliminar(usuario)) {
                JOptionPane.showMessageDialog(null, "Eliminado exitosamente el usuario" + userName );
                usuarioDao.listaControl();
            }else {
                JOptionPane.showMessageDialog(null,"No se pudo eliminar " + userName);
            }
        }
        if(e.getSource() == agregarUsuario.btnAgregar) {
            String pass = new String(agregarUsuario.tfPassword.getPassword());
            String passNuevo = new String(agregarUsuario.tfConfiPassword.getPassword());
            if(agregarUsuario.tfNombre.getText().isEmpty() || agregarUsuario.tfApellidos.getText().isEmpty() || agregarUsuario.tfUsername.getText().isEmpty() || pass.isEmpty() || passNuevo.isEmpty()) {
                JOptionPane.showMessageDialog(null , "Llenar los campos", "Informacion", JOptionPane.ERROR_MESSAGE);
            }else {

            }
        }
    }
}
