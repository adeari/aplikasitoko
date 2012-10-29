/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko;

import java.text.NumberFormat;
import javax.swing.text.MaskFormatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author amy
 */
public class fungsi {
    //diganti saat di berikan
    public static boolean idebugging = false;
    public static boolean printdeh=true; // jika true langsung print jika false view saja

    public String klaSS = "jdbc:mysql://localhost/webnoy?user=root&password=webnonoy",
            klas = "com.mysql.jdbc.Driver";
    

    public String fixSqlCharacter(String isi) {
        String balik = "NULL";
        if (isi.length() > 0) {
            isi=isi.replace("'", "\'");
        }
        balik = "'" + isi + "'";
        return balik;
    }
    
    public String fixSqlNumber(String isi) {
        String balik = "NULL";
        if (isi.length() > 0) {
            isi=isi.replace(".", "");
        }
        balik =  isi ;
        return balik;
    }

    public static String digitNomor(String nom) {
        String balik="";
        int i=0,x=0;
        for (i=(nom.length()-1);i>=0;i--)
        {
            if ((x%3)==0&&x>0)   balik=nom.substring(i, (i+1)) +"."+balik;
            else balik=nom.substring(i, (i+1))+balik;
            x++;
        }
        return balik;
    }
    
    private String kodehrgbeli(String kode)
    {
        if (kode.equalsIgnoreCase("1"))
            kode="X";
        else if (kode.equalsIgnoreCase("2"))
            kode="Z";
        else if (kode.equalsIgnoreCase("3"))
            kode="E";
        else if (kode.equalsIgnoreCase("4"))
            kode="A";
        else if (kode.equalsIgnoreCase("5"))
            kode="S";
        else if (kode.equalsIgnoreCase("6"))
            kode="G";
        else if (kode.equalsIgnoreCase("7"))
            kode="T";
        else if (kode.equalsIgnoreCase("8"))
            kode="B";
        else if (kode.equalsIgnoreCase("9"))
            kode="R";
        return kode;
    }
    public String pengkodean(String hrgbeli)
    {
        String balik="",karakter="";
        boolean ada0=false;
        int panjang=hrgbeli.length(),x=0,lanjut=0,itung=0;
        while (x<panjang)
        {
            karakter=hrgbeli.substring(x, (x+1));
            if (karakter.equalsIgnoreCase("0"))
            {
                ada0=true;
                lanjut=x+1;
                itung=1;
                while (ada0&&lanjut<panjang)
                {
                    karakter=hrgbeli.substring(lanjut, (lanjut+1));
                    if (!karakter.equalsIgnoreCase("0"))  ada0=false;
                    else {x=lanjut; lanjut++; itung++;}
                }
                if (itung==1)   balik+="C";
                else balik+=itung;
            } else balik+=kodehrgbeli(karakter);
            x++;
        }
        return balik;
    }
    
    public String ceknull(String ini)
    {
        if (ini==null) ini="";
        return ini;
    }  
    public String ceknullangka(String ini)
    {
        if (ini==null) ini="0";
        ini =digitNomor(ini);
        return ini;
    }  
    
    public static String getPath()
    {
        
        String balik="",path=""; 
        boolean windows=false;
        java.util.StringTokenizer stk12=new java.util.StringTokenizer(System.getProperty("java.class.path"),"\\");
        if (stk12.countTokens()>1)
            windows=true;
        else
        {
            stk12=new java.util.StringTokenizer(System.getProperty("user.dir"),"\\");
            if (stk12.countTokens()>1)
                windows=true;
        }
        if (windows) //untuk windows
        {
            
           path=System.getProperty("java.class.path");
           int panjang=path.length(),i=0;
           boolean adatitikkoma=false;
           String sementara="";
           i=0;
          
           while (i<panjang&&!adatitikkoma)
           {
               sementara=path.substring(i,(i+1));
               if (sementara.equalsIgnoreCase(":"))
                   adatitikkoma=true;
               i++;
           }
           if (!adatitikkoma)
           {
               path=System.getProperty("user.dir")+"\\"+path;
               
           }
           java.util.StringTokenizer stk=new java.util.StringTokenizer(path,"\\");
           path="";
           panjang=stk.countTokens();
           for (i=0;i<panjang-1;i++)
           {
                if (stk.hasMoreTokens())
                path+=stk.nextToken()+"/";
           }
           balik=path;
        }
        else  //untuk linux
        {
        try{
           path=System.getProperty("java.class.path");
           String pathSeleksi=path;           
           java.util.StringTokenizer stk=new java.util.StringTokenizer(path,"/");
           if (path.substring(0,1).equalsIgnoreCase("/"))
               path="/";
           else
               path=System.getProperty("user.dir")+"/";
           int i=0;           
           int panjang=stk.countTokens();
           for (i=1;i<panjang;i++)
           {
               if (stk.hasMoreTokens())
                   path+=stk.nextToken()+"/";  
           }
           java.io.File fl=new java.io.File(pathSeleksi);
           if (!fl.isFile())
               path=System.getProperty("user.dir")+"/"+path;
           balik=path;
        }
        catch (Exception e){}        
        }
        return balik;
    }
    
    public void normalKanBarang(String pemakai){
         try {
            Class.forName(klas).newInstance();
            Connection con = DriverManager.getConnection(klaSS);
            Statement sta = con.createStatement();
            Statement stin = con.createStatement();
            String qry = "SELECT stok,kd_brg FROM tb_trxjual2 where nambah and kd_user=" + pemakai;
            ResultSet rs=sta.executeQuery(qry);
            while (rs.next()) {
                qry="update tb_barang set stok=stok+"+rs.getString("stok")+" where kd_brg="+fixSqlCharacter(rs.getString("kd_brg"));
                stin.executeUpdate(qry);
            }
            qry="delete from tb_trxjual2 where kd_user=" + pemakai;
                stin.executeUpdate(qry);
            rs.close();
            sta.close();
            stin.close();
            con.close();
        } catch (Exception ex) {
        }
    }
}
