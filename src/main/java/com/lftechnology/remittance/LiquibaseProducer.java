package com.lftechnology.remittance;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import liquibase.integration.cdi.CDILiquibaseConfig;
import liquibase.integration.cdi.annotations.LiquibaseType;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/**
 * A simple CDI producer to configure the CDI Liquibase integration.
 *
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Startup
public class LiquibaseProducer {

	@Resource(mappedName = "java:jboss/datasources/remittance")
	private DataSource dataSource;

	@Produces
	@LiquibaseType
	public CDILiquibaseConfig createConfig() {
		CDILiquibaseConfig config = new CDILiquibaseConfig();
		config.setChangeLog("/changelog-master.xml");
		return config;
	}

	@Produces
	@LiquibaseType
	public DataSource createDataSource() throws SQLException {
		return dataSource;
	}

	@Produces
	@LiquibaseType
	public ResourceAccessor create() {
		return new ClassLoaderResourceAccessor(getClass().getClassLoader());
	}
}
