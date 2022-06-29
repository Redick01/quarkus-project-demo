package io.redick.quarkus.dto;

/**
 * @author Redick01
 */
public class Fruit {

    private String name;

    private String description;

    public Fruit() {}

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
