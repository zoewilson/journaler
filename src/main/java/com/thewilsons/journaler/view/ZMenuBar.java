package com.thewilsons.journaler.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The menu bar of the frame.
 *
 * @author Zoe Wilson
 * @author Zach Wilson
 * @since version 1.0
 * created February 21, 2016
 */
public final class ZMenuBar extends JMenuBar {

    /** Shortcut key mask for cross platform key commands. */
    private final int KEY_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

    /**
     * Constructor.
     */
    ZMenuBar() {
        init();
    }

    /**
     * Initializes the menu bar.
     */
    private void init() {
        add(createFileMenuItem());
        add(createEditMenuItem());
        add(createFormatMenuItem());
        add(createViewMenuItem());
        add(createWindowMenuItem());
        add(createHelpMenuItem());
    }

    /**
     * Creates the file menu.
     * @return the file menu
     */
    private JMenu createFileMenuItem() {

        JMenu menu = new JMenu("File");

        // "New"
        JMenuItem newMi = new JMenuItem("New");
        newMi.setToolTipText("Create new post");
        newMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KEY_MASK));
        menu.add(newMi);

        // "Post"
        JMenuItem postMi = new JMenuItem("Post");
        postMi.setToolTipText("Submit post");
        postMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KEY_MASK));
        menu.add(postMi);

        // Separator
        menu.addSeparator();

        // "Close"
        JMenuItem closeMi = new JMenuItem("Close");
        closeMi.setToolTipText("Close application");
        closeMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KEY_MASK));
        closeMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KEY_MASK));
        menu.add(closeMi);

        return menu;
    }

    /**
     * Creates the edit menu.
     * @return the edit menu
     */
    private JMenu createEditMenuItem() {

        JMenu menu = new JMenu("Edit");

        JMenuItem cutMi = new JMenuItem("Cut");
        menu.add(cutMi);

        JMenuItem copyMi = new JMenuItem("Copy");
        menu.add(copyMi);

        JMenuItem pasteMi = new JMenuItem("Paste");
        menu.add(pasteMi);

        return menu;
    }

    /**
     * Creates the format menu.
     * @return the format menu
     */
    private JMenu createFormatMenuItem() {

        JMenu menu = new JMenu("Format");

        JMenuItem boldMi = new JMenuItem("Bold");
        menu.add(boldMi);

        JMenuItem italicMi = new JMenuItem("Italic");
        menu.add(italicMi);

        JMenuItem underlineMi = new JMenuItem("Underline");
        menu.add(underlineMi);

        return menu;
    }

    /**
     * Creates the view menu.
     * @return the view menu
     */
    private JMenu createViewMenuItem() {

        JMenu menu = new JMenu("View");

        // "Full screen"
        JMenuItem fullScreenMi = new JMenuItem("Full Screen");
        fullScreenMi.setToolTipText("Enter full screen");
        menu.add(fullScreenMi);

        // "View posts"
        JMenuItem viewPostsMi = new JMenuItem("View posts");
        viewPostsMi.setToolTipText("View posts");
        viewPostsMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KEY_MASK));
        menu.add(viewPostsMi);

        // "Preview post
        JMenuItem previewPostMi = new JMenuItem("Preview post");
        previewPostMi.setToolTipText("Preview post");
        previewPostMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KEY_MASK));
        menu.add(previewPostMi);

        return menu;
    }

    /**
     * Creates the window menu.
     * @return the window menu
     */
    private JMenu createWindowMenuItem() {

        JMenu menu = new JMenu("Window");

        JMenuItem maximizeMi = new JMenuItem("Maximize");
        JMenuItem minimizeMi = new JMenuItem("Minimize");

        menu.add(maximizeMi);
        menu.add(minimizeMi);

        return menu;
    }

    /**
     * Creates the help menu.
     * @return the help menu
     */
    private JMenu createHelpMenuItem() {
        return new JMenu("Help");
    }

}

