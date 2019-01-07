package repository;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Monster XML Parse puts the monsters in the XML, and takes them out of there when they are needed.
 */

public class MonsterXMLparse {
    // Simon

    public static void setMonsters(Monsters monsters){
        try(BufferedWriter output = Files.newBufferedWriter(Paths.get("monsters.xml"))){

            JAXBContext jaxbContext = JAXBContext.newInstance(Monsters.class);
            Marshaller jaxBMarshaller = jaxbContext.createMarshaller();
            jaxBMarshaller.marshal(monsters, output);
        }

        catch (IOException ioException){
            System.err.println("File write error");
        }
        catch (JAXBException ee){
            ee.printStackTrace();
        }



    }

    public static Monsters getMonsters(){
        Monsters monsters = null;
        try(BufferedReader input = Files.newBufferedReader(Paths.get("monsters.xml"))){
            JAXBContext jaxbContext = JAXBContext.newInstance(Monsters.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            monsters = (Monsters) jaxbUnmarshaller.unmarshal(input);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch (JAXBException je){
            je.printStackTrace();
        }
        return monsters;
    }

}
