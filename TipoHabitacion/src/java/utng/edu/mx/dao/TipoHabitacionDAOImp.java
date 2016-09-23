/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utng.edu.mx.modelo.TipoHabitacion;
import utng.edu.mx.util.UtilDB;


/**
 *
 * @author jony
 */
public class TipoHabitacionDAOImp implements TipoHabitacionDAO {

    private Connection connection;

    public TipoHabitacionDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {
            String query = "INSERT INTO tipo_habitaciones (nombre,descripcion,capacidad,precio,hotel) "
                    + " values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tipoHabitacion.getNombre());
            ps.setString(2, tipoHabitacion.getDescripcion());
            ps.setInt(3, tipoHabitacion.getCapacidad());
            ps.setInt(4, tipoHabitacion.getPrecio());
            ps.setString(5, tipoHabitacion.getHotel());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarTipoHabitacion(int id_TipoHabitacion) {
        try {
            String query = "DELETE FROM tipo_habitaciones WHERE "
                    + " id_tipo_habitacion = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_TipoHabitacion);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void cambiarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        try {
            String query = "UPDATE tipo_habitaciones  SET "
                    + "nombre = ?"
                    + ",descripcion = ?"
                    + ",capacidad = ?"
                    + ",precio = ?"
                    + ",hotel = ? "
                    + "WHERE id_tipo_habitacion = ?";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tipoHabitacion.getNombre());
            ps.setString(2, tipoHabitacion.getDescripcion());
            ps.setInt(3, tipoHabitacion.getCapacidad());
            ps.setInt(4, tipoHabitacion.getPrecio());
            ps.setString(5, tipoHabitacion.getHotel());
            ps.setInt(6, tipoHabitacion.getId_tipoHabitacion());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TipoHabitacion> desplegarTipoHabitacion() {
        List<TipoHabitacion> tipoHabitaciones = new ArrayList<TipoHabitacion>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tipo_habitaciones ");
            while (rs.next()) {
                TipoHabitacion tipoHabitacion = new TipoHabitacion(
                        rs.getInt("id_tipo_habitacion")
                        , rs.getString("nombre")
                        , rs.getString("descripcion")
                        , rs.getInt("capacidad")
                        , rs.getInt("precio")
                        , rs.getString("hotel"));

                tipoHabitaciones.add(tipoHabitacion);
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoHabitaciones;
    }

    @Override
    public TipoHabitacion elegirTipoHabitacion(int id_TipoHabitacion) {
        TipoHabitacion tipoHabitacion = null;
        try {
            String query = "SELECT * FROM tipo_habitaciones WHERE id_tipo_habitacion = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id_TipoHabitacion);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                tipoHabitacion = new TipoHabitacion(
                        rs.getInt("id_tipo_habitacion")
                        , rs.getString("nombre")
                        , rs.getString("descripcion")
                        , rs.getInt("capacidad")
                        , rs.getInt("precio")
                        , rs.getString("hotel"));
            }
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoHabitacion;
    }

}
