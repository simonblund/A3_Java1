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
}
