//Сервис для работы с табличкой пользователей
package controller;
import config.HibernateSessionFactoryUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static boolean GetUsers(String userName, String password, ArrayList<User> users) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            users.clear();
            List<User> items;
            if(userName != null) {
                items = session.createQuery("From User Where UserName = :UserName and Password = :Password", User.class)
                        .setParameter("UserName", userName)
                        .setParameter("Password", password)
                        .list();
            }else {
                items = session.createQuery("From User", User.class).list();
            }
            users.addAll(items);
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return result;
    }

    public static boolean CreateUser(User user) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return result;
    }
}
