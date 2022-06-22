package ru.javastudy.hibernate.main;

import org.hibernate.Session;
import ru.javastudy.hibernate.drop.DeleteFields;
import ru.javastudy.hibernate.entity.Person;
import ru.javastudy.hibernate.entity.RecordBook;
import ru.javastudy.hibernate.create.CreatePersons;
import ru.javastudy.hibernate.create.CreateRB;
import ru.javastudy.hibernate.create.CreateStudents;
import ru.javastudy.hibernate.entity.Student;
import ru.javastudy.hibernate.select.CriteriaSelect;
import ru.javastudy.hibernate.select.HQLSelect;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        CreatePersons createpersons=new CreatePersons();
        ArrayList<Person> persons=createpersons.create10Persons();

        CreateRB createRB=new CreateRB();
        ArrayList<RecordBook> recordbooks= createRB.createSomeNumberOfRB();

        CreateStudents createstudents=new CreateStudents();
        List<Student> students=createstudents.create10Students(persons,recordbooks);

        HQLSelect hqlSelect=new HQLSelect();
        hqlSelect.selectByLetterInName('а');

        CriteriaSelect criteriaSelect=new CriteriaSelect();
        criteriaSelect.selectByLetterInName('а');

        hqlSelect.selectByLackOfRB();
        criteriaSelect.selectByLackOfRB();

        DeleteFields delete=new DeleteFields();
        delete.dropAllFields(students);
    }

}
