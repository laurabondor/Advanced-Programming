package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Artist artist = new Artist();
        artist.testJPA();

        ArtistRepository artistRepository = null;
        artistRepository.create(artist);

        Artist foundArtist = artistRepository.findById(artist.getId());
        System.out.println(foundArtist);

        List<Artist> artists = artistRepository.findByName("Beatles");
        System.out.println(artists);
    }
}