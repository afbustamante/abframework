package net.andresbustamante.framework.web;

import java.security.Principal;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andres Bustamante 
 */
public abstract class FacesBean {

    /**
     *
     * @param msg
     */
    protected void addWarningMessage(String msg) {
        addMessage(msg, FacesMessage.SEVERITY_INFO);
    }

    /**
     *
     * @param msg
     */
    protected void addErrorMessage(String msg) {
        addMessage(msg, FacesMessage.SEVERITY_ERROR);
    }

    protected String getUsername() {
        Principal username = FacesContext.getCurrentInstance().getExternalContext().
                getUserPrincipal();

        return (username != null) ? username.getName() : null;
    }

    /**
     *
     * @param msg
     * @param severity
     */
    private void addMessage(String msg, FacesMessage.Severity severity) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ResourceBundle messages =
                fc.getApplication().getResourceBundle(fc, "messages");
        String text = (messages.containsKey(msg)) ? messages.getString(msg) : msg;
        FacesMessage facesMsg = new FacesMessage(severity, text, text);
        fc.addMessage(null, facesMsg);
    }
}
