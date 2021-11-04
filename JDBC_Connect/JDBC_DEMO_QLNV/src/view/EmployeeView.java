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
import model.Department;
import model.Employee;
import model.SalaryGrade;

/**
 *
 * @author minht
 */
public class EmployeeView extends javax.swing.JPanel {

    private DefaultTableModel tm;

    public EmployeeView() {
        initComponents();
        tm = (DefaultTableModel) tbEm.getModel();
        btnDelete.setEnabled(false);
    }

    // hiển thị bảng
    public void showAll(List<Employee> employees) {
        tm.setRowCount(0);
        for (Employee em : employees) {
            tm.addRow(em.toObjects());
        }
    }

    // reset form
    public void resetForm() {
        tfEmId.setText("");
        tfEmId.setEditable(true);
        tfEmName.setText("");
        tfEmNo.setText("");
        tfHireDate.setText("");
        tfImg.setText("");
        tfJob.setText("");
        tfSalary.setText("");
        tfSearch.setText("");
        cbSG.setSelectedIndex(0);
        cbEm.setSelectedIndex(0);
        cbD.setSelectedIndex(0);
        tbEm.setSelectionMode(0);
    }

    // lấy tên để tìm
    public String getNameSearch() {
        return tfSearch.getText();
    }

    // set combobox
    public void setCombobox(List<SalaryGrade> salaryGrades, List<Department> departments, List<Employee> employees) {
        cbSG.removeAllItems();
        cbEm.removeAllItems();
        cbD.removeAllItems();
        for (SalaryGrade sa : salaryGrades) {
            cbSG.addItem(sa.getGrade() + ": " + sa.getLowSalary() + "-" + sa.getHighSalary());
        }
        for (Employee em : employees) {
            cbEm.addItem(em.getEmpId() + ": " + em.getEmpName());
        }
        for (Department de : departments) {
            cbD.addItem(de.getDeptId() + ": " + de.getDeptName());
        }
    }

