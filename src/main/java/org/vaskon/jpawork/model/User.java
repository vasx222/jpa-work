package org.vaskon.jpawork.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@NamedQueries({
        @NamedQuery(name = "updateUser", query = "UPDATE User set name = :name, userType = :userType where id = :id"),
        @NamedQuery(name = "removeUserById", query = "DELETE from User where id = :id"),
        @NamedQuery(name = "removeDocumentsByUserId", query = "DELETE from Document d where d.userId = :id")
})
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    private UserType userType;


    @JoinColumn(name = "USER_ID")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true/*, mappedBy = "user"*/)
    private List<Document> documents;

    public User() {
    }

    public User(String name, Integer age, UserType userType, List<Document> documents) {
        this.name = name;
        this.age = age;
        this.userType = userType;
        this.documents = documents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", userType=" + userType +
                ", documents=" + documents +
                '}';
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
