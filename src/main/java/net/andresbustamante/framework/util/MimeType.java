package net.andresbustamante.framework.util;

/**
 *
 * @author Andres Bustamante 
 */
public class MimeType {

    public static final MimeType PLAIN_TEXT = new MimeType("text/plain");
    public static final MimeType HTML = new MimeType("text/html");
    public static final MimeType XML = new MimeType("application/xml");
    /**
     * 
     */
    private String code;

    private MimeType(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
