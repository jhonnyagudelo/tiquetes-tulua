package com.tiquetes.Dao;

import com.tiquetes.Modelos.Conduce;
import com.tiquetes.Modelos.Db.DataBaseConexion;
import com.tiquetes.Modelos.Vehiculo;
import com.tiquetes.Vistas.ConduceVista;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class ConduceDao {
    private ConduceVista conduceVista;

    public ConduceDao(ConduceVista conduceVista) {
        this.conduceVista = conduceVista;
        l_vehiculo();
        cargarConduces();
    }

    public void l_vehiculo() {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connection = conn.getConn();
        PreparedStatement ps;
        ResultSet rs;
        this.conduceVista.dcVehiculo.removeAllElements();
        try {
            String SQL = "SELECT id, n_interno FROM vehiculo ORDER BY id";
            ps = connection.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()) {
                conduceVista.vehiculo.addItem( new Vehiculo(
                        rs.getInt("id"),
                        rs.getInt("n_interno"))
                );

            }
            rs.close();
        } catch (SQLException e) {
            System.out.printf("Error al cargar vehiculos " + e.getMessage());
        } catch (Exception e) {
            System.out.printf("Error vehiculos " + e.getMessage());
        }
    }

    public void cargarConduces() {

        DataBaseConexion conn = new DataBaseConexion();
        CallableStatement cs;
        ResultSet rs;
        Vector<Object> row;
        for (int i = this.conduceVista.dtm.getRowCount(); i > 0; i--) {
            this.conduceVista.dtm.removeRow(i - 1);
        }
        try {

            String query = "SELECT * FROM m_conduce()";
            cs = conn.getConn().prepareCall(query);
            rs = cs.executeQuery();

            while (rs.next()) {
                row = new Vector<Object>();
                row.add(rs.getInt("vehiculo"));
                row.add(rs.getInt("conduce"));
                this.conduceVista.dtm.addRow(row);

            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar los conduces" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al cargar los conduces", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean guardarConduce(Conduce conduce) {
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        PreparedStatement pstmt;
        String SQL = "SELECT g_conduce(?, ?)";
        ResultSet rs;
        try{
            pstmt = connect.prepareStatement(SQL);
            pstmt.setInt(2, conduce.getC_conduce());
            pstmt.setInt(1, conduce.getVehiculo_id());
            rs = pstmt.executeQuery();
            System.out.println("el resultado es: " + pstmt);
            LOGGER.log(Level.INFO,"Enlazando conduce");
            rs.close();
            return  true;
        }catch (SQLException e){
            System.out.println("Error SQL al ingresar conduce: " + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al ingresar conduce: " + e.getMessage() );
        }

        return false;
    }


    public boolean delete(Conduce conduce) {
        PreparedStatement ps = null;
        DataBaseConexion conn = new DataBaseConexion();
        Connection connect = conn.getConn();
        String SQL = "DELETE FROM tickets WHERE ticket_id = ?";
        try {
            ps = connect.prepareStatement(SQL);
            ps.setInt(1, conduce.getId());
            ps.execute();
            return true;
        } catch (SQLException e1) {
            System.out.println("Error al borrar conduce " + e1.getMessage());
        }
        conn.disconnect();
        return false;
    }

}
