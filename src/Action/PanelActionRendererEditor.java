/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class PanelActionRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
    private final JButton btnModifier = new JButton("✏ Modifier");
    private final JButton btnSupprimer = new JButton("🗑 Supprimer");

    public PanelActionRendererEditor(JTable table) {
        // Customiser les boutons
        customizeButton(btnModifier, new Color(66, 133, 244)); // Bleu Google
        customizeButton(btnSupprimer, new Color(234, 67, 53)); // Rouge Google

        // Ajouter au panel
        panel.add(btnModifier);
        panel.add(btnSupprimer);

        // Action bouton Modifier
        btnModifier.addActionListener(e -> {
            int row = table.getEditingRow();
            JOptionPane.showMessageDialog(null, "Modifier ligne : " + row);
            fireEditingStopped();
        });

        // Action bouton Supprimer
        btnSupprimer.addActionListener(e -> {
            int row = table.getEditingRow();
            JOptionPane.showMessageDialog(null, "Supprimer ligne : " + row);
            fireEditingStopped();
        });
    }

    private void customizeButton(JButton btn, Color color) {
        btn.setFocusPainted(false);
        btn.setForeground(Color.WHITE);
        btn.setBackground(color);
        btn.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // Le renderer (affichage normal)
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        return panel;
    }

    // L’éditeur (quand on clique)
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
            int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}

