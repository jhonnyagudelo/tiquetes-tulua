package com.tiquetes.Dao;

import com.tiquetes.Modelos.Tiquete_detalle;

import java.util.ArrayList;

public class Venta {
    private ArrayList<Tiquete_detalle> arregloTiquete;



    public Venta() {
        arregloTiquete = new ArrayList<Tiquete_detalle>();
    }

    public ArrayList<Tiquete_detalle> getTiquetes(){
        return arregloTiquete;
    }
}
