package com.thewilsons.journaler.controller;

import com.thewilsons.journaler.model.Model;
import com.thewilsons.journaler.view.View;
import com.thewilsons.journaler.view.ZFrame;
import com.thewilsons.journaler.view.ZMenuBar;
import org.apache.log4j.Logger;

import java.awt.*;

/**
 * Represents the Controller in the MVC.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 20, 2016
 */
public final class Controller {

    /** Log4j logger. */
    private static final Logger LOG = Logger.getLogger(Controller.class);

    /** The model of the MVC. */
    private Model model;

    /** The view of the MVC. */
    private View view;

    /**
     * Constructor.
     */
    @SuppressWarnings("unused")
    private Controller() {}

    /**
     * Constructor.
     * @param m the model
     * @param v the view
     */
    public Controller(Model m, View v) {
        this.model = m;
        this.view = v;
    }

    /**
     * Controls the application by creating event listeners for components.
     */
    public void control() {

        // Set up the Model with a new thread
        Thread thread = new Thread(() -> {
            try {
                model.setUp();
            } catch (Exception e) {
                System.err.println("Error: failed to set up model.");
            }
        });
        thread.start();


        createActionListeners();
        view.getFrame().setVisible(true);

        // Join the thread
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Create all action listeners.
     */
    private void createActionListeners() {

        ZFrame frame = view.getFrame();
        ZMenuBar menu = frame.getZMenuBar();

        // Close listener
        menu.getMenu(0).getItem(3).addActionListener(event -> {
            shutdownHook();
            System.exit(0);
        });

        // Post listener
        menu.getMenu(0).getItem(1).addActionListener(event -> {
            String text = frame.getTextArea().getText();
            if (text.trim().equals("")) {
                return;
            }
            model.post(text);
            frame.getTextArea().setText("");
        });

        // Full screen listener
        menu.getMenu(3).getItem(0).addActionListener(event -> {
            if (frame.getExtendedState() != Frame.MAXIMIZED_BOTH) {
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            } else {
                frame.setExtendedState(Frame.NORMAL);
            }
        });

    }

    /**
     * Shutdown hook.
     */
    private void shutdownHook() {
        try {
            model.write();
        } catch (Exception e) {
            view.getFrame().displayMessageBox("ERROR: unable to save posts!");
        }
    }

}
