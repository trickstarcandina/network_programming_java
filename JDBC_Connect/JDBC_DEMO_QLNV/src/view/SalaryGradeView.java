/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SalaryGrade;

/**
 *
 * @author minht
 */
public class SalaryGradeView extends javax.swing.JPanel {

    private DefaultTableModel tm;

    public SalaryGradeView() {
        initComponents();
        tm = (DefaultTableModel) tbSalary.getModel();
    }

    // lấy thông tin lương gán vào bảng
    public void showAll(List<SalaryGrade> salaryGrades) {
        tm.setRowCount(0);
        for (SalaryGrade sa : salaryGrades) {
            tm.addRow(sa.toObjects());
        }
    }

    // làm mới giao diện nhập
    public void resetForm() {
        tfSaId.setEditable(true);
        tfSaId.setText("");
        tfSaHigh.setText("");
        tfSaLow.setText("");
        tbSalary.setSelectionMode(0);
    }

    // lấy phòng ban từ form để thêm/sửa
    public SalaryGrade getSalaryGrade() {
        int grade = 0;
        try {
            grade = Integer.parseInt(tfSaId.getText());
            if (grade <= 0) {
                JOptionPane.showMessageDialog(this, "Grade is number and > 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Grade is number");
            return null;
        }
        float highSalary = 0;
        try {
            highSalary = Float.parseFloat(tfSaHigh.getText());
            if (highSalary <= 0) {
                JOptionPane.showMessageDialog(this, "High Salary is number and > 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "High Salary is number");
            return null;
        }
        float lowSalary = 0;
        try {
            lowSalary = Float.parseFloat(tfSaLow.getText());
            if (lowSalary <= 0) {
                JOptionPane.showMessageDialog(this, "Low Salary is number and > 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Low Salary is number");
            return null;
        }
        if (highSalary <= lowSalary) {
            JOptionPane.showMessageDialog(this, "High Salary must be bigger than Low Salary");
            return null;
        }
        return new SalaryGrade(grade, highSalary, lowSalary);
    }

    // thêm lương thành công
    public void addRow(SalaryGrade sa) {
        tm.addRow(sa.toObjects());
    }

    // Sửa thông tin hàng sau khi sửa phòng ban
    public void setSalaryGrade(int r, SalaryGrade sa) {
        tm.setValueAt(sa.getGrade(), r, 0);
        tm.setValueAt(sa.getHighSalary(), r, 1);
        tm.setValueAt(sa.getLowSalary(), r, 2);
    }

    // Xóa dòng sau khi xóa phòng ban
    public void removeRow(int r) {
        tm.removeRow(r);
    }

    // lấy dòng đang chọn
    public int getRowSelected() {
        return tbSalary.getSelectedRow();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfSaId = new javax.swing.JTextField();
        tfSaHigh = new javax.swing.JTextField();
        tfSaLow = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSalary = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Grade_ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("High Salary");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Low Salary");

        tfSaId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfSaHigh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfSaLow.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

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

        tbSalary.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbSalary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade ID", "High Salary", "Low Salary"
            }
        ));
        tbSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSalaryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSalary);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfSaHigh, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(tfSaLow)
                            .addComponent(tfSaId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfSaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfSaHigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfSaLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnShow))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1074, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 573, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // lấy dữ liệu dòng được chọn trong bảng ra form
    private void tbSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSalaryMouseClicked
        int r = tbSalary.getSelectedRow();
        if (r >= 0) {
            tfSaId.setText(tm.getValueAt(r, 0).toString());
            tfSaId.setEditable(false);
            tfSaHigh.setText(tm.getValueAt(r, 1).toString());
            tfSaLow.setText(tm.getValueAt(r, 2).toString());
        }
    }//GEN-LAST:event_tbSalaryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSalary;
    private javax.swing.JTextField tfSaHigh;
    private javax.swing.JTextField tfSaId;
    private javax.swing.JTextField tfSaLow;
    // End of variables declaration//GEN-END:variables
}
