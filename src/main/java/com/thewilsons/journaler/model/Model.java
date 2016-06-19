package com.thewilsons.journaler.model;

import java.util.List;

/**
 * Represents the Model in the MVC.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 20, 2016
 */
public final class Model {

    /** DatabaseManager. */
    private DatabaseManager databaseManager;

    /** List of all post posts. */
    private List<Post> posts;

    /** Markdown renderer that converts Markdown posts to HTML strings. */
    private MarkdownRenderer renderer;

    /**
     * Constructor.
     */
    public Model() { }

    /**
     * Sets up the Model by creating the DatabaseManager object and obtaining the posts from the
     * database file.
     * @throws Exception
     */
    public void setUp() throws Exception {
        databaseManager = new DatabaseManager();
        posts = databaseManager.getPosts();
        renderer = new MarkdownRenderer();
    }

    /**
     * Creates a new post and adds it to the list of posts.
     * @param text text from post
     */
    public void post(final String text) {
        posts.add(new Post(Long.toString(new java.util.Date().getTime()), text));
    }

    /**
     * Gets the post based on number provided.
     * @param postNumber the post number
     * @return the post
     */
    public Post get(int postNumber) {
        return posts.get(postNumber);
    }

    /**
     * Gets all posts.
     * @return all JSON posts
     */
    public List<Post> getAll() {
        return posts;
    }

    /**
     * Gets all posts and returns a string of HTML.
     * @return HTML equivalent of all Markdown posts
     */
    public String getAllRenderedPosts() {
        return renderer.markdownToHTML(posts);
    }

    /**
     * Gets post and returns a string of HTML.
     * @return HTML equivalent of Markdown post
     */
    public String getRenderedPost(int index) {
        return renderer.markdownToHTML(get(index));
    }

    /**
     * Write posts out to file.
     * @throws Exception
     */
    public void write() throws Exception {
        databaseManager.writePosts(posts);
    }

}

