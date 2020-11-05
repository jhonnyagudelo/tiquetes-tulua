package com.tiquetes.Dao;

public class DatoQr {
    private String establecimiento;
    private String destino;

    public DatoQr() {
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return  establecimiento + ',' +  destino;
    }
}
