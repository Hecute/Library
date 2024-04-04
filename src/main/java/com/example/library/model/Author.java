package com.example.library.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Author {

    private @Id
    @GeneratedValue Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "authorId", nullable = false)
    private Set<Book> bookSet;

    public Author() { }
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String fisrtName) {
        this.firstName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }
    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + id +
                ", fisrtName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bookSet=" + bookSet +
                '}';
    }
}
