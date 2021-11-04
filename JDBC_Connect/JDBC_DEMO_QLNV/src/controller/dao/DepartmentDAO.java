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
import model.Department;

/**
 *
 * @author Acer
 */
public class DepartmentDAO extends IDAO<Department> {

    public DepartmentDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Department> selectAll() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION FROM DEPARTMENT";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.rs = this.preStatement.executeQuery();
            Department de;
            while (rs.next()) {
                de = new Department(this.rs.getInt("DEPT_ID"), this.rs.getString("DEPT_NAME"),
                        this.rs.getString("DEPT_NO"), this.rs.getString("LOCATION"));
                list.add(de);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Department selectByID(int id) {
        Department de = null;
        String sql = "SELECT DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION FROM DEPARTMENT WHERE DEPT_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, id);
            this.rs = this.preStatement.executeQuery();
            if (rs.next()) {
                de = new Department(this.rs.getInt("DEPT_ID"), this.rs.getString("DEPT_NAME"),
                        this.rs.getString("DEPT_NO"), this.rs.getString("LOCATION"));
            }
        } catch (Exception e) {
        }
        return de;
    }

    @Override
    public List<Department> selectByName(String name) {
        String sql = "SELECT DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION FROM DEPARTMENT WHERE DEPT_NAME LIKE " + "'%" + name + "%'";
        List<Department> departments = new ArrayList<>();
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.rs = this.preStatement.executeQuery();
            Department de;
            while (rs.next()) {
                de = new Department(this.rs.getInt("DEPT_ID"), this.rs.getString("DEPT_NAME"),
                        this.rs.getString("DEPT_NO"), this.rs.getString("LOCATION"));
                departments.add(de);
            }
        } catch (Exception e) {
        }
        return departments;
    }

    @Override
    public int insert(Department de) {
        String sql = "INSERT INTO DEPARTMENT (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION) VALUES (?, ?, ?, ?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, de.getDeptId());
            this.preStatement.setString(2, de.getDeptName());
            this.preStatement.setString(3, de.getDeptNo());
            this.preStatement.setString(4, de.getLocation());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Department de) {
        String sql = "UPDATE DEPARTMENT SET DEPT_NAME = ?, DEPT_NO = ?, LOCATION = ? WHERE DEPT_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, de.getDeptName());
            this.preStatement.setString(2, de.getDeptNo());
            this.preStatement.setString(3, de.getLocation());
            this.preStatement.setInt(4, de.getDeptId());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM DEPARTMENT WHERE DEPT_ID = ?";
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
