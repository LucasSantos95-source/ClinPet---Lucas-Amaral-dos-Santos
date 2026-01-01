/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import dao.ConsultaDAO;
import model.Consulta;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import telas.Telainicial;
/**
 *
 * @author JUARES
 */
public class TelaListarConsultas extends javax.swing.JFrame {
    
    public TelaListarConsultas() {
        initComponents();
        carregarTabela();
    }
    
    @SuppressWarnings("unchecked")
    // Variables declaration
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tutor", "Pet", "Medico", "Data", "Hora"
            }
        ));
        jScrollPane1.setViewportView(tblConsultas);

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Menu inicial");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButton3)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jButton2)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(46, 46, 46))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(332, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(113, 113, 113)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int linha = tblConsultas.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma consulta!");
        return;
    }

    int id = (int) tblConsultas.getValueAt(linha, 0);

    int opcao = JOptionPane.showConfirmDialog(
        this,
        "Deseja excluir esta consulta?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION
    );

    if (opcao == JOptionPane.YES_OPTION) {
        ConsultaDAO dao = new ConsultaDAO();
        dao.excluir(id);
        carregarTabela(); // recarrega a tabela
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
Telainicial tela = new Telainicial();
    tela.setVisible(true);
    this.dispose();
    //TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConsultas;
    // End of variables declaration//GEN-END:variables

    private void carregarTabela() {
       DefaultTableModel modelo = new DefaultTableModel(
        new Object[]{"ID", "Tutor", "Pet", "Médico", "Data", "Hora"},
        0
    );

    ConsultaDAO dao = new ConsultaDAO();
    List<Consulta> lista = dao.listar();

    for (Consulta c : lista) {
        modelo.addRow(new Object[]{
            c.getIdConsulta(),
            c.getNomeTutor(),
            c.getNomePet(),
            c.getNomeMedico(),
            c.getDataConsulta(),
            c.getHoraConsulta()
        });
    }

    tblConsultas.setModel(modelo);
    }
}