package com.tiquetes.Modelos;

public class Conduce  {
    private Integer id;
    private Integer c_conduce;
    private Integer vehiculo_id;
    private String estado;


    public Conduce() {

    }

    public Conduce(Integer id, Integer c_conduce, Integer vehiculo_id, String estado) {
        this.id = id;
        this.c_conduce = c_conduce;
        this.vehiculo_id = vehiculo_id;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getC_conduce() {
        return c_conduce;
    }

    public void setC_conduce(Integer c_conduce) {
        this.c_conduce = c_conduce;
    }

    public Integer getVehiculo_id() {
        return vehiculo_id;
    }

    public void setVehiculo_id(Integer vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    private void Totalnumero() {

    }


    @Override
    public String toString() {
        return "Conduce{" +
                "id=" + id +
                ", c_conduce=" + c_conduce +
                ", vehiculo_id=" + vehiculo_id +
                ", estado='" + estado + '\'' +
                '}';
    }

}
