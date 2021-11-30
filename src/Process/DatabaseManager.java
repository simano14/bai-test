/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DatabaseManager {

    public static String LayGTHH(String chon, String mahh) throws SQLException{
        String dm = null;
        DBConnection dbConn = new DBConnection();        
        String qr = "Select " + chon +" from hanghoa where mahh = '" + mahh + "'";
        ResultSet rs = dbConn.GetData(qr);
        if(rs.next()) { 
            dm = rs.getString(chon);
        }
        return dm;
    }
    
    public static DefaultComboBoxModel LayMKH() throws SQLException {
        DefaultComboBoxModel dm=new DefaultComboBoxModel();
        DBConnection dbConn = new DBConnection();
        
        String qr = "Select makh from khachhang";
        ResultSet rs = dbConn.GetData(qr);
        while(rs.next())
        {
            String name=rs.getString(1);
            dm.addElement(name);
        }
        return dm;
    }
    
    public static DefaultComboBoxModel LayMHH() throws SQLException {
        DefaultComboBoxModel dm=new DefaultComboBoxModel();
        DBConnection dbConn = new DBConnection();
        
        String qr = "Select mahh from hanghoa";
        ResultSet rs = dbConn.GetData(qr);
        while(rs.next())
        {
            String name=rs.getString(1);
            dm.addElement(name);
        }
        return dm;
    }
    //Khách hàng
    public static boolean ThemKhachHang(String makh, String tenkh, String dthoai) {
        DBConnection dbConn = new DBConnection();
        String qr = "Insert Into khachhang Values('" + makh + "',N'" + tenkh + "', N'" + dthoai + "')";
        return dbConn.UpdateData(qr);
    }

    public static boolean SuaKhachHang(String makh, String tenkh, String dthoai) {
        DBConnection dbConn = new DBConnection();
        String qr = "Update khachhang Set tenkh = N'" + tenkh + "', dthoai = N'" + dthoai + "' Where makh = '" + makh + "'";
        return dbConn.UpdateData(qr);
    }

    public static boolean XoaKhachHang(String makh) {
        String qr = "Delete From khachhang Where makh = '" + makh + "'";
        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean KHToTable(JTable jTable) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            ResultSet rs = db.GetData("Select * From khachhang");
            String[] row = new String[3];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //Hàng hóa
    public static boolean ThemHH(String mahh, String tenhh, String quicach, String dvtinh, String dongia) {
        String qr = "Insert Into hanghoa Values('" + mahh + "',N'" + tenhh + "'  , N'" + quicach + "'  , N'" + dvtinh + "'  , '" + dongia + "'  )";
        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr) == true;
    }

    public static boolean SuaHH(String mahh, String tenhh, String quicach, String dvtinh, String dongia) {
        String qr = "Update hanghoa Set tenhh = N'" + tenhh + "', quicach = N'" + quicach + "'  , dvtinh = N'" + dvtinh + "'  , dongia = '" + dongia + "'Where mahh = '" + mahh + "'  ";

        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean XoaHH(String mahh) {
        String qr = "Delete From hanghoa Where mahh = '" + mahh + "'";
        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean HHToTable(JTable jTable) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            ResultSet rs = db.GetData("Select * From hanghoa");
            String[] row = new String[5];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
//    public static boolean SinhVienToTable_ByLopHoc(JTable jTable, String msLop) {
//        try {
//            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
//            dfTableModel.setRowCount(0);
//            DBConnection db = new DBConnection();
//            ResultSet rs = db.GetData("Select * From SinhVien Where mslop = '"+msLop+"'  ");
//
//            String[] row = new String[4];
//            while (rs.next()) {
//                row[0] = rs.getString(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                row[3] = rs.getString(4);
//                dfTableModel.addRow(row);
//            }
//            return true;
//        } catch (Exception ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,ex);
//            return false;
//        }
//    }
    //Hóa đơn
    public static boolean ThemHD(String hdso, String ngay, String makh, String trigia) {
        DBConnection dbConn = new DBConnection();
        String qr = "Insert Into hoadon Values('" + hdso + "',N'" + ngay + "', N'" + makh + "', N'" + trigia + "')";
        return dbConn.UpdateData(qr);
    }

    public static boolean SuaHD(String hdso, String ngay, String makh, String trigia) {
        DBConnection dbConn = new DBConnection();
        String qr = "Update hoadon Set ngay = N'" + ngay + "', makh = N'" + makh + "', trigia = N'" + trigia + "' Where hdso = '" + hdso + "'";
        return dbConn.UpdateData(qr);
    }

    public static boolean XoaHD(String hdso) {
        boolean a = false;
        String qr = "Delete From chitiethoadon Where hdso = '" + hdso + "'";
        String qr1 = "Delete From hoadon Where hdso = '" + hdso + "'";
        DBConnection dbConn = new DBConnection();
        if(dbConn.UpdateData(qr)== true && dbConn.UpdateData(qr1) == true) a = true;
        return a;
    }
    
    public static boolean HDToTable(JTable jTable) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            ResultSet rs = db.GetData("Select * From hoadon");
            String[] row = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean FullDataToTable(JTable jTable) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            ResultSet rs = db.GetData("Select * From hoadon,khachhang,hanghoa,chitiet");
            String[] row = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    //Chi tiết hóa đơn
    public static boolean ThemCTHD(String hdso, String mahh, String soluong) {
        DBConnection dbConn = new DBConnection();
        String qr = "Insert Into chitiethoadon Values('" + hdso + "',N'" + mahh + "', N'" + soluong + "')";
        return dbConn.UpdateData(qr);
    }

    public static boolean SuaCTHD(String mahh, String soluong) {
        DBConnection dbConn = new DBConnection();
        String qr = "Update chitiethoadon Set soluong = N'" + soluong + "' Where mahh = '" + mahh + "'";
        return dbConn.UpdateData(qr);
    }

    public static boolean XoaCTHD(String mahh, String hdso) {
        String qr = "Delete From chitiethoadon Where mahh = '" + mahh + "' And hdso = '" + hdso + "'";
        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean CTHDToTable(JTable jTable, String hdso) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            ResultSet rs = db.GetData("Select * From chitiethoadon Where hdso = '" + hdso + "'");
            String[] row = new String[2];
            while (rs.next()) {
                row[0] = rs.getString(2);
                row[1] = rs.getString(3);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static int CountCTHD(String tableName, String columnName1, String id1, String columnName2, String id2) {
        String qr = "";
        if ((id1.length() == 0 || columnName1.length() == 0) && (id2.length() == 0 || columnName2.length() == 0)) {
            qr = "Select COUNT(*) from " + tableName;
        } else qr = "Select COUNT(*) from " + tableName + " Where " + columnName1 + " = '" + id1 + "' And " + columnName2 + " = '" + id2 + "'";

        DBConnection dbConn = new DBConnection();
        ResultSet rs = dbConn.GetData(qr);
        try {
            if (rs.next()) {
                int count = Integer.parseInt(rs.getString(1));
                return count;
            }
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,ex);
            return -1;
        }
        return -1;
    }
    
    public static Double triGia(String hdso){
        Double a = 0.0;
        String qr = "Select SUM(hanghoa.dongia * chitiethoadon.soluong) From hanghoa INNER JOIN chitiethoadon ON hanghoa.mahh = chitiethoadon.mahh Where chitiethoadon.hdso = '" + hdso +"'";
        DBConnection dbConn = new DBConnection();
        ResultSet rs = dbConn.GetData(qr);
        try {
            if (rs.next()) {
                a = Double.parseDouble(rs.getString(1));
                return a;
            }
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,ex);
            return a;
        }
        return a;
    }
    
    public static int Count(String tableName, String columnName, String id) {
        String qr = "";
        if (id.length() == 0 || columnName.length() == 0) {
            qr = "Select COUNT(*) from " + tableName;
        } else qr = "Select COUNT(*) from " + tableName + " Where " + columnName + " = '"+id+"'  ";

        DBConnection dbConn = new DBConnection();
        ResultSet rs = dbConn.GetData(qr);
        try {
            if (rs.next()) {
                int count = Integer.parseInt(rs.getString(1));
                return count;
            }
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,ex);
            return -1;
        }
        return -1;
    }

}
