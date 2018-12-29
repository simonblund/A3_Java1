package repository;

import game.Monster;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class Monsters {
    @XmlElement(name = "monster")
    private static List<Monster> monsters = new ArrayList<>();

    public static  List<Monster> getMonsters() {return monsters;}

    public static void addMonster(Monster monster){
        monsters.add(monster);
    }

    public static void saveMonsters(){
        MonsterXMLparse.setMonsters(monsters);

    }
}
