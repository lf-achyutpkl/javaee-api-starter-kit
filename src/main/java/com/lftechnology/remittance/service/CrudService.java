package com.lftechnology.remittance.service;

import java.util.List;

/**
 * Common CRUD operations.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public interface CrudService<T, Pk> {

	/**
	 * Save entity.
	 * 
	 * @param entity
	 *            entity to save
	 * @return entity
	 */
	public T save(T entity);

	/**
	 * Find entity by Id.
	 * 
	 * @param id
	 *            UUID of entity
	 * @return entity
	 */
	public T findById(Pk id);

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
	 * Restrict all properties update by defining merge rule.
	 * 
	 * @param id
	 *            UUID of entity to update
	 * @param entity
	 *            entity having new changes
	 * @return entity
	 */
	public T merge(Pk id, T entity);

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
	 * Fetch all entities after applying filters.
	 * 
	 * @return
	 */
	public List<T> findByFilter();
}
