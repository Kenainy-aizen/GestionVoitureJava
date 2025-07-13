/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class table extends JTable{
    
    public table() {
      setShowHorizontalLines(true);
      setRowHeight(50);
      getTableHeader().setReorderingAllowed(false);
      getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer () {
          @Override
          public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
              tableHeader header = new tableHeader(o + "");
              header.setHorizontalAlignment(JLabel.CENTER);
              
              return header;
          }
      });
    }
    
}
