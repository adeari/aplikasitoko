/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.aplikasi;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author amy
 */
public class labelklip extends JLabel {
    private int distance;
    private Color dropShadowColor;
    public labelklip() {
        super();
        setDistance(3);
        setForeground(Color.WHITE);
        setDropShadowColor(Color.RED);
    }
    public int getDistance() {
        return distance;
    }

    public Color getDropShadowColor() {
        return dropShadowColor;
    }

    public void setDropShadowColor(Color dropShadowColor) {
        this.dropShadowColor = dropShadowColor;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    

    protected void paintComponent(Graphics g) {
        FontMetrics metric = getFontMetrics(getFont());

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(getFont());
        g2.setColor(getDropShadowColor());
        g2.drawString(getText(), getDistance(), metric.getHeight() - getDistance());
        g2.setColor(getForeground());
        g2.drawString(getText(), 3, metric.getHeight());
        
    }

}
