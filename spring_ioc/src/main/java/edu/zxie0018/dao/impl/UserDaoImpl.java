package edu.zxie0018.dao.impl;

import edu.zxie0018.dao.UserDao;
import edu.zxie0018.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    //    private String username;
//    private int age;
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    @Override
    public void save() {
        //System.out.println("User Saving! Name is " + username + ", Age is " + age );
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
    }


    public void destory() {

    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl");
    }

    public void init() {

    }
}
