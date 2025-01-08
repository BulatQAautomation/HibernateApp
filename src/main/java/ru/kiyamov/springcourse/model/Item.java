package ru.kiyamov.springcourse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item() {
    }

    public Item(String itemName, Person owner) {
        this.itemName = itemName;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
