/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package transversalparte2.Vistas;

import controladores.AlumnoData;
import controladores.InscripcionData;
import controladores.MateriaData;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import transversalparte2.Conexion;
import transversalparte2.Entity.Alumno;
import transversalparte2.Entity.Inscripcion;
import transversalparte2.Entity.Materia;

/**
 *
 * @author User
 */
public class FormularioInscripcion extends javax.swing.JInternalFrame {

    private ArrayList<Inscripcion> listaInscripcion;
    private ArrayList<Materia> listaMateria;
    private ArrayList<Alumno> listaAlumno;

    private InscripcionData inscripcionData;
    private MateriaData materiaData;
    private AlumnoData alumnoData;
    private Connection conexion;

    private DefaultTableModel model;

    public FormularioInscripcion() {
        initComponents();

        try {
            conexion = Conexion.getConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormularioInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }

        alumnoData = new AlumnoData();
        listaAlumno = (ArrayList) alumnoData.listarAlumnos();
        model = new DefaultTableModel();
        cargarAlumno();
        armarCabeceraTabla();

        inscripcionData = new InscripcionData();

        materiaData = new MateriaData();
        listaMateria = (ArrayList<Materia>) materiaData.listarMaterias();
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
        cbAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        radioInscriptas = new javax.swing.JRadioButton();
        radioNoInscrip = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btInscribir = new javax.swing.JButton();
        btAnularInscrip = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel1.setText("FORMULARIO INSCRIPCION");

        jLabel2.setText("SELECCIONE UN ALUMNO:");

        jLabel3.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        jLabel3.setText("LISTADO DE MATERIAS");

        radioInscriptas.setText("Materias inscriptas");
        radioInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInscriptasActionPerformed(evt);
            }
        });

        radioNoInscrip.setText("Materias no inscriptas");
        radioNoInscrip.setPreferredSize(new java.awt.Dimension(116, 23));
        radioNoInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoInscripActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btInscribir.setText("INSCRIBIR");
        btInscribir.setEnabled(false);
        btInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInscribirActionPerformed(evt);
            }
        });

        btAnularInscrip.setText("ANULAR INSCRIPCION");
        btAnularInscrip.setEnabled(false);
        btAnularInscrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnularInscripActionPerformed(evt);
            }
        });

        btSalir.setText("SALIR");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(radioInscriptas)
                        .addGap(138, 138, 138)
                        .addComponent(radioNoInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btInscribir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAnularInscrip)
                                .addGap(75, 75, 75)
                                .addComponent(btSalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNoInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInscribir)
                    .addComponent(btAnularInscrip)
                    .addComponent(btSalir))
                .addGap(160, 160, 160))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInscriptasActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        radioNoInscrip.setSelected(false);
        cargarDatosInscriptas();
        btAnularInscrip.setEnabled(true);
        btInscribir.setEnabled(false);
    }//GEN-LAST:event_radioInscriptasActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void radioNoInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoInscripActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        radioInscriptas.setSelected(false);
        cargarDatosNoInscriptas();
        btAnularInscrip.setEnabled(false);
        btInscribir.setEnabled(true);
    }//GEN-LAST:event_radioNoInscripActionPerformed

    private void btInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInscribirActionPerformed
        // TODO add your handling code here:
        int fSelecc = jTable1.getSelectedRow();
        if (fSelecc != -1) {
            Alumno a = (Alumno) cbAlumno.getSelectedItem();
            int idM = (Integer) model.getValueAt(fSelecc, 0);
            String nMateria = (String) model.getValueAt(fSelecc, 1);
            int an = (Integer) model.getValueAt(fSelecc, 2);
            Materia m = new Materia(idM, nMateria, an, true);

            Inscripcion i = new Inscripcion(0, a, m,0);
            inscripcionData.guardarInscripcion(i);

            borrarFilaTabla();
        }
    }//GEN-LAST:event_btInscribirActionPerformed

    private void btAnularInscripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnularInscripActionPerformed
        // TODO add your handling code here:
        int fSelecc = jTable1.getSelectedRow();
        if (fSelecc != -1) {
            Alumno a = (Alumno) cbAlumno.getSelectedItem();
            int idMateria = (Integer) model.getValueAt(fSelecc, 0);
            inscripcionData.borrarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
            borrarFilaTabla();
        }
    }//GEN-LAST:event_btAnularInscripActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnularInscrip;
    private javax.swing.JButton btInscribir;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<Alumno> cbAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioInscriptas;
    private javax.swing.JRadioButton radioNoInscrip;
    // End of variables declaration//GEN-END:variables

    private void borrarFilaTabla() {
        int indice = model.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void cargarDatosNoInscriptas() {
        borrarFilaTabla();
        Alumno selecc = (Alumno) cbAlumno.getSelectedItem();
        listaMateria = (ArrayList) inscripcionData.obtenerMateriasNoCursadas(selecc.getIdAlumno());
        for (Materia m : listaMateria) {
                model.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
        }
    }

    private void armarCabeceraTabla() {
        ArrayList<Object> fCabecera = new ArrayList<>();
        fCabecera.add("ID");
        fCabecera.add("Nombre");
        fCabecera.add("Año");
        for (Object it : fCabecera) {
            model.addColumn(it);
        }
        jTable1.setModel(model);
    }

    private void cargarAlumno() {
        for (Alumno item : listaAlumno) {
            cbAlumno.addItem(item);
        }
    }

    private void cargarDatosInscriptas() {
        borrarFilaTabla();
        Alumno selecc = (Alumno) cbAlumno.getSelectedItem();
        List<Materia> lista = (ArrayList) inscripcionData.obtenerMateriasCursadas(selecc.getIdAlumno());
        for (Materia m : lista) {
            model.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
        }
    }
}
