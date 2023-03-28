package org.example;
import java.util.Map;
public class Article extends Document {
    /**
     * Article este constructorul clasei Article
     * @param id reprezinta id-ul articolului Article
     * @param title reprezinta titlul articolului Article
     * @param location reprezinta locatia articolului Article
     * @param tags reprezinta tagurile articolului Article
     * */
    public Article(String id, String title, String location, Map<String, Object> tags) {
        super(id, title, location, tags);
    }
    /**
     * @return returneaza tipul documentului adica Article
     * */
    @Override
    public String getType() {
        return "Article";
    }
}