package com.tiquetes.Modelos;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class Tiquete {
    private Integer id;
    private Integer rodamiento_id;
    private Date f_compra;
    private Timer h_compra;
    private String estado;


    public Tiquete(Integer id, Integer rodamiento_id, Date f_compra, Timer h_compra, String estado) {
        this.id = id;
        this.rodamiento_id = rodamiento_id;
        this.f_compra = f_compra;
        this.h_compra = h_compra;
        this.estado = estado;
    }

    public Tiquete() {
    }


    public Tiquete(Integer rodamiento_id) {
        this.rodamiento_id = rodamiento_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRodamiento_id() {
        return rodamiento_id;
    }

    public void setRodamiento_id(Integer rodamiento_id) {
        this.rodamiento_id = rodamiento_id;
    }

    public Date getF_compra() {
        return f_compra;
    }

    public void setF_compra(Date f_compra) {
        this.f_compra = f_compra;
    }

    public Timer getH_compra() {
        return h_compra;
    }

    public void setH_compra(Timer h_compra) {
        this.h_compra = h_compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tiquete{" +
                "id=" + id +
                ", rodamiento_id=" + rodamiento_id +
                ", f_compra=" + f_compra +
                ", h_compra=" + h_compra +
                ", estado='" + estado + '\'' +
                '}';
    }
}
