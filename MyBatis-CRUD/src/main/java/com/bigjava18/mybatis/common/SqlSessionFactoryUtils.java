package com.bigjava18.mybatis.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author zgp
 * @Since 2021 -04 -16 15 :06
 * @Description
 */
public class SqlSessionFactoryUtils {

    private static SqlSessionFactory SQLSESSIONFACTORY=null;

    public static SqlSessionFactory getInstance(){

        if (SQLSESSIONFACTORY==null){
            try {
                SQLSESSIONFACTORY= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SQLSESSIONFACTORY;
    }
}
