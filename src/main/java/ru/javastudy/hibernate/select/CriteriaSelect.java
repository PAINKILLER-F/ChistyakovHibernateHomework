package ru.javastudy.hibernate.select;

import org.hibernate.Session;
import ru.javastudy.hibernate.entity.Student;
import ru.javastudy.hibernate.output.ConsoleOutput;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;

public class CriteriaSelect implements Select {
    @Override
    public void selectByLetterInName(Character letter) {
        String pattern="%"+letter+"%";

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root=criteria.from(Student.class);
        Predicate firstNameCheck =builder.like(root.get("person").get("firstName"),pattern);
        Predicate lastNameCheck =builder.like(root.get("person").get("lastName"),pattern);
        Predicate middleNameCheck =builder.like(root.get("person").get("middleName"),pattern);
        criteria.select(root);
        criteria.where(builder.or(firstNameCheck,lastNameCheck,middleNameCheck));
        List<Student> students=session.createQuery(criteria).getResultList();
        System.out.println("Вывод на консоль студентов с буквой "+letter+" при помощи Criteria:");
        ConsoleOutput CO=new ConsoleOutput();
        CO.printStudentDataToConsole(students);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void selectByLackOfRB() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        Root<Student> root=criteria.from(Student.class);
        criteria.select(root);
        criteria.where(builder.isNull(root.get("RB")));
        List<Student> students=session.createQuery(criteria).getResultList();
        System.out.println("Вывод на консоль студентов без зачетной книжки при помощи Criteria:");
        ConsoleOutput CO=new ConsoleOutput();
        CO.printStudentDataToConsole(students);

        session.getTransaction().commit();
        session.close();

    }
}
