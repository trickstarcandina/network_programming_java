/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.Timekeeper;

/**
 *
 * @author minht
 */
public class TimeKeeperView extends javax.swing.JPanel {

    private DefaultTableModel tm;

    public TimeKeeperView() {
        initComponents();
        tm = (DefaultTableModel) tbTime.getModel();
    }

    // lấy thông tin phòng ban gán vào bảng
    public void showAll(List<Timekeeper> timekeepers) {
        tm.setRowCount(0);
        for (Timekeeper ti : timekeepers) {
            tm.addRow(ti.toObjects());
        }
    }

    // set combobox
    public void setCombobox(List<Employee> employees) {
        cbEmp.removeAllItems();
        cbEmp1.removeAllItems();
        for (Employee em : employees) {
            cbEmp.addItem(em.getEmpId() + ": " + em.getEmpName());
            cbEmp1.addItem(em.getEmpId() + ": " + em.getEmpName());
        }
    }

    // làm mới lại giao diện sau khi thêm/sửa/xóa
    public void resetForm() {
        tfTimeId.setEditable(true);
        tfTimeId.setText("");
        cbEmp.setSelectedIndex(0);
        cbEmp1.setSelectedIndex(0);
        raOff.setSelected(true);
        tfDate.setText("");
        tbTime.setSelectionMode(0);
    }
    // lấy id employee
    public int getEmpId(){
        return Integer.parseInt(cbEmp1.getSelectedItem().toString().split(":")[0]);
    }
    // lấy thông tin timekeeper
    public Timekeeper getTimekeeper() throws ParseException {
        String timekeeperId = tfTimeId.getText();
        timekeeperId = timekeeperId.replaceAll("\\s+", " ");
        timekeeperId = timekeeperId.trim();
        String date = tfDate.getText();
        if (!date.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Date format: dd/MM/yyyy");
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (timekeeperId.equals("") || date.equals("")) {
            JOptionPane.showMessageDialog(this, "timekeeperId and Date not empty!");
            return null;
        }
        String[] arr = cbEmp.getSelectedItem().toString().split(":");
        BigInteger empId = BigInteger.valueOf(Long.parseLong(arr[0]));
        String In_Out = "";
        if (raOn.isSelected()) {
            In_Out = "I";
        } else if (raOff.isSelected()) {
            In_Out = "O";
        }
        return new Timekeeper(timekeeperId, formatter.parse(date), In_Out, empId);
    }

    // Sửa thông tin hàng sau khi sửa 
    public void setTimekeeper(int r, Timekeeper ti) {
        tm.setValueAt(ti.getTimekeeper_Id(), r, 0);
        tm.setValueAt(ti.getDate_Time(), r, 1);
        tm.setValueAt(ti.getIn_Out(), r, 2);
        tm.setValueAt(ti.getEmpId(), r, 3);
    }

    // thêm hàng vào bảng
    public void addRow(Timekeeper ti) {
        tm.addRow(ti.toObjects());
    }

    // Xóa dòng sau khi xóa phòng ban
    public void removeRow(int r) {
        tm.removeRow(r);
    }

    // lấy dòng đang chọn
    public int getRowSelected() {
        return tbTime.getSelectedRow();
    }

    // nút thêm
    public void btnAddListener(ActionListener log) {
        btnAdd.addActionListener(log);
    }

    // nút sửa
    public void btnEditListener(ActionListener log) {
        btnEdit.addActionListener(log);
    }

    // nút xóa
    public void btnDeleteListener(ActionListener log) {
        btnDelete.addActionListener(log);
    }

    // nút hiển thị
    public void btnShowListener(ActionListener log) {
        btnShow.addActionListener(log);
    }

    // nút reset
    public void btnResetListener(ActionListener log) {
        btnReset.addActionListener(log);
    }

    // nút tìm kiếm
    public void btnSearchListener(ActionListener log) {
        btnSearch.addActionListener(log);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTimeId = new javax.swing.JTextField();
        tfDate = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTime = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbEmp = new javax.swing.JComboBox<>();
        cbEmp1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        raOn = new javax.swing.JRadioButton();
        raOff = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Time_ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date Time");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("In_Out");

        tfTimeId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setText("Thêm");

        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEdit.setText("Sửa");

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setText("Xóa");

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnReset.setText("Reset");

        btnShow.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnShow.setText("Hiển thị");

        tbTime.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date_Time", "In_Out", "EMP_ID"
            }
        ));
        tbTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTimeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTime);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("EMP");

        cbEmp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        cbEmp1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Xem lich cá nhân");

        buttonGroup1.add(raOn);
        raOn.setText("Làm");

        buttonGroup1.add(raOff);
        raOff.setSelected(true);
        raOff.setText("Nghỉ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfTimeId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(raOn)
                                    .addGap(43, 43, 43)
                                    .addComponent(raOff))
                                .addComponent(cbEmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbEmp)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTimeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(raOn)
                                .addComponent(raOff)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1083, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 20, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTimeMouseClicked
        int r = tbTime.getSelectedRow();
        if (r >= 0) {
            tfTimeId.setText(tm.getValueAt(r, 0).toString());
            tfTimeId.setEditable(false);
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(tm.getValueAt(r, 1).toString());
            } catch (ParseException ex) {
                Logger.getLogger(TimeKeeperView.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            tfDate.setText(formatter.format(date));
            if (tm.getValueAt(r, 2).toString().equals("I")) {
                raOn.setSelected(true);
            } else {
                raOff.setSelected(true);
            }
            for (int i = 0; i < cbEmp.getItemCount(); i++) {
                String[] s = cbEmp.getItemAt(i).split(":");
                Long b = Long.parseLong(s[0]);
                Long b1 = Long.parseLong(tm.getValueAt(r, 3).toString());
                if (Objects.equals(b1, b)) {
                    cbEmp.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tbTimeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShow;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbEmp;
    private javax.swing.JComboBox<String> cbEmp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton raOff;
    private javax.swing.JRadioButton raOn;
    private javax.swing.JTable tbTime;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfTimeId;
    // End of variables declaration//GEN-END:variables
}
