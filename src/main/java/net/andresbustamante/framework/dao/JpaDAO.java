package net.andresbustamante.framework.dao;

import net.andresbustamante.framework.exceptions.DatabaseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Andres Bustamante 
 * @param <T> 
 */
public abstract class JpaDAO<T extends Object> implements DAO<T> {

    private final Class<T> entityClass;

    public JpaDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public void save(T entity) throws DatabaseException {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) throws DatabaseException {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(T entity) throws DatabaseException {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T load(Object id) throws DatabaseException {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> list() throws DatabaseException {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
