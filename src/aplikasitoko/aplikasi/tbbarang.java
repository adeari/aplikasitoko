/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * tbbarang.java
 *
 * Created on Mar 10, 2012, 5:52:46 AM
 */
package aplikasitoko.aplikasi;

import aplikasitoko.Animation;
import aplikasitoko.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import org.apache.commons.lang.StringEscapeUtils;
import java.awt.Color;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author amy
 */
public class tbbarang extends Frame {

    /** Creates new form tbbarang */
    public tbbarang() {
        glasspanel1 = new glasspanel();
        setGlassPane(glasspanel1);

        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        lihat();
        setLocationRelativeTo(null);
        setAnimationHide(Animation.HIDE_TO_BOTTOM);
        glasspanel1.showPanel(pnSimpan, (pnSimpan.getWidth() + 250), (pnSimpan.getHeight() + 220));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelimagetbbarang1 = new aplikasitoko.panelimagetbbarang("/aplikasitoko/gambar/barang.jpg");
        panelalpa1 = new aplikasitoko.panelalpa();
        btlanjut = new aplikasitoko.buttonStyle();
        btakhir = new aplikasitoko.buttonStyle();
        btbalik = new aplikasitoko.buttonStyle();
        btawal = new aplikasitoko.buttonStyle();
        jScrollPane1 = new javax.swing.JScrollPane();
        final String kolom[]={"Kode Barang","Nama Barang","Harga Beli","Harga Jual\nGrosir","Harga Jual\nRetail","Stok"};
        tmtabel=new javax.swing.table.AbstractTableModel() {
            public int getColumnCount() {  return kolom.length;   }
            public int getRowCount() {  return dataini.size();}
            public Object getValueAt(int baris1, int kolom1) {
                java.util.Vector barisan = (java.util.Vector)dataini.elementAt(baris1);
                return barisan.elementAt(kolom1);
            }
            public String getColumnName(int kolom1)
            {return kolom[kolom1];				    		}
            public boolean isCellEditable(int baris1, int kolom1){
                return false;
            }
            public void setValueAt(Object obj, int baris1, int kolom1){
                java.util.Vector barisdata = (java.util.Vector)dataini.elementAt(baris1);
                barisdata.setElementAt(obj, kolom1);
            }
            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }
        };
        tabel = new javax.swing.JTable(tmtabel);
        tabel.setAutoResizeMode(tabel.AUTO_RESIZE_OFF);
        tc=tabel.getColumn("Kode Barang");
        tc.setMinWidth(190);
        MultiLineHeaderRenderer mlhr = new MultiLineHeaderRenderer();
        mlhr.setBackground(new Color(255,204,153));
        headerrender = new headertabel(mlhr);
        tc.setHeaderRenderer(headerrender);
        tc=tabel.getColumn("Nama Barang");
        tc.setMinWidth(220);tc.setHeaderRenderer(headerrender);
        tc=tabel.getColumn("Harga Beli");
        tc.setMinWidth(170);tc.setHeaderRenderer(headerrender);
        tc=tabel.getColumn("Harga Jual\nGrosir");
        tc.setMinWidth(170);tc.setHeaderRenderer(headerrender);
        tc=tabel.getColumn("Harga Jual\nRetail");
        tc.setMinWidth(170);tc.setHeaderRenderer(headerrender);
        tc=tabel.getColumn("Stok");
        tc.setMinWidth(220);tc.setHeaderRenderer(headerrender);
        tabel.setDefaultRenderer(Object.class, new rendertaabel());

