package org.neu.java.course.exercise8_xml_json_parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class XmlJsonParser {
    public static Document xmlParse(String filePath) {

        File inputFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            System.out.println(doc.toString());

            return doc;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void jsonParse(String filePath) {

        File inputFile = new File(filePath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            System.out.println(doc.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
