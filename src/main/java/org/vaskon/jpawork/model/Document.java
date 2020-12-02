package org.vaskon.jpawork.model;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "USER_ID")
    private Long userId;

/*    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;*/

    public Document() {
    }

    public Document(String name, String text, Long userId) {
        this.name = name;
        this.text = text;
        this.userId = userId;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

/*    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }*/

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
//                ", userId=" + userId +
                ", user='" + userId + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
