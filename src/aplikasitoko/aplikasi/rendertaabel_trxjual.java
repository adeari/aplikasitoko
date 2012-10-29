/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.aplikasi;

/**
 *
 * @author amy
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JTextPane;
import java.util.StringTokenizer;

public class rendertaabel_trxjual extends JTextPane implements TableCellRenderer {

    int satubaris = -1, tampungtertinggi = 1;

    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {

        this.setText(value.toString());
        if (isSelected) {
            this.setBackground(new Color(153, 204, 255));
            this.setFont(new java.awt.Font("Arial", 1, 25));
        } else {
            if (row % 3 == 0) {
                this.setBackground(new Color(255, 204, 255));
                this.setFont(new java.awt.Font("Arial", 0, 25));
            } else if (row % 3 == 1) {
                this.setBackground(new Color(255, 255, 153));
                this.setFont(new java.awt.Font("Arial", 0, 25));
            } else if (row % 3 == 2) {
                this.setBackground(new Color(204, 255, 204));
                this.setFont(new java.awt.Font("Arial", 0, 25));
            }
        }

        StyledDocument doc = this.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        if (column == 0) {
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        } else if (column == 3 || column == 4 || column == 5|| column == 6|| column == 7) {
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_RIGHT);
        } else {
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
        }
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        this.setDocument(doc);

        if (satubaris != row) {
            satubaris = row;
            tampungtertinggi = 1;
        }
        
        int tampung = value.toString().length() * 10 / table.getColumnModel().getColumn(column).getWidth(),sementara=0;
        if (tampung >0) {
            if ((value.toString().length() * 8) % table.getColumnModel().getColumn(column).getWidth() > 0) {
                tampung++;
            }
        }
        
        StringTokenizer stk = new StringTokenizer(this.getText(), "\n");
        if (1 < stk.countTokens()) {
            tampung=0;
            stk = new StringTokenizer(this.getText(), "\n");
            String elemenini="";
            while (stk.hasMoreElements()) {
                tampung++;
                elemenini=stk.nextElement().toString();
                sementara = elemenini.length() * 10 / table.getColumnModel().getColumn(column).getWidth();
                if (sementara >1) {
                    tampung=tampung+sementara;
                    if ((elemenini.toString().length() * 8) % table.getColumnModel().getColumn(column).getWidth() > 0) {
                        tampung++;
                    }
                }
            }
        }
        if (tampung > tampungtertinggi) {
            tampungtertinggi = tampung;
        }
        table.setRowHeight(row, (tampungtertinggi * 33));
        return this;
    }
}