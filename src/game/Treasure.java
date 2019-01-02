package game;

/**
 * The Treasure Class is the class describing the objects that can be found in the rooms.
 * The treasure can be a potion, a weapon, a shield or something else. What differentiates the different
 * types of objects are their attributes. ex. A sword has impact on the player's strength but no impact on his health.
 */

public class Treasure {
    private String name;
    private String description;
    private int health;
    private int strength;
    private int coin;

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
    
}
