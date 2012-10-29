/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package aplikasitoko.aplikasi;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author fifin
 */
public class imageGlass extends JPanel {
    private Image image;

    public imageGlass() {
        image=new ImageIcon(getClass().getResource("/aplikasitoko/gambar/pantai.jpg")).getImage();
    }

    public Image getImage() {
        return image;
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g);
        if (getImage() != null) {
            for (int i = 0; i < getWidth(); i += getImage().getWidth(null)) {
                for (int j = 0; j < getHeight(); j += getImage().getHeight(null)) {
                    g2.drawImage(getImage(), i, j, null);
                }
            }
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        Graphics2D g2 = (Graphics2D) g.create();

        Color dark = new Color(1F, 0F, 0F, 0F);
        Color light = new Color(1F, 0F, 0F, 0.5F);
        GradientPaint paint = new GradientPaint(0, 0, light, 0, getHeight() / 2, dark);

        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
    
}
