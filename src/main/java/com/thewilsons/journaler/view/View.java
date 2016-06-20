package com.thewilsons.journaler.view;

import com.thewilsons.journaler.controller.Controller;
import org.apache.log4j.Logger;

/**
 * Represents the View in the MVC.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 20, 2016
 */
public final class View {

    /** Log4j logger. */
    private static final Logger LOG = Logger.getLogger(View.class);

    /** The frame of the application. */
    private ZFrame frame;

    /**
     * Constructor.
     */
    public View() {
        frame = new ZFrame();
        LOG.info("Created frame.");
    }

    /**
     * Gets the frame.
     * @return the frame
     */
    public ZFrame getFrame() {
        return frame;
    }

}
