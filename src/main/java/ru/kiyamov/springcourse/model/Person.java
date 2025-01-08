package ru.kiyamov.springcourse.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    // таким образом теперь будет касакадироваться вызов метода save()
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
        item.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", age=" + age + ", name=" + name + "]";
    }
}
