package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();
    /**
     * Catalog reprezinta constructorul clasei Catalog
     * @param name reprezinta numele catalogului Catalog
     * */
    public Catalog(String name) {
        this.name = name;
    }
    /**
     * este o metoda setter
     * @param name reprezinta numele catalogului Catalog
     * */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return returneaza numele catalogului Catalog
     * */
    public String getName() {
        return name;
    }
    /**
     * @return returneaza documetele catalogului Catalog
     * */
    public List<Document> getDocs() {
        return docs;
    }
    /**
     * @param doc reprezinta documentul pe care il adaugam in ArrayList-ul docs
     * */
    public void add(Document doc) {
        docs.add(doc);
    }
    /**
     * @param id reprezinta id-ul cautat in ArrayList-ul docs
     * @return returneaza documentul care contine id-ul dat ca paramentru sau null daca nu exista un astfel de document
     * */
    public Document findById(String id) {
        for (var doc : docs) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
    /**
     * @param catalog reprezinta catalogul in care vom cauta
     * @param id reprezinta id-ul cautat in catalog
     * */
    public static Document getDocumentById(Catalog catalog, String id) {
        return catalog.findById(id);
    }
    /**
     * @param location reprezinta locatia pe care o cautam in ArrayList-ul docs
     * @return returneaza documentul care contine locatia dat ca paramentru sau null daca nu exista un astfel de document
     * */
    public Document findByLocation(String location) {
        for (var doc : docs) {
            if (doc.getLocation().equals(location)) {
                return doc;
            }
        }
        return null;
    }
    /**
     * @param catalog reprezinta catalogul in care vom cauta
     * @param location reprezinta locatia pe care o vom cauta in catalog
     * */
    public static Document getDocumentByLocation(Catalog catalog, String location) {
        return catalog.findByLocation(location);
    }
    /**
     * @param catalog reprezinta catalogul pe care vrem sa il salvam
     * @param path reprezinta calea in care va fi salvat catalogul
     * */
    public static void save(Catalog catalog, String path)
            throws IOException, InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
    /**
     * @param path reprezinta calea de unde se va deschide catalogul
     * */
    public static Catalog load(String path)
            throws IOException, InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Catalog.class);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Document doc : docs) {
            builder.append(doc).append("\n");
        }
        return builder.toString();
    }
}