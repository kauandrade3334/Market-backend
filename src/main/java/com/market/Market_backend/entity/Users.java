package com.market.Market_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;


    //CONSTRUCTORS
    public Users() {
    }

    public Users(String name, String passwordHah, Market market) {
        this.name = name;
        this.passwordHash = passwordHah;
        this.market = market;
    }


    //GETTERS
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPasswordHah() {
        return passwordHash;
    }

    public Market getMarket() {
        return market;
    }


    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPasswordHah(String passwordHah) {
        this.passwordHash = passwordHah;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
