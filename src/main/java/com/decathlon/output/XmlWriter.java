package com.decathlon.output;

import com.decathlon.exceptions.FileWriteException;
import com.decathlon.model.AthleteResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XmlWriter implements FileWriter {
    @Override
    public boolean writeFile(List<AthleteResult> results, String path) {
        System.out.println("Writing to file: " + path);
        try {
            Document doc = getDocument();
            Element rootElement = doc.createElement("decathlon-result");
            doc.appendChild(rootElement);

            for (AthleteResult result: results) {
                Element athlete = doc.createElement("athlete");
                rootElement.appendChild(athlete);
                athlete.appendChild(createElement(doc, "name", "" + result.getAthleteName()));
                athlete.appendChild(createElement(doc, "score", "" + result.getScore()));
                athlete.appendChild(createElement(doc, "rank", "" + result.getRank()));
            }

            saveFile(doc, path);

        } catch (Exception e) {
            System.out.println("Error in writing file: " + e.getMessage());
            throw new FileWriteException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean writeFile(List<AthleteResult> results) {
        return writeFile(results, "test-results.xml");
    }

    private Document getDocument() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.newDocument();
    }

    private Element createElement(Document doc, String name, String value) {
        Element element = doc.createElement(name);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    private void saveFile(Document document, String path) throws TransformerException, IOException {
        FileOutputStream output = new FileOutputStream(path);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);
    }
}
