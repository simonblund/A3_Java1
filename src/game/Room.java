package game;

public class Room {

    // Variables

    //private String name;
    private String description;
    private Monster monster;
    private Treasure treasure;
    private boolean salesman;

    // Setters and getters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public boolean isSalesman() {
        return salesman;
    }

    public void setSalesman(boolean salesman) {
        this.salesman = salesman;
    }


}
