package org.vaskon.jpawork.bean;

import org.springframework.stereotype.Component;
import org.vaskon.jpawork.model.User;

@Component
public class Storage {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
