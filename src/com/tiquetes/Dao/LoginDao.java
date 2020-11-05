package com.tiquetes.Dao;
import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Modelos.Sesion;
import com.tiquetes.Modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class LoginDao {
    public LoginDao(){

    }

    public boolean autUsuario(Sesion login) {
        PreparedStatement st;
        DataBaseConexion conn = new DataBaseConexion();
        Connection conexion = conn.getConn();
        ResultSet rs;
        String SQL = "SELECT \n" +
                "       u.username\n" +
                "       ,initcap(u.nombre)\n" +
                "       ,u.contrasena\n" +
                "       ,u.estado\n" +
                "       ,u.apellido\n" +
                "       ,u.id\n" +
                "       ,r.nombre\n" +
                "   FROM usuario u\n" +
                "       INNER JOIN usuario_rol u_r\n" +
                "           ON u.id = u_r.usuario_id\n " +
                "       INNER JOIN rol r\n" +
                "           ON r.id = u_r.rol_id" +
                "       WHERE TRUE \n" +
                "           AND u.username = ?\n" +
                "           AND u.contrasena = ?\n" +
                "           AND u.estado = 'Activo'\n" +
                "           LIMIT 1";

        try {

            st = conexion.prepareStatement(SQL);
            st.setString(1,login.getUsername());
            st.setString(2,login.getContrasena());
            rs = st.executeQuery();
            if (rs.next()) {
                if (login.getContrasena().equals(rs.getString(3))){
                    //Agregar de la tabla sesion;
                    login.setUsername(rs.getString(1));
                    login.setNombre(rs.getString(2));
                    login.setApellido(rs.getString(5));

                    String insert = "INSERT INTO sesion (usuario_id) \n" +
                            "    SELECT\n" +
                            "        ( SELECT id FROM usuario WHERE username = ?);";

                    st = conexion.prepareStatement(insert);
                    st.setString(1,login.getUsername());
                    st.execute();
                    rs.close();
                    LOGGER.log(Level.INFO, "Buscando usuario");
//                    System.out.println(st);
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        }catch (SQLException e){
            System.out.println("usuario: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exepcíon de usuario: " + e.getMessage());
        }
        return  false;
    }
}
