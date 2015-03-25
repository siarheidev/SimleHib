package com.dev.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "head")
public class Head {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "head")
    Set<Classes> classes = new HashSet<Classes>();

    @Transient
    String tDate;

    public String gettDate() {
        return tDate;
    }

    public void settDate(String tDate) {
        this.tDate = tDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Classes classe) {
        classes.add(classe);
    }

    public void setName(String name) {

        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
