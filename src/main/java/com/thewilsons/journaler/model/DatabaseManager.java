package com.thewilsons.journaler.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The database for the Model for saving and extracting posts from file.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 22, 2016
 */
final class DatabaseManager {

    /** The resources directory. */
    private File directory = new File("resources");

    /** The file containing all posts. */
    private File file = new File(directory.getAbsolutePath() + File.separator + "posts.xml");

    /**
     * Gets the posts from file and returns them. If the file does not exist, the resources
     * directory and the posts.xml file will be created.
     * @return the posts
     * @throws Exception
     */
    List<Post> getPosts() throws Exception {


        // Directory and file do not exist
        if (!directory.exists()) {
            if (!directory.mkdir()) {
                throw new Exception("Failed to create '" + directory + "'.");
            }
            if (!file.createNewFile()) {
                throw new Exception("Failed to create '" + file + "'.");
            }
            return new ArrayList<>();
        }

        // Directory exists but file does not exist
        else {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new Exception("Failed to create '" + file + "'.");
                }
                return new ArrayList<>();
            }
        }

        return PostsProcessor.parse(file);
    }

    /**
     * Writes the posts back to file.
     * @param posts the posts to be written to file
     * @throws Exception
     */
    void writePosts(List<Post> posts) throws Exception {
        PostsProcessor.write(file, posts);
    }

}
