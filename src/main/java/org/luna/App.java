package org.luna;

import org.luna.beans.User;
import org.luna.daoImpl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserDaoImpl userDao =
                (UserDaoImpl) context.getBean("userDao");
        System.out.println("----create records----");
        userDao.create("lain", "123");
        userDao.create("john", "123");
        userDao.create("bee", "123");
        System.out.println("----select records----");
        List<User> list = userDao.listUsers();
        for (User record : list) {
            System.out.println("ID: " + record.getId());
            System.out.println("Username: " + record.getUsername());
            System.out.println("Password: " + record.getPassword());
        }
        System.out.println("----update record where id is 2----");
        userDao.update(2, new User("Joker", "456"));
        System.out.println("----select record where id is 2----");
        User user = userDao.getUser(2);
        System.out.println("ID: " + user.getId());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
    }
}
