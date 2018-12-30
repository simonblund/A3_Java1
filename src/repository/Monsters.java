package repository;

import game.Monster;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "monsters")
@XmlAccessorType(XmlAccessType.FIELD)
public class Monsters {
    @XmlElement(name = "monster")
    private List<Monster> monsters;

    public boolean monstersEmpty(){
        return monsters.isEmpty();
    }

    public  List<Monster> getMonsters() {return monsters;}

    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

}
