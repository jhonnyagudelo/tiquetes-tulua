package com.tiquetes.Modelos;

import java.sql.Timestamp;

public class Usuario {
    private Integer id;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String username;
    private Integer establecimiento_id;
    private String  estado;

    public Usuario(){}


    public Usuario(Integer id, String nombre, String apellido, String contrasena, String username, Integer establecimiento_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.username = username;
        this.establecimiento_id = establecimiento_id;
    }

    public Usuario(Integer id, String nombre, String apellido, String contrasena, String username, Integer establecimiento_id, String estado) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.username = username;
        this.establecimiento_id = establecimiento_id;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", username='" + username + '\'' +
                ", establecimiento_id=" + establecimiento_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
