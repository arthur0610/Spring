package edu.zxie0018.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    // test c3p0
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

    @Test
    // test druid
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Drvier");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

    @Test
    // test c3p0 with conf file in resources
    public void test3() throws  Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

    @Test
    // using spring test c3p0
    public void test4() throws  Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSources = (DataSource) app.getBean("dataSources");
        Connection connection = dataSources.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // using spring test c3p0 with conf file in xml
    public void test5() throws  Exception {

    }
}
