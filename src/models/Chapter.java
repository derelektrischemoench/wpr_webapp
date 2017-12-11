package models;

import java.io.Serializable;

public class Chapter implements Serializable {
    private String name;
    private String description;
    
    public Chapter() {}
    public Chapter(String name, String description) {
        super();
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
    
    //for serialization purposes:
    public String toString() {
        return "Chapter [" + this.name + "], Beschreibung: [" + this.description + "]";
    }
}
