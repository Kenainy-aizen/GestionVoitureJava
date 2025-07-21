package form;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import testelogin1.ConnexionBD;

public class form_recette extends javax.swing.JPanel {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
  
    public form_recette() {
        
        initComponents();
        conn = ConnexionBD.conexion();
        affichage();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.panelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRecette = new swing.table();
        jLabel1 = new javax.swing.JLabel();

        tableRecette.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableRecette);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setText("Recette accumule par mois");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

     public void affichage() {
        
        try {
        
             ps = conn.prepareStatement("SET lc_time_names = 'fr_FR'");
             ps.execute();
         //   String query1 = "SELECT * FROM VOITURE";
           // String query = "SELECT DATE_FORMAT(A.date, '%Y-%m') AS Mois , SUM(A.qte * V.prix) AS 'Recette Totale'  FROM ACHAT A JOIN VOITURE V ON A.idvoit = V.idvoit WHERE A.date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH) GROUP BY DATE_FORMAT(A.date, '%Y-%m') ORDER BY mois DESC";
           String query = "SELECT DATE_FORMAT(A.date, '%M %Y') AS Mois, CONCAT(FORMAT(SUM(A.qte * V.prix), 0), ' Ar') AS 'Recette Totale' FROM ACHAT A JOIN VOITURE V ON A.idvoit = V.idvoit WHERE A.date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH) GROUP BY DATE_FORMAT(A.date, '%Y-%m') ORDER BY A.date DESC";

           
           ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
             tableRecette.setModel(DbUtils.resultSetToTableModel(rs));
              // Centrer le contenu
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            centerRenderer.setFont(new Font("SansSerif", Font.BOLD, 30));

            for (int i = 0; i < tableRecette.getColumnCount(); i++) {
                tableRecette.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
            
               // Supprimer les lignes verticales
            tableRecette.setShowVerticalLines(false);
            tableRecette.setShowHorizontalLines(true);
            tableRecette.getTableHeader().setReorderingAllowed(false); 
            tableRecette.setGridColor(Color.LIGHT_GRAY);
            
                
            Font font = new Font("SansSerif", Font.BOLD, 20); // nom, style, taille
            tableRecette.setFont(font);

              
            Font headerFont = new Font("SansSerif", Font.BOLD, 16);
            tableRecette.getTableHeader().setFont(headerFont);
            tableRecette.setGridColor(new Color(200, 200, 200));
            tableRecette.setRowHeight(50);
            
            
       
        } catch (Exception e) {
            System.out.println("---> Exception " +e);
        }
     }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.panelBorder panelBorder1;
    private swing.table tableRecette;
    // End of variables declaration//GEN-END:variables
}
