package game;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Monster {

    // Fields
    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "description")
    private String description;

    @XmlAttribute(name = "strength")
    private int strength;

    @XmlAttribute(name = "health")
    private int health;

    //Getters and Setters

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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Methods


}
