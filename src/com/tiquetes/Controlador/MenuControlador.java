package com.tiquetes.Controlador;

import com.tiquetes.Modelos.Sesion;
import com.tiquetes.Vistas.ConduceVista;
import com.tiquetes.Vistas.RodamientoVista;
import com.tiquetes.Vistas.TiquetesVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuControlador implements ActionListener {
    ConduceVista conduceVista;
    RodamientoVista rodamientoVista;
    TiquetesVista tiquetesVista;
    Sesion sesion;

    public MenuControlador(ConduceVista conduceVista, RodamientoVista rodamientoVista, TiquetesVista tiquetesVista, Sesion sesion) {
        this.conduceVista = conduceVista;
        this.rodamientoVista = rodamientoVista;
        this.tiquetesVista = tiquetesVista;
        this.sesion = sesion;

        //Conduce
        this.tiquetesVista.liConduce.addActionListener( this);
        this.rodamientoVista.liConduce.addActionListener( this);

        //Rodamiento
        this.tiquetesVista.liRodamiento.addActionListener(this);
        this.conduceVista.liRodamiento.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tiquetesVista.liConduce || e.getSource() == rodamientoVista.liConduce) {
            try{
                conduceVista.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
                System.out.println("menu conduce: " + e1.getMessage());
            }
        }
        if (e.getSource() == tiquetesVista.liRodamiento || e.getSource() == rodamientoVista.liRodamiento){
            try{
                rodamientoVista.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
                System.out.println("menu rodamiento: " + e1.getMessage());
            }
        }
    }
}
