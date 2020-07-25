package edu.zxie0018.test;

import edu.zxie0018.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    // test spring bean tag Scope
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
//        scope="singleton"
//        edu.zxie0018.dao.impl.UserDaoImpl@694e1548
//        edu.zxie0018.dao.impl.UserDaoImpl@694e1548

//        scope="prototype"
//        edu.zxie0018.dao.impl.UserDaoImpl@5e853265
//        edu.zxie0018.dao.impl.UserDaoImpl@67205a84
    }
}
