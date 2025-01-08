package ru.kiyamov.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.kiyamov.springcourse.model.Item;
import ru.kiyamov.springcourse.model.Person;

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

            /** - выводим человека и его айтемы
             Person person = session.get(Person.class, 3);
             System.out.println(person);

             List<Item> itemList = person.getItems();
             for (Item item : itemList) {
             System.out.println(item);
             }
             */

//            выводим сначала айтем и из айтема вычленяем человека
            Item item = session.get(Item.class, 5);
            System.out.println(item);

            Person person = item.getOwner();
            System.out.println(person);

//            Person person = session.get(Person.class, 3);



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}