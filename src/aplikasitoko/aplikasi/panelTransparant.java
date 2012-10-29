/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.aplikasi;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
/**
 *
 * @author fifin
 */
public class panelTransparant extends JPanel {
    private Color warna;
    public panelTransparant(){
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), 
                getBackground().getBlue(),0);
        
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), 
                getBackground().getBlue(),0);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D gd = (Graphics2D)grphcs.create();
        gd.setColor(warna);
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        gd.dispose();
    }
    
}
