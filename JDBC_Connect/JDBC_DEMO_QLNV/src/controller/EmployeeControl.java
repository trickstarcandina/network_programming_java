/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.DepartmentDAO;
import controller.dao.EmployeeDAO;
import controller.dao.SalaryGradeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Department;
import model.Employee;
import model.SalaryGrade;
import model.Timekeeper;
import view.EmployeeView;

/**
 *
 * @author Acer
 */
public class EmployeeControl {

    private EmployeeView view;
    private SalaryGradeDAO saDAO;
    private DepartmentDAO deDAO;
    private EmployeeDAO emDAO;
    private List<SalaryGrade> salaryGrades;
    private List<Department> departments;
    private List<Employee> employees;

    public EmployeeControl(EmployeeView view, SalaryGradeDAO saDAO, DepartmentDAO deDAO, EmployeeDAO emDAO) {
        this.view = view;
        this.saDAO = saDAO;
        this.deDAO = deDAO;
        this.emDAO = emDAO;

        this.view.btnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Employee em = view.getEmployee();
                    if (em != null) {
                        System.out.println(em.getEmpId());
                        System.out.println(em.getHireDate());
                        System.out.println(em.getMngId());
                        
                        Employee em1 = emDAO.selectByID(em.getEmpId());
                        if (em1 == null) {
                            if (emDAO.insert(em) == 1) {
                                view.addRow(em);
                                view.resetForm();
                                showAll();
                                JOptionPane.showMessageDialog(view, "Add successful");
                            } else {
                                JOptionPane.showMessageDialog(view, "Add failure");
                            }
                        } else {
                            JOptionPane.showMessageDialog(view, "EmployeeID existed,Please retype!");
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(TimeKeeperControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.view.btnEditListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = view.getRowSelected();
                if (r < 0) {
                    JOptionPane.showMessageDialog(view, "Please choose a row to edit or delete");
                } else {
                    Employee em = null;
                    try {
                        em = view.getEmployee();
                    } catch (ParseException ex) {
                        Logger.getLogger(TimeKeeperControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (em != null) {
                        if (emDAO.update(em) == 1) {
                            view.setEmployee(r, em);
                            view.resetForm();
                            showAll();
                            JOptionPane.showMessageDialog(view, "Update successful");
                        } else {
                            JOptionPane.showMessageDialog(view, "Update failure");
                        }
                    }
                }
            }
        });
        this.view.btnDeleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = view.getRowSelected();
                if (r < 0) {
                    JOptionPane.showMessageDialog(view, "Please choose a row to edit or delete");
                } else {
                    Employee em = null;
                    try {
                        em = view.getEmployee();
                    } catch (ParseException ex) {
                        Logger.getLogger(TimeKeeperControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (em != null) {
                        int c = JOptionPane.showConfirmDialog(view, "Are you sure delete?", "Delete", JOptionPane.YES_NO_OPTION);
                        if (c == JOptionPane.YES_OPTION) {
                            if (emDAO.delete(em.getEmpId()) == 1) {
                                view.removeRow(r);
                                view.resetForm();
                                showAll();
                                JOptionPane.showMessageDialog(view, "Delete successful");
                            } else {
                                JOptionPane.showMessageDialog(view, "Delete failure");
                            }
                        }
                    }
                }
            }
        });
        this.view.btnShowListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAll();
                setCombobox();
            }
        });
        this.view.btnResetListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.resetForm();
            }
        });
        this.view.btnSearchListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = view.getNameSearch();
                employees = emDAO.selectByName(name);
                view.showAll(employees);
            }
        });

    }

    public void setCombobox() {
        salaryGrades = saDAO.selectAll();
        departments = deDAO.selectAll();
        employees = emDAO.selectAll();
        view.setCombobox(salaryGrades, departments, employees);
    }

    public void showAll() {
        employees = emDAO.selectAll();
        view.showAll(employees);
    }
}
