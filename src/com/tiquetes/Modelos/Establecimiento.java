package com.tiquetes.Modelos;

public class Establecimiento {
    private Integer id;
    private String nombre;
    private Integer nit;
    private String estado;

    public Establecimiento(Integer id, String nombre, Integer nit, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.estado = estado;
    }

    public Establecimiento(){}

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

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Establecimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", estado='" + estado + '\'' +
                '}';
    }
}
