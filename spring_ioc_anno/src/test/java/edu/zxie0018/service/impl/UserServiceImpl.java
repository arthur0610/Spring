package edu.zxie0018.service.impl;

import edu.zxie0018.dao.UserDao;
import edu.zxie0018.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


//<bean id="userService" class="edu.zxie0018.service.impl.UserServiceImpl">
//    <property name="userDao" ref="userDao"></property>
//</bean>

//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao" ref="userDao"></property>
    //@Autowired //按照数据类型从Spring容器中进行匹配
    //@Qualifier("userDao") //按照Bean_id从Spring容器中进行匹配 但是@Qualifier 和@Autowired结合使用
    @Resource(name="userDao") // = @Qualifier + @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println(driver);
        System.out.println("init()");
    }

    @PreDestroy
    public void destory(){
        System.out.println("destory()");
    }
}
