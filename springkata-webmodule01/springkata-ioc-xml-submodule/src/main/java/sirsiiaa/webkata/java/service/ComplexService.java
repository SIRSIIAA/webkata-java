package sirsiiaa.webkata.java.service;

public class ComplexService {
    private String name;
    private int id;

    public ComplexService(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name = " + name + ", id = " + id;
    }
}
