package com.tiquetes.Modelos;

public class Vehiculo {
    private Integer id;
    private Integer n_interno;
    private String placa;
    private Integer capacidad;
    private Integer establecimiento_id;
    private String  estado;

    public Vehiculo(){}


    public Vehiculo(Integer id, Integer n_interno) {
        this.id = id;
        this.n_interno = n_interno;
    }

    public Vehiculo(Integer id, Integer n_interno, String placa, Integer capacidad, Integer establecimiento_id, String estado) {
        this.id = id;
        this.n_interno = n_interno;
        this.placa = placa;
        this.capacidad = capacidad;
        this.establecimiento_id = establecimiento_id;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getN_interno() {
        return n_interno;
    }

    public void setN_interno(Integer n_interno) {
        this.n_interno = n_interno;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getEstablecimiento_id() {
        return establecimiento_id;
    }

    public void setEstablecimiento_id(Integer establecimiento_id) {
        this.establecimiento_id = establecimiento_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    @Override
    public String toString() {
        return id + " - " + n_interno  ;
    }
}
