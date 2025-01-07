package ru.kiyamov.springcourse.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Person")
public class Person implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "seq_generator_person")
    @SequenceGenerator(name = "seq_generator_person",
            sequenceName = "person_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person() {}
}
