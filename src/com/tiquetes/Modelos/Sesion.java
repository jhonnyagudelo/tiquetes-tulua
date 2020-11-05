package com.tiquetes.Modelos;

import java.sql.Timestamp;

public class Sesion extends Usuario {
    private Integer id;
    private Integer usuario_id;
    private String estado;


    public Sesion(){}

    public Sesion(Integer id, String nombre, String apellido, String contrasena, String username, Integer establecimiento_id, Integer id1, Integer usuario_id, String estado) {
        super(id, nombre, apellido, contrasena, username, establecimiento_id);
        this.id = id1;
        this.usuario_id = usuario_id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }


    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "id=" + id +
                ", usuario_id=" + usuario_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
