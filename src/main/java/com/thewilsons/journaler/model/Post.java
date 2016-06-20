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
     * @throws IllegalArgumentException if either argument is <code>null</code>
     */
    public Post(String time, String text) throws IllegalArgumentException {
        if (time == null) {
            throw new IllegalArgumentException("Time field cannot be null.");
        }
        if (text == null) {
            throw new IllegalArgumentException("Text field cannot be null.");
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (text != null ? !text.equals(post.text) : post.text != null) return false;
        return time != null ? time.equals(post.time) : post.time == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post[time=" + time + ", post=" + text + "]";
    }

}
