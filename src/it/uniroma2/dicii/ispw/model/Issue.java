package it.uniroma2.dicii.ispw.model;

public class Issue {

    private String name;
    private String description;
    private String state;

    public Issue(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }
}
