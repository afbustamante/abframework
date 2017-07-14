package net.andresbustamante.framework.exceptions;

/**
 *
 * @author Andres Bustamante 
 */
public class DatabaseException extends Exception {

    /**
     *
     */
    public DatabaseException() {
    }

    /**
     *
     * @param msg
     */
    public DatabaseException(String msg) {
        super(msg);
    }
}