        tabel.getTableHeader().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                JTableHeader header = (JTableHeader) (event.getSource());
                int index = header.columnAtPoint(event.getPoint());
                Class dataType = tabel.getModel().getColumnClass(index);
                Class[] interfaces = dataType.getInterfaces();
                for (int i = 0; i < interfaces.length; i++) {
                    if (interfaces[i].equals(java.lang.Comparable.class)) {
                        ascendi=headerrender.columnSelected(index);
                        kolompilih=index;
                        lihat();
                        break;
                    }
                }
            }
        });

        limitnih = new javax.swing.JComboBox();
        lbhal = new aplikasitoko.textFieldStyle();
        lbakhirhalaman = new aplikasitoko.aplikasi.labelklip();
        lbakhirhalaman.setFont(lbakhirhalaman.getFont().deriveFont(50F));
        labelklip2 = new aplikasitoko.aplikasi.labelklip();
        labelklip3 = new aplikasitoko.aplikasi.labelklip();
        txCari = new aplikasitoko.textFieldStyle();
        btkeluar1 = new aplikasitoko.btkeluar();
        pnSimpan = new aplikasitoko.aplikasi.panelalpatebel();
        jLabel2 = new javax.swing.JLabel();
        kd_brg = new aplikasitoko.textFieldStyle();
        jLabel3 = new javax.swing.JLabel();
        nama_brg = new aplikasitoko.textFieldStyle();
        jLabel4 = new javax.swing.JLabel();
        satuan = new aplikasitoko.textFieldStyle();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btBatal = new aplikasitoko.buttonStyle();
        btSimpan = new aplikasitoko.buttonStyle();
        lbsimpantext = new aplikasitoko.aplikasi.labelklip();
        lbakhirhalaman.setFont(lbakhirhalaman.getFont().deriveFont(50F));
        hrg_beli = new aplikasitoko.numberfield();
        hrg_jual_grosir = new aplikasitoko.numberfield();
        hrg_jual_retail = new aplikasitoko.numberfield();
        stok = new aplikasitoko.numberfield();
        buttonStyle1 = new aplikasitoko.buttonStyle();

        setTitle("Data Barang");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelimagetbbarang1.setLayout(null);

        panelalpa1.setBackground(new java.awt.Color(255, 153, 102));
        panelalpa1.setLayout(null);

        btlanjut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/btlanjut.png"))); // NOI18N
        btlanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlanjutActionPerformed(evt);
            }
        });
        panelalpa1.add(btlanjut);
        btlanjut.setBounds(610, 500, 64, 56);

        btakhir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/btakhir.png"))); // NOI18N
        btakhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btakhirActionPerformed(evt);
            }
        });
        panelalpa1.add(btakhir);
        btakhir.setBounds(690, 500, 64, 56);

        btbalik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/btbalik.png"))); // NOI18N
        btbalik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbalikActionPerformed(evt);
            }
        });
        panelalpa1.add(btbalik);
        btbalik.setBounds(170, 500, 64, 56);

        btawal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/btawal.png"))); // NOI18N
        btawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btawalActionPerformed(evt);
            }
        });
        panelalpa1.add(btawal);
        btawal.setBounds(100, 500, 60, 56);

        tabel.setToolTipText("Data Barang");
        tabel.setRowHeight(30);
        tabel.setSurrendersFocusOnKeystroke(true);
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        tabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        panelalpa1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 1160, 380);

        limitnih.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        limitnih.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "20", "30", "50", "100" }));
        limitnih.setSelectedIndex(3);
        limitnih.setRenderer(new aplikasitoko.pagingCombo());
        limitnih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limitnihActionPerformed(evt);
            }
        });
        panelalpa1.add(limitnih);
        limitnih.setBounds(20, 500, 70, 50);

        lbhal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbhal.setText("1");
        lbhal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbhalKeyReleased(evt);
            }
        });
        panelalpa1.add(lbhal);
        lbhal.setBounds(240, 500, 90, 56);

        lbakhirhalaman.setText("halaman");
        lbakhirhalaman.setFont(new java.awt.Font("Arial", 1, 25));
        panelalpa1.add(lbakhirhalaman);
        lbakhirhalaman.setBounds(340, 510, 260, 50);

        labelklip2.setText("DATA BARANG");
        labelklip2.setFont(new java.awt.Font("Arial", 1, 36));
        panelalpa1.add(labelklip2);
        labelklip2.setBounds(450, 0, 270, 60);

        labelklip3.setBackground(new java.awt.Color(153, 204, 255));
        labelklip3.setText("Kata Pencarian");
        labelklip3.setFont(new java.awt.Font("Arial", 1, 36));
        panelalpa1.add(labelklip3);
        labelklip3.setBounds(30, 60, 270, 50);

        txCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txCariKeyReleased(evt);
            }
        });
        panelalpa1.add(txCari);
        txCari.setBounds(320, 60, 760, 56);

        panelimagetbbarang1.add(panelalpa1);
        panelalpa1.setBounds(10, 10, 1210, 580);

        btkeluar1.setForeground(new java.awt.Color(0, 0, 204));
        btkeluar1.setText("Tutup");
        btkeluar1.setFont(new java.awt.Font("Arial Black", 1, 20));
        btkeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkeluar1ActionPerformed(evt);
            }
        });
        panelimagetbbarang1.add(btkeluar1);
        btkeluar1.setBounds(30, 600, 230, 57);

        pnSimpan.setBackground(new java.awt.Color(153, 51, 255));
        pnSimpan.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Kode Barang");
        pnSimpan.add(jLabel2);
        jLabel2.setBounds(20, 90, 200, 50);

        kd_brg.setName("kd_brg"); // NOI18N
        kd_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kd_brgKeyReleased(evt);
            }
        });
        pnSimpan.add(kd_brg);
        kd_brg.setBounds(250, 90, 310, 47);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Nama Barang");
        pnSimpan.add(jLabel3);
        jLabel3.setBounds(20, 140, 200, 50);

        nama_brg.setName("usr"); // NOI18N
        nama_brg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nama_brgKeyReleased(evt);
            }
        });
        pnSimpan.add(nama_brg);
        nama_brg.setBounds(250, 140, 660, 47);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Satuan");
        pnSimpan.add(jLabel4);
        jLabel4.setBounds(20, 190, 200, 50);

        satuan.setName("usr"); // NOI18N
        satuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                satuanKeyReleased(evt);
            }
        });
        pnSimpan.add(satuan);
        satuan.setBounds(250, 190, 310, 47);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Harga Beli");
        pnSimpan.add(jLabel5);
        jLabel5.setBounds(20, 240, 200, 50);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Harga Jual Grosir");
        pnSimpan.add(jLabel6);
        jLabel6.setBounds(20, 290, 240, 50);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Harga Jual Retail");
        pnSimpan.add(jLabel7);
        jLabel7.setBounds(20, 340, 240, 50);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Stok");
        pnSimpan.add(jLabel8);
        jLabel8.setBounds(20, 390, 240, 50);

        btBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/kancel.gif"))); // NOI18N
        btBatal.setMnemonic('B');
        btBatal.setText("Batal");
        btBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBatalActionPerformed(evt);
            }
        });
        pnSimpan.add(btBatal);
        btBatal.setBounds(380, 460, 220, 58);

        btSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/simpan.gif"))); // NOI18N
        btSimpan.setMnemonic('S');
        btSimpan.setText("Simpan");
        btSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanActionPerformed(evt);
            }
        });
        pnSimpan.add(btSimpan);
        btSimpan.setBounds(120, 460, 230, 60);

        lbsimpantext.setText("TAMBAH DATA BARANG");
        lbsimpantext.setFont(new java.awt.Font("Arial", 1, 36));
        pnSimpan.add(lbsimpantext);
        lbsimpantext.setBounds(240, 20, 480, 50);

        hrg_beli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hrg_beliKeyReleased(evt);
            }
        });
        pnSimpan.add(hrg_beli);
        hrg_beli.setBounds(250, 240, 310, 47);

        hrg_jual_grosir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hrg_jual_grosirKeyReleased(evt);
            }
        });
        pnSimpan.add(hrg_jual_grosir);
        hrg_jual_grosir.setBounds(250, 290, 310, 47);

        hrg_jual_retail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hrg_jual_retailKeyReleased(evt);
            }
        });
        pnSimpan.add(hrg_jual_retail);
        hrg_jual_retail.setBounds(250, 340, 310, 47);

        stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stokKeyReleased(evt);
            }
        });
        pnSimpan.add(stok);
        stok.setBounds(250, 390, 310, 47);

        panelimagetbbarang1.add(pnSimpan);
        pnSimpan.setBounds(50, 680, 680, 310);

        buttonStyle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasitoko/gambar/tambah.gif"))); // NOI18N
        buttonStyle1.setMnemonic('T');
        buttonStyle1.setText("Tambah");
        buttonStyle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStyle1ActionPerformed(evt);
            }
        });
        panelimagetbbarang1.add(buttonStyle1);
        buttonStyle1.setBounds(520, 600, 220, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelimagetbbarang1, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelimagetbbarang1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1259)/2, (screenSize.height-718)/2, 1259, 718);
    }// </editor-fold>//GEN-END:initComponents

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    this.setVisible(false);
}//GEN-LAST:event_formWindowClosing

