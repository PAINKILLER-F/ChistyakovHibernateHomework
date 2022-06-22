package ru.javastudy.hibernate.create;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.Person;
import ru.javastudy.hibernate.entity.RecordBook;
import ru.javastudy.hibernate.entity.Student;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStudents {
    public List<Student> create10Students(ArrayList<Person> persons, ArrayList<RecordBook> recordBooks)
    {
        List<Student> students = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        Random random = new Random();

        for (int j = 0; j < 10; j++) {
            String group = "";

            for (int i = 0; i < 9; i++) {
                if (i < 2) {
                    int v = 1040 + random.nextInt(32);//промежуток кириллицы Верхнего регистра в десятичном юникоде UTF-8
                    char a = (char) v;//Получаем случайную букву Кириллицы
                    group += String.valueOf(a);
                } else if(i==2){
                    group += "-";
                }
                else{
                    int g = random.nextInt(10);
                    group += String.valueOf(g);
                }
            }
            Student student = new Student(persons.get(j),recordBooks.get(j),group);
            session.save(student);
            students.add(student);

        }
        session.getTransaction().commit();
        session.close();
        return students;
    }
}

