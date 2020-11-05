package com.tiquetes.Modelos.Db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConexion {

    private final String USER = "postgres";
    private final String LOCALHOST = "localhost:5432";
    private final String PASSWORD = "1113645020";
    private  String SERVER = "";
    private final String URL = "jdbc:postgresql://localhost:5432/tiquetes_actualizacion";
    private static Connection conn = null;

    public DataBaseConexion(String tiquetes_actualizacion){
        this.SERVER = "jdbc:postgresql://"+this.LOCALHOST+"/"+tiquetes_actualizacion;
        //Registrar el driver
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(this.SERVER,this.USER,this.PASSWORD);

        } catch(ClassNotFoundException e){
            System.out.println("Error al registrar driver");
            System.exit(0);
            JOptionPane.showMessageDialog(null,"Error al registrar driver"+ e.getMessage());
        } catch (SQLException e){
            System.out.println("Error al conectar con el servidor");
            System.exit(0);
            JOptionPane.showMessageDialog(null,"Error al conectar con el servidor"+ e.getMessage());
        }
        System.out.println("Conectado a " + tiquetes_actualizacion);
    }

    public DataBaseConexion() {

    }

    public Connection getConn(){
        System.out.println("Connected to the PosgreSQL");
        return conn;
    }
    public void disconnect(){
        System.out.println("Disconnect to the PosgreSQL");
        conn = null;
    }

}
