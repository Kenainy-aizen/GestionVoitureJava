/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
    private final JButton btnModifier = new JButton("✏ Modifier");
    private final JButton btnSupprimer = new JButton("🗑 Supprimer");

    public ActionCellEditor(JTable table) {
        styliser(btnModifier, new Color(66, 133, 244));
        styliser(btnSupprimer, new Color(234, 67, 53));

        panel.add(btnModifier);
        panel.add(btnSupprimer);

        btnModifier.addActionListener(e -> {
            int row = table.getEditingRow();
            JOptionPane.showMessageDialog(null, "Modifier ligne : " + row);
            fireEditingStopped();
        });

        btnSupprimer.addActionListener(e -> {
            int row = table.getEditingRow();
            JOptionPane.showMessageDialog(null, "Supprimer ligne : " + row);
            fireEditingStopped();
        });
    }

    private void styliser(JButton btn, Color bg) {
        btn.setFocusable(false);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder(3, 6, 3, 6));
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
