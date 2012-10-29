/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;

/**
 *
 * @author amy
 */

import java.awt.Color;
import java.awt.Component;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author usu
 */
public class pagingCombo implements ListCellRenderer {

    private Random generator = new Random();

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel(value.toString());
        label.setFont(new java.awt.Font("Arial", 1, 25));
        label.setOpaque(true);
        if (isSelected) {
            label.setForeground(Color.RED);
            label.setBackground(Color.WHITE);
        } else {
            label.setForeground(new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255)));
            label.setBackground(new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255)));
        }

        return label;
    }
}