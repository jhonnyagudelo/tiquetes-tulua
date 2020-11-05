package com.tiquetes.Modelos;

import java.sql.Time;
import java.util.Date;

public class Qr {
    private String fecha;
    private String hora;
    private Integer c_empresa;
    private String placa;
    private Integer origen;
    private Integer destino;
    private Integer conduce;
    private Integer id;

    public Qr(String fecha, String hora, Integer c_empresa, String placa, Integer origen, Integer destino, Integer conduce, Integer id) {
        this.fecha = fecha;
        this.hora = hora;
        this.c_empresa = c_empresa;
        this.placa = placa;
        this.origen = origen;
        this.destino = destino;
        this.conduce = conduce;
        this.id = id;
    }

    public Qr() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getC_empresa() {
        return c_empresa;
    }

    public void setC_empresa(Integer c_empresa) {
        this.c_empresa = c_empresa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getOrigen() {
        return origen;
    }

    public void setOrigen(Integer origen) {
        this.origen = origen;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Integer getConduce() {
        return conduce;
    }

    public void setConduce(Integer conduce) {
        this.conduce = conduce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                fecha +
                "," + hora +
                "," + c_empresa +
                "," + placa +
                "," + origen +
                "," + destino +
                "," + conduce +
                "," + id;
    }
}

