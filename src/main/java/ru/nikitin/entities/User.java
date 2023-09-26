package ru.nikitin.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }
    public User(String username, String encode, String email) {
        this.username = username;
        this.password = encode;
        this.email = email;
    }
    public User(String username, String email, Collection<Role> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean isEmpty() {
        if(username.isEmpty()){
            return true;
        }
          return false;
    }

//    @JsonIgnore
//    @Transient
//    private boolean confirmed;

//
//    public  void update (User user){
//        this.User.update(user);
//    }


}
