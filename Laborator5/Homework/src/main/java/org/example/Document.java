package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
public abstract class Document implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page
    private Map<String, Object> tags;
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

    public Iterator<Map.Entry<String, Object>> iterator() {
        return tags.entrySet().iterator();
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
    /**
     * @param document reprezinta documentul pe care vrem sa il salvam
     * @param path reprezinta locatia unde salvam documentul document
     * */
    public static void save(Document document, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), document);
    }
}