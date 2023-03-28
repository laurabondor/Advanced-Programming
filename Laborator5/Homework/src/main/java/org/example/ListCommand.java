package org.example;

import java.util.List;

public class ListCommand implements Command{
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public void execute() throws InvalidCommandException {
        List<Document> documents = catalog.getDocs();

        if (documents.isEmpty()) {
            System.out.println("Empty catalog");
        } else {
            System.out.println("Documents in the catalog:");
            for (Document document : documents) {
                System.out.println(document.getTitle());
            }
        }
    }
}
