package edu.zxie0018.factory;

import edu.zxie0018.dao.UserDao;
import edu.zxie0018.dao.impl.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
