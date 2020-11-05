package com.tiquetes.Controlador;

import com.tiquetes.Dao.QrDao;
import com.tiquetes.Dao.TiqueteDetalleDao;
import com.tiquetes.Dao.TiquetesDao;
import com.tiquetes.Modelos.*;
import com.tiquetes.Utilidades.Pdf;
import com.tiquetes.Utilidades.QrImg;
import com.tiquetes.Vistas.TiquetesVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;

public class TiqueteControlador implements ActionListener, Implementos {
    TiquetesVista tiquetesVista;
    Tiquete_detalle tiquete_detalle;
    TiqueteDetalleDao tiqueteDetalleDao;
    Tiquete tiquete;
    TiquetesDao tiquetesDao;
    Qr qr;
    Pdf pdf;
    QrImg qrImg;
    QrDao qrDao;


    public TiqueteControlador(TiquetesVista tiquetesVista, Tiquete_detalle tiquete_detalle, Tiquete tiquete, Qr qr, Pdf pdf, QrImg qrImg, TiqueteDetalleDao tiqueteDetalleDao, TiquetesDao tiquetesDao, QrDao qrDao) {
        this.tiquetesVista = tiquetesVista;
        this.tiquete_detalle = tiquete_detalle;
        this.tiquete = tiquete;
        this.tiquetesDao = tiquetesDao;
        this.tiqueteDetalleDao = tiqueteDetalleDao;
        this.qr = qr;
        this.pdf = pdf;
        this.qrImg = qrImg;
        this.qrDao = qrDao;


        this.tiquetesVista.btnComprar.addActionListener(this);
        this.tiquetesVista.btnEliminar.addActionListener(this);
        this.tiquetesVista.btnLimpiar.addActionListener(this);
//        this.tiquetesVista.btnUpdate.addActionListener(this);
    }

    @Override
    public void tfClear() {
        tiquetesVista.tfCantidad.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tiquetesVista.btnComprar) {
            if (tiquetesVista.tfCantidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Colocar la cantidad de tiquetes");
            } else {
                String idvehiculo;
                String[] dato;
                idvehiculo = tiquetesVista.selectVehicle.getSelectedItem().toString();
                dato = idvehiculo.split(" - ");
                tiquete_detalle.setVehiculo(Integer.parseInt(dato[0]));
                System.out.println(dato[0]);
                tiquete_detalle.setOrigen_id(tiquetesVista.s_origen.getSelectedIndex());
                tiquete_detalle.setDestino_id(tiquetesVista.s_destino.getSelectedIndex());
                tiquete_detalle.setCantidad(Integer.parseInt(tiquetesVista.tfCantidad.getText()));
                if (tiqueteDetalleDao.insertarDetalle(tiquete_detalle)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    tfClear();
                    tiquetesDao.cargarTablaVenta();
                    qrImg.qrImagen(qrDao.datoQr());
                    qrDao.datostiquete();
                    Integer n_tiquete = tiquete_detalle.getCantidad();
                    while (n_tiquete <= 3 ){
                        if (tiquete_detalle.getCantidad() > 0) {
                            for (int i = 0; i < tiquete_detalle.getCantidad(); i++) {
                                try {
                                    pdf.printTicket();
                                } catch (IOException ex) {
                                    System.out.println("Venta: " + ex.getMessage());
                                } catch (PrinterException ex) {
                                    System.out.println("Venta1: " + ex.getMessage());
                                }
                            }
                            n_tiquete++;
                        } else {
                            JOptionPane.showMessageDialog(null, "Registro no guardado");
                            tfClear();
                        }
                    }

                }
            }
        }
    }
}
