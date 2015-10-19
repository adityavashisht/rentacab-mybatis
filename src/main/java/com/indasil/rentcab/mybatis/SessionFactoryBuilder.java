package com.indasil.rentcab.mybatis;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vashishta on 10/19/15.
 */
public class SessionFactoryBuilder {

    private static SqlSessionFactory sessionFactory = build();

    private SessionFactoryBuilder() {

    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SqlSessionFactory build() {
        String resource = "mybatis-config.xml";

        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (IOException ioe) {

        }
        if (inputStream != null) {
            // read and build the configuration
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // Inform the config of the mappers in the system
            //sqlSessionFactory.getConfiguration().addMappers("com.indasil.rentcab.mapper");
        }
        return sqlSessionFactory;
    }
}
