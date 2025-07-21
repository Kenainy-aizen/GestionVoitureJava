
package form;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import testelogin1.ConnexionBD;

public class form_facture extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(form_facture.class.getName());
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    
    public form_facture() {
        initComponents();
        conn = ConnexionBD.conexion();
        affichage();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.panelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFacture = new swing.table();
        header1 = new component.header();
        pdf = new javax.swing.JButton();
        envoyeEmail = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));

        tableFacture.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableFacture);

        pdf.setText("Pdf");

        envoyeEmail.setText("Envoyer Email");
        envoyeEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyeEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1284, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(envoyeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(envoyeEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void envoyeEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyeEmailActionPerformed
        
    }//GEN-LAST:event_envoyeEmailActionPerformed

    public void affichage() {
            
        try { 
            String requete = "SELECT A.numAchat as 'Numero client', C.nom as 'Nom', C.mail as 'Email', SUM(A.qte * V.prix) as 'Montant total', A.date as 'Date' FROM ACHAT A JOIN CLIENT C on A.idcli = C.idcli JOIN VOITURE V on A.idvoit = V.idvoit GROUP BY A.numAchat, C.nom, C.mail, A.date ORDER BY A.numAchat ASC ";
            ps = conn.prepareStatement(requete);            
            rs = ps.executeQuery();
            tableFacture.setModel(DbUtils.resultSetToTableModel(rs));
                 
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
             centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
             centerRenderer.setFont(new Font("SansSerif", Font.BOLD, 30));
            for (int i = 0; i < tableFacture.getColumnCount(); i++) {
            tableFacture.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // Supprimer les lignes verticales
            tableFacture.setShowVerticalLines(false);
            tableFacture.setShowHorizontalLines(true); // Optionnel
            tableFacture.getTableHeader().setReorderingAllowed(false); 
            tableFacture.setGridColor(Color.LIGHT_GRAY);
            
                
            Font font = new Font("SansSerif", Font.BOLD, 20); // nom, style, taille
            tableFacture.setFont(font);

            tableFacture.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            Font headerFont = new Font("SansSerif", Font.BOLD, 16);
            tableFacture.getTableHeader().setFont(headerFont);
            tableFacture.setGridColor(new Color(200, 200, 200));

              
            tableFacture.setRowHeight(50);
            
        
        }catch (Exception e) {
            System.out.println("--> Exception "+e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(() -> new form_facture().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton envoyeEmail;
    private component.header header1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.panelBorder panelBorder1;
    private javax.swing.JButton pdf;
    private swing.table tableFacture;
    // End of variables declaration//GEN-END:variables
}
