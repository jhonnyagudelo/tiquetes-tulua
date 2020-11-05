package com.tiquetes.Controlador;

import com.tiquetes.Dao.ConduceDao;
import com.tiquetes.Dao.RodamientoDao;
import com.tiquetes.Modelos.Conduce;
import com.tiquetes.Vistas.ConduceVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConduceControlador implements ActionListener,Implementos {

    ConduceVista conduceVista;
    Conduce conduce;
    ConduceDao conduceDao;
    RodamientoDao rodamientoDao;

    public ConduceControlador(ConduceVista conduceVista, Conduce conduce, ConduceDao conduceDao, RodamientoDao rodamientoDao) {
        this.conduceVista = conduceVista;
        this.conduce = conduce;
        this.conduceDao = conduceDao;
        this.rodamientoDao = rodamientoDao;


        this.conduceVista.btnGuardar.addActionListener(this);
        this.conduceVista.btnEliminar.addActionListener(this);
        this.conduceVista.btnLimpiar.addActionListener(this);
    }

    public int totalNumero() {
        Integer numero = conduce.getC_conduce();
        String x = Integer.toString(numero);
        return x.length();

    }


    @Override
    public void tfClear() {
        this.conduceVista.tfConduce.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == conduceVista.btnGuardar) {
            if(conduceVista.tfConduce.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Hay campos vacios");
            }else{
                String idvehiculo;
                String[] dato;
                idvehiculo = conduceVista.vehiculo.getSelectedItem().toString();
                dato = idvehiculo.split(" - ");
                conduce.setVehiculo_id(Integer.parseInt(dato[0]));
                System.out.println("conduce" + conduceVista.vehiculo.getSelectedIndex());
                conduce.setC_conduce(Integer.parseInt(conduceVista.tfConduce.getText()));
                if (totalNumero() !=7) {
                    JOptionPane.showMessageDialog(null, "El conduce debe tener 7 digitos, este contiene: " + totalNumero() );
                }else if(conduceDao.guardarConduce(conduce)) {
                        JOptionPane.showMessageDialog(null, "Registro guardado");
                        tfClear();
                        conduceDao.cargarConduces();
                        rodamientoDao.cargarlista();
                }else{
                    JOptionPane.showMessageDialog(null, "No relaciono el conduce");
                }
            }
        }
    }

}
