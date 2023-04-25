package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {
    int index = 0;
    public void create(int year, String title, String artist, String genres) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id, release_year, title, artist, genres) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, index);
            pstmt.setInt(2, year);
            pstmt.setString(3, title);
            pstmt.setString(4, artist);
            pstmt.setString(5, genres);
            pstmt.executeUpdate();

            int albumId = index;
            int genreId = GenreDAO.findByName(genres);
                try (PreparedStatement pstmt2 = con.prepareStatement(
                        "insert into album_genres (album_id, genre_id) values (?, ?)")) {
                    pstmt2.setInt(1, albumId);
                    pstmt2.setInt(2, genreId);
                    pstmt2.executeUpdate();
                }
            index++;
        }
    }

    public List<Album> findAll() throws SQLException {
        List<Album> albums = new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from albums")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int year = rs.getInt("release_year");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String genres = rs.getString("genres");
                Album album = new Album(id, year, title, artist, genres);
                albums.add(album);
            }
        }
        return albums;
    }

    public void printAll() throws SQLException {
        List<Album> albums = findAll();
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    private static class Album {
        private final int id;
        private final int year;
        private final String title;
        private final String artist;
        private final String genres;

        public Album(int id, int year, String title, String artist, String genres) {
            this.id = id;
            this.year = year;
            this.title = title;
            this.artist = artist;
            this.genres = genres;
        }

        @Override
        public String toString() {
            return "Album{" +
                    "id=" + id +
                    ", year=" + year +
                    ", title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", genres=" + genres +
                    '}';
        }
    }
}
