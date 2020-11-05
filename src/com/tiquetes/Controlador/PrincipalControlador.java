package com.tiquetes.Controlador;

import com.google.zxing.WriterException;
import com.tiquetes.Dao.*;
import com.tiquetes.Modelos.*;
import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Utilidades.Pdf;
import com.tiquetes.Utilidades.QrImg;
import com.tiquetes.Vistas.ConduceVista;
import com.tiquetes.Vistas.RodamientoVista;
import com.tiquetes.Vistas.SesionVista;
import com.tiquetes.Vistas.TiquetesVista;

public class PrincipalControlador {


    public static void main(String[] args) throws WriterException {
        new DataBaseConexion("tiquetes_actualizacion");

        //Sesion
        Sesion sesion = new Sesion();
        SesionVista sesionVista = new SesionVista();
        LoginDao loginDao = new LoginDao();
        TiquetesVista tiquetesVista = new TiquetesVista();

        //Rodamiento
        Rodamiento rodamiento = new Rodamiento();
        RodamientoVista rodamientoVista = new RodamientoVista();
        RodamientoDao rodamientoDao = new RodamientoDao(rodamientoVista);

        //conduce
        Conduce conduce = new Conduce();
        ConduceVista conduceVista = new ConduceVista();
        ConduceDao conduceDao = new ConduceDao(conduceVista);

        Tiquete tiquete = new Tiquete();
        Tiquete_detalle tiquete_detalle = new Tiquete_detalle();
        TiqueteDetalleDao tiqueteDetalleDao = new TiqueteDetalleDao();
        TiquetesDao tiquetesDao = new TiquetesDao(tiquetesVista);
        QrImg qrImg = new QrImg();
        Qr qr = new Qr();
        QrDao qrDao = new QrDao();
        Venta venta = new Venta();

        Pdf pdf = new Pdf(qrDao, sesion);






        SesionControllador sc = new SesionControllador(sesion,loginDao,sesionVista,tiquetesVista,rodamientoVista);
        RodamientoControlador rc = new RodamientoControlador(rodamientoVista,rodamiento,rodamientoDao, tiquetesDao);
        ConduceControlador cc = new ConduceControlador(conduceVista, conduce, conduceDao, rodamientoDao);
        MenuControlador mc = new MenuControlador(conduceVista,rodamientoVista, tiquetesVista,sesion);
        TiqueteControlador tc = new TiqueteControlador(tiquetesVista,tiquete_detalle,tiquete, qr,pdf,qrImg,tiqueteDetalleDao, tiquetesDao, qrDao);

    }
}
