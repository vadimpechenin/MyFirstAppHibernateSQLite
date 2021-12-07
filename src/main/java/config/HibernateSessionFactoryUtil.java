package config;


import model.Profile;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil
{
    private static volatile SessionFactory sessionFactory;
    private static final Object sessionFactoryLock = new Object();

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null)
        {
            synchronized(sessionFactoryLock)
            {
                if (sessionFactory == null)
                {
                    try
                    {
                        Configuration configuration = new Configuration().configure();

                        configuration.addAnnotatedClass(User.class);

                        configuration.addAnnotatedClass(Profile.class);

                        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                        sessionFactory = configuration.buildSessionFactory(builder.build());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Исключение!" + e);
                    }
                }
            }
        }

        return sessionFactory;
    }
}