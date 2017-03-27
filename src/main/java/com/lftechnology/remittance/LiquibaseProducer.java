package com.lftechnology.remittance;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

/**
 * Liquibase producer for running changelogs in all database.
 *
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Startup
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class LiquibaseProducer {

    Map<DataSource, String> changeLogFile = new HashMap<>();
    private static final String CHANGE_LOG_FILE = "/changelog-master.xml";
    private static final String STAGE = "development";

    @Resource(mappedName = "java:jboss/datasources/remittance")
    private DataSource ds1;

    @Resource(mappedName = "java:jboss/datasources/dummyDS")
    private DataSource ds2;

    @PostConstruct
    protected void bootstrap() {
        changeLogFile.put(ds1, CHANGE_LOG_FILE);
        changeLogFile.put(ds2, CHANGE_LOG_FILE);

        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(getClass().getClassLoader());
        changeLogFile.forEach((datasource, changeLogFilePath) -> this.runChangeLog(datasource, changeLogFilePath, resourceAccessor));
    }

    private void runChangeLog(DataSource datasource, String changeLogFilePath, ResourceAccessor resourceAccessor) {
        try (Connection connection = datasource.getConnection()) {
            JdbcConnection jdbcConnection = new JdbcConnection(connection);
            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);

            Liquibase liquiBase = new Liquibase(changeLogFilePath, resourceAccessor, db);
            liquiBase.update(STAGE);
        } catch (SQLException | LiquibaseException e) {
            e.printStackTrace();
        }
    }
}
