/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package aplikasitoko.laporan;
import aplikasitoko.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author fifin
 */
public class panelimageLaporanlabarugi extends JPanel {
    private Image img;
    public panelimageLaporanlabarugi(){
        img=new ImageIcon(getClass().getResource("/aplikasitoko/gambar/laporan.jpg")).getImage();
    }
    public panelimageLaporanlabarugi(String ikon){
        if (ikon.length()<1)
            ikon="/aplikasitoko/gambar/barang.jpg";
        img=new ImageIcon(getClass().getResource(ikon)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D)g.create();
        gd.drawImage(img, 0, 0,getWidth(),getHeight(), null);
        gd.dispose();
    }
    
}
