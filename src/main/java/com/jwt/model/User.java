package com.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_level")
    private String userLevel;

    @OneToMany(mappedBy = "usersAssigned")
    @JsonIgnore
    private List<CandidateUser> candidateUsers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_stream",
            joinColumns = @JoinColumn(name = "uuser_id"),
            inverseJoinColumns = @JoinColumn(name = "ustream_id")
    )
    @JsonIgnore
    private List<Stream> userStreams;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Stream> getUserStreams() {
        return userStreams;
    }

    public void setUserStreams(List<Stream> userStreams) {
        this.userStreams = userStreams;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public List<CandidateUser> getCandidateUsers() {
        return candidateUsers;
    }

    public void setCandidateUsers(List<CandidateUser> candidateUsers) {
        this.candidateUsers = candidateUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", userName='" + userName + '\'' +
                ", userLevel='" + userLevel + '\'' +
                '}';
    }
}
