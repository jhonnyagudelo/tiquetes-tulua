package com.tiquetes.Modelos;

public class Tiquete_detalle {
    private Integer id;
    private Integer tiquete_id;
    private Integer origen_id;
    private Integer destino_id;
    private Integer cantidad;
    private String estado;
    private Integer n_tiquete;
    private Integer vehiculo;


    public Tiquete_detalle() {
    }

    public Tiquete_detalle(Integer id, Integer tiquete_id, Integer origen_id, Integer destino_id, Integer cantidad, String estado, Integer n_tiquete, Integer vehiculo) {
        this.id = id;
        this.tiquete_id = tiquete_id;
        this.origen_id = origen_id;
        this.destino_id = destino_id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.n_tiquete = n_tiquete;
        this.vehiculo = vehiculo;
    }


    public Integer getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Integer vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTiquete_id() {
        return tiquete_id;
    }

    public void setTiquete_id(Integer tiquete_id) {
        this.tiquete_id = tiquete_id;
    }

    public Integer getOrigen_id() {
        return origen_id;
    }

    public void setOrigen_id(Integer origen_id) {
        this.origen_id = origen_id;
    }

    public Integer getDestino_id() {
        return destino_id;
    }

    public void setDestino_id(Integer destino_id) {
        this.destino_id = destino_id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getN_tiquete() {
        return n_tiquete;
    }

    public void setN_tiquete(Integer n_tiquete) {
        this.n_tiquete = n_tiquete;
    }

    @Override
    public String toString() {
        return "Tiquete_detalle{" +
                "id=" + id +
                ", tiquete_id=" + tiquete_id +
                ", origen_id=" + origen_id +
                ", destino_id=" + destino_id +
                ", cantidad=" + cantidad +
                ", estado='" + estado + '\'' +
                ", n_tiquete=" + n_tiquete +
                '}';
    }
}
