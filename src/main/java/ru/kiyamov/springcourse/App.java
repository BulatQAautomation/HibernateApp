package ru.kiyamov.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kiyamov.springcourse.model.Item;
import ru.kiyamov.springcourse.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // читаем конфигурацию из файла hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 2);
//          SQL
            session.remove(person);
//          было правильное состояние Hibernate кэша
            person.getItems().forEach(i -> i.setOwner(null));

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}