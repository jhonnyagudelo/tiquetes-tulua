package com.tiquetes.Modelos;

import java.util.Date;

public class Exportacion extends Tiquete{
    private Date f_inicio;
    private Date f_fin;
    private Integer rodamiento_id;

    public Exportacion(Date f_inicio, Date f_fin) {
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
    }

    public Exportacion(Date f_inicio, Date f_fin, Integer rodamiento_id) {
        super(rodamiento_id);
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
    }

    public Date getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Date f_inicio) {
        this.f_inicio = f_inicio;
    }

    public Date getF_fin() {
        return f_fin;
    }

    public void setF_fin(Date f_fin) {
        this.f_fin = f_fin;
    }

    @Override
    public Integer getRodamiento_id() {
        return rodamiento_id;
    }

    @Override
    public void setRodamiento_id(Integer rodamiento_id) {
        this.rodamiento_id = rodamiento_id;
    }

    @Override
    public String toString() {
        return "Exportacion{" +
                "f_inicio=" + f_inicio +
                ", f_fin=" + f_fin +
                ", rodamiento_id=" + rodamiento_id +
                '}';
    }
}
