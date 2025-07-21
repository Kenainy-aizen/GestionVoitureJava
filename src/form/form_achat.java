/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import boite.ajoutAchat;
import boite.modifAchat;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import testelogin1.ConnexionBD;

public class form_achat extends javax.swing.JPanel {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String numAchat = "";
    String idCli = "";
    String idVoit = "";
    String date = "";
    String nb = "";
 
    
    public form_achat() {
        initComponents();
        conn = ConnexionBD.conexion();
        affichage();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new component.header();
        panelBorder1 = new swing.panelBorder();
        ajouter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entreDeux = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAchat = new swing.table();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        ajouter.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("LISTES DES ACHATS");

        supprimer.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supprimerMouseClicked(evt);
            }
        });
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 18)); // NOI18N
        jLabel2.setText("Premier date :");

        jLabel3.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 18)); // NOI18N
        jLabel3.setText("Deuxieme date :");

        entreDeux.setBackground(new java.awt.Color(0, 153, 102));
        entreDeux.setFont(new java.awt.Font("Andale Mono", 1, 18)); // NOI18N
        entreDeux.setText("rechercher");
        entreDeux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entreDeuxActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        tableAchat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero achat", "ID client", "ID voiture", "Date", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAchatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAchat);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(ajouter)
                                .addGap(222, 222, 222)
                                .addComponent(supprimer)
                                .addGap(222, 222, 222)
                                .addComponent(modifier))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(571, 571, 571)
                                .addComponent(jLabel1))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(259, 259, 259)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(entreDeux)))
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supprimer)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(entreDeux, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(header1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1509, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
 
          java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);          
          ajoutAchat dialog = new ajoutAchat(parent, true);   
          dialog.setLocationRelativeTo(parent);                
          dialog.setVisible(true);           
          affichage();
          
    }//GEN-LAST:event_ajouterActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);          
          modifAchat dialog = new modifAchat(parent, true);   
          dialog.setLocationRelativeTo(parent);                
          dialog.setVisible(true);           
          affichage();
    }//GEN-LAST:event_modifierActionPerformed

    private void tableAchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAchatMouseClicked
         DefaultTableModel model = (DefaultTableModel)tableAchat.getModel();
         int Myindex = tableAchat.getSelectedRow();
         
         this.numAchat = model.getValueAt(Myindex, 0).toString();
         idCli = model.getValueAt(Myindex, 1).toString();
         idVoit = model.getValueAt(Myindex, 2).toString();
         date = model.getValueAt(Myindex, 3).toString();
         nb = model.getValueAt(Myindex, 4).toString();
         
         
         System.out.println(idCli+","+idVoit+","+date+","+nb);
    }//GEN-LAST:event_tableAchatMouseClicked

    private void supprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supprimerMouseClicked
        try {
            
            String requete = "DELETE FROM ACHAT WHERE numAchat = ?";
            ps = conn.prepareStatement(requete);
            ps.setString(1, numAchat);
            ps.executeUpdate();
            
        } catch(Exception e) {
            System.out.println("---> Exception " +e);
        }
                
        affichage();
    }//GEN-LAST:event_supprimerMouseClicked

    private void entreDeuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entreDeuxActionPerformed
        java.util.Date utilDate = date1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(utilDate);
        
        java.util.Date utilDate1 = date2.getDate();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = sdf1.format(utilDate);
        
        
        try {
            String requete = "SELECT * FROM ACHAT WHERE Date BETWEEN ? and ? ";
            ps = conn.prepareStatement(requete);
            ps.setString(1, date1);
            ps.setString(2, date2);
            rs = ps.executeQuery();
            
                tableAchat.setModel(DbUtils.resultSetToTableModel(rs));
              
        // Centrer le contenu
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                centerRenderer.setFont(new Font("SansSerif", Font.BOLD, 30));

                for (int i = 0; i < tableAchat.getColumnCount(); i++) {
                    tableAchat.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                tableAchat.setRowHeight(50);

            
        } catch(Exception e) {
            System.out.println("--> Exception " +e);
        }
    }//GEN-LAST:event_entreDeuxActionPerformed

    
    public void affichage() {
        
        try {
            String query = "SELECT numAchat as 'Numero Achat', idcli as 'ID client', idvoit as 'ID voiture', Date as 'Date', qte as 'nombre' FROM ACHAT";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            tableAchat.setModel(DbUtils.resultSetToTableModel(rs));
            
              
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
             centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
             centerRenderer.setFont(new Font("SansSerif", Font.BOLD, 30));
            for (int i = 0; i < tableAchat.getColumnCount(); i++) {
            tableAchat.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // Supprimer les lignes verticales
            tableAchat.setShowVerticalLines(false);
            tableAchat.setShowHorizontalLines(true);
            tableAchat.getTableHeader().setReorderingAllowed(false); 
            tableAchat.setGridColor(Color.LIGHT_GRAY);
            
                
            Font font = new Font("SansSerif", Font.BOLD, 20); // nom, style, taille
            tableAchat.setFont(font);

              
            Font headerFont = new Font("SansSerif", Font.BOLD, 16);
            tableAchat.getTableHeader().setFont(headerFont);
            tableAchat.setGridColor(new Color(200, 200, 200));

              
            tableAchat.setRowHeight(50);
            
            
        } catch(Exception e) {
            
            System.out.println("---> Exception " +e);
            
        }
        
    }

    public String getNumAchat() {
        return numAchat;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JButton entreDeux;
    private component.header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifier;
    private swing.panelBorder panelBorder1;
    private javax.swing.JButton supprimer;
    private swing.table tableAchat;
    // End of variables declaration//GEN-END:variables
}
