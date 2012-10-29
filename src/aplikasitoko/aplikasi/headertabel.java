/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.aplikasi;

/**
 *
 * @author amy
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.TableCellRenderer;

class headertabel implements TableCellRenderer {

    protected TableCellRenderer textRenderer;
    protected int sortColumn = -1, pilih = -1;
    protected boolean sortAscending = true;

    public headertabel(TableCellRenderer renderer) {
        textRenderer = renderer;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Component text = textRenderer.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
        panel.add(text, BorderLayout.CENTER);
        if (column == pilih) {
            BasicArrowButton bab = new BasicArrowButton(
                    (sortAscending ? SwingConstants.SOUTH : SwingConstants.NORTH));
            bab.setBackground(new Color(255,204,153));
            panel.add(bab, BorderLayout.WEST);
        }
        return panel;
    }

    public boolean columnSelected(int column) {
        pilih = column;
        if (pilih == sortColumn) {
            if (sortAscending) {
                sortAscending = false;
            } else {
                sortAscending = true;
            }
        } else {
            sortColumn = pilih;
        }      
        return sortAscending;
    }
}