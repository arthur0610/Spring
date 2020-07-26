package edu.zxie0018.dao.impl;

import edu.zxie0018.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


// <bean id="userDao" class="edu.zxie0018.dao.impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("User saving!!!");
    }
}
