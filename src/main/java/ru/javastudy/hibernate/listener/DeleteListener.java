package ru.javastudy.hibernate.listener;

import ru.javastudy.hibernate.entity.Student;

import javax.persistence.PreRemove;

public class DeleteListener {
    @PreRemove
    private void beforeRemove(Student student){
        System.out.println("Студент " +student.getPerson().getFirstName()+" "+student.getPerson().getLastName()+" удален");
    }
}
