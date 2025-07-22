/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package boite;

//import com.lowagie.text.Font; // ✅ iText (lowagie)
//import com.lowagie.text.FontFactory;
//
//import com.lowagie.text.*;
//import com.lowagie.text.pdf.*;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
//import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import testelogin1.ConnexionBD;

/**
 *
 * @author kenainy
 */
public class ajoutAchat extends javax.swing.JDialog {
    
    private int totalGlobal = 0;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ajoutAchat.class.getName());
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement Ps = null;
    public ajoutAchat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String[] columnNames = {"Désignation", "Quantité", "Prix Unitaire", "Total"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tableUnAchat.setModel(model);
        conn = ConnexionBD.conexion();
        date.setDate(new java.util.Date());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idVoiture = new javax.swing.JTextField();
        numAchat = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        suivant = new javax.swing.JButton();
        ajout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        idClient = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUnAchat = new swing.table();
        totalLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        jLabel1.setText("ID Client                :");

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        jLabel2.setText("ID Voiture             :");

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        jLabel3.setText("Date                        :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        jLabel4.setText("Nombre                 :");

        idVoiture.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        idVoiture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idVoitureActionPerformed(evt);
            }
        });

        numAchat.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        numAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numAchatActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 36)); // NOI18N
        jLabel5.setText("AJOUT ACHAT");

        suivant.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        suivant.setText("Client suivant");
        suivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suivantActionPerformed(evt);
            }
        });

        ajout.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        ajout.setText("OK");
        ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable Static Display", 1, 18)); // NOI18N
        jLabel6.setText("Numero Achat   :");

        idClient.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        idClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClientActionPerformed(evt);
            }
        });

        tableUnAchat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableUnAchat);

        totalLabel.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        totalLabel.setText("0 ar");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel7.setText("Total  des achats :");

        pdf.setText("pdf");
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(93, 93, 93)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idVoiture)
                                        .addComponent(idClient, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(suivant, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60)
                                    .addComponent(ajout))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pdf)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idClient, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idVoiture, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suivant)
                            .addComponent(ajout))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(pdf)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idVoitureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idVoitureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idVoitureActionPerformed

    private void numAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numAchatActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void suivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suivantActionPerformed
      
        // Vider toutes les lignes du tableau sans supprimer l'entête
        DefaultTableModel model = (DefaultTableModel) tableUnAchat.getModel();
        model.setRowCount(0);

        // Vider les champs de saisie sauf la date
        idVoiture.setText("");
        nombre.setText("");
        idClient.setText("");
        numAchat.setText("");
        totalGlobal = 0;
        totalLabel.setText("0 Ar");

        // Redonner le focus au premier champ si tu veux
        idVoiture.requestFocus();

    }//GEN-LAST:event_suivantActionPerformed

    private void ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutActionPerformed
                                        
                                          
    Date utilDate = date.getDate();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dateAchat = sdf.format(utilDate);

    try {
        String texteQte = nombre.getText().trim();
        
           if (texteQte.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Veuillez remplir le champ de quantité.",
                "Champ vide",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int qte;
        try {
            qte = Integer.parseInt(texteQte);
            if (qte <= 0) {
                JOptionPane.showMessageDialog(this,
                    "La quantité doit être supérieure à zéro.",
                    "Quantité invalide",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Veuillez saisir un nombre entier valide pour la quantité.",
                "Format incorrect",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
   
        
        
        // 1. Récupération des infos de la voiture
        String query = "SELECT Design, prix, nombre FROM VOITURE WHERE idvoit = ?";
        Ps = conn.prepareStatement(query);
        Ps.setString(1, idVoiture.getText());
        rs = Ps.executeQuery();

        if (rs.next()) {
            String designation = rs.getString("Design");
            int prixUnitaire = rs.getInt("prix");
            int stockDisponible = rs.getInt("nombre");

           // int qte = Integer.parseInt(nombre.getText());
            
           

            // Vérification de stock
            if (qte > stockDisponible) {
                JOptionPane.showMessageDialog(this, "Stock insuffisant : seulement " + stockDisponible + " voitures disponibles.");
                return;
            }

//            if (prixUnitaire >= 50_000_000) {
//                JOptionPane.showMessageDialog(this, "Achat refusé : le prix unitaire dépasse 50 000 000 Ar !");
//                return;
//            }

            int total = prixUnitaire * qte;

//            if (total >= 50_000_000) {
//                JOptionPane.showMessageDialog(this, "Achat refusé : le total de cette ligne dépasse 50 000 000 Ar !");
//                return;
//            }

//            if (totalGlobal + total >= 50_000_000) {
//                JOptionPane.showMessageDialog(this, "Achat refusé : le total global dépasse 50 000 000 Ar !");
//                return;
//            }
//            
            

            // 2. Insertion dans la table ACHAT
            String requete = "INSERT INTO ACHAT (numAchat, idcli, idvoit, date, qte) VALUES (?, ?, ?, ?, ?)";
            Ps = conn.prepareStatement(requete);
            Ps.setString(1, numAchat.getText());
            Ps.setString(2, idClient.getText());
            Ps.setString(3, idVoiture.getText());
            Ps.setString(4, dateAchat);
            Ps.setString(5, nombre.getText());
            Ps.executeUpdate();
            Ps.close();

            
            // 3. Mise à jour du stock
            String updateQuery = "UPDATE VOITURE SET nombre = nombre - ? WHERE idvoit = ?";
            PreparedStatement psUpdate = conn.prepareStatement(updateQuery);
            psUpdate.setInt(1, qte);
            psUpdate.setString(2, idVoiture.getText());
            psUpdate.executeUpdate();
            psUpdate.close();

            // 4. Ajout à la table graphique
            DefaultTableModel model = (DefaultTableModel) tableUnAchat.getModel();
            model.addRow(new Object[]{
                designation,
                qte,
                String.format("%,d Ar", prixUnitaire),
                String.format("%,d Ar", total)
            });

            totalGlobal += total;
            totalLabel.setText(String.format("%,d Ar", totalGlobal));

            // Mise en forme de la table
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            centerRenderer.setFont(new Font("SansSerif", Font.BOLD, 30));

            for (int i = 0; i < tableUnAchat.getColumnCount(); i++) {
                tableUnAchat.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            tableUnAchat.setShowHorizontalLines(true);
            tableUnAchat.getTableHeader().setReorderingAllowed(false);
            tableUnAchat.setGridColor(Color.LIGHT_GRAY);

            Font font = new Font("SansSerif", Font.BOLD, 20);
            tableUnAchat.setFont(font);

            Font headerFont = new Font("SansSerif", Font.BOLD, 16);
            tableUnAchat.getTableHeader().setFont(headerFont);
            tableUnAchat.setGridColor(new Color(200, 200, 200));

        } else {
            JOptionPane.showMessageDialog(this, "Voiture introuvable !");
        }

    } catch (Exception e) {
        System.out.println("---> Exception " + e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (Ps != null) Ps.close();
        } catch (Exception e) {
            System.out.println("--> Exception " + e);
        }
    }
    }//GEN-LAST:event_ajoutActionPerformed

    private void idClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClientActionPerformed
        
    }//GEN-LAST:event_idClientActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
       genererFacturePDF(numAchat.getText());
    }//GEN-LAST:event_pdfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ajoutAchat dialog = new ajoutAchat(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
  
    
public void genererFacturePDF(String numAchat) {
    try {
        
        Ps = conn.prepareStatement("SET lc_time_names = 'fr_FR'");
        Ps.execute();// 1. Infos client + date
        String infoClientSQL = "SELECT DATE_FORMAT(A.date, '%d %M %Y') AS dateFacturation, C.nom as nomClient, C.contact as contact FROM ACHAT A JOIN CLIENT C on A.idcli = C.idcli WHERE A.numAchat = ? LIMIT 1";

        PreparedStatement ps1 = conn.prepareStatement(infoClientSQL);
        ps1.setString(1, numAchat);
        ResultSet rs1 = ps1.executeQuery();

        String dateFacturation = "", nomClient = "", contact = "";
        if (rs1.next()) {
            dateFacturation = rs1.getString("dateFacturation");
            nomClient = rs1.getString("nomClient");
            contact = rs1.getString("contact");
        }

        // 2. Création du PDF
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("facture_" + numAchat + ".pdf"));
        document.open();

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
        Paragraph title = new Paragraph("FACTURE DE N*"+numAchat, font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" "));

        document.add(new Paragraph("Date de facturation : " + dateFacturation));
        document.add(new Paragraph("Nom du Client : " + nomClient));
        document.add(new Paragraph("Contact : " + contact));
        document.add(new Paragraph(" "));

        // 3. Récupérer les lignes de produits
        String produitsSQL = "SELECT V.Design AS Design, A.qte AS nombre, V.prix AS prix, (A.qte * V.prix) AS total FROM ACHAT A JOIN VOITURE V ON A.idvoit = V.idvoit WHERE A.numAchat = ? ORDER BY V.Design";
        PreparedStatement ps2 = conn.prepareStatement(produitsSQL);
        ps2.setString(1, numAchat);
        ResultSet rs2 = ps2.executeQuery();

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{4, 2, 3, 3});

        table.addCell("Désignation");
        table.addCell("Quantité");
        table.addCell("Prix Unitaire");
        table.addCell("Total");

        int totalGlobal = 0;
        while (rs2.next()) {
              table.addCell(rs2.getString("Design"));
              table.addCell(rs2.getString("nombre"));
              String prix = String.format("%,d Ar", rs2.getInt("prix"));     // ← Prix avec "Ar"
              String total = String.format("%,d Ar", rs2.getInt("total"));
              table.addCell(prix);
              table.addCell(total);
              totalGlobal += rs2.getInt("total");
        }

        document.add(table);
        document.add(new Paragraph(" "));

        com.lowagie.text.Font totalFont = new com.lowagie.text.Font(com.lowagie.text.Font.HELVETICA, 14, com.lowagie.text.Font.BOLD);
        Paragraph total = new Paragraph("Total général : " + String.format("%,d Ar", totalGlobal), totalFont);
        total.setAlignment(Element.ALIGN_RIGHT);
        document.add(total);

        document.close();
        JOptionPane.showMessageDialog(null, "Facture générée avec succès : facture_" + numAchat + ".pdf");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erreur génération PDF : " + e.getMessage());
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajout;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField idClient;
    private javax.swing.JTextField idVoiture;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField numAchat;
    private javax.swing.JButton pdf;
    private javax.swing.JButton suivant;
    private swing.table tableUnAchat;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
