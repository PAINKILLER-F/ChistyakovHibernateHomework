package ru.javastudy.hibernate.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_generator")
    @SequenceGenerator(name="pers_generator", sequenceName = "pers_seq", allocationSize=1)
    @Column(unique = true)
    private Long id;
    private Integer passportSeria;
    private Integer passportNumber;
    private String lastName;
    private String firstName;
    private String middleName;

    public Person(Integer passportSeria, Integer passportNumber, String lastName, String firstName, String middleName) {
        this.passportSeria = passportSeria;
        this.passportNumber = passportNumber;
        this.lastName = lastName;
        this.firstName= firstName;
        this.middleName = middleName;
    }

}
