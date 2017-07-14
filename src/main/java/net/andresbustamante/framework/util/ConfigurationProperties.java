package net.andresbustamante.framework.util;

import java.util.ResourceBundle;

/**
 * Utilidad de recuperación de cadenas de texto para configuración de propiedades
 * de la aplicación
 *
 * @author Andres Bustamante 
 */
public class ConfigurationProperties {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    /**
     * Obtener el valor a partir de una clave del archivo properties
     *
     * @param key Clave a buscar en el archivo properties
     * @return El valor para la clave
     */
    public static String getValue(String key) {
        return bundle.getString(key);
    }
}
