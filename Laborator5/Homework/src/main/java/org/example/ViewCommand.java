package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command{
    private Document doc;

    public ViewCommand(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() throws InvalidCommandException {
        try {
            Desktop.getDesktop().open(new File(doc.getLocation()));
        } catch (IOException e) {
            throw new InvalidCommandException("Error: " + e.getMessage());
        }
    }
}