private void btlanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlanjutActionPerformed
    lbhal.setText(String.valueOf(Integer.valueOf(lbhal.getText()) + 1));
    lihat();
}//GEN-LAST:event_btlanjutActionPerformed

private void btbalikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbalikActionPerformed
    lbhal.setText(String.valueOf(Integer.valueOf(lbhal.getText()) - 1));
    lihat();
}//GEN-LAST:event_btbalikActionPerformed

private void btawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btawalActionPerformed
    lbhal.setText("1");
    lihat();
}//GEN-LAST:event_btawalActionPerformed

private void limitnihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limitnihActionPerformed
    lbhal.setText("1");
    lihat();
}//GEN-LAST:event_limitnihActionPerformed

private void btakhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btakhirActionPerformed
    lbhal.setText(String.valueOf(akhir));
    lihat();
}//GEN-LAST:event_btakhirActionPerformed

private void lbhalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbhalKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        lihat();
    } else {
        if (lbhal.getText().length() > 0) {
            try {
                Integer.valueOf(lbhal.getText());
            } catch (Exception ex) {
                lbhal.setText("1");
            }
        }
    }
}//GEN-LAST:event_lbhalKeyReleased

private void txCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCariKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        lihat();
    }
}//GEN-LAST:event_txCariKeyReleased

