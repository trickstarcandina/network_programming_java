/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author Acer
 */
public class EmployeeDAO extends IDAO<Employee> {

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, IMAGE, JOB, SALARY, DEPT_ID, MNG_ID, GRD_ID FROM employee";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.rs = this.preStatement.executeQuery();
            Employee em;
            while (rs.next()) {
                em = new Employee(this.rs.getInt("EMP_ID"), this.rs.getString("EMP_NAME"),
                        this.rs.getString("EMP_NO"), this.rs.getDate("HIRE_DATE"),
                        this.rs.getBytes("IMAGE"), this.rs.getString("JOB"),
                        this.rs.getFloat("SALARY"), this.rs.getInt("DEPT_ID"), BigInteger.valueOf(this.rs.getInt("MNG_ID")),
                        this.rs.getInt("GRD_ID"));
                employees.add(em);
            }
        } catch (Exception e) {
        }
        return employees;
    }

    @Override
    public Employee selectByID(int id) {
        Employee em = null;
        String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, IMAGE, JOB, SALARY, DEPT_ID, MNG_ID, GRD_ID FROM employee WHERE EMP_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.rs = this.preStatement.executeQuery();
            while (rs.next()) {
                em = new Employee(this.rs.getInt("EMP_ID"), this.rs.getString("EMP_NAME"),
                        this.rs.getString("EMP_NO"), this.rs.getDate("HIRE_DATE"),
                        this.rs.getBytes("IMAGE"), this.rs.getString("JOB"),
                        this.rs.getFloat("SALARY"), this.rs.getInt("DEPT_ID"), BigInteger.valueOf(this.rs.getInt("MNG_ID")),
                        this.rs.getInt("GRD_ID"));
            }
        } catch (Exception e) {
        }
        return em;
    }

    @Override
    public List<Employee> selectByName(String name) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, IMAGE, JOB, SALARY, DEPT_ID, MNG_ID, GRD_ID FROM employee "
                + "WHERE EMP_NAME LIKE " + "'%" + name + "%'";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            System.out.println(sql);
            this.rs = this.preStatement.executeQuery();
            Employee em;
            while (rs.next()) {
                em = new Employee(this.rs.getInt("EMP_ID"), this.rs.getString("EMP_NAME"),
                        this.rs.getString("EMP_NO"), this.rs.getDate("HIRE_DATE"),
                        this.rs.getBytes("IMAGE"), this.rs.getString("JOB"),
                        this.rs.getFloat("SALARY"), this.rs.getInt("DEPT_ID"), BigInteger.valueOf(this.rs.getInt("MNG_ID")),
                        this.rs.getInt("GRD_ID"));
                employees.add(em);
            }
        } catch (Exception e) {
        }
        return employees;
    }

    @Override
    public int insert(Employee em) {
        String sql = "INSERT INTO EMPLOYEE (EMP_ID,"
                + "EMP_NAME,"
                + "EMP_NO,"
                + "HIRE_DATE,"
                + "IMAGE,"
                + "JOB,"
                + "SALARY,"
                + "DEPT_ID,"
                + "MNG_ID,"
                + "GRD_ID)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, em.getEmpId());
            this.preStatement.setString(2, em.getEmpName());
            this.preStatement.setString(3, em.getEmpNo());
            this.preStatement.setDate(4, new java.sql.Date(em.getHireDate().getTime()));
            this.preStatement.setBytes(5, em.getImage());
            this.preStatement.setString(6, em.getJob());
            this.preStatement.setFloat(7, em.getSalary());
            this.preStatement.setInt(8, em.getDeptId());
            this.preStatement.setLong(9, em.getMngId().longValue());
            this.preStatement.setInt(10, em.getGrdId());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Employee em) {
        String sql = "UPDATE EMPLOYEE SET EMP_NAME = ?, EMP_NO = ?, HIRE_DATE = ?, IMAGE= ?, JOB= ?, SALARY = ?, "
                + "DEPT_ID = ?, MNG_ID= ?, GRD_ID = ? WHERE EMP_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, em.getEmpName());
            this.preStatement.setString(2, em.getEmpNo());
            this.preStatement.setDate(3, new java.sql.Date(em.getHireDate().getTime()));
            this.preStatement.setBytes(4, em.getImage());
            this.preStatement.setString(5, em.getJob());
            this.preStatement.setFloat(6, em.getSalary());
            this.preStatement.setInt(7, em.getDeptId());
            this.preStatement.setLong(8, em.getMngId().longValue());
            this.preStatement.setInt(9, em.getGrdId());
            this.preStatement.setInt(10, em.getEmpId());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
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
