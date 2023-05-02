package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        try {
            DataImporter.importData();
            AlbumDAO albumDAO = new AlbumDAO();

            // Print all the albums in the database
            System.out.println("All albums: ");
            albumDAO.printAll();
            Database.getConnection().close();

        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
