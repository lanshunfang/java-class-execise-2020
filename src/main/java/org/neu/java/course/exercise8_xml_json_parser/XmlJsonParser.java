package org.neu.java.course.exercise8_xml_json_parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.NodeList;

public class XmlJsonParser {
    public static Document xmlParse(File file) {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            System.out.println(doc.toString());

            return doc;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void printXmlDoc(Node containerNode, String prefix) {
        String display = containerNode.getNodeName();
        boolean isTextNode = containerNode.getNodeType() == Node.TEXT_NODE;

        if (isTextNode) {
            display = containerNode.getNodeValue().replaceAll("[\\n\\t ]", "");
        }

        if (display.equals("")) {
            return;
        }

        System.out.println(
                String.format(
                        "%s%s",
                        prefix,
                        display
                )
        );

        if (isTextNode || !containerNode.hasChildNodes()) {
            return;
        }

        NodeList nodeList = containerNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            printXmlDoc(
                    nodeList.item(i),
                    String.format("\t%s", prefix)
            );
        }
    }

    public static void jsonParse(File file) {

        JSONParser parser = new JSONParser();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String json = IOUtils.toString(br);

            Object obj = parser.parse(json);

            JSONArray array = (JSONArray) obj;

            System.out.println(array.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Node getNewBook(
            Document xmlDoc,
            String title,
            String publishedYear,
            String numberOfPages,
            String[] authors
    ) {
        Node newBook = xmlDoc.createElement("Book");

        appendNewNodeWithText(
                xmlDoc,
                newBook,
                "title",
                title
        );

        appendNewNodeWithText(
                xmlDoc,
                newBook,
                "publishedYear",
                publishedYear
        );

        appendNewNodeWithText(
                xmlDoc,
                newBook,
                "numberOfPages",
                numberOfPages
        );

        Node authorContainer = xmlDoc.createElement("authors");

        for (String author : authors) {

            appendNewNodeWithText(
                    xmlDoc,
                    authorContainer,
                    "author",
                    author
            );

        }


        return newBook;
    }

    private static Node appendNewNodeWithText(
            Document xmlDoc,
            Node containerNode,
            String nodeName,
            String text
    ) {

        Node newNode = xmlDoc.createElement(nodeName);
        Node textNode = xmlDoc.createTextNode(text);
        newNode.appendChild(textNode);
        containerNode.appendChild(newNode);
        return newNode;

    }


    public static void main(String... args) {

        File booksXml = new File(XmlJsonParser.class.getClassLoader().getResource("json-parser/books.xml").getFile());
//        File booksJson = new File(XmlJsonParser.class.getClassLoader().getResource("json-parser/books.json").getFile());

        Document xmlDoc = XmlJsonParser.xmlParse(booksXml);

        System.out.println("[INFO] First parse XML");
        printXmlDoc(xmlDoc, "");


        xmlDoc.getFirstChild().appendChild(
                getNewBook(
                        xmlDoc,
                        "Love Is a Choice: The Definitive Book on Letting Go of Unhealthy Relationships",
                        "2003",
                        "288",
                        new String[]{
                                "Robert Hemfelt",
                                "Frank Minirth",
                                "Paul Meier"
                        }
                )
        );

        System.out.println("[INFO] Append a new book into XML DOM");
        printXmlDoc(xmlDoc, "");

//        XmlJsonParser.jsonParse(booksJson);
    }
}
