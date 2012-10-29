/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;

/**
 *
 * @author fifin
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyEvent;

public class numberfield extends  JTextField {

    private Paint paint;

    private Shape shape;

    private boolean fokus;

    private Paint glass;
    aplikasitoko.fungsi fsu;

    public numberfield() {
        
        setFont(new java.awt.Font("Arial", 0, 25));
        setOpaque(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        fsu = new aplikasitoko.fungsi();
        setHorizontalAlignment(RIGHT);

        addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                setFokus(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setFokus(false);
            }
        });
        
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e){
                try {
                    Integer.valueOf(getText().replace(".", ""));
                    if (getText().charAt(0)=='0'&&getText().length()>1)
                        setText(String.valueOf(getText().charAt(1)));
                    setText(fsu.digitNomor(getText().replace(".", "")));
                } catch (Exception ex) {
                    setText("0");
                }
               
            }
        });
    }

    public boolean isFokus() {
        return fokus;
    }

    public void setFokus(boolean fokus) {
        this.fokus = fokus;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gd = (Graphics2D) g.create();

        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), getHeight(), getWidth());

        if (isFokus()) {
            setForeground(Color.RED);
            paint = new GradientPaint(0, 0, Color.YELLOW , getWidth(), 0, Color.YELLOW);
        } else {
            setForeground(Color.BLACK);
            paint = new GradientPaint(0, 0, Color.white, getWidth(), 0, Color.white);
        }

        gd.setPaint(paint);
        gd.fill(shape);

        super.paintComponent(g);

        glass = new GradientPaint(0, 0, new Color(1F, 1F, 1F, 0.5F), 0, getHeight(), new Color(1F, 1F, 1F, 0F));
        gd.setPaint(glass);
        gd.fill(shape);

        gd.dispose();
    }
}
