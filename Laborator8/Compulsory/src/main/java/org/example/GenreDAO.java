package org.example;

import java.sql.*;
public class GenreDAO {
    int index = 0;
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id, name) values (?, ?)")) {
            pstmt.setInt(1, index);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            index++;
        }
    }

    public static Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
