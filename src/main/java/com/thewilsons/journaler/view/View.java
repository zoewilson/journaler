package com.thewilsons.journaler.view;

/**
 * Represents the View in the MVC.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 20, 2016
 */
public final class View {

    /** The frame of the application. */
    private ZFrame frame;

    /**
     * Constructor.
     */
    public View() {
        frame = new ZFrame();
    }

    /**
     * Gets the frame.
     * @return the frame
     */
    public ZFrame getFrame() {
        return frame;
    }

}
