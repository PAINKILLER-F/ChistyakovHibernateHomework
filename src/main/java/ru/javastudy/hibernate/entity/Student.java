package ru.javastudy.hibernate.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.javastudy.hibernate.listener.DeleteListener;

@Entity
@EntityListeners(DeleteListener.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "st_generator")
    @SequenceGenerator(name="st_generator", sequenceName = "st_seq", allocationSize=1)
    @Column(unique = true)
    private Long id;
    @OneToOne
    private Person person;
    @OneToOne
    private RecordBook RB;
    private String study_group;

    public Student(Person person,RecordBook RB,String group) {
        this.person = person;
        this.RB = RB;
        this.study_group=group;
    }
}
