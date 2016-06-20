package com.thewilsons.journaler.view;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * The frame.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 20, 2016
 */
public final class ZFrame extends JFrame {

    /** Log4j logger. */
    private static final Logger LOG = Logger.getLogger(ZFrame.class);

    /** The panel of the frame. */
    private JPanel panel;

    /** The text area. */
    private JTextArea textArea;

    /** The menu bar. */
    private ZMenuBar menuBar;

    /**
     * Constructor.
     */
    public ZFrame() {
        panel = new JPanel();
        menuBar = new ZMenuBar();
        textArea = new JTextArea();
        init();
    }

    /**
     * Display message box with message.
     * @param message message to be displayed in message dialog
     */
    public void displayMessageBox(final String message){
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Gets the panel.
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Gets the text area.
     * @return the text area
     */
    public JTextArea getTextArea() {
        return textArea;
    }

    /**
     * Gets the menu bar
     * @return the menu bar
     */
    public ZMenuBar getZMenuBar() {
        return menuBar;
    }

    /**
     * Initializes frame.
     */
    private void init() {
        setJMenuBar(menuBar);
        createLayout();
        display();
    }

    /**
     * Configures the display of the frame.
     */
    private void display() {
        setTitle("Journaler");
        setSize(700, 800);
        setMinimumSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel);
    }

    /**
     * Crates the group layout.
     */
    private void createLayout() {
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(textArea));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(textArea));
    }

}