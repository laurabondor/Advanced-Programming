package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected abstract String getTableName();

    protected abstract String getIdColumnName();

    protected abstract String getNameColumnName();

    protected void create(String name) throws SQLException {
        Connection con = getConnection();

        int index;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select (max(id) +1) from "+ getTableName())) {
            index = rs.next() ? rs.getInt(1) : 0;
        }

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into " + getTableName() + " (" + getIdColumnName() + ", " + getNameColumnName() + ") values (?, ?)")) {
            pstmt.setInt(1, index);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }

    protected Connection getConnection() throws SQLException {
        return Database.getConnection();
    }

    protected int findByName(String name) throws SQLException {
        Connection con = getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select " + getIdColumnName() + " from " + getTableName() + " where " + getNameColumnName() + "='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : -1;
        }
    }

    protected String findById(int id) throws SQLException {
        Connection con = getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select " + getNameColumnName() + " from " + getTableName() + " where " + getIdColumnName() + "=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
