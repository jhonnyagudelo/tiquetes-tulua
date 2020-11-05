package com.tiquetes.Modelos;

public class Usuario_rol {
    private Integer id;
    private Integer usuario_id;
    private Integer rol_id;
    private String estado;

    public Usuario_rol(Integer id, Integer usuario_id, Integer rol_id, String estado) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.rol_id = rol_id;
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

    public Integer getRol_id() {
        return rol_id;
    }

    public void setRol_id(Integer rol_id) {
        this.rol_id = rol_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario_rol{" +
                "id=" + id +
                ", usuario_id=" + usuario_id +
                ", rol_id=" + rol_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
