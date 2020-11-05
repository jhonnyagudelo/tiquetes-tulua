package com.tiquetes.Dao;

import com.tiquetes.Modelos.*;
import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Vistas.TiquetesVista;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class TiquetesDao {

    TiquetesVista tiquetesVista;

    public TiquetesDao(TiquetesVista tiquetesVista) {
        this.tiquetesVista = tiquetesVista;
        listaVehiculos();
        listaDestino();
        listaOrigen();
    }

    public void listaDestino() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.tiquetesVista.dcbmD.removeAllElements();
        try {
            String SQL = "SELECT id, nombre FROM destino ORDER BY id";
            ps = connect.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                tiquetesVista.s_destino.addItem(new Destino(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Error SQL destino " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Error destino " + e.getMessage());
        }
    }

    public void listaOrigen() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.tiquetesVista.dcbm.removeAllElements();
        try {
            String SQL = "SELECT id, nombre FROM origen ORDER BY id";
            ps = connect.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                tiquetesVista.s_origen.addItem(new Destino(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.printf("Error SQL destino " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("Error destino " + e.getMessage());
        }
    }

    public void listaVehiculos() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.tiquetesVista.selectVehicle.removeAllItems();
        try {
            String SQL = "SELECT " +
                    "       v.id " +
                    "       ,v.n_interno\n" +
                    "    FROM vehiculo v\n" +
                    "        INNER JOIN rodamiento r\n" +
                    "            ON r.vehiculo_id = v.id\n" +
                    "    WHERE TRUE\n" +
                    "        AND CURRENT_DATE::TIMESTAMP <= r.created_at\n" +
                    "        AND r.h_salida >= CURRENT_TIME\n" +
                    "        AND r.h_salida IS NOT NULL\n" +
                    "        ORDER BY r.id;";
            ps = connect.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                tiquetesVista.selectVehicle.addItem(new Vehiculo(
                        rs.getInt("id"),
                        rs.getInt("n_interno"))
                );
            }
            System.out.println();
            rs.close();
        } catch (SQLException es) {
            System.out.println("Error al cargar la lista: " + es.getMessage());
        } catch (Exception es) {
            es.printStackTrace();
            System.out.println("Error Modelo: " + es.getMessage());
        }
    }

    // cargar ventas;
    public void cargarTablaVenta() {

        DataBaseConexion conn = new DataBaseConexion();
        CallableStatement cs;
        ResultSet rs;
        Vector<Object> row;
        for (int i = this.tiquetesVista.dtm.getRowCount(); i > 0; i--) {
            this.tiquetesVista.dtm.removeRow(i - 1);
        }
        try {
            String query = " SELECT * FROM m_tiquetes()";
            cs = conn.getConn().prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                row = new Vector<Object>();
                row.add(rs.getInt("interno"));
                row.add(rs.getTime("salida"));
                row.add(rs.getString("destino"));
                row.add(rs.getInt("cantidad"));
                this.tiquetesVista.dtm.addRow(row);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error SQL al cargar los Datos venta" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al cargar los DATOS venta", "Informacion", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al cargar los Datos venta: " + e.getMessage());
        }
    }

}