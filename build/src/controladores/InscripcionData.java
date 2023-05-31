/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.sql.Connection;
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
import transversalparte2.Entity.Alumno;
import transversalparte2.Entity.Inscripcion;
import transversalparte2.Entity.Materia;

/**
 *
 * @author Ariana
 */
public class InscripcionData {

    private Connection conexion = null;
    private AlumnoData alumnoData;
    private MateriaData materiaData;

    public InscripcionData() {
        try {
            conexion = Conexion.getConexion();
            alumnoData = new AlumnoData();
            materiaData = new MateriaData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Se inscribio con Exito!");
                inscripcion.setIdInscripcion(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Fallo en la Inscripcion");
            }
            ps.close();

        } catch (SQLException ex) {
            //En la vista va un cartelito que diga "no se puedo ejecutar la consulta"
        }
    }

    public Inscripcion buscarInscripcion(int id) {
        Inscripcion inscripcion = new Inscripcion();
        String sql = "SELECT nota, idAlumno, idMateria FROM inscripcion WHERE idInscripto = ?";
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inscripcion.setIdInscripcion(id);
                inscripcion.setNota(rs.getInt("nota"));
                inscripcion.setAlumno(alumnoData.buscarAlumno(rs.getInt("idAlumno")));
                inscripcion.setMateria(materiaData.buscarMateria(rs.getInt("idMateria")));

            } else {
                System.out.println("no se encontro");
            }

        } catch (SQLException ex) {
            //cartelito "Error en buscarInscripcion"
        }
        return inscripcion;
    }

    public void updateNota(int idAlumno, int idMateria, double nota) {

        try {

            String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?;";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Nota actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "El Alumno seleccionado o la materia no existen");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar nota. " + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM inscripcion;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idInscripto");
                Inscripcion i = new Inscripcion();
                i.getIdInscripcion();

                id = rs.getInt("idAlumno");
                Alumno a = alumnoData.buscarAlumno(id);
                i.setAlumno(a);

                id = rs.getInt("idMateria");
                Materia m = materiaData.buscarMateria(id);
                i.setMateria(m);
                i.setNota(rs.getDouble("nota"));
                inscripciones.add(i); // Agregar el objeto Inscripcion a la lista
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> cursadas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripto"));

                Alumno a = alumnoData.buscarAlumno(rs.getInt("idAlumno"));
                inscripcion.setAlumno(a);

                Materia m = materiaData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setMateria(m);
                inscripcion.setNota(rs.getDouble("nota"));

                cursadas.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a Inscripcion " + ex.getMessage());
        }
        return cursadas;
    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        List<Alumno> alumnosMateria = new ArrayList<>();

        try {
            String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
                    + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND i.idMateria = ? AND a.estado = 1;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alumno alum = new Alumno();
                alum.setIdAlumno(rs.getInt("idAlumno"));
                alum.setDNI(rs.getInt("dni"));
                alum.setNombre(rs.getString("nombre"));
                alum.setApellido(rs.getString("apellido"));
                alum.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alum.setEstado(true);

                alumnosMateria.add(alum);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia." + ex.getMessage());
        }
        return alumnosMateria;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materias = new ArrayList<Materia>();
        try {
            String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion,"
                    + " materia WHERE inscripcion.idMateria = materia.idMateria\n"
                    + "AND inscripcion.idAlumno = ?;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones." + ex.getMessage());
        }
        return materias;
    }

    public List<Materia> obtenerMateriasNoCursadas(int id) {
        List<Materia> materias = new ArrayList<>();
        try {
            String sql;
            sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria not in "
                    + "(SELECT idMateria FROM inscripcion WHERE idAlumno =?);";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Acceder a la tabla Inscripcion " + ex.getMessage());
        }
        return materias;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno =? and idMateria =?;";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion Eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No existe");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion " + ex.getMessage());
        }
    }

}
