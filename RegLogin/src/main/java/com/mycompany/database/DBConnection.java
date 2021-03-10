/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author rosan
 */
public class DBConnection {

    private static Logger logger = LogManager.getLogger();
    private static BasicDataSource basicDS;
    private static Connection con;

    static {
        try {
            basicDS = new BasicDataSource();
            Properties properties = new Properties();
            // Loading properties file from classpath
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            if (inputStream == null) {
                throw new IOException("File not found");
            }
            properties.load(inputStream);
            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
            basicDS.setUrl(properties.getProperty("DB_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PASSWORD"));
            //The initial number of connections that are created when the pool is started.
            basicDS.setInitialSize(Integer.parseInt(properties.getProperty("INITIAL_POOL_SIZE")));
            //The maximum number of active connections that can be allocated from this pool at the same time
            basicDS.setMaxTotal(Integer.parseInt(properties.getProperty("MAX_POOL_SIZE")));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        DataSource ds = DBConnection.getDataSource();
        con = ds.getConnection();
        return con;
    }

    public static DataSource getDataSource() {
        return basicDS;
    }

}
