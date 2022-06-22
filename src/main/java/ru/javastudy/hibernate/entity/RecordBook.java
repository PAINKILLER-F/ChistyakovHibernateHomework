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
@Table(name = "RecordBook")
public class RecordBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rb_generator")
    @SequenceGenerator(name="rb_generator", sequenceName = "rb_seq", allocationSize=1)
    @Column(unique = true)
    private Long id;
    @Column(unique = true)
    private Integer code;

    public RecordBook(Integer code) {
        this.code=code;

    }
}
