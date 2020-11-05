package com.tiquetes.Controlador;

import com.tiquetes.Dao.RodamientoDao;
import com.tiquetes.Dao.TiquetesDao;
import com.tiquetes.Modelos.Rodamiento;
import com.tiquetes.Vistas.RodamientoVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//lLAMAR A UN TEXTO


public class RodamientoControlador implements ActionListener {
    RodamientoVista rodamientoVista;
    Rodamiento rodamiento;
    RodamientoDao rodamientoDao;
    TiquetesDao tiquetesDao;


    public RodamientoControlador(RodamientoVista rodamientoVista, Rodamiento rodamiento, RodamientoDao rodamientoDao, TiquetesDao tiquetesDao) {
        this.rodamientoVista = rodamientoVista;
        this.rodamiento = rodamiento;
        this.rodamientoDao = rodamientoDao;
        this.tiquetesDao = tiquetesDao;

        this.rodamientoVista.btnLimpiar.addActionListener(this);
        this.rodamientoVista.btnGuardar.addActionListener(this);
        this.rodamientoVista.btnEliminar.addActionListener(this);

    }

    public static String obtenerHoraActual() {
        String formato = ("HH:mm");
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern((formato));
        LocalDateTime ahora = LocalDateTime.now();
        return formateador.format(ahora);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rodamientoVista.btnGuardar) {
            String idvehiculo;
            String[] dato;
            idvehiculo = rodamientoVista.vehiculo.getSelectedItem().toString();
            dato = idvehiculo.split(" - ");
            rodamiento.setVehiculo_id(Integer.parseInt(dato[0]));
            rodamiento.setH_salida(Time.valueOf(rodamientoVista.tiempo.getFormatedTime()));
            System.out.println("hora actual: " + obtenerHoraActual());
            if (rodamiento.getH_salida().toString().compareTo(obtenerHoraActual())< 0 ){
                JOptionPane.showMessageDialog(null,"La hora de despacho debe ser mayor a: " + obtenerHoraActual());
            }else
                if(rodamientoDao.g_rodamiento(rodamiento)) {
                    JOptionPane.showMessageDialog(null,"Rodamiento guardao");
                    rodamientoDao.tablaRodamiento();
                    rodamientoDao.cargarlista();
                    tiquetesDao.listaVehiculos();

                }else{
                    JOptionPane.showMessageDialog(null,"Registro no guardado");
                }
            }
        if(e.getSource()==rodamientoVista.btnLimpiar) {
//            rodamientoDao.cargarlista();
        }
    }

}
