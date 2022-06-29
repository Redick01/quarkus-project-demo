package io.redick.quarkus.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * @author Redick01
 */
@RegisterForReflection
public class Animals {

    private String name;

    private String description;

    public Animals() {}

    public Animals(String name, String description) {
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
        return "Animals{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
