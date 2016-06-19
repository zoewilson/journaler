package com.thewilsons.journaler.model;

/**
 * Represents a single post.
 *
 * @author Zach Wilson
 * @since version 1.0
 * created February 23, 2016
 */
public class Post {

    /** Text of the post (the post itself). */
    private String text;

    /** Timestamp of the post. */
    private String time;

    /**
     * Constructor.
     */
    @SuppressWarnings("unused")
    private Post() {}

    /**
     * Constructor.
     * @param time time of the post
     * @param text the text of the post
     */
    public Post(String time, String text) {
        this.time = time;
        this.text = text;
    }

    /**
     * Gets the text of the post.
     * @return the text of the post
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the time stamp of the post.
     * @return the time stamp of the post
     */
    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Post[time=" + time + ", post=" + text + "]";
    }

}
