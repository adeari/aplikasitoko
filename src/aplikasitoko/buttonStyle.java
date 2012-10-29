/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
/**
 *
 * @author fifin
 */
public class buttonStyle extends JButton {

    private Paint paint;

    private Shape shape;

    private Paint glass;

    private boolean over,press;

    public buttonStyle() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setFont(new java.awt.Font("Arial", 1, 25));
        

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }
            
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }
            
            public void mouseReleased(MouseEvent e) {
                setOver(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }
        });
    }

    public boolean isOver() {
        return over;
    }
    
    public boolean isPress() {
        return press;
    }
    

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }
    
    public void setPress(boolean press) {
        this.press = press;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();

        paint = new GradientPaint(0, 0, Color.blue, 0, getHeight(), Color.blue);
        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        if (isOver()) {
                setForeground(Color.RED);
                setFont(new java.awt.Font("Arial", 1, 21));
                glass = new GradientPaint(0, 0, new Color(1F, 1F, 0F, 0F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        } else if (isPress()) {
                setForeground(Color.GREEN);
                setFont(new java.awt.Font("Arial", 1, 21));
                glass = new GradientPaint(0, 0, new Color(1F, 1F, 0F, 0F), 0, getHeight(), new Color(1F, 1F, 1F, 0.5F));
        } else {
            setForeground(Color.YELLOW);
            setFont(new java.awt.Font("Arial", 0, 20));
            glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 0F, 0F));
        }

        gd.setPaint(paint);
        gd.fill(shape);

        super.paintComponent(g);

        gd.setPaint(glass);
        gd.fill(shape);

        gd.dispose();
    }
}
