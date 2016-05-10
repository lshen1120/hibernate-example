package hibernate.example;

import hibernate.example.entity.Employee;
import hibernate.example.tool.DatabaseSchemaTool;
import hibernate.example.tool.SessionFactoryTool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by SL on 2016/5/4.
 */
public class Test {

    public static void main(String[] args) {
        DatabaseSchemaTool schemaTool = new DatabaseSchemaTool(SessionFactoryTool.getConfiguration());
        //  schemaTool.update(true,true);
        SessionFactory sessionFactory = SessionFactoryTool.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Employee e = (Employee) session.get(Employee.class, 1L);
        e.setName("测试2");

        tx.commit();
        sessionFactory.close();

    }

}
