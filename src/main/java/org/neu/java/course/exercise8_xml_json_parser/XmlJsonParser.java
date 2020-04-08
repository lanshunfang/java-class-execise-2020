package org.neu.java.course.exercise8_xml_json_parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.NodeList;

public class XmlJsonParser {

  enum BookPropertyEnum {
    title,
    publishedYear,
    numberOfPages,
    authors,
    author,
  }

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


  private static Node getNewBookXml(
      Document xmlDoc,
      String title,
      String publishedYear,
      String numberOfPages,
      String[] authors
  ) {
    Node newBook = xmlDoc.createElement("Book");

    appendNewNodeWithTextXml(
        xmlDoc,
        newBook,
        BookPropertyEnum.title.toString(),
        title
    );

    appendNewNodeWithTextXml(
        xmlDoc,
        newBook,
        BookPropertyEnum.publishedYear.toString(),
        publishedYear
    );

    appendNewNodeWithTextXml(
        xmlDoc,
        newBook,
        BookPropertyEnum.numberOfPages.toString(),
        numberOfPages
    );

    Node authorContainer = xmlDoc.createElement(BookPropertyEnum.authors.toString());

    for (String author : authors) {

      appendNewNodeWithTextXml(
          xmlDoc,
          authorContainer,
          BookPropertyEnum.author.toString(),
          author
      );

    }


    return newBook;
  }

  private static JSONObject getNewBookJson(
      String title,
      String publishedYear,
      String numberOfPages,
      String[] authors
  ) {
    JSONObject newBook = new JSONObject();

    newBook.put(
        BookPropertyEnum.title.toString(),
        title
    );

    newBook.put(
        BookPropertyEnum.publishedYear.toString(),
        publishedYear
    );

    newBook.put(
        BookPropertyEnum.numberOfPages.toString(),
        numberOfPages
    );


    JSONArray authorContainer = new JSONArray();

    for (String author : authors) {

      authorContainer.add(author);

    }

    newBook.put(
        BookPropertyEnum.authors.toString(),
        authorContainer
    );


    return newBook;
  }

  private static Node appendNewNodeWithTextXml(
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

  public static Object jsonParse(File file) {

    JSONParser parser = new JSONParser();
    Object obj = null;
    try {

      BufferedReader br = new BufferedReader(new FileReader(file));
      String json = IOUtils.toString(br);

      obj = parser.parse(json);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return obj;

  }

  public static void printJson(Object jsonObj) {
    System.out.println(jsonObj.toString());
//        if (jsonObj instanceof JSONArray) {
//            System.out.println("Books");
//            ((JSONArray) jsonObj).forEach(
//                    book -> {
//                        System.out.println("\tBook");
//                        printBookJson((JSONObject) book, "\t\t");
//                    }
//            );
//        }
  }
//
//    private static void printBookJson(JSONObject jsonBook, String indent) {
//        System.out.println(
//                String.format(
//                        "%s%s",
//                        indent,
//                        jsonBook.get(BookPropertyEnum.title.toString())
//                )
//        );
//        System.out.println(
//                String.format(
//                        "%s%s",
//                        indent,
//                        jsonBook.get(BookPropertyEnum.publishedYear.toString())
//                )
//        );
//        System.out.println(
//                String.format(
//                        "%s%s",
//                        indent,
//                        jsonBook.get(BookPropertyEnum.numberOfPages.toString())
//                )
//        );
//        JSONArray authors = (JSONArray)jsonBook.get(BookPropertyEnum.authors.toString());
//
//        for (author: authors) {
//            System.out.println(
//                    String.format(
//                            "%s%s",
//                            indent,
//
//                            )
//            );
//        }
//
//    }

  public static void main(String... args) {

    File booksXml = new File(XmlJsonParser.class.getClassLoader().getResource("json-parser/books.xml").getFile());
    File booksJson = new File(XmlJsonParser.class.getClassLoader().getResource("json-parser/books.json").getFile());

    Document booksFromXML = XmlJsonParser.xmlParse(booksXml);

    System.out.println("[INFO] Parse XML");
    printXmlDoc(booksFromXML, "");


    System.out.println("[INFO] Append a new book into XML DOM");
    booksFromXML.getFirstChild().appendChild(
        getNewBookXml(
            booksFromXML,
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

//        printXmlDoc(xmlDoc, "");


    System.out.println("[INFO] ");
    System.out.println("[INFO] ----------------------");
    System.out.println("[INFO] Parse JSON");

    JSONArray booksFromJSON = (JSONArray) XmlJsonParser.jsonParse(booksJson);
    XmlJsonParser.printJson(booksFromJSON);

    booksFromJSON.add(
        getNewBookJson(
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

      System.out.println("[INFO] Add a new book to JSON object");
      XmlJsonParser.printJson(booksFromJSON);


  }
}
