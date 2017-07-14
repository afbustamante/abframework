package net.andresbustamante.framework.exceptions;

/**
 *
 * @author Andres Bustamante 
 */
public class ServiceNotAvailableException extends Exception {

    /**
     * Creates a new instance of
     * <code>ServicioNoDisponibleException</code> without detail message.
     */
    public ServiceNotAvailableException() {
    }

    /**
     * Constructs an instance of
     * <code>ServicioNoDisponibleException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public ServiceNotAvailableException(String msg) {
        super(msg);
    }
}
