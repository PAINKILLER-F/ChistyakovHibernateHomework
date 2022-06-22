package ru.javastudy.hibernate.output;

import ru.javastudy.hibernate.entity.Student;

import java.util.List;

public class ConsoleOutput {
    public void printStudentDataToConsole(List<Student> students){
        for(Student student:students){
            String buffRB;
            if(student.getRB()==null){
                buffRB="У студента нет зачетной книжки";
            }
            else {
                buffRB= "Номер зачетной книжки: "+student.getRB().getCode();
            }
            System.out.println("Студент номер "+student.getId()+
                    ". ФИО: "+student.getPerson().getLastName()+" "+student.getPerson().getFirstName()+" "+student.getPerson().getMiddleName()+". "+
                    "Серия и номер паспорта: "+student.getPerson().getPassportSeria()+" "+student.getPerson().getPassportNumber()+". "+
                    buffRB);
        }

    }
}
