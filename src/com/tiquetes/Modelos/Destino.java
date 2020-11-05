package com.tiquetes.Modelos;

public class Destino {
    private Integer id;
    private String nombre;
    private Integer c_codigo;
    private String estado;

    public Destino(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Destino(Integer id, String nombre, Integer c_codigo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.c_codigo = c_codigo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getC_codigo() {
        return c_codigo;
    }

    public void setC_codigo(Integer c_codigo) {
        this.c_codigo = c_codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id +" - " + nombre;
    }
}