    //lấy thông tin nhân viên
    public Employee getEmployee() throws ParseException {
        int empId = 0;
        try {
            empId = Integer.parseInt(tfEmId.getText());
            if (empId <= 0) {
                JOptionPane.showMessageDialog(this, "EmployeeId is number and > 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "EmployeeId is number");
            return null;
        }
        String empName = tfEmName.getText();
        empName = empName.replaceAll("\\s+", " ");
        empName = empName.trim();
        String empNo = tfEmNo.getText();
        empNo = empNo.replaceAll("\\s+", " ");
        empNo = empNo.trim();
        String hireDate = tfHireDate.getText();
        if (!hireDate.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Date format: dd/MM/yyyy");
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String job = tfJob.getText();
        job = job.replaceAll("\\s+", " ");
        job = job.trim();
        if (empName.equals("") || empNo.equals("") || job.equals("")) {
            JOptionPane.showMessageDialog(this, "Department Name and Department No And Job not empty!");
            return null;
        }
        float salary = 0;
        try {
            salary = Float.parseFloat(tfSalary.getText());
            if (salary <= 0) {
                JOptionPane.showMessageDialog(this, "Salary is number and > 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salary is number");
            return null;
        }
        String[] arr = cbEm.getSelectedItem().toString().split(":");
        BigInteger mngId = BigInteger.valueOf(Long.parseLong(arr[0]));
        System.out.println(mngId);
        String[] arr1 = cbD.getSelectedItem().toString().split(":");
        int dId = Integer.parseInt(arr1[0]);
        System.out.println(dId);
        String[] arr2 = cbSG.getSelectedItem().toString().split(":");
        int sgId = Integer.parseInt(arr2[0]);
        System.out.println(sgId);
        return new Employee(empId, empName, empNo, formatter.parse(hireDate), null, job, salary, dId, mngId, sgId);
    }

    // add row
    public void addRow(Employee em) {
        tm.addRow(em.toObjects());
    }

    // Sửa thông tin hàng sau khi sửa 
    public void setEmployee(int r, Employee em) {
        tm.setValueAt(em.getEmpId(), r, 0);
        tm.setValueAt(em.getEmpName(), r, 1);
        tm.setValueAt(em.getEmpNo(), r, 2);
        tm.setValueAt(em.getHireDate(), r, 3);
        tm.setValueAt(em.getImage(), r, 4);
        tm.setValueAt(em.getJob(), r, 5);
        tm.setValueAt(em.getSalary(), r, 6);
        tm.setValueAt(em.getDeptId(), r, 7);
        tm.setValueAt(em.getMngId(), r, 8);
        tm.setValueAt(em.getGrdId(), r, 9);
    }

    // Xóa dòng sau khi xóa phòng ban
    public void removeRow(int r) {
        tm.removeRow(r);
    }

    // lấy dòng đang chọn
    public int getRowSelected() {
        return tbEm.getSelectedRow();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfEmId = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEm = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfEmName = new javax.swing.JTextField();
        tfEmNo = new javax.swing.JTextField();
        tfHireDate = new javax.swing.JTextField();
        tfImg = new javax.swing.JTextField();
        tfJob = new javax.swing.JTextField();
        tfSalary = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbD = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbSG = new javax.swing.JComboBox<>();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbEm = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("EMP_ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Name emp");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("No emp");

        tfEmId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

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

        tbEm.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbEm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMP_ID", "Name emp", "No emp", "Hire Date", "Image ", "Job", "Salary Float", "Dept ID", "Mng_ID", "Grd_ID"
            }
        ));
        tbEm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEm);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Hire Date");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Job");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Image");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Salary ");

        tfEmName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfEmNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfHireDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfImg.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfJob.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tfSalary.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("SalaryGrade");

        cbD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Department");

        cbSG.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        tfSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Tìm");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Manager");

        cbEm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSalary)
                            .addComponent(tfJob)
                            .addComponent(tfImg)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tfEmName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfEmId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfEmNo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfHireDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfEmId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfEmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tfEmNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnReset)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnShow))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmMouseClicked
        int r = tbEm.getSelectedRow();
        if (r >= 0) {
            tfEmId.setText(tm.getValueAt(r, 0).toString());
            tfEmId.setEditable(false);
            tfEmName.setText(tm.getValueAt(r, 1).toString());
            tfEmNo.setText(tm.getValueAt(r, 2).toString());
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(tm.getValueAt(r, 3).toString());
            } catch (ParseException ex) {
                Logger.getLogger(TimeKeeperView.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            tfHireDate.setText(formatter.format(date));
            tfImg.setText("");
//            if (tm.getValueAt(r, 4).toString().equals("") || tm.getValueAt(r, 4).toString() == null || tm.getValueAt(r, 4) == null ) {
//                tfImg.setText("");
//            } else {
//                tfImg.setText(tm.getValueAt(r, 4).toString());
//            }
            tfJob.setText(tm.getValueAt(r, 5).toString());
            tfSalary.setText(tm.getValueAt(r, 6).toString());
            for (int i = 0; i < cbEm.getItemCount(); i++) {
                String[] s = cbEm.getItemAt(i).split(":");
                Long b = Long.parseLong(s[0]);
                Long b1 = Long.parseLong(tm.getValueAt(r, 8).toString());
                if (Objects.equals(b1, b)) {
                    cbEm.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < cbD.getItemCount(); i++) {
                String[] s = cbD.getItemAt(i).split(":");
                Long b = Long.parseLong(s[0]);
                Long b1 = Long.parseLong(tm.getValueAt(r, 7).toString());
                if (Objects.equals(b1, b)) {
                    cbD.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < cbSG.getItemCount(); i++) {
                String[] s = cbSG.getItemAt(i).split(":");
                Long b = Long.parseLong(s[0]);
                Long b1 = Long.parseLong(tm.getValueAt(r, 9).toString());
                if (Objects.equals(b1, b)) {
                    cbSG.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_tbEmMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShow;
    private javax.swing.JComboBox<String> cbD;
    private javax.swing.JComboBox<String> cbEm;
    private javax.swing.JComboBox<String> cbSG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEm;
    private javax.swing.JTextField tfEmId;
    private javax.swing.JTextField tfEmName;
    private javax.swing.JTextField tfEmNo;
    private javax.swing.JTextField tfHireDate;
    private javax.swing.JTextField tfImg;
    private javax.swing.JTextField tfJob;
    private javax.swing.JTextField tfSalary;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
