/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.DepartmentDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.Department;
import view.DepartmentView;

/**
 *
 * @author Acer
 */
public class DepartmentControl {

    private DepartmentView view;
    private DepartmentDAO dao;
    private List<Department> departments;

    public DepartmentControl(DepartmentView view, DepartmentDAO dao) {
        this.view = view;
        this.dao = dao;
        this.view.btnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department de = view.getDepartment();
                if (de != null) {
                    Department de1 = dao.selectByID(de.getDeptId());
                    if (de1 == null) {
                        if (dao.insert(de) == 1) {
                            view.addRow(de);
                            view.resetForm();
                            JOptionPane.showMessageDialog(view, "Add successful");
                        } else {
                            JOptionPane.showMessageDialog(view, "Add failure");
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "DepartmentID existed,Please retype!");
                    }
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
                    Department de = view.getDepartment();
                    if (de != null) {
                        if (dao.update(de) == 1) {
                            view.setDepartment(r, de);
                            view.resetForm();
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
                    Department de = view.getDepartment();
                    int c = JOptionPane.showConfirmDialog(view, "Are you sure delete?", "Delete", JOptionPane.YES_NO_OPTION);
                    if (c == JOptionPane.YES_OPTION) {
                        if (dao.delete(de.getDeptId()) == 1) {
                            view.removeRow(r);
                            view.resetForm();
                            JOptionPane.showMessageDialog(view, "Delete successful");
                        } else {
                            JOptionPane.showMessageDialog(view, "Delete failure");
                        }
                    }
                }
            }
        });

        this.view.btnShowListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAll();
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
                departments = dao.selectByName(name);
                view.showAll(departments);
            }
        });

    }

    public void showAll() {
        departments = dao.selectAll();
        view.showAll(departments);
    }
}
