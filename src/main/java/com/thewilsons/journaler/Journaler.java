package com.thewilsons.journaler;

import com.thewilsons.journaler.controller.Controller;
import com.thewilsons.journaler.model.Model;
import com.thewilsons.journaler.view.View;

import javax.swing.*;

/**
 * Launches the application.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 18, 2016
 */
final class Journaler {

    /**
     * Main.
     * Runs application by creating an instance of the model, view, and passing them into the
     * controller. The controller then controls the application by listening for events.
     * @param args no command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater( () -> {
            new Controller(new Model(), new View()).control();
        });

    }

}
