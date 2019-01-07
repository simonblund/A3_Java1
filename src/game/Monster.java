package game;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Monster class.
 */

@XmlRootElement(name = "monster")
public class Monster {
    // Simon

    // Fields

    private String name;
    private String description;
    private int strength;
    private int health;
    private boolean boss = false;

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

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    // Methods


}
