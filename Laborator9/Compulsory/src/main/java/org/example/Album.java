package org.example;

import javax.persistence.*;
@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Album e where e.artist = ?1"),
        //...
        })

public class Album {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "release_year")
        private Integer releaseYear;

        private String title;
        private Artist artist;

        public Album() {
        }

        public Album(Integer releaseYear, String title, Artist artist) {
                this.releaseYear = releaseYear;
                this.title = title;
                this.artist = artist;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Integer getReleaseYear() {
                return releaseYear;
        }

        public void setReleaseYear(Integer releaseYear) {
                this.releaseYear = releaseYear;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public Artist getArtist() {
                return artist;
        }

        public void setArtist(Artist artist) {
                this.artist = artist;
        }

        @Override
        public String toString() {
                return "Album{" +
                        "id=" + id +
                        ", releaseYear=" + releaseYear +
                        ", title='" + title + '\'' +
                        ", artist=" + artist +
                        '}';
        }
}
