package com.lftechnology.remittance.dao;

import java.util.List;

/**
 * Common CRUD operations.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public interface CrudDao<T, Pk> {

	/**
	 * Save entity.
	 * 
	 * @param entity
	 *            entity to save
	 * @return entity
	 */
	public T save(T entity);

	/**
	 * Entity to update.
	 * 
	 * @param entity
	 *            entity to update
	 * @return entity
	 */
	public T update(T entity);

	/**
	 * Delete entity.
	 * 
	 * @param entity
	 *            entity to delete
	 */
	public void remove(T entity);

	/**
	 * Find entity and remove it.
	 * 
	 * @param id
	 *            UUID of entity
	 * @param entity
	 *            removing entity
	 */
	public void removeById(Pk id);

	/**
	 * Find entity by Id.
	 * 
	 * @param id
	 *            UUID of entity
	 * @return entity
	 */
	public T findById(Pk id);

	/**
	 * Fetch all entities after applying filters.
	 * 
	 * @return
	 */
	public List<T> findByFilter();

}
