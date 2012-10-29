/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;

/**
 *
 * @author fifin
 */
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelImageAlpaUser  extends JPanel  {
    private Image image;

    public panelImageAlpaUser() {
        setOpaque(false);
        image = new ImageIcon(getClass().getResource("/aplikasitoko/gambar/ada3user.gif")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();

        gd.setComposite(AlphaComposite.SrcOver.derive(0.3F));
        gd.drawImage(image, 0, 0, null);

        gd.dispose();
    }
}
