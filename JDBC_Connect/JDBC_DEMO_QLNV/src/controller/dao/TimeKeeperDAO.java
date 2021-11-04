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
import model.Timekeeper;

/**
 *
 * @author Acer
 */
public class TimeKeeperDAO extends IDAO<Timekeeper> {

    public TimeKeeperDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Timekeeper> selectAll() {
        List<Timekeeper> timekeepers = new ArrayList<>();
        String sql = "SELECT Timekeeper_Id, Date_Time, In_Out, EMP_ID FROM timekeeper";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.rs = this.preStatement.executeQuery();
            Timekeeper ti;
            while (rs.next()) {
                ti = new Timekeeper(this.rs.getString("Timekeeper_Id"), this.rs.getDate("Date_Time"),
                        this.rs.getString("In_Out"), BigInteger.valueOf(this.rs.getInt("EMP_ID")));
                timekeepers.add(ti);
            }
        } catch (Exception e) {
        }
        return timekeepers;
    }
    public List<Timekeeper> selectByEmpId(int id) {
        List<Timekeeper> timekeepers = new ArrayList<>();
        String sql = "SELECT Timekeeper_Id, Date_Time, In_Out, EMP_ID FROM timekeeper WHERE EMP_ID = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setInt(1, id);
            this.rs = this.preStatement.executeQuery();
            Timekeeper ti;
            while (rs.next()) {
                ti = new Timekeeper(this.rs.getString("Timekeeper_Id"), this.rs.getDate("Date_Time"),
                        this.rs.getString("In_Out"), BigInteger.valueOf(this.rs.getInt("EMP_ID")));
                timekeepers.add(ti);
            }
        } catch (Exception e) {
        }
        return timekeepers;
    }
    @Override
    public Timekeeper selectByID(int id) {
        Timekeeper ti = null;
        return ti;
    }

    public Timekeeper selectByTimeId(String id) {
        Timekeeper ti = null;
        String sql = "SELECT Timekeeper_Id, Date_Time, In_Out, EMP_ID FROM timekeeper WHERE Timekeeper_Id = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, id);
            this.rs = this.preStatement.executeQuery();
            while (rs.next()) {
                ti = new Timekeeper(this.rs.getString("Timekeeper_Id"), this.rs.getDate("Date_Time"),
                        this.rs.getString("In_Out"), BigInteger.valueOf(this.rs.getInt("EMP_ID")));
            }
        } catch (Exception e) {
        }
        return ti;
    }
    
    @Override
    public List<Timekeeper> selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Timekeeper ti) {
        String sql = "INSERT INTO timekeeper (Timekeeper_Id, Date_Time, In_Out, EMP_ID) VALUES (?, ?, ?, ?)";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, ti.getTimekeeper_Id());
            this.preStatement.setDate(2, new java.sql.Date(ti.getDate_Time().getTime()));
            this.preStatement.setString(3, ti.getIn_Out());
            this.preStatement.setLong(4, ti.getEmpId().longValue());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int update(Timekeeper ti) {
        String sql = "UPDATE timekeeper SET Date_Time = ?, In_Out = ?, EMP_ID = ? WHERE Timekeeper_Id = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setDate(1, new java.sql.Date(ti.getDate_Time().getTime()));
            this.preStatement.setString(2, ti.getIn_Out());
            this.preStatement.setLong(3, ti.getEmpId().longValue());
            this.preStatement.setString(4, ti.getTimekeeper_Id());
            this.preStatement.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int deleteTime(String id) {
        String sql = "DELETE FROM timekeeper WHERE Timekeeper_Id = ?";
        try {
            this.preStatement = this.conn.prepareStatement(sql);
            this.preStatement.setString(1, id);
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
