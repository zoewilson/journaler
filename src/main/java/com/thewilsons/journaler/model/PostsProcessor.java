package com.thewilsons.journaler.model;

import com.thewilsons.journaler.controller.Controller;
import com.thewilsons.journaler.utils.XmlException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles processing Posts for reading, writing, and parsing.
 *
 * @author Zach Wilson
 * @since version 1.0
 * created February 23, 2016
 */
final class PostsProcessor {

    /** Log4j logger. */
    private static final Logger LOG = Logger.getLogger(Controller.class);

    /**
     * Parses a file Posts into a list of Posts.
     * @param f the file to be parsed
     * @return the posts list
     * @throws Exception
     */
    static List<Post> parse(File f) throws Exception {
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + f + "' does not exist.");
        }

        // If file is empty, return an empty list
        if (f.length() == 0) {
            return new ArrayList<>();
        }

        List<Post> posts = new ArrayList<>();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(f);
        Node allPosts = document.getChildNodes().item(0);

        // For each post
        for (Node postNode = allPosts.getFirstChild();
             (postNode = postNode.getNextSibling()) != null;
              postNode = postNode.getNextSibling())
        {

            // Get the time stamp
            Node timeNode = postNode.getFirstChild().getNextSibling();
            if (!timeNode.getNodeName().equals("time")) {
                throw new XmlException("Invalid XML format: " + timeNode.getNodeName());
            }
            if (timeNode.getTextContent() == null) {
                throw new XmlException("Missing time data.");
            }

            // Get the text
            Node textNode = timeNode.getNextSibling().getNextSibling();
            if (!textNode.getNodeName().equals("text")) {
                throw new XmlException("Invalid XML format: " + textNode.getNodeName());
            }
            if (textNode.getTextContent() == null) {
                throw new XmlException("Missing text data.");
            }

            // Add it
            posts.add(new Post(timeNode.getTextContent(), textNode.getTextContent()));
        }

        return posts;
    }

    /**
     * Writes a list of Posts out to the specified file.
     * @param f the file to have posts written out to
     * @param posts - the list of posts
     * @throws Exception
     */
    static void write(File f, List<Post> posts) throws Exception {
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + f + "' does not exist.");
        }

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element postsElement = document.createElement("posts");

        for (Post p : posts) {
            Element postElement = document.createElement("post");
            Element timeElement = document.createElement("time");
            timeElement.appendChild(document.createTextNode(p.getTime()));
            postElement.appendChild(timeElement);
            Element textElement = document.createElement("text");
            textElement.appendChild(document.createTextNode(p.getText()));
            postElement.appendChild(textElement);
            postsElement.appendChild(postElement);
        }

        document.appendChild(postsElement);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(f);
        transformer.transform(source, result);
    }

}

