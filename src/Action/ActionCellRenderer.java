/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ActionCellRenderer extends JPanel implements TableCellRenderer {

    public ActionCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JButton btnModifier = new JButton("✏");
        JButton btnSupprimer = new JButton("🗑");

        styliser(btnModifier, new Color(66, 133, 244));
        styliser(btnSupprimer, new Color(234, 67, 53));

        add(btnModifier);
        add(btnSupprimer);
    }

    private void styliser(JButton btn, Color bg) {
        btn.setFocusable(false);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder(3, 6, 3, 6));
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setEnabled(false); // désactivé pour éviter le clic
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        return this;
    }
}
