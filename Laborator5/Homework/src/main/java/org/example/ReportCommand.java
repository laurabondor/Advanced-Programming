package org.example;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class ReportCommand implements Command {
    private Catalog catalog;
    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("report.vm");
        VelocityContext context = new VelocityContext();
        List<Document> documents = catalog.getDocs();
        context.put("documents", documents);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        try {
            BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("catalog.html"));
            htmlWriter.write(writer.toString());
            htmlWriter.close();
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("catalog.html"));
        } catch (IOException e) {
            System.err.println("Error: HTML file");
        }
    }
}