package com.dogeatdogenterprises.domain.security;

import com.dogeatdogenterprises.domain.AbstractDomainClass;
import com.dogeatdogenterprises.domain.User;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by donaldsmallidge on 2/21/17.
 */
@Entity
public class Role extends AbstractDomainClass {

    private String role;

    @ManyToMany
    @JoinTable
    // ~ defaults to @JoinTable(name = "USER_ROLE", joinColumns = "role_id"),
    //  inverseJoinColumns = @joinColumn(name = "user_id")
    private List<User> users = new ArrayList<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // support bi-directional relationship
    public void addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
        }
        if (!user.getRoles().contains(this)) {
            user.getRoles().add(this);
        }
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}

