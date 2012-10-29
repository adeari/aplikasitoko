/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
/**
 *
 * @author fifin
 */
public class panelalpa extends JPanel {
    private Color warna;
    public panelalpa(){
        setOpaque(false);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), 
                getBackground().getBlue(),130);
        
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        warna = new Color(getBackground().getRed(), getBackground().getGreen(), 
                getBackground().getBlue(),80);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D gd = (Graphics2D)grphcs.create();
        gd.setColor(warna);
        //gd.fillRect(0, 0, getWidth(), getHeight());
        //gd.fill3DRect(0, 0, getWidth(), getHeight(), false);
        //gd.fillOval(0, 0, getWidth(), getHeight());
        gd.fillRoundRect(0, 0, getWidth(), getHeight(), 80, 80);
        gd.dispose();
    }
    
}
