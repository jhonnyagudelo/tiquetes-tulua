package com.tiquetes.Dao;

import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Modelos.Qr;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class QrDao {

    public QrDao() {

    }

    public Qr datoQr() {
        DataBaseConexion conn = new DataBaseConexion();
        CallableStatement ct;
        ResultSet rs;
        Qr qr = null;
        final String  SQL = "SELECT * FROM imprimir_qr()";
        try{
            ct = conn.getConn().prepareCall(SQL);
            rs  = ct.executeQuery();
            while (rs.next()){
                qr = new Qr();
                qr.setFecha(rs.getString("fecha"));
                qr.setHora(rs.getString("hora"));
                qr.setC_empresa(rs.getInt("nit"));
                qr.setPlaca(rs.getString("placa"));
                qr.setOrigen(rs.getInt("origen"));
                qr.setDestino(rs.getInt("destino"));
                qr.setConduce(rs.getInt("conduce"));
                qr.setId(rs.getInt("n_qr"));
                System.out.println("Qr: " + qr);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("datos Qr" + e.getMessage());
        }

        return qr;
    }

    public DatoQr datostiquete() {
        DataBaseConexion conn = new DataBaseConexion();
        CallableStatement  cs;
        ResultSet rs;
        DatoQr datoQr = null;
        String SQL = "SELECT * FROM datostiquete()";
        try {
            cs = conn.getConn().prepareCall(SQL);
            rs = cs.executeQuery();
            while (rs.next()){
                datoQr = new DatoQr();
                datoQr.setEstablecimiento(rs.getString("establecimiento"));
                datoQr.setDestino(rs.getString("destino"));
                System.out.println("hola: " + datoQr);
            }
        }catch (Exception e){
            System.out.println("datos tickets: " + e.getMessage());
        }
        return datoQr;
    }

}

