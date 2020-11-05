package com.tiquetes.Modelos;

public class Usuario_control {
    private Integer id;
    private Integer usuario_id;
    private Integer control_id;
    private String estado;

    public Usuario_control(){

    }

    public Usuario_control(Integer usuario_id, Integer control_id) {
        this.usuario_id = usuario_id;
        this.control_id = control_id;
    }

    public Usuario_control(Integer id, Integer usuario_id, Integer control_id, String estado) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.control_id = control_id;
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

    public Integer getControl_id() {
        return control_id;
    }

    public void setControl_id(Integer control_id) {
        this.control_id = control_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario_control{" +
                "id=" + id +
                ", usuario_id=" + usuario_id +
                ", control_id=" + control_id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
