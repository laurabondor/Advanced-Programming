package org.example;

import java.util.HashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {
        Catalog catalog = new Catalog("My Catalog");

        // Add an article to the catalog
        Map<String, Object> articleTags = new HashMap<>();
        articleTags.put("title", "Laborator 5");
        articleTags.put("author", "Profesor Java");
        articleTags.put("publishingDate", "21-03-2023");
        AddCommand addCommand = new AddCommand(catalog, new Article("1", "Article1", "C:\\Users\\user\\lab5\\doc\\articles\\doc1.json", articleTags));
        addCommand.execute();

        // Save the article
        Document doc1 = Catalog.getDocumentById(catalog, "1");
        Document.save(doc1, "C:\\Users\\user\\lab5\\doc\\articles\\doc1.json");

        // Add a book to the catalog
        Map<String, Object> bookTags = new HashMap<>();
        bookTags.put("title", "Luceafarul");
        bookTags.put("author", "Eminescu");
        bookTags.put("year", "1883");
        addCommand.setDoc(new Book("2", "Book1", "C:\\Users\\user\\lab5\\doc\\books\\doc2.json", bookTags));
        addCommand.execute();

        // Save the book
        Document doc2 = Catalog.getDocumentById(catalog, "2");
        Document.save(doc2, "C:\\Users\\user\\lab5\\doc\\books\\doc2.json");

        //Save the catalog to an external file using JSON format
        Catalog.save(catalog, "catalog.json");

        System.out.println(catalog);

        Command listCommand = new ListCommand(catalog);
        listCommand.execute();

        Command viewCommand = new ViewCommand(Catalog.getDocumentById(catalog, "1"));
        viewCommand.execute();

        Command reportCommand = new ReportCommand(catalog);
        reportCommand.execute();
    }
}