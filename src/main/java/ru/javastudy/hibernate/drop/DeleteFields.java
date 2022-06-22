package ru.javastudy.hibernate.drop;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.Student;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import java.util.List;

public class DeleteFields {
    public void dropAllFields(List<Student> students) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("Удаляем студентов");
        for (Student student : students) {
            session.remove(student);
            session.remove(student.getPerson());
            if (student.getRB() != null)
                session.remove(student.getRB());
        }
        session.getTransaction().commit();
        session.close();
    }
}
