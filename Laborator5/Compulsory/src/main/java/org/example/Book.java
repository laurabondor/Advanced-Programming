package org.example;
import java.util.Map;
public class Book extends Document {
    /**
     * Book este constructorul clasei Book
     * @param id reprezinta id-ul cartii Book
     * @param title reprezinta titlul cartii Book
     * @param location reprezinta locatia cartii Book
     * @param tags reprezinta tagurile cartii Book
     * */
    public Book(String id, String title, String location, Map<String, Object> tags) {
        super(id, title, location, tags);
    }
    /**
     * @return returneaza tipul documentului adica Book
     * */
    @Override
    public String getType() {
        return "Book";
    }
}