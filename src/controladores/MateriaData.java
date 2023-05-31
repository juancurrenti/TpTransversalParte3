/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transversalparte2.Conexion;
import transversalparte2.Entity.Materia;

/**
 *
 * @author Ariana
 */
public class MateriaData {

    private Connection connection = null;

    public MateriaData() {
        try {
            connection = Conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.estado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                //Esto va en la vista, debe ir un cartelito que diga "si se creo el alumno"
                materia.setIdMateria(rs.getInt(1));
            } else {
                //Esto va en la vista, debe ir un cartelito de "no se creo el alumno"
            }
            ps.close();

        } catch (SQLException ex) {
            //En la vista va un cartelito que diga "no se puedo ejecutar la consulta"
        }
    }

    public Materia buscarMateria(int id) {
        Materia materia = new Materia();
        String sql = "SELECT * FROM materia WHERE idMateria = ? AND estado = 1;";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setAnio(rs.getInt("anio"));
                materia.setNombre(rs.getString("nombre"));
                materia.setEstado(Utils.intToBool(rs.getBoolean("estado")));

            } else {
                //en vistas, cartelito que diga "no se pudo buscar el alumno" o "no existe el alumno"
                JOptionPane.showMessageDialog(null, "La materia no fue encontrada.");
            }
            ps.close();

        } catch (SQLException ex) {
            //cartelito "error en buscar alumno"
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia " + ex.getMessage());
        }
        return materia;
    }

    public void borrarMateria(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        try {
            int fila;
            try ( PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                fila = ps.executeUpdate();
            }
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminÃ³ la Materia.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia");
        }
    }

    public Materia actualizarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ?, anio = ?, estado = ? WHERE idMateria = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.getEstado());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex);
        }
        return materia;
    }

    public List<Materia> listarMaterias() {

        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1 ;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(Utils.intToBool(rs.getBoolean("estado")));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            // CARTEL DE ERROR
        }
        return materias;
    }

}
