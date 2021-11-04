/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SalaryGrade;

/**
 *
 * @author Acer
 */
public class SalaryGradeDAO extends IDAO<SalaryGrade> {

    public SalaryGradeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<SalaryGrade> selectAll() {
        List<SalaryGrade> salaryGrades = new ArrayList<>();
        String sql = "SELECT GRADE, HIGH_SALARY, LOW_SALARY FROM SALARY_GRADE";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.rs = this.preStatement.executeQuery();
            SalaryGrade sa;
            while (rs.next()) {
                sa = new SalaryGrade(this.rs.getInt("GRADE"), this.rs.getFloat("HIGH_SALARY"), this.rs.getFloat("LOW_SALARY"));
                salaryGrades.add(sa);
            }
        } catch (Exception e) {
        }
        return salaryGrades;
    }

    @Override
    public SalaryGrade selectByID(int id) {
        String sql = "SELECT GRADE, HIGH_SALARY, LOW_SALARY FROM SALARY_GRADE WHERE GRADE = ?";
        SalaryGrade sa = null;
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, id);
            this.rs = this.preStatement.executeQuery();
            if (rs.next()) {
                sa = new SalaryGrade(this.rs.getInt("GRADE"), this.rs.getFloat("HIGH_SALARY"), this.rs.getFloat("LOW_SALARY"));
            }
        } catch (Exception e) {
        }
        return sa;
    }

    @Override
    public List<SalaryGrade> selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(SalaryGrade sa) {
        String sql = "INSERT INTO SALARY_GRADE (GRADE, HIGH_SALARY, LOW_SALARY) VALUES (?, ?, ?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, sa.getGrade());
            this.preStatement.setFloat(2, sa.getHighSalary());
            this.preStatement.setFloat(3, sa.getLowSalary());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(SalaryGrade sa) {
        String sql = "UPDATE SALARY_GRADE SET HIGH_SALARY = ?, LOW_SALARY = ? WHERE GRADE = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setFloat(1, sa.getHighSalary());
            this.preStatement.setFloat(2, sa.getLowSalary());
            this.preStatement.setInt(3, sa.getGrade());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM SALARY_GRADE WHERE GRADE = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, id);
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
