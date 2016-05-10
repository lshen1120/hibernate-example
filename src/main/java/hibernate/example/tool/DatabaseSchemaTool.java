package hibernate.example.tool;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.reflections.Reflections;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Created by SL on 2016/5/4.
 */
public class DatabaseSchemaTool {

    Configuration hibernateCfg;

    public DatabaseSchemaTool(Configuration hibernateCfg) {
        this.hibernateCfg = hibernateCfg;
    }

    public DatabaseSchemaTool(String entityPackage, String dialect,
                              String driverClass, String conUrl, String user, String pass) {
        Configuration config = createHibernateConfig(entityPackage, dialect, driverClass, conUrl, user, pass);
        hibernateCfg = config;
    }

    public void update(boolean script, boolean isExport) {
        SchemaUpdate update = new SchemaUpdate(hibernateCfg);
        update.execute(script, isExport);
    }

    public void drop(boolean script, boolean isExport) {
        SchemaExport export = new SchemaExport(hibernateCfg);
        export.drop(script, isExport);
    }

    public void create(boolean script, boolean isExport) {
        SchemaExport export = new SchemaExport(hibernateCfg);
        export.execute(script, isExport, false, true);
    }

    public void generateCreateScriptToFile(String fileName) {
        SchemaExport export = new SchemaExport(hibernateCfg);
        export.setOutputFile(fileName);
        export.execute(true, false, false, true);
    }

    //不需要数据库连接,直接生成sql create,drop
    //refer https://github.com/geowarin

    private Configuration createHibernateConfig(String entityPackage, String dialect,
                                                String driverClass, String conUrl, String user, String pass) {

        Configuration hibernateConfiguration = new Configuration();

        //依赖 reflections-maven
        final Reflections reflections = new Reflections(entityPackage);
        for (Class<?> cl : reflections.getTypesAnnotatedWith(MappedSuperclass.class)) {
            hibernateConfiguration.addAnnotatedClass(cl);
            System.out.println("Mapped = " + cl.getName());
        }
        for (Class<?> cl : reflections.getTypesAnnotatedWith(Entity.class)) {
            hibernateConfiguration.addAnnotatedClass(cl);
            System.out.println("Mapped = " + cl.getName());
        }
        hibernateConfiguration.setProperty(AvailableSettings.DIALECT, dialect);
        hibernateConfiguration.setProperty(AvailableSettings.DRIVER, driverClass);
        hibernateConfiguration.setProperty(AvailableSettings.URL, conUrl);
        hibernateConfiguration.setProperty(AvailableSettings.USER, user);
        hibernateConfiguration.setProperty(AvailableSettings.PASS, pass);
        return hibernateConfiguration;
    }

}
