package ru.javastudy.hibernate.create;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.RecordBook;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Random;

public class CreateRB {
    public ArrayList<RecordBook> createSomeNumberOfRB() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ArrayList<RecordBook> recordBooks = new ArrayList();

        Random random = new Random();
        for (int j = 0; j < 10; j++) {
            int value = random.nextInt(2);
            if (value == 1) {
                int code = 100000 + random.nextInt(900000);//номера от 100000 до 999999
                RecordBook RB = new RecordBook(code);
                session.save(RB);
                recordBooks.add(RB);
            } else {
                recordBooks.add(null);
            }
        }
        session.getTransaction().commit();
        session.close();
        return recordBooks;
    }
}
