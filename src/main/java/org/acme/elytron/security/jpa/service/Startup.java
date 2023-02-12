package org.acme.elytron.security.jpa.service;

import io.quarkus.runtime.StartupEvent;
import org.acme.elytron.security.jpa.model.User;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Startup {

    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        //reset and load all users
        User.deleteAll();
        User.add("admin", "admin", "admin");
        User.add("user", "user", "user");
        User.add("riku", "riku", "riku");
    }
}
