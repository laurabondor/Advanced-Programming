package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e order by e.name"),
})
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    public void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Artist artist = new Artist("Beatles");
        em.persist(artist);

        Artist a = (Artist)em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


