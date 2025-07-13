/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import testelogin1.ConnexionBD;
public class form_client extends javax.swing.JPanel {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
      
    public form_client() {
        initComponents();
        conn = ConnexionBD.conexion();
        affichage();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.panelBorder();
        ajouter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClient = new swing.table();
        header1 = new component.header();

        setOpaque(false);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        ajouter.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        tableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Client", "Nom", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableClient);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ajouter)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        ajoutClient act = new ajoutClient();
        act.setVisible(true);
        affichage();
    }//GEN-LAST:event_ajouterActionPerformed
    public void affichage () {
        try {
            String requete = "SELECT idcli as 'ID client', nom as 'Nom', mail as 'E-mail' FROM CLIENT";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            
            tableClient.setModel(DbUtils.resultSetToTableModel(rs));
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
             centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
             centerRenderer.setFont(new Font("SansSerif", Font.BOLD, 30));
            for (int i = 0; i < tableClient.getColumnCount(); i++) {
            tableClient.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // Supprimer les lignes verticales
            tableClient.setShowVerticalLines(false);
            tableClient.setShowHorizontalLines(true); // Optionnel
            tableClient.getTableHeader().setReorderingAllowed(false); 
            tableClient.setGridColor(Color.LIGHT_GRAY);
            
                
            Font font = new Font("SansSerif", Font.BOLD, 20); // nom, style, taille
            tableClient.setFont(font);

              
            Font headerFont = new Font("SansSerif", Font.BOLD, 16);
            tableClient.getTableHeader().setFont(headerFont);
            tableClient.setGridColor(new Color(200, 200, 200));

              
            tableClient.setRowHeight(50);
            
            
        } catch (Exception e) {
            System.out.println("--> Exception " +e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private component.header header1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.panelBorder panelBorder1;
    private swing.table tableClient;
    // End of variables declaration//GEN-END:variables
}
