package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
public abstract class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();
    /**
     * getType este o metoda abstracta care va fi implementata in clasele derivate si returneaza tipul documentului
     * */
    public abstract String getType();
    /**
     * Document este constructorul clasei Document
     * @param id reprezinta id-ul documentului Document
     * @param title reprezinta titlul documentului Document
     * @param location reprezinta locatia documentului Document
     * @param tags reprezinta tagurile documentului Document
     * */
    public Document(String id, String title, String location, Map<String, Object> tags){
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = tags;
    }
    /**
     * @return returneaza id-ul documentului Document
     * */
    public String getId() {
        return id;
    }
    /**
     * @return returneaza titlul-ul documentului Document
     * */
    public String getTitle() {
        return title;
    }
    /**
     * @return returneaza locatia unde se gaseste documentul Document
     * */
    public String getLocation() {
        return location;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}

class CatalogManager {
    private Catalog catalog;
    /**
     * CatalogManager reprezinta constructorul clasei
     * */
    public CatalogManager(Catalog catalog) {
        this.catalog = catalog;
    }
    /**
     * @param catalog reprezinta catalogul in care vrem sa adaugam documente
     * @param id reprezinta id-ul documentului Document
     * @param name reprezinta numele documentului Document
     * @param location reprezinta locatia documentului Document
     * @param tags reprezinta tagurile documentului Document
     * @param type reprezinta tipul documentului Document
     * */
    public static void addDocument(Catalog catalog, String id, String name, String location, Map<String, Object> tags, String type) {
        Document document;
        switch (type) {
            case "Article":
                document = new Article(id, name, location, tags);
                break;
            case "Book":
                document = new Book(id, name, location, tags);
                break;
            default:
                throw new IllegalArgumentException("Error: document type");
        }
        catalog.add(document);
    }
    /**
     * @param catalog reprezinta catalogul pe care vrem sa il salvam
     * @param path reprezinta calea in care va fi salvat catalogul
     * */
    public static void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
    /**
     * @param path reprezinta calea de unde se va deschide catalogul
     * */
    public static Catalog load(String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }
    /**
     * @param catalog reprezinta catalogul in care vom cauta
     * @param id reprezinta id-ul cautat in catalog
     * */
    public static Document getDocumentById(Catalog catalog, String id) {
        return catalog.findById(id);
    }
    /**
     * @param catalog reprezinta catalogul in care vom cauta
     * @param location reprezinta locatia pe care o vom cauta in catalog
     * */
    public static Document getDocumentByLocation(Catalog catalog, String location) {
        return catalog.findByLocation(location);
    }

    @Override
    public String toString() {
        return "CatalogManager{" +
                "catalogName='" + catalog + '\'' +
                '}';
    }
}