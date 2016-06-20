package com.thewilsons.journaler.model;

import org.apache.log4j.Logger;

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

    /** Log4j logger. */
    private static final Logger LOG = Logger.getLogger(DatabaseManager.class);

    /** The db directory. */
    private File dbDirectory = new File("src" + File.separator + "main" + File.separator +
                                        "resources" + File.separator + "db");

    /** The file containing all posts. */
    private File file = new File(dbDirectory.getAbsolutePath() + File.separator + "posts.xml");

    /**
     * Gets the posts from file and returns them. If the file does not exist, the resources
     * resourcesDirectory and the posts.xml file will be created.
     * @return the posts
     * @throws Exception
     */
    List<Post> getPosts() throws Exception {
        LOG.info("Checking if database file exists.");
        if (dbDirectory.exists()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Directory exists: " + dbDirectory.getAbsolutePath());
            }
            if (file.exists()) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Database file exists: " + file.getAbsolutePath());
                }
                LOG.info("Calling PostsProcessor to parse database file.");
                return PostsProcessor.parse(file);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Database file: " + file.getAbsolutePath());
            }
            LOG.info("Returning new, empty list.");
            return new ArrayList<>();
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Database file does not exist: " + file.getAbsolutePath());
            }
            if (!file.createNewFile()) {
                throw new Exception("Unable to create: " + file.getAbsolutePath());
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Created database file: " + file.getAbsolutePath());
            }
            return new ArrayList<>();
        }
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
