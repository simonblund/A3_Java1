package repository;

import game.Monster;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class MonsterXMLparse {

    public static void setMonsters(List<Monster> monsters){
        try(BufferedWriter output = Files.newBufferedWriter(Paths.get("monsters.xml"))){
            System.out.println(monsters.get(0).getName());
            JAXB.marshal(monsters, output);
        }


        catch (IOException ioException){
            System.err.println("File write error");
        }



    }

}
