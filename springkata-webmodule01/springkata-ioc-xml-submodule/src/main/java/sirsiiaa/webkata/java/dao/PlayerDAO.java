package sirsiiaa.webkata.java.dao;

import java.util.HashSet;

public class PlayerDAO {
    private String name;
    private int id;

    public HashSet<String> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<String> roles) {
        this.roles = roles;
    }

    private HashSet<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
