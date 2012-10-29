package aplikasitoko.aplikasi;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;

/**
 *
 * @author usu
 */
public class glasspanel extends JPanel {

    public glasspanel() {
        super();
        setLayout(null);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
        addKeyListener(new KeyAdapter() {
        });
    }

    public void showPanel(JPanel panel, int lebar,int tinggi) {
        removeAll();
        add(panel);
        panel.setBounds(100, 100, lebar, tinggi);
    }
    
    public void showPanelii(JPanel panel, int x,int y, int lebar,int tinggi) {
        removeAll();
        add(panel);
        panel.setBounds(x, y, lebar, tinggi);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        GradientPaint paint = new GradientPaint(0, 0, Color.WHITE, getWidth(), getHeight(), Color.BLACK);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setComposite(AlphaComposite.SrcOver.derive(0.7F));
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
