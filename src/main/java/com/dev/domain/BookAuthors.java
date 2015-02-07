package com.dev.domain;


import org.hibernate.proxy.LazyInitializer;

import javax.persistence.*;

//@Entity
//@Table(name = "book_authors")
public class BookAuthors {

    @Id
//	@Column (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "book_id", referencedColumnName = "id")
    private Author author;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn (name = "author_id", referencedColumnName = "id")
    private Book book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
