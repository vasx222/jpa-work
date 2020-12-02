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

@Component
@Order(2)
public class Starter2 implements CommandLineRunner {

    @PersistenceContext
    private final EntityManager em;
    private final Storage storage;

    public Starter2(EntityManager em, Storage storage) {
        this.em = em;
        this.storage = storage;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        User user = em.find(User.class, 1L);
//        System.out.println(user);
//        System.out.println(user.getDocuments().size());
    }
}
