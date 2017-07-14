package net.andresbustamante.framework.web;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author andresbustamante
 */
public abstract class TransactionalWebService {
    
    private final Log log = LogFactory.getLog(TransactionalWebService.class);
    
    /**
     * Restablecer una transacción de usuario
     * 
     * @param utx Transacción a restablecer
     */
    protected void rollbackTransaction(UserTransaction utx) {
        try {
            if (utx != null) {
                utx.rollback();
            }
        } catch (SystemException e) {
            log.error("Transaction exception while doing rollback operation", e);
        }
    }
}
