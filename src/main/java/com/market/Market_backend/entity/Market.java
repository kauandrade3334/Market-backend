package com.market.Market_backend.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "market")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "market")
    private final List<Users> usersList = new ArrayList<Users>();


    //CONSTRUCTORS
    public Market() {
    }
    public Market(String cnpj, String name, String passwordHash) {
        this.cnpj = cnpj;
        this.name = name;
        this.passwordHash = passwordHash;
    }

    //GETTERS
    public String getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    //SETTERS
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    //list methods
    public void addUsers(Users users){
        this.usersList.add(users);
        users.setMarket(this);
    }

    public void removeUsers(Users users){
        this.usersList.remove(users);
        users.setMarket(null);
    }
}
