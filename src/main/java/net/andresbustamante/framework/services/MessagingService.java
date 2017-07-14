package net.andresbustamante.framework.services;

import net.andresbustamante.framework.util.MimeType;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Andres Bustamante 
 */
public class MessagingService {
    
    /**
     * Construir un objeto email a partir de la información base, con 
     * origen en la dirección configurada en el archivo aplicacion.properties
     * con la clave "email.origen.direccion"
     * 
     * @param fromAddress
     * @param toAddresses
     * @param copyAddresses
     * @param subject
     * @param content
     * @param emailSession
     * @param mimeType
     * @return
     * @throws MessagingException 
     */
    public static Message buildEmail(String fromAddress, String[] toAddresses, String[] copyAddresses,
            String subject, String content, Session emailSession, MimeType mimeType) 
            throws MessagingException {
        Message email = new MimeMessage(emailSession);

        email.setFrom(new InternetAddress(fromAddress));

        // Cargar la lista de destinatarios
        for (String dst : toAddresses) {
            email.addRecipient(javax.mail.Message.RecipientType.TO,
                    new InternetAddress(dst));
        }

        if (copyAddresses != null) {
            for (String dst : copyAddresses) {
                email.addRecipient(javax.mail.Message.RecipientType.CC,
                        new InternetAddress(dst));
            }
        }

        email.setSubject(subject);
        email.setContent(content, mimeType.toString());
        return email;
    }
}
