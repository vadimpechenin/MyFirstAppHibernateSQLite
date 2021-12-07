package controller.dbController;

import config.HibernateSessionFactoryUtil;
import model.Profile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileService {
    //Класс для реализации методов работы в базе данных с таблицей profiles
    public static boolean GetProfiles(String userID, ArrayList<Profile> profiles) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            profiles.clear();
            List<Profile> items;
            if(userID != null) {
                //String s = "From Profile Where UserID = :UserID";
                items = session.createQuery("From Profile Where UserID = :UserID", Profile.class)
                        .setParameter("UserID", userID)
                        .list();
            }else {
                items = session.createQuery("From Profile", Profile.class).list();
            }
            profiles.addAll(items);
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return result;
    }

    public static boolean CreateProfile(Profile profile) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(profile);
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

    public static boolean DeleteProfile(Profile profile) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            CommonService.DeleteItemsHandler(session, "Profile", new ArrayList<>(Arrays.asList(profile)));
            transaction.commit();
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            session.close();
        }
        return result;
    }

    public static boolean UpdateProfile(Profile profile) {
        boolean result = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(profile);
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
