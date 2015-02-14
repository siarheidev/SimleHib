package com.dev.domain;

import javax.persistence.*;

@Entity
@Table (name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", unique = true, nullable = false)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "roomNumber")
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "headId")
    private Head head;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
