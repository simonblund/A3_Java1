package game;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int gold;
    private int healthPotionsCarried;

    public int getHealthPotions() {
        return healthPotionsCarried;
    }

    public void setHealthPotions(int healthPotions) {
        this.healthPotionsCarried = healthPotions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void printStats (){
        System.out.println();
    
    }
    // backpack, path, current room?

}
