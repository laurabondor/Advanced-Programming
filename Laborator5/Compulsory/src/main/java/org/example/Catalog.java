package org.example;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Document doc : docs) {
            builder.append(doc).append("\n");
        }
        return builder.toString();
    }
}