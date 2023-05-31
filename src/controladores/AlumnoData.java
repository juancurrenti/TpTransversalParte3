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
import transversalparte2.Entity.Alumno;

/**
 *
 * @author Ariana
 */
public class AlumnoData {
    private Connection connection = null;

    public AlumnoData() {
        try {
            connection = Conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarAlumno(Alumno alumno){
    String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
    try{
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, alumno.getDNI());
        ps.setString(2, alumno.getApellido());
        ps.setString(3, alumno.getNombre());
        ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
        ps.setBoolean(5, alumno.estado());
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            //Esto va en la vista, debe ir un cartelito que diga "si se creo el alumno"
            alumno.setIdAlumno(rs.getInt(1));
                            JOptionPane.showMessageDialog(null, "Alumno aÃ±adido con exito.");
        }else{
            //Esto va en la vista, debe ir un cartelito de "no se creo el alumno"
                            JOptionPane.showMessageDialog(null, "El alumno no fue aÃ±adido.");
        }
        ps.close();
        
        
    }catch(SQLException ex){
      //En la vista va un cartelito que diga "no se puedo ejecutar la consulta"
                  JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex);
    }
    
}
    public Alumno buscarAlumno(int id){
        Alumno alumno = new Alumno();
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE idAlumno = ?";
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno.setIdAlumno(id);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDNI(rs.getInt("dni"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(Utils.intToBool(rs.getBoolean("estado")));
                
                
            }else{
                //en vistas, cartelito que diga "no se pudo buscar el alumno" o "no existe el alumno"
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
            
        }catch(SQLException ex){
            //cartelito "error en buscar alumno"
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
        return alumno;
    }
    public void borrarAlumno(int id){
            
            String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ";
            try {
                int fila;
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    fila = ps.executeUpdate();
                }
            if(fila==1){
                JOptionPane.showMessageDialog(null, " Se eliminÃ³ el alumno.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
    }
    
    public Alumno actualizarAlumno(Alumno alumno){
                String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fechaNacimiento = ?, estado = ? WHERE  idAlumno = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, alumno.getDNI());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(6, alumno.getIdAlumno());
            ps.setBoolean(5, alumno.getEstado());
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex);
        }
        return alumno;
    }
    public List<Alumno> listarAlumnos() {

        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1 ;";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    
                    alumno.setIdAlumno(rs.getInt("idAlumno"));
                    alumno.setDNI(rs.getInt("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    alumno.setEstado(Utils.intToBool(rs.getBoolean("estado")));
                    alumnos.add(alumno);
                }
            }

        } catch (SQLException ex) {
            // mensajito de error en vista
        }
        return alumnos;
    }
      
    
}
