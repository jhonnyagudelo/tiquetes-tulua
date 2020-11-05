package com.tiquetes.Dao;

import com.tiquetes.Modelos.Control;
import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Modelos.Rol;
import com.tiquetes.Modelos.Usuario;
import com.tiquetes.Vistas.AgregarUsuarioVista;
import com.tiquetes.Vistas.ConfigUsuarios;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UsuarioDao {
    AgregarUsuarioVista agregarUsuario;
    ConfigUsuarios configuracion;

    public UsuarioDao(AgregarUsuarioVista agregarUsuario, ConfigUsuarios configuracion) {
        this.agregarUsuario = agregarUsuario;
        this.configuracion = configuracion;
        listaControl();
        listaRol();
        listaUsuario();
    }

    public void listaRol() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connection = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.agregarUsuario.dcbmT.removeAllElements();
        final String SQL = "SELECT nombre FROM rol";
        try {
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()){
                agregarUsuario.selectControl.addItem(new Rol(
                        rs.getString("nombre")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error lista control" + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error lista control" + e.getMessage());
        }
    }


    public void listaControl() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connection = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.agregarUsuario.dcbmC.removeAllElements();
        final String SQL = "SELECT nombre FROM control";
        try {
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()){
                agregarUsuario.selectControl.addItem(new Control(
                    rs.getString("nombre")
                ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error lista control" + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error lista control" + e.getMessage());
        }
    }

    public void listaUsuario() {
        DataBaseConexion conn = new DataBaseConexion();
        PreparedStatement ps;
        Connection connection = conn.getConn();
        ResultSet rs;
        Vector<Object> dato;
        for (int i = this.configuracion.dtm.getRowCount(); i > 0; i--) {
            this.configuracion.dtm.removeRow(i - 1);
        }
        try {
            final String SQL = "SELECT \n" +
                    "    INITCAP(u.nombre)\n" +
                    "    ,INITCAP(u.apellido)\n" +
                    "    ,INITCAP(u.username)\n" +
                    "    ,INITCAP(r.nombre) AS rol\n" +
                    "    ,INITCAP(c.nombre) AS control\n" +
                    "    ,u.estado\n" +
                    "   FROM usuario u\n" +
                    "    INNER JOIN usuario_rol u_r\n" +
                    "        ON u.id = u_r.usuario_id\n" +
                    "    INNER JOIN  rol r\n" +
                    "        ON r.id = u_r.rol_id\n" +
                    "    LEFT JOIN usuario_control u_c\n" +
                    "        ON u.id = u_c.usuario_id\n" +
                    "    LEFT JOIN control c\n" +
                    "        ON c.id = u_c.control_id\n" +
                    "   WHERE TRUE;";
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()){
                dato = new Vector<Object>();
                dato.add(rs.getString("nombre"));
                dato.add(rs.getString("apellidos"));
                dato.add(rs.getString("username"));
                dato.add(rs.getString("rol"));
                dato.add(rs.getString("control"));
                this.configuracion.dtm.addRow(dato);
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("cargar usuario: " + e.getMessage());
    }

    }

    public boolean usuarioUser2(Usuario usuario) {
        PreparedStatement ps;
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        final String SQL = "INSERT INTO usuario(\n" +
                "    nombre\n" +
                "    ,apellido\n" +
                "    ,password\n" +
                "    ,username\n" +
                "    ) VALUES (\n" +
                "        initcap(?)\n" +
                "        ,initcap(?)\n" +
                "        ,?\n" +
                "        ,?\n" +
                "    )";

        try{
            ps = connect.prepareStatement(SQL);
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getApellido());
            ps.setString(3,usuario.getContrasena());
            ps.setString(4,usuario.getUsername());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println("agregar usuario query: " + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("agregar usuario: " + e.getMessage());
        }
        return false;
    }


    public boolean eliminar(Usuario usuario) {
        PreparedStatement ps;
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();

        String SQL = "DELETE FROM users WHERE username = ?";
        try {
            ps = connect.prepareStatement(SQL);
            ps.setString(1, usuario.getUsername());
            ps.execute();
            return true;
        } catch (SQLException e1) {
            System.out.println("Error delete " + e1.getMessage());
        }
        return false;
    }
}
