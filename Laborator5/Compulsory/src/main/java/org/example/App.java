package org.example;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("My Catalog");

        // Add an article to the catalog
        Map<String, Object> articleTags = new HashMap<>();
        articleTags.put("title", "Laborator 5");
        articleTags.put("author", "Profesor Java");
        articleTags.put("publishingDate", "21-03-2023");
        CatalogManager.addDocument(catalog, "1", "Article1", "C:\\Users\\user\\articles", articleTags, "Article");

        // Add a book to the catalog
        Map<String, Object> bookTags = new HashMap<>();
        bookTags.put("title", "Luceafarul");
        bookTags.put("author", "Eminescu");
        bookTags.put("year", "1883");
        CatalogManager.addDocument(catalog, "2", "Book1", "C:\\Users\\user\\books", bookTags, "Book");

        System.out.println(catalog);

        // Find a document by Id
        Document findById = CatalogManager.getDocumentById(catalog, "1");
        System.out.println("Document by Id: " + findById.getTitle());

        // Find documents by Location
        Document findByTag = CatalogManager.getDocumentByLocation(catalog, "C:\\Users\\user\\books");
        System.out.println("Document by tag: " + findByTag.getTitle());

        //Save the catalog to an external file using JSON format
        CatalogManager.save(catalog, "catalog.json");

        //Loads the catalog from an external file
        System.out.println(CatalogManager.load("catalog.json"));
    }
}