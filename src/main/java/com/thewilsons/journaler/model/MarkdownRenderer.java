package com.thewilsons.journaler.model;

import com.thewilsons.journaler.controller.Controller;
import org.apache.log4j.Logger;
import org.markdown4j.Markdown4jProcessor;
import java.io.IOException;
import java.util.List;

/**
 * Handles parsing markdown for rendering.
 *
 * @author Zach Wilson
 * @since version 1.0
 * created Mar 4, 2016
 */
final class MarkdownRenderer {

    /** Log4j logger. */
    private static final Logger LOG = Logger.getLogger(MarkdownRenderer.class);

    /** The Markdown processor. */
    private Markdown4jProcessor processor;

    /**
     * Constructor.
     */
    MarkdownRenderer() {
        processor = new Markdown4jProcessor();
    }

    /**
     * Converts Markdown text to HTML.
     * @param post the Markdown text
     * @return HTML equivalent of the markdown
     */
    String markdownToHTML(Post post) {
        String htmlText;
        try {
            htmlText = processor.process(post.getText());
        } catch (IOException e) {
            return null;
        }
        return "<html>" + htmlText + "</html>";
    }

    /**
     * Converts a list of Markdown text to HTML.
     * @param posts the Markdown text
     * @return HTML equivalent of the markdown
     */
    String markdownToHTML(List<Post> posts) {
        String htmlText = "";
        for (Post post : posts) {
            String text;
            try {
                text = processor.process(post.getText());
            } catch (IOException e) {
                return null;
            }
            htmlText += text;
        }
        return "<html>" + htmlText + "</html>";
    }

}
