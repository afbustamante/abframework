package net.andresbustamante.framework.dao;

import net.andresbustamante.framework.exceptions.DatabaseException;
import java.util.List;

/**
 *
 * @author Andres Bustamante 
 * @param <T> 
 */
public interface DAO<T extends Object> {

    /**
     * Guardar un objeto nuevo en el sistema de forma permanente
     *
     * @param t El objeto a save
     * @throws DatabaseException Si ocurre un problema al ejecutar el guardado
     * en base de datos
     */
    public void save(T t) throws DatabaseException;

    /**
     * Cargar un objeto persistido previamente a partir de su identificador
     *
     * @param id Identificador del objeto en persistencia
     * @return El objeto encontrado con el identificador
     * @throws DatabaseException Si ocurre un problema al ejecutar la consulta
     * en base de datos
     */
    public T load(Object id) throws DatabaseException;

    /**
     * Listar los objetos almacenados para la entidad
     *
     * @return El listado de objetos encontrados en persistencia
     * @throws DatabaseException Si ocurre un problema al ejecutar la consulta
     * en base de datos
     */
    public List<T> list() throws DatabaseException;

    /**
     * Actualizar los datos de un objeto en persistencia.
     *
     * @param t El objeto con los datos actualizados.
     * @throws DatabaseException Si ocurre un problema al ejecutar la
     * modificación en base de datos
     */
    public void update(T t) throws DatabaseException;

    /**
     * Borrar un objeto persistido en el sistema
     *
     * @param t El objeto a remove
     * @throws DatabaseException Si ocurre un problema al ejecutar el borrado
     * en base de datos
     */
    public void remove(T t) throws DatabaseException;
}
