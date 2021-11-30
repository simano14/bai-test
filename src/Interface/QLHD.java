/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Process.ChucNang;
import Process.DatabaseManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLHD extends javax.swing.JFrame {

    DefaultTableModel dfTableModel;
    int chucNangDaChon = ChucNang.NONE;

    /**
     * Creates new form QLHD
     */

    public QLHD() throws SQLException {
        initComponents();
        dfTableModel = (DefaultTableModel) tblDSHD.getModel();
        retrieve();
    }

    private void retrieve() throws SQLException {
        DefaultComboBoxModel dm = new DatabaseManager().LayMKH();
        cbMakh.setModel(dm);
    }

    void TblDSHD_SelectionChanged() {
        int row = tblDSHD.getSelectedRow();
        if (row >= 0) {
            String hdSo = (String) dfTableModel.getValueAt(row, 0);
            String ngay = (String) dfTableModel.getValueAt(row, 1);
            String makh = (String) dfTableModel.getValueAt(row, 2);
            String triGia = (String) dfTableModel.getValueAt(row, 3);
            txtHDS.setText(hdSo.trim());
            txtNgay.setText(ngay.trim());
            cbMakh.setSelectedItem(makh.trim());
            txtTriGia.setText(triGia.trim());
        } else {

            txtHDS.setText("");
            txtNgay.setText("");
            txtTriGia.setText("");
        }
        ReloadLblIndexTblDSHD();
    }
    //Lấy dữ liệu cho bảng lớp học

    void ReloadTaleHD() {
        if (DatabaseManager.HDToTable(tblDSHD) == false) {
            JOptionPane.showMessageDialog(null, "Lấy dữ liệu hóa đơn có lỗi", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            ReloadLblIndexTblDSHD();
        }
    }

    void ReloadLblIndexTblDSHD() {
        int rowSelected = tblDSHD.getSelectedRow();
        int totalRow = tblDSHD.getRowCount();
        lblIndexTblKH.setText((rowSelected + 1) + "/" + totalRow);
    }

    void SwitchMode(int chucNang) {
        chucNangDaChon = chucNang;
        switch (chucNang) {
            case ChucNang.ADD: {
                boolean trangThai = true;
                txtHDS.setEnabled(trangThai);
                txtNgay.setEnabled(trangThai);
                cbMakh.setEnabled(trangThai);
                txtHDS.requestFocus();
                btnSave.setEnabled(trangThai);
                btnUpdate.setEnabled(!trangThai);
                btnDelete.setEnabled(!trangThai);
                txtHDS.setText("");
                txtNgay.setText("");
                txtTriGia.setText("");
                btnAdd.setText("Hủy");
                break;
            }
            case ChucNang.UPDATE: {
                boolean trangThai = true;
                txtNgay.setEnabled(trangThai);
                cbMakh.setEnabled(trangThai);
                txtNgay.requestFocus();
                btnSave.setEnabled(trangThai);
                btnAdd.setEnabled(!trangThai);
                btnDelete.setEnabled(!trangThai);
                btnUpdate.setText("Hủy");
                break;
            }
            case ChucNang.NONE: {
                boolean trangThai = false;
                txtHDS.setEnabled(trangThai);
                txtNgay.setEnabled(trangThai);
                cbMakh.setEnabled(trangThai);
                btnSave.setEnabled(trangThai);
                btnAdd.setEnabled(true);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnAdd.setText("Thêm");
                btnUpdate.setText("Sửa");
            }
        }
    }

    boolean CheckInput() {
        String hdSo = txtHDS.getText().trim();
        String ngay = txtNgay.getText().trim();
        String triGia = txtTriGia.getText().trim();
        if (hdSo.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã số hóa đơn", "Chưa nhập mã số hóa đơn", JOptionPane.WARNING_MESSAGE);
            txtHDS.requestFocus();
            return false;
        }
        if (ngay.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ngày", "Chưa nhập ngày", JOptionPane.WARNING_MESSAGE);
            txtNgay.requestFocus();
            return false;
        }
        return true;
    }

    void exit() {
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Thoát ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.CANCEL_OPTION) {
            return;
        }
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        txtNgay = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtHDS = new javax.swing.JTextField();
        lblIndexTblKH = new javax.swing.JLabel();
        txtTriGia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSHD = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbMakh = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý hóa đơn");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Trở lại");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtNgay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNgay.setEnabled(false);

        btnFirst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Trị giá");

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hóa đơn số");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Ngày");

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Danh sách hóa đơn");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtHDS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHDS.setEnabled(false);
        txtHDS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHDSKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHDSKeyReleased(evt);
            }
        });

        lblIndexTblKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIndexTblKH.setText("0/0");

        txtTriGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTriGia.setEnabled(false);

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hóa đơn số", "Ngày", "Mã khách hàng", "Trị giá"
            }
        ));
        jScrollPane2.setViewportView(tblDSHD);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mã khách hàng");

        cbMakh.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Chi tiết hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)
                        .addGap(20, 20, 20)
                        .addComponent(lblIndexTblKH)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtHDS, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTriGia, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMakh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(52, 52, 52))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(440, 440, 440)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTriGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnBack)
                    .addComponent(btnLast)
                    .addComponent(lblIndexTblKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(btnAdd)
                    .addGap(3, 3, 3)
                    .addComponent(btnSave)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnUpdate)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnDelete)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Main fmain = new Main();
        this.setVisible(false);
        fmain.setLocationRelativeTo(null);
        fmain.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        if (tblDSHD.getRowCount() > 0) {
            tblDSHD.getSelectionModel().setSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        int rowSelected = tblDSHD.getSelectedRow();
        if (rowSelected > 0) {
            rowSelected--;
            tblDSHD.getSelectionModel().setSelectionInterval(rowSelected,
                    rowSelected);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        int rowSelected = tblDSHD.getSelectedRow();
        if (rowSelected < tblDSHD.getRowCount() - 1) {
            rowSelected++;
            tblDSHD.getSelectionModel().setSelectionInterval(rowSelected,
                    rowSelected);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (chucNangDaChon == ChucNang.NONE) {
            SwitchMode(ChucNang.ADD);
        } else {
            SwitchMode(ChucNang.NONE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        if (tblDSHD.getRowCount() > 0) {
            int lastRowIndex = tblDSHD.getRowCount() - 1;
            tblDSHD.getSelectionModel().setSelectionInterval(lastRowIndex,
                    lastRowIndex);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String hdSo = txtHDS.getText().trim();
        String ngay = txtNgay.getText().trim();
        String makh = cbMakh.getSelectedItem().toString();
        String triGia = txtTriGia.getText().trim();
        if (chucNangDaChon == ChucNang.ADD) {
            if (CheckInput() == false) {
                return;
            }
            if (DatabaseManager.Count("hoadon", "hdSo", hdSo) > 0) {
                txtHDS.requestFocus();
                JOptionPane.showMessageDialog(null, "Số hóa đơn bạn nhập đã tồn tại trong csdl", "Trùng mã", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (DatabaseManager.ThemHD(hdSo, ngay, makh, triGia)) {
                btnAdd.requestFocus();
                SwitchMode(ChucNang.NONE);
                ReloadTaleHD();
                JOptionPane.showMessageDialog(null, "Thêm thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (chucNangDaChon == ChucNang.UPDATE) {
            if (CheckInput() == false) {
                return;
            }
            if (DatabaseManager.SuaHD(hdSo, ngay, makh, triGia)) {
                btnUpdate.requestFocus();
                SwitchMode(ChucNang.NONE);
                ReloadTaleHD();
                JOptionPane.showMessageDialog(null, "Sửa thành công",
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại", "Có lỗi ", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String hdSo = txtHDS.getText().trim();
        txtTriGia.setText(DatabaseManager.triGia(hdSo).toString());
        if (tblDSHD.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng để sửa",
                    "Chưa chọn khách hàng", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (chucNangDaChon == ChucNang.NONE) {
            SwitchMode(ChucNang.UPDATE);
        } else {
            SwitchMode(ChucNang.NONE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDSHD.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng nào để xóa", "Chưa chọn khách hàng", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này không", "Xóa khách hàng?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.CANCEL_OPTION) {
            return;
        }
        String hdSo = (String) tblDSHD.getValueAt(selectedRow, 0);
        //        if (DatabaseManager.Count("khachhang", "hdSo", hdSo) > 0) {
        //            JOptionPane.showMessageDialog(null, "Đã có khách hàng này trong danh sách!", "Không thể xóa", JOptionPane.WARNING_MESSAGE);
        //            return;
        //        }
        if (DatabaseManager.XoaHD(hdSo)) {
            btnAdd.requestFocus();
            SwitchMode(ChucNang.NONE);
            ReloadTaleHD();
            JOptionPane.showMessageDialog(null, "Xóa thành công",
                    "Thành công", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String hdSo = txtHDS.getText().trim();
        if (hdSo.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã số hóa đơn", "Chưa nhập mã số hóa đơn", JOptionPane.WARNING_MESSAGE);
            txtHDS.requestFocus();
        } else {
            ChiTietHH fmain = null;
            try {
                fmain = new ChiTietHH(Integer.parseInt(txtHDS.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(QLHD.class.getName()).log(Level.SEVERE, null, ex);
            }
            fmain.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtHDSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHDSKeyPressed
//        String hdSo = txtHDS.getText().trim();
//        txtTriGia.setText(DatabaseManager.triGia(hdSo).toString());
    }//GEN-LAST:event_txtHDSKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tblDSHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                TblDSHD_SelectionChanged();
            }
        });
        ReloadTaleHD();
    }//GEN-LAST:event_formWindowOpened

    private void txtHDSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHDSKeyReleased
        String hdSo = txtHDS.getText().trim();
        txtTriGia.setText(DatabaseManager.triGia(hdSo).toString());
    }//GEN-LAST:event_txtHDSKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QLHD().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QLHD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbMakh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIndexTblKH;
    private javax.swing.JTable tblDSHD;
    private javax.swing.JTextField txtHDS;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtTriGia;
    // End of variables declaration//GEN-END:variables
}
