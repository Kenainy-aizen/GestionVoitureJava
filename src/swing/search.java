
package swing;

import java.awt.Color;
import java.awt.FontMetrics;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.EmptyBorder;

public class search extends JTextField{
    public search() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(220, 204, 182));
        
    }
    private final String hint = "Search here . . .";
    
    @Override
   
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        if (getText().isEmpty()) {
            int h = getHeight();
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            Insets ins = getInsets();
            FontMetrics fm = g2.getFontMetrics();

            int c0 = getBackground().getRGB();
            int c1 = getBackground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);

            //g2.setColor(new Color(c2, true));
            g2.setColor(Color.GRAY);

            
            g2.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

}
