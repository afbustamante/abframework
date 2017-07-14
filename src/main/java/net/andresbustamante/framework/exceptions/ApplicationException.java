package net.andresbustamante.framework.exceptions;

/**
 *
 * @author Andres Bustamante 
 */
public class ApplicationException extends Exception {

    /**
     * Creates a new instance of
     * <code>AplicacionException</code> without detail message.
     */
    public ApplicationException() {
    }

    /**
     * Constructs an instance of
     * <code>AplicacionException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ApplicationException(String msg) {
        super(msg);
    }
}
