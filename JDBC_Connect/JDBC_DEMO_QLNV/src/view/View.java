/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DepartmentControl;
import controller.EmployeeControl;
import controller.SalaryGradeControl;
import controller.TimeKeeperControl;
import controller.dao.DepartmentDAO;
import controller.dao.EmployeeDAO;
import controller.dao.SalaryGradeDAO;
import controller.dao.TimeKeeperDAO;
import controller.utils.ConnectionUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minht
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() throws SQLException, ClassNotFoundException {
        initComponents();
        // department
        DepartmentView departmentView = new DepartmentView();
        DepartmentDAO departmentDAO = new DepartmentDAO(ConnectionUtils.getMyConnection());
        DepartmentControl departmentControl = new DepartmentControl(departmentView, departmentDAO);
        departmentControl.showAll();
        jTabbedPane1.add("Department", departmentView);
        //salary grade
        SalaryGradeView salaryGradeView = new SalaryGradeView();
        SalaryGradeDAO salaryGradeDAO = new SalaryGradeDAO(ConnectionUtils.getMyConnection());
        SalaryGradeControl salaryGradeControl = new SalaryGradeControl(salaryGradeView, salaryGradeDAO);
        salaryGradeControl.showAll();
        jTabbedPane1.add("Salary Grade", salaryGradeView);
        //employee
        EmployeeView viewEmployee = new EmployeeView();
        EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionUtils.getMyConnection());
        EmployeeControl employeeControl = new EmployeeControl(viewEmployee, salaryGradeDAO, departmentDAO, employeeDAO);
        employeeControl.showAll();
        employeeControl.setCombobox();
        jTabbedPane1.add("Employee", viewEmployee);
        // timekeeper
        TimeKeeperView viewTimeKeeper = new TimeKeeperView();
        TimeKeeperDAO timeKeeperDAO = new TimeKeeperDAO(ConnectionUtils.getMyConnection());
        TimeKeeperControl timeKeeperControl = new TimeKeeperControl(viewTimeKeeper, employeeDAO, timeKeeperDAO);
        timeKeeperControl.setCombobox();
        timeKeeperControl.showAll();
        jTabbedPane1.add("TimeKeeper", viewTimeKeeper);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new View().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
