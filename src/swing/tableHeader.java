/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class tableHeader extends JLabel{
    public tableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(0, 102, 204));
        setFont(new Font("SansSerif",Font.BOLD,30));
        setForeground(Color.white);
        setBorder(new EmptyBorder(10,5,10,5));
    }
}
