/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ButtonRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private final JPanel panel = new JPanel();
    private final JButton btnModifier = new JButton("Modifier");
    private final JButton btnSupprimer = new JButton("Supprimer");

    public ButtonRendererEditor(JTable table) {
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panel.add(btnModifier);
        panel.add(btnSupprimer);

        btnModifier.addActionListener(e -> {
            int row = table.getEditingRow();
            // 🛠 Ajoute ici ton code pour modifier
            JOptionPane.showMessageDialog(null, "Modifier ligne : " + row);
            fireEditingStopped();
        });

        btnSupprimer.addActionListener(e -> {
            int row = table.getEditingRow();
            // 🛠 Ajoute ici ton code pour supprimer
            JOptionPane.showMessageDialog(null, "Supprimer ligne : " + row);
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}