private void btkeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkeluar1ActionPerformed
    setVisible(false);
}//GEN-LAST:event_btkeluar1ActionPerformed

private void buttonStyle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStyle1ActionPerformed
    glasspanel1.setVisible(true);
    lbsimpantext.setText("TAMBAH DATA BARANG");
    btSimpan.setText("TAMBAH");
    btSimpan.setMnemonic('T');
    kd_brg.setText("");
    kd_brg.requestFocus();
    nama_brg.setText("");
    satuan.setText("");
    hrg_beli.setText("0");
    hrg_jual_grosir.setText("0");
    hrg_jual_retail.setText("0");
    stok.setText("0");
    kd_brg.setEditable(true);
}//GEN-LAST:event_buttonStyle1ActionPerformed

private void btBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBatalActionPerformed
    kd_brg.setText("");
    nama_brg.setText("");
    satuan.setText("");
    hrg_beli.setText("0");
    hrg_jual_grosir.setText("0");
    hrg_jual_retail.setText("0");
    stok.setText("0");
    kd_brg.setEditable(true);
    glasspanel1.setVisible(false);
}//GEN-LAST:event_btBatalActionPerformed

private void btSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanActionPerformed
    String qry = "";
    boolean bisa=true;
    if (kd_brg.getText().length()<1&&bisa) {
        bisa=false;
        kd_brg.requestFocus();
        javax.swing.JOptionPane.showMessageDialog(null, "Isi Kode Barang", "Pesan", 1);
    }
    if (Integer.valueOf(stok.getText().replace(".", ""))<1&&bisa) {
        bisa=false;
        stok.requestFocus();
        javax.swing.JOptionPane.showMessageDialog(null, "Isi Stok Barang", "Pesan", 1);
    }
    if (bisa)
    if (Integer.valueOf( hrg_jual_grosir.getText().replace(".", ""))>0&&Integer.valueOf( hrg_jual_grosir.getText().replace(".", ""))
            <Integer.valueOf( hrg_beli.getText().replace(".", "")) )
    {
        bisa=false;
        hrg_jual_grosir.requestFocus();
        javax.swing.JOptionPane.showMessageDialog(null, "Harga Jual Grosir lebih kecil daripada harga beli", "Pesan", 1);
    }
    if (bisa)
    if (Integer.valueOf( hrg_jual_retail.getText().replace(".", ""))>0&&Integer.valueOf( 
            hrg_jual_retail.getText().replace(".", ""))<Integer.valueOf( 
            hrg_beli.getText().replace(".", "")) )
    {
        bisa=false;
        hrg_jual_retail.requestFocus();
        javax.swing.JOptionPane.showMessageDialog(null, "Harga Jual Retail lebih kecil daripada harga beli", "Pesan", 1);
    }
    
    if (bisa) {
        if (lbsimpantext.getText().equalsIgnoreCase("TAMBAH DATA BARANG")) {
            qry = "select count(kd_brg) as jumlah from tb_barang where kd_brg=" + fsu.fixSqlCharacter(kd_brg.getText());
            try {
                Class.forName(fsu.klas).newInstance();
                Connection con = DriverManager.getConnection(fsu.klaSS);
                Statement sta = con.createStatement();
                Statement stin = con.createStatement();
                ResultSet rs = sta.executeQuery(qry);
                if (rs.next()) {
                    if (rs.getInt("jumlah") > 0) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Kode barang ini telah terpakai", "Pesan", 1);
                    } else {
                        qry = "insert into tb_barang (kd_brg,nama_brg,satuan,hrg_beli,hrg_jual_grosir,hrg_jual_retail,stok,kd_hrgbeli) "
                                + " values (" + fsu.fixSqlCharacter(kd_brg.getText())
                                + "," + fsu.fixSqlCharacter(nama_brg.getText())
                                + "," + fsu.fixSqlCharacter(satuan.getText())
                                + "," + fsu.fixSqlNumber(hrg_beli.getText())
                                + "," + fsu.fixSqlNumber(hrg_jual_grosir.getText())
                                + "," + fsu.fixSqlNumber(hrg_jual_retail.getText())
                                + "," + fsu.fixSqlNumber(stok.getText())
                                + "," + fsu.fixSqlCharacter(fsu.pengkodean(fsu.fixSqlNumber(hrg_beli.getText())))
                                + ");";
                        if (fsu.idebugging) {
                            System.out.println(" simpanbarang " + qry);
                        }
                        stin.executeUpdate(qry);
                        lihat();
                        btBatalActionPerformed(null);
                    }
                }
                rs.close();
                sta.close();
                stin.close();
                con.close();
            } catch (Exception ex) {
                if (fsu.idebugging) {
                    System.out.println(" Salah nya " + ex.getMessage());
                }
            }
        } else if (lbsimpantext.getText().equalsIgnoreCase("UBAH DATA BARANG")) {
            try {
                Class.forName(fsu.klas).newInstance();
                Connection con = DriverManager.getConnection(fsu.klaSS);
                Statement stin = con.createStatement();
                qry = "update tb_barang set nama_brg=" + fsu.fixSqlCharacter(nama_brg.getText())
                        + ",satuan=" + fsu.fixSqlCharacter(satuan.getText())
                        + ",hrg_beli=" + fsu.fixSqlNumber(hrg_beli.getText())
                        + ",hrg_jual_grosir=" + fsu.fixSqlNumber(hrg_jual_grosir.getText())
                        + ",hrg_jual_retail=" + fsu.fixSqlNumber(hrg_jual_retail.getText())
                        + ",stok=" + fsu.fixSqlNumber(stok.getText())
                        + ",kd_hrgbeli=" + fsu.fixSqlCharacter(fsu.pengkodean(fsu.fixSqlNumber(hrg_beli.getText())))
                        + " where kd_brg=" + fsu.fixSqlCharacter(kd_brg.getText());
                stin.executeUpdate(qry);
                lihat();
                btBatalActionPerformed(null);
                stin.close();
                con.close();
            } catch (Exception ex) {
                if (fsu.idebugging) {
                    System.out.println(" Salah nya " + ex.getMessage());
                }
            }
        }
    }
}//GEN-LAST:event_btSimpanActionPerformed

