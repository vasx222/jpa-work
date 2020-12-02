package org.vaskon.jpawork.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.vaskon.jpawork.bean.Storage;
import org.vaskon.jpawork.model.Document;
import org.vaskon.jpawork.model.User;
import org.vaskon.jpawork.model.UserType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
@Order(1)
public class Starter1 implements CommandLineRunner {

    @PersistenceContext
    private final EntityManager em;

    private final Storage storage;

    public Starter1(EntityManager em, Storage storage) {
        this.em = em;
        this.storage = storage;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        User user = new User("Tommy", 32, UserType.ADMIN, null);
//        Document doc = new Document("Doc1", "Text1", 1L);
//        user.getDocuments().add(doc);
//        em.persist(user);
    }
}
