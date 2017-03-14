package com.lftechnology.remittance.dao.impl;

import java.util.UUID;

import com.lftechnology.remittance.dao.UserDao;
import com.lftechnology.remittance.entity.User;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 *
 */
public class UserDaoImpl extends BaseDao<User, UUID> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