private void kd_brgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kd_brgKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        nama_brg.requestFocus();
    }
}//GEN-LAST:event_kd_brgKeyReleased

private void nama_brgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_brgKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        satuan.requestFocus();
    }
}//GEN-LAST:event_nama_brgKeyReleased

private void hrg_beliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hrg_beliKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        hrg_jual_grosir.requestFocus();
    }
}//GEN-LAST:event_hrg_beliKeyReleased

private void satuanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_satuanKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        hrg_beli.requestFocus();
    }
}//GEN-LAST:event_satuanKeyReleased

private void hrg_jual_retailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hrg_jual_retailKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        stok.requestFocus();
    }
}//GEN-LAST:event_hrg_jual_retailKeyReleased

private void hrg_jual_grosirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hrg_jual_grosirKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        hrg_jual_retail.requestFocus();
    }
}//GEN-LAST:event_hrg_jual_grosirKeyReleased

private void stokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stokKeyReleased
    if (evt.getKeyCode() == evt.VK_ENTER) {
        kd_brg.requestFocus();
    }
}//GEN-LAST:event_stokKeyReleased

private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
    if (evt.getClickCount() == 2) {
        glasspanel1.setVisible(true);
        lbsimpantext.setText("UBAH DATA BARANG");
        btSimpan.setText("UBAH");
        btSimpan.setMnemonic('U');
        nama_brg.requestFocus();
        kd_brg.setText(tabel.getValueAt(tabel.getSelectedRow(), 0).toString());
        kd_brg.setEditable(false);
        String qry = "select nama_brg,satuan,hrg_beli,hrg_jual_grosir,hrg_jual_retail,stok "
                + "from tb_barang "
                + "where kd_brg=" + fsu.fixSqlCharacter(kd_brg.getText());
        try {
            Class.forName(fsu.klas).newInstance();
            Connection con = DriverManager.getConnection(fsu.klaSS);
            Statement sta = con.createStatement();
            Statement stin = con.createStatement();
            ResultSet rs = sta.executeQuery(qry);
            if (rs.next()) {
                nama_brg.setText(fsu.ceknull(rs.getString("nama_brg")));
                satuan.setText(fsu.ceknull(rs.getString("satuan")));
                hrg_beli.setText(fsu.ceknullangka(rs.getString("hrg_beli")));
                hrg_jual_grosir.setText(fsu.ceknullangka(rs.getString("hrg_jual_grosir")));
                hrg_jual_retail.setText(fsu.ceknullangka(rs.getString("hrg_jual_retail")));
                stok.setText(fsu.ceknullangka(rs.getString("stok")));
            }
            sta.close();
            con.close();
        } catch (Exception ex) {
        }
    }
}//GEN-LAST:event_tabelMouseClicked

