package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class DataImporter {
    private static final String CSV_FILE = "albumlist.csv";
    private static final String DELIMITER = ",";

    public static void importData() throws SQLException, IOException {
        ArtistDAO artistDAO = new ArtistDAO();
        GenreDAO genreDAO = new GenreDAO();
        AlbumDAO albumDAO = new AlbumDAO();

        BufferedReader br = new BufferedReader(new FileReader(CSV_FILE));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(DELIMITER);

            // Extract data from CSV
            //int id = Integer.parseInt(data[0]);
            int year = Integer.parseInt(data[1]);
            String title = data[2];
            String artist = data[3];
            String genres = data[4];

            if (artistDAO.findByName(artist) == -1) {
                artistDAO.create(artist);
            }

            if (genreDAO.findByName(genres) == -1) {
                genreDAO.create(genres);
            }

            albumDAO.create(year, title, artist, String.join(",", genres));
        }
        br.close();
    }
}
