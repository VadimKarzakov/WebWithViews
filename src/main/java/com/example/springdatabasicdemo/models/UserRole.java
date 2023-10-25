package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.constants.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    @Column(name = "name")
    private Role role;
    @OneToMany(mappedBy = "role")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Set<User> users = new HashSet<>();

    void addModel(User user){
        users.add(user);
    }

    public UserRole(Role role, Set<User> users) {
        this.role = role;
        this.users = users;
    }

    public UserRole(Role role, Date created, Date modified) {
        super.created = created;
        super.modified = modified;
        this.role = role;
    }

    public UserRole() {}

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
