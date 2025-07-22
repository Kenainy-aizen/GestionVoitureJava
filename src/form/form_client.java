/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import boite.ajoutClient;
import boite.modifClient;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import testelogin1.ConnexionBD;
public class form_client extends javax.swing.JPanel {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String idCli = "";
    String nom = "";
    String email = "";
    
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
        jLabel1 = new javax.swing.JLabel();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        header1 = new component.header();

        setOpaque(false);
        setLayout(null);

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
        tableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClient);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("LISTES DES CLIENTS");

        supprimer.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        supprimer.setText("Supprimer");
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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(604, 604, 604)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(ajouter)
                .addGap(420, 420, 420)
                .addComponent(supprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
            .addComponent(jScrollPane1)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajouter)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modifier)
                        .addComponent(supprimer)))
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(panelBorder1);
        panelBorder1.setBounds(0, 65, 1570, 640);
        add(header1);
        header1.setBounds(0, 6, 1570, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
         
            java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);

            ajoutClient dialog = new ajoutClient(parent, true);  

            dialog.setLocationRelativeTo(parent);

            dialog.setVisible(true);

            affichage();
            
    }//GEN-LAST:event_ajouterActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        
        try {
            String requete1 = "DELETE FROM ACHAT WHERE idcli = ? ";
            ps = conn.prepareStatement(requete1);
            ps.setString(1, idCli);
            ps.executeUpdate();
            
        }catch (Exception e) {
            System.out.println("--> Exception " +e);
        }
        
        try {
            String requete = "DELETE FROM CLIENT WHERE idcli = ? ";
            ps = conn.prepareStatement(requete);           
            ps.setString(1,idCli);
            ps.executeUpdate();
            
            
            
        } catch (Exception e ) {
            System.out.println("---> Exception " +e);
        }
       
        affichage();
        idCli = "";
        nom = "";
        email = "";
    }//GEN-LAST:event_supprimerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        
            java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
            modifClient dialog = new modifClient(parent, true);  
            dialog.setLocationRelativeTo(parent);
            dialog.setVisible(true);

            affichage();
    }//GEN-LAST:event_modifierActionPerformed

    private void tableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientMouseClicked
         DefaultTableModel model = (DefaultTableModel)tableClient.getModel();
         int Myindex = tableClient.getSelectedRow();
         
         this.idCli = model.getValueAt(Myindex, 0).toString();
         nom = model.getValueAt(Myindex, 1).toString();
         email = model.getValueAt(Myindex, 2).toString();
         
         System.out.println(idCli+","+nom+","+email);
         
         
    }//GEN-LAST:event_tableClientMouseClicked
   
    public void affichage () {
        try {
            String requete = "SELECT idcli as 'ID client', nom as 'Nom', mail as 'E-mail' , contact as 'Contact' FROM CLIENT";
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
            tableClient.setShowHorizontalLines(true);
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
    
     public String getValeurId() {
        return idCli;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private component.header header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private swing.panelBorder panelBorder1;
    private javax.swing.JButton supprimer;
    private swing.table tableClient;
    // End of variables declaration//GEN-END:variables
}
