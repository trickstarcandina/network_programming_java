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
import model.Department;

/**
 *
 * @author minht
 */
public class DepartmentView extends javax.swing.JPanel {

    private DefaultTableModel tm;
    
    public DepartmentView() {
        initComponents();
        tm = (DefaultTableModel) tbDepart.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDeId = new javax.swing.JTextField();
        tfDeName = new javax.swing.JTextField();
        tfDeNo = new javax.swing.JTextField();
        tfDeLocation = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDepart = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("DEFT_ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("No");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Location");

        tfDeId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfDeName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfDeNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfDeLocation.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

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

        tbDepart.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbDepart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "No", "Location"
            }
        ));
        tbDepart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDepartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDepart);

        tfSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Tìm theo tên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfDeName, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addComponent(tfDeId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfDeNo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)
                                .addComponent(tfDeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfDeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfDeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnReset))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnShow)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // lấy thông tin phòng ban gán vào bảng
    public void showAll(List<Department> departments){
        tm.setRowCount(0);
        for (Department de : departments) {
            tm.addRow(de.toObjects());
        }
    }
    // làm mới lại giao diện sau khi thêm/sửa/xóa
    public void resetForm(){
        tfDeId.setEditable(true);
        tfDeId.setText("");
        tfDeName.setText("");
        tfDeNo.setText("");
        tfDeLocation.setText("");
        tfSearch.setText("");
        tbDepart.setSelectionMode(0);
    }
    // lấy tên phòng ban để tìm kiếm
    public String getNameSearch(){
        return tfSearch.getText();
    }
    // lấy phòng ban từ form để thêm/sửa
    public Department getDepartment(){
        int deptId = 0;
        try {
            deptId = Integer.parseInt(tfDeId.getText());
            if(deptId <= 0){
                JOptionPane.showMessageDialog(this, "DepartmentId is number and > 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DepartmentId is number");
            return null;
        }
        String deptName = tfDeName.getText();
        deptName = deptName.replaceAll("\\s+", " ");
        deptName = deptName.trim();
        String deptNo = tfDeName.getText();
        deptNo = deptNo.replaceAll("\\s+", " ");
        deptNo = deptNo.trim();
        if(deptName.equals("") || deptNo.equals("")){
            JOptionPane.showMessageDialog(this, "Department Name and Department No not empty!");
            return null;
        }
        return new Department(deptId, deptName, deptNo, tfDeLocation.getText());
    }
    public void addRow(Department de){
        tm.addRow(de.toObjects());
    }
    // Sửa thông tin hàng sau khi sửa phòng ban
    public void setDepartment(int r, Department de){
        tm.setValueAt(de.getDeptId(), r, 0);
        tm.setValueAt(de.getDeptName(), r, 1);
        tm.setValueAt(de.getDeptNo(), r, 2);
        tm.setValueAt(de.getLocation(), r, 3);
    }
    // Xóa dòng sau khi xóa phòng ban
    public void removeRow(int r){
        tm.removeRow(r);
    }
    // lấy dòng đang chọn
    public int getRowSelected(){
        return tbDepart.getSelectedRow();
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
    public void btnSearchListener(ActionListener log){
        btnSearch.addActionListener(log);
    }
    // khi chọn vào 1 dòng trong bảng sẽ hiển thị thông tin ra form để sửa/xóa
    private void tbDepartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDepartMouseClicked
        int r = tbDepart.getSelectedRow();
        if(r >= 0){
            tfDeId.setText(tm.getValueAt(r, 0).toString());
            tfDeId.setEditable(false);
            tfDeName.setText(tm.getValueAt(r, 1).toString());
            tfDeNo.setText( tm.getValueAt(r, 2).toString());
            tfDeLocation.setText( tm.getValueAt(r, 3).toString());
        }
    }//GEN-LAST:event_tbDepartMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDepart;
    private javax.swing.JTextField tfDeId;
    private javax.swing.JTextField tfDeLocation;
    private javax.swing.JTextField tfDeName;
    private javax.swing.JTextField tfDeNo;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
