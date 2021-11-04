/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.SalaryGradeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.SalaryGrade;
import view.SalaryGradeView;

/**
 *
 * @author Acer
 */
public class SalaryGradeControl {

    private SalaryGradeView view;
    private SalaryGradeDAO dao;
    private List<SalaryGrade> salaryGrades;

    public SalaryGradeControl(SalaryGradeView view, SalaryGradeDAO dao) {
        this.view = view;
        this.dao = dao;

        this.view.btnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalaryGrade sa = view.getSalaryGrade();
                if (sa != null) {
                    SalaryGrade sa1 = dao.selectByID(sa.getGrade());
                    if (sa1 == null) {
                        if (dao.insert(sa) == 1) {
                            view.addRow(sa);
                            view.resetForm();
                            JOptionPane.showMessageDialog(view, "Add successful");
                        } else {
                            JOptionPane.showMessageDialog(view, "Add failure");
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Grade existed,Please retype!");
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
                    SalaryGrade sa = view.getSalaryGrade();
                    if (sa != null) {
                        if (dao.update(sa) == 1) {
                            view.setSalaryGrade(r, sa);
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
                    SalaryGrade de = view.getSalaryGrade();
                    int c = JOptionPane.showConfirmDialog(view, "Are you sure delete?", "Delete", JOptionPane.YES_NO_OPTION);
                    if (c == JOptionPane.YES_OPTION) {
                        if (dao.delete(de.getGrade()) == 1) {
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
    }

    public void showAll() {
        salaryGrades = dao.selectAll();
        view.showAll(salaryGrades);
    }
}
