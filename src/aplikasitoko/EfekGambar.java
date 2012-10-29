/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;

/**
 *
 * @author amy
 */

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * 
 * @author usu
 */
public final class EfekGambar {

    public static final BufferedImage getBuffered(Image source) {
        int width = source.getWidth(null);
        int height = source.getHeight(null);
        BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = (Graphics2D) dest.getGraphics();
        g2.drawImage(source, 0, 0, null);
        g2.dispose();

        return dest;
    }

    public static final BufferedImage getEfekKaca(BufferedImage source) {

        BufferedImage dest = new BufferedImage(source.getWidth(), source.getHeight() + source.getHeight() / 2, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = (Graphics2D) dest.getGraphics();
        g2.drawImage(source, 0, 10, null);
        g2.scale(1, -1);
        //g2.drawImage(source, 0, -source.getHeight() * 2, null);
        g2.scale(1, -1);
        g2.translate(0, source.getHeight());
        g2.setPaint(new GradientPaint(0, 0, Color.BLUE, 0, source.getHeight() / 2,
                Color.white));
        g2.setComposite(AlphaComposite.DstIn);
        g2.fillRect(0, 0, source.getWidth(), source.getHeight());
        g2.dispose();

        return dest;
    }

    public static final BufferedImage getEfekKaca(Image source) {
        return EfekGambar.getEfekKaca(EfekGambar.getBuffered(source));
    }
}
