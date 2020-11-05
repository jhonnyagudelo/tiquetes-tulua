package com.tiquetes.Modelos;

public class Dato_qr {
    private String establecimiento;
    private String destino;

    public Dato_qr(){
    }

    public Dato_qr(String establecimiento, String destino) {
        this.establecimiento = establecimiento;
        this.destino = destino;

    }

    public String getestablecimiento() {
        return establecimiento;
    }

    public void setestablecimiento( String nombre) {
        establecimiento = nombre;
    }

    public String getdestino() {
        return destino;
    }

    public void setdestino(String nombre) {
        destino = nombre;
    }

    @Override
    public String toString() {
        return establecimiento + ',' + destino;
    }
}
