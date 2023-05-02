package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {
    private static final String PERSISTENCE_UNIT_NAME = "ExamplePU";
    private static EntityManagerFactory emf;

    private ArtistRepository() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void create(Artist artist) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
    }

    public Artist findById(int id) {
        EntityManager em = emf.createEntityManager();
        Artist artist = em.find(Artist.class, id);
        em.close();
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for ID "
                    + id);
        }
        return artist;
    }

    public List<Artist> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName",
                Artist.class);
        query.setParameter("name", "%" + name + "%");
        List<Artist> artists = query.getResultList();
        em.close();
        return artists;
    }
}
