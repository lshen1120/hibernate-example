package hibernate.example.tool;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Created by SL on 2016/5/4.
 */
public class SessionFactoryTool {

    static {
        Configuration cfg = new Configuration();
        cfg.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL57InnoDBDialect");
        cfg.setProperty(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver");
        cfg.setProperty(AvailableSettings.URL, "jdbc:mysql://127.0.0.1/test?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8");
        cfg.setProperty(AvailableSettings.USER, "root");
        cfg.setProperty(AvailableSettings.PASS, "Leechan2013");
        cfg.setProperty(AvailableSettings.SHOW_SQL, "true");
        cfg.setProperty(AvailableSettings.FORMAT_SQL, "true");

        final Reflections reflections = new Reflections("hibernate.example.entity");
        for (Class<?> cl : reflections.getTypesAnnotatedWith(MappedSuperclass.class)) {
            cfg.addAnnotatedClass(cl);
        }
        for (Class<?> cl : reflections.getTypesAnnotatedWith(Entity.class)) {
            cfg.addAnnotatedClass(cl);
        }
        SessionFactoryTool.cfg = cfg;
        sessionFactory = cfg.buildSessionFactory();
    }

    static Configuration cfg;

    static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return cfg;
    }
}
