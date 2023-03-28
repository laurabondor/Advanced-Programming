package org.example;
public class AddCommand implements Command{
    private Catalog catalog;
    private Document doc;

    public AddCommand(Catalog catalog, Document doc) {
        this.catalog = catalog;
        this.doc = doc;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Document getDoc() {
        return doc;
    }

    public void execute() throws InvalidCommandException {
        if (catalog.getDocumentById(catalog, doc.getId()) != null) {
            throw new InvalidCommandException("Id already exists");
        }
        catalog.add(doc);
    }
}
