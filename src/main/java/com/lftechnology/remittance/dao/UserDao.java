package com.lftechnology.remittance.dao;

import java.util.UUID;

import com.lftechnology.remittance.entity.User;

/**
 * Common CRUD operations.
 * 
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
public interface UserDao extends CrudDao<User, UUID> {
}
