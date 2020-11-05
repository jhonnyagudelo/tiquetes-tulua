package com.tiquetes.Dao;

import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Modelos.Tiquete_detalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TiqueteDetalleDao {
    public TiqueteDetalleDao() {
    }

    public boolean insertarDetalle(Tiquete_detalle tiquete_detalle) {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connection = conn.getConn();
        PreparedStatement st = null;
        ResultSet rs;

        String SQL = "                    INSERT INTO tiquete_detalle\n" +
                "                        (tiquete_id, origen_id, destino_id, cantidad)\n" +
                "                        SELECT max(t_k.id), \n" +
                "                                ?, \n" +
                "                                ?, \n" +
                "                                ?\n" +
                "                            FROM tiquete t_k\n" +
                "                                INNER JOIN rodamiento r\n" +
                "                                    ON t_k.rodamiento_id = r.id\n" +
                "                                INNER JOIN vehiculo v\n" +
                "                                    ON v.id = r.vehiculo_id\n" +
                "                                WHERE TRUE\n" +
                "                                    AND CURRENT_DATE::timestamp <= t_k.created_at\n" +
                "                                    AND r.vehiculo_id = ?\n" +
                "                                    GROUP BY t_k.rodamiento_id;";
        try{
            st = connection.prepareStatement(SQL);
            st.setInt(1,tiquete_detalle.getOrigen_id());
            st.setInt(2,tiquete_detalle.getDestino_id());
            st.setInt(3,tiquete_detalle.getCantidad());
            st.setInt(4,tiquete_detalle.getVehiculo());
            st.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error SQL al ingresar venta: " + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al ingresar venta: " + e.getMessage() );
        }
        return false;
    }



}