private void tabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelKeyReleased
    if (evt.getKeyCode() == evt.VK_DELETE) {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Hapus data barang ini?", "Perhatian",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE) == javax.swing.JOptionPane.YES_OPTION) {
            try {
                String qry = "";
                Class.forName(fsu.klas).newInstance();
                Connection con = DriverManager.getConnection(fsu.klaSS);
                Statement stin = con.createStatement();
                int baris[] = tabel.getSelectedRows();
                for (int x = 0; x < baris.length; x++) {
                    if (x > 0) {
                        qry += ",";
                    }
                    qry += fsu.fixSqlCharacter(tabel.getValueAt(baris[x], 0).toString());
                }
                qry = "delete from tb_barang where kd_brg in (" + qry + ");";
                stin.executeUpdate(qry);
                lihat();
                btBatalActionPerformed(null);
                stin.close();
                con.close();
            } catch (Exception ex) {
                if (fsu.idebugging) {
                    System.out.println(" Salah nya " + ex.getMessage());
                }
            }
        }
    }
}//GEN-LAST:event_tabelKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aplikasitoko.buttonStyle btBatal;
    private aplikasitoko.buttonStyle btSimpan;
    private aplikasitoko.buttonStyle btakhir;
    private aplikasitoko.buttonStyle btawal;
    private aplikasitoko.buttonStyle btbalik;
    private aplikasitoko.btkeluar btkeluar1;
    private aplikasitoko.buttonStyle btlanjut;
    private aplikasitoko.buttonStyle buttonStyle1;
    private aplikasitoko.numberfield hrg_beli;
    private aplikasitoko.numberfield hrg_jual_grosir;
    private aplikasitoko.numberfield hrg_jual_retail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private aplikasitoko.textFieldStyle kd_brg;
    private aplikasitoko.aplikasi.labelklip labelklip2;
    private aplikasitoko.aplikasi.labelklip labelklip3;
    private aplikasitoko.aplikasi.labelklip lbakhirhalaman;
    private aplikasitoko.textFieldStyle lbhal;
    private aplikasitoko.aplikasi.labelklip lbsimpantext;
    private javax.swing.JComboBox limitnih;
    private aplikasitoko.textFieldStyle nama_brg;
    private aplikasitoko.panelalpa panelalpa1;
    private aplikasitoko.panelimagetbbarang panelimagetbbarang1;
    private aplikasitoko.aplikasi.panelalpatebel pnSimpan;
    private aplikasitoko.textFieldStyle satuan;
    private aplikasitoko.numberfield stok;
    private javax.swing.JTable tabel;
    private aplikasitoko.textFieldStyle txCari;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.TableModel tmtabel;
    java.util.Vector dataini = new java.util.Vector();
    javax.swing.table.TableColumn tc = new javax.swing.table.TableColumn();
    aplikasitoko.fungsi fsu = new aplikasitoko.fungsi();
    headertabel headerrender;
    private glasspanel glasspanel1;
    int akhir = 0;
    boolean ascendi = true;
    int kolompilih = 0;

    private void lihat() {
        String qry = "", orderbi = "", kondisi = "";
        int posisi = (Integer.valueOf(lbhal.getText()) - 1);
        if (fsu.idebugging) {
            System.out.println(" lihat data ini tbbarang " + posisi);
        }
        if (posisi == 0) {
            btbalik.setEnabled(false);
            btawal.setEnabled(false);
        } else {
            btbalik.setEnabled(true);
            btawal.setEnabled(true);
        }

        switch (kolompilih) {
            case 0:
                orderbi = " order by kd_brg ";
                break;
            case 1:
                orderbi = " order by nama_brg ";
                break;
            case 2:
                orderbi = " order by hrg_beli ";
                break;
            case 3:
                orderbi = " order by hrg_jual_grosir ";
                break;
            case 4:
                orderbi = " order by hrg_jual_retail ";
                break;
            case 5:
                orderbi = " order by stok ";
                break;
        }
        if (ascendi) {
            orderbi += " asc ";
        } else {
            orderbi += " desc ";
        }


        if (txCari.getText().length() > 0) {
            kondisi = " where kd_brg like '%" + StringEscapeUtils.escapeSql(txCari.getText())
                    + "%' OR nama_brg like '%" + StringEscapeUtils.escapeSql(txCari.getText())
                    + "%' OR satuan like '%" + StringEscapeUtils.escapeSql(txCari.getText())
                    + "%' ";
        }

        int i = 0, limit = Integer.valueOf(limitnih.getSelectedItem().toString()),
                posisi2 = 0;
        String opset = "";
        try {
            Class.forName(fsu.klas).newInstance();
            Connection con = DriverManager.getConnection(fsu.klaSS);
            Statement sta = con.createStatement();
            qry = "select count(*) as jumlah from tb_barang " + kondisi;
            ResultSet rs = sta.executeQuery(qry);
            if (rs.next()) {
                if (rs.getInt("jumlah") > 0) {
                    akhir = rs.getInt("jumlah") / limit;
                    if ((rs.getInt("jumlah") % limit) > 0) {
                        akhir++;
                    }
                    if ((akhir - 1) <= posisi) {
                        btlanjut.setEnabled(false);
                        btakhir.setEnabled(false);
                        lbhal.setText(String.valueOf(akhir));
                        posisi = (Integer.valueOf(lbhal.getText()) - 1);
                    } else {
                        if (posisi < 0) {
                            posisi = 0;
                            lbhal.setText("1");
                            btbalik.setEnabled(false);
                            btawal.setEnabled(false);
                        }
                        btlanjut.setEnabled(true);
                        btakhir.setEnabled(true);
                    }
                } else {
                    posisi = 0;
                    btlanjut.setEnabled(false);
                    btakhir.setEnabled(false);
                    btbalik.setEnabled(false);
                    btawal.setEnabled(false);
                    lbhal.setText("0");
                }
            }
            posisi2 = posisi * limit;
            opset = " limit " + posisi2 + " , " + String.valueOf(limit);
            qry = "SELECT kd_brg,nama_brg,kd_hrgbeli,"
                    + "hrg_beli,hrg_jual_grosir,hrg_jual_retail,stok,"
                    + "satuan,format(hrg_jual_grosir,0) as hrg_jual_grosirnya,"
                    + "format(hrg_jual_retail,0) as hrg_jual_retailnya,"
                    + "format(stok,0) as stoknya "
                    + "FROM tb_barang "
                    + kondisi + orderbi + opset;
            if (fsu.idebugging) {
                System.out.println(" lihat data ini tbbarang " + qry);
            }
            rs = sta.executeQuery(qry);
            java.util.Vector baris = null;
            dataini = new java.util.Vector();
            while (rs.next()) {

                baris = new java.util.Vector();
                baris.addElement(fsu.ceknull(rs.getString("kd_brg")));
                baris.addElement(fsu.ceknull(rs.getString("nama_brg")));
                baris.addElement(fsu.pengkodean(fsu.ceknull(rs.getString("hrg_beli"))));
                baris.addElement(fsu.ceknullangka(rs.getString("hrg_jual_grosir")));
                baris.addElement(fsu.ceknullangka(rs.getString("hrg_jual_retail")));
                baris.addElement(fsu.ceknullangka(rs.getString("stok")) + " " + rs.getString("satuan"));
                dataini.addElement(baris);
            }
            tabel.tableChanged(new javax.swing.event.TableModelEvent(tmtabel));
            lbakhirhalaman.setText(" dari " + akhir + " Halaman");
            sta.close();
            con.close();
        } catch (Exception ex) {
            if (fsu.idebugging) {
                System.out.println(" error enter tb_barang lihat " + ex.getMessage());
            }
        }

    }

    class MultiLineHeaderRenderer extends JPanel implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label;
            removeAll();
            String[] header = ((String) value).split("\n");
            setLayout(new GridLayout(header.length, 1));
            for (String s : header) {
                label = new JLabel(s, JLabel.CENTER);
                label.setFont(new java.awt.Font("Arial", 1, 25));
                add(label);
            }
            LookAndFeel.installBorder(this, "TableHeader.cellBorder");
            return this;
        }
    }
}
