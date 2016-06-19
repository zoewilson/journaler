package com.thewilsons.journaler.utils;

/**
 * XML exception.
 *
 * @author Zach Wilson
 * @since version 1.0
 * created May 27, 2016
 */
public class XmlException extends Exception {

    /**
     * Constructor.
     */
    public XmlException() {
        super();
    }

    /**
     * Constructor.
     * @param message message to be set
     */
    public XmlException(String message) {
        super(message);
    }

    /**
     * Constructor.
     * @param message message to be set
     * @param t throwable to be set
     */
    public XmlException(String message, Throwable t) {
        super(message, t);
    }
}
