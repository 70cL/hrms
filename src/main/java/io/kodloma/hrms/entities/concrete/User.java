package io.kodloma.hrms.entities.concrete;

import io.kodloma.hrms.entities.abstracts.IEntity;

public class User implements IEntity {
    private int id;
    private String mail;
    private String password;

    public User(){
    }

    public User(int id, String mail, String password)
    {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
