package ru.kiyamov.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kiyamov.springcourse.model.Person;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // читаем конфигурацию из файла hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Person> people = session.createQuery("FROM Person WHERE age >= 30").getResultList();
            for (Person p : people) {
                System.out.println(p);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}