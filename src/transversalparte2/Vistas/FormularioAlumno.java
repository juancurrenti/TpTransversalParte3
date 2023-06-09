/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package transversalparte2.Vistas;

import controladores.AlumnoData;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import transversalparte2.Conexion;
import transversalparte2.Entity.Alumno;

/**
 *
 * @author User
 */
public class FormularioAlumno extends javax.swing.JInternalFrame {

    private AlumnoData alumnoData;
    private Connection conexion;

    /**
     * Creates new form FormularioAlumno
     */
    public FormularioAlumno() {
        initComponents();
        try {
            conexion = Conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormularioAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        alumnoData = new AlumnoData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtFecha = new javax.swing.JTextField();
        chActivo = new javax.swing.JCheckBox();
        btBuscar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btBorrar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel1.setText("ALUMNOS");

        jLabel2.setText("ID:");

        jLabel3.setText("NOMBRE ALUMNO:");

        jLabel4.setText("FECHA DE NAC:");

        jLabel5.setText("ACTIVO:");

        jtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIdActionPerformed(evt);
            }
        });

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btBorrar.setText("Borrar");
        btBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });

        btActualizar.setText("Actualizar");
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        jLabel6.setText("DNI:");

        jLabel7.setText("APELLIDO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btGuardar)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6))
                                    .addGap(74, 74, 74)))
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chActivo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                        .addComponent(jtDni, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(btBuscar))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btLimpiar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chActivo)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btBorrar)
                    .addComponent(btActualizar)
                    .addComponent(btLimpiar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        jtId.setText("");
        jtDni.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        jtFecha.setText("");
        chActivo.setEnabled(true);
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        int dni = Integer.parseInt(jtDni.getText());
        String apellido = jtApellido.getText();
        String nombre = jtNombre.getText();
        LocalDate fecNac = LocalDate.parse(jtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        boolean activo = chActivo.isEnabled();
        Alumno alumno = new Alumno(dni, apellido, nombre, fecNac, activo);
        alumnoData.guardarAlumno(alumno);
        jtId.setText(alumno.getIdAlumno() + "");
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBorrarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jtId.getText());
        alumnoData.borrarAlumno(id);
    }//GEN-LAST:event_btBorrarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        // TODO add your handling code here:
        if (jtId.getText() != null) {
            int dni = Integer.parseInt(jtDni.getText());
            int id = Integer.parseInt(jtId.getText());
            String apellido = jtApellido.getText();
            String nombre = jtNombre.getText();
            LocalDate fecNac = LocalDate.parse(jtFecha.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            boolean activo = chActivo.isEnabled();
            Alumno alumno = new Alumno(id, dni, apellido, nombre, fecNac, activo);
            alumnoData.actualizarAlumno(alumno);
        }
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(jtId.getText());
        Alumno alumno = alumnoData.buscarAlumno(id);
        if (alumno != null) {
            jtId.setText(jtId.getText());
            jtDni.setText(alumno.getDNI() + "");
            jtApellido.setText(alumno.getApellido());
            jtNombre.setText(alumno.getNombre());
            jtFecha.setText(alumno.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            chActivo.setSelected(alumno.getEstado());
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btBorrar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtFecha;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
