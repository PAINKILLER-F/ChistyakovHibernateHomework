package ru.javastudy.hibernate.select;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.Person;
import ru.javastudy.hibernate.entity.Student;
import ru.javastudy.hibernate.output.ConsoleOutput;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import javax.persistence.Query;
import java.util.List;

public class HQLSelect implements Select {

    @Override
    public void selectByLetterInName(Character letter) {
        String pattern = "%" + letter + "%";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select s " +
                "from Student s " +
                "inner join s.person p " +
                "where p.firstName like :pattern or p.lastName like :pattern or p.middleName like :pattern").setParameter("pattern", pattern);
        List<Student> students = query.getResultList();
        System.out.println("Вывод на консоль студентов с буквой " + letter + " в ФИО при помощи HQL:");
        ConsoleOutput CO = new ConsoleOutput();
        CO.printStudentDataToConsole(students);

    }
    @Override
    public void selectByLackOfRB() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("select s " +
                "from Student s " +
                "where s.RB is null");
        List<Student> students = query.getResultList();
        System.out.println("Вывод на консоль студентов без зачетной книжки при помощи HQL:");
        ConsoleOutput CO = new ConsoleOutput();
        CO.printStudentDataToConsole(students);

    }
}
