/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.EmployeeDAO;
import controller.dao.TimeKeeperDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Department;
import model.Employee;
import model.Timekeeper;
import view.TimeKeeperView;

/**
 *
 * @author Acer
 */
public class TimeKeeperControl {

    private TimeKeeperView view;
    private EmployeeDAO emDAO;
    private TimeKeeperDAO timeDAO;
    private List<Employee> employees;
    private List<Timekeeper> timekeepers;

    public TimeKeeperControl(TimeKeeperView view, EmployeeDAO emDAO, TimeKeeperDAO timeDAO) {
        this.view = view;
        this.emDAO = emDAO;
        this.timeDAO = timeDAO;

        this.view.btnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Timekeeper ti = view.getTimekeeper();
                    if (ti != null) {
                        Timekeeper ti1 = timeDAO.selectByTimeId(ti.getTimekeeper_Id());
                        if (ti1 == null) {
                            if (timeDAO.insert(ti) == 1) {
                                view.addRow(ti);
                                view.resetForm();
                                showAll();
                                JOptionPane.showMessageDialog(view, "Add successful");
                            } else {
                                JOptionPane.showMessageDialog(view, "Add failure");
                            }
                        } else {
                            JOptionPane.showMessageDialog(view, "TimekeeperID existed,Please retype!");
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
                    Timekeeper ti = null;
                    try {
                        ti = view.getTimekeeper();
                    } catch (ParseException ex) {
                        Logger.getLogger(TimeKeeperControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ti != null) {
                        if (timeDAO.update(ti) == 1) {
                            view.setTimekeeper(r, ti);
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
                    Timekeeper ti = null;
                    try {
                        ti = view.getTimekeeper();
                    } catch (ParseException ex) {
                        Logger.getLogger(TimeKeeperControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (ti != null) {
                        int c = JOptionPane.showConfirmDialog(view, "Are you sure delete?", "Delete", JOptionPane.YES_NO_OPTION);
                        if (c == JOptionPane.YES_OPTION) {
                            if (timeDAO.deleteTime(ti.getTimekeeper_Id()) == 1) {
                                view.removeRow(r);
                                view.resetForm();
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
                int id = view.getEmpId();
                timekeepers = timeDAO.selectByEmpId(id);
                view.showAll(timekeepers);
            }
        });
    }

    public void setCombobox() {
        employees = emDAO.selectAll();
        view.setCombobox(employees);
    }

    public void showAll() {
        timekeepers = timeDAO.selectAll();
        view.showAll(timekeepers);
    }

}
