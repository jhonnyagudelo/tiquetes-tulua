package com.tiquetes.Modelos;

import java.sql.Time;
import java.util.Date;


public class Rodamiento {
    private Integer id;
    private Integer vehiculo_id;
    private Time h_salida;
    private String estado;
    private Date d_despacho;

    public Rodamiento() {
    }

    public Rodamiento(Integer id, Integer vehiculo_id, Time h_salida, String estado, Date d_despacho) {
        this.id = id;
        this.vehiculo_id = vehiculo_id;
        this.h_salida = h_salida;
        this.estado = estado;
        this.d_despacho = d_despacho;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVehiculo_id() {
        return vehiculo_id;
    }

    public Date getD_despacho() {
        return d_despacho;
    }

    public void setD_despacho(Date d_despacho) {
        this.d_despacho = d_despacho;
    }

    public void setVehiculo_id(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public Time getH_salida() {
        return h_salida;
    }

    public void setH_salida(Time h_salida) {
        this.h_salida = h_salida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


//    @Override
//    public String toString() {
//        return n_interno + "";
//    }


}
