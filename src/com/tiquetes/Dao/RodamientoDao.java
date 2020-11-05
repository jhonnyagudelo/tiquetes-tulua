package com.tiquetes.Dao;

import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Modelos.Rodamiento;
import com.tiquetes.Modelos.Vehiculo;
import com.tiquetes.Vistas.RodamientoVista;

import javax.swing.*;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class RodamientoDao {

    private RodamientoVista rodamientoVista;

    public RodamientoDao(RodamientoVista rodamientoVista) {
        this.rodamientoVista = rodamientoVista;
        cargarlista();
        tablaRodamiento();
    }

    public void cargarlista() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.rodamientoVista.vehiculo.removeAllItems();
        try {
            String SQL = "SELECT DISTINCT\n" +
                    "                v.id"+
                    "                ,v.n_interno\n" +
                    "                FROM vehiculo v\n" +
                    "                INNER JOIN rodamiento r\n" +
                    "                ON v.id = r.vehiculo_id\n" +
                    "            WHERE TRUE \n" +
                    "            AND CURRENT_DATE::timestamp <= r.created_at\n" +
                    "            ORDER BY v.n_interno";
            ps = connect.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()){
                rodamientoVista.vehiculo.addItem(new Vehiculo(
                        rs.getInt("id"),
                        rs.getInt("n_interno"))
                );
            }
            System.out.println();
            rs.close();
    } catch (SQLException es) {
            System.out.println("Error al cargar la lista: " + es.getMessage() );
        } catch (Exception es) {
            es.printStackTrace();
            System.out.println("Error Modelo: " + es.getMessage());
        }
    }


    public void tablaRodamiento() {
        DataBaseConexion conn = new DataBaseConexion();
        CallableStatement cs;
        ResultSet rs;
        Vector<Object> row;
        for(int i = this.rodamientoVista.dtm.getRowCount(); i > 0; i--) {
            this.rodamientoVista.dtm.removeRow(i - 1);
        }
        try {
            String SQL = "SELECT * FROM m_rodamiento()";
            cs = conn.getConn().prepareCall(SQL);
            rs = cs.executeQuery();

            while(rs.next()) {
                row = new Vector<>();
                row.add(rs.getInt("vehiculo"));
                row.add(rs.getInt("conduce"));
                row.add(rs.getTime("salida"));
                row.add(rs.getDate("despacho"));
                row.add(rs.getString("estado"));
                this.rodamientoVista.dtm.addRow(row);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos " + e.getMessage());
            JOptionPane.showMessageDialog(null,"Error al cargar los datos", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean g_rodamiento(Rodamiento rodamiento) {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connection = conn.getConn();
        PreparedStatement st;
        String SQL = " SELECT actualizar_r(?, ?)";
        ResultSet rs;
        try {
            st = connection.prepareStatement(SQL);
            st.setTime(2, rodamiento.getH_salida());
            st.setInt(1, rodamiento.getVehiculo_id());
            rs = st.executeQuery();
            System.out.println(st);
            LOGGER.log(Level.INFO,"Actualizando rodamiento");
            rs.close();
            return true;
        }catch (SQLException e){
            System.out.println("Actualizar hora: " + e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excepcion de actualizacion: " + e.getMessage());
        }
    return false;
    }
}
