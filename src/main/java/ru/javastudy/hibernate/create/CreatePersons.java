package ru.javastudy.hibernate.create;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.Person;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Random;

public class CreatePersons {
    public ArrayList<Person> create10Persons(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ArrayList<Integer> numbers = new ArrayList();
        ArrayList<Person> persons = new ArrayList();
        for (Integer t=112650;t<112660;t++) {
            numbers.add(t);
        }
        Integer seria=6543;
        Random random = new Random();

        for (int j = 0; j < 10; j++) {
            //Person person = new Person();
            String firstname = "";
            String lastname = "";
            String middlename = "";
            int razmer = 4 + random.nextInt(9);
            for (int i = 0; i < razmer; i++) {
                int v = 1072 + random.nextInt(32);//промежуток кириллицы нижнего регистра в десятичном юникоде UTF-8
                char a = (char) v;//Получаем случайную букву Кириллицы
                firstname += String.valueOf(a);
            }
            razmer = 4 + random.nextInt(9);
            for (int i = 0; i < razmer; i++) {
                int v = 1072 + random.nextInt(32);//промежуток кириллицы нижнего регистра в десятичном юникоде UTF-8
                char a = (char) v;//Получаем случайную букву Кириллицы
                lastname += String.valueOf(a);
            }
            razmer = 4 + random.nextInt(9);
            for (int i = 0; i < razmer; i++) {
                int v = 1072 + random.nextInt(32);//промежуток кириллицы нижнего регистра в десятичном юникоде UTF-8
                char a = (char) v;//Получаем случайную букву Кириллицы
                middlename += String.valueOf(a);
            }
            Person person =new Person(seria,numbers.get(j),lastname,firstname,middlename);
            persons.add(person);
            session.save(person);

        }
        session.getTransaction().commit();
        session.close();
        return persons;
    }
}
