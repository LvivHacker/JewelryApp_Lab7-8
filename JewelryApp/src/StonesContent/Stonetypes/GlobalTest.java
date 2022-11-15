package StonesContent.Stonetypes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Logger;

import StonesContent.Necklace;
import filework.WorkFile;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalTest {
    private static final Logger logger = Logger.getLogger(GlobalTest.class.getName());
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @org.junit.jupiter.api.Test
    void test1AddStone() {
        logger.setUseParentHandlers(false);

        Necklace stones = new Necklace();
        stones.addStone(Stone.StoneType.PREC,"DIAMOND", 100, 0.2, 0.1);

        assertEquals(new PreciousStone("DIAMOND", 100, 0.2, 0.1).toString(), stones.getStones().get(0).toString());
        stones.getStones().clear();
    }

    @org.junit.jupiter.api.Test
    void test2AddStone() {
        logger.setUseParentHandlers(false);

        Necklace stones = new Necklace();
        stones.getStones().clear();
        stones.addStone(Stone.StoneType.SEMI, "LAZURYT", 50, 0.2, 0.8);

        assertEquals(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8).toString(),
                stones.getStones().get(0).toString());
        stones.getStones().clear();
    }

    @org.junit.jupiter.api.Test
    void testDelStone() {
        logger.setUseParentHandlers(false);

        Necklace stones = new Necklace();
        stones.getStones().clear();
        stones.addStone(Stone.StoneType.SEMI, "LAZURYT", 50, 0.2, 0.8);
        stones.addStone(Stone.StoneType.SEMI, "RUBY", 80, 0.2, 0.2);
        stones.delStone(0);

        assertEquals(new SemiPreciousStone("RUBY", 80, 0.2, 0.2).toString(),
                stones.getStones().get(0).toString());
        stones.getStones().clear();
    }

    @org.junit.jupiter.api.Test
    void test1ListOfStones() {
        logger.setUseParentHandlers(false);

        Necklace list= new Necklace();
        list.getStones().clear();

        System.setOut(new PrintStream(outputStreamCaptor));
        Stone.listOfStones(list.getStones(),logger);

        assertEquals("В намисті каменів нема",outputStreamCaptor.toString().trim());

        System.setOut(new PrintStream(standardOut));
    }

    @org.junit.jupiter.api.Test
    void test2ListOfStone() {

        logger.setUseParentHandlers(false);

        Necklace stones = new Necklace();
        stones.addStone(Stone.StoneType.SEMI,"LAZURYT", 50, 0.2, 0.8);

        System.setOut(new PrintStream(outputStreamCaptor));
        Stone.listOfStones(stones.getStones(),logger);

        String test = (1 + ") Тип каменя: " + Stone.StoneType.SEMI + "," + " Назва-: " + "LAZURYT" +
                ", Ціна-: " + 50.0 +
                ", Вага-: " + 0.2 +
                ", Прозорість-: " + 0.8 + '\'');

        assertEquals(test,outputStreamCaptor.toString().trim());

        System.setOut(new PrintStream(standardOut));

        stones.getStones().clear();
    }

    @org.junit.jupiter.api.Test
    void test1SortStones() {
        logger.setUseParentHandlers(false);
        ArrayList<Stone> stones = new ArrayList<>();

        stones.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stones.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));
        stones.add(new PreciousStone("RUBY", 80, 0.2, 0.2));

        ArrayList<Stone> stonesRight = new ArrayList<>();

        stonesRight.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));
        stonesRight.add(new PreciousStone("RUBY", 80, 0.2, 0.2));
        stonesRight.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));

        String expected = null,actual = null;

        stones = Stone.sortStones(stones, Stone.rangeSorting.ASC, logger);

        for(int i = 0; i < 3; i++){
            expected += stonesRight.get(i).toString();
            actual += stones.get(i).toString();
        }

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void test2SortStones() {
        logger.setUseParentHandlers(false);
        ArrayList<Stone> stones = new ArrayList<>();

        stones.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stones.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));
        stones.add(new PreciousStone("RUBY", 80, 0.2, 0.2));

        ArrayList<Stone> stonesRight = new ArrayList<>();

        stonesRight.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stonesRight.add(new PreciousStone("RUBY", 80, 0.2, 0.2));
        stonesRight.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));

        String expected = null,actual = null;

        stones = Stone.sortStones(stones, Stone.rangeSorting.DESC,logger);

        for(int i = 0; i < 3; i++){
            expected += stonesRight.get(i).toString();
            actual += stones.get(i).toString();
        }

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void testFilterStones() {
        logger.setUseParentHandlers(false);
        ArrayList<Stone> stones = new ArrayList<>();

        stones.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stones.add(new PreciousStone("RUBY", 80, 0.2, 0.2));
        stones.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));

        ArrayList<Stone> stonesRight = new ArrayList<>();

        stonesRight.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stonesRight.add(new PreciousStone("RUBY", 80, 0.2, 0.2));

        String expected = null,actual = null;

        Stone.filterStones(stones,logger);

        for(int i = 0; i < 2; i++){
            expected += stonesRight.get(i).toString();
            actual += stones.get(i).toString();
        }

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void testGetTotalPrice() {
        logger.setUseParentHandlers(false);
        ArrayList<Stone> stones = new ArrayList<>();

        stones.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stones.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));
        stones.add(new PreciousStone("RUBY", 80, 0.2, 0.2));

        assertEquals(230,Necklace.getTotalPrice(stones,logger));
    }

    @org.junit.jupiter.api.Test
    void testGetTotalWeight() {
        logger.setUseParentHandlers(false);
        ArrayList<Stone> stones = new ArrayList<Stone>();

        stones.add(new PreciousStone("DIAMOND", 100, 0.2, 0.1));
        stones.add(new SemiPreciousStone("LAZURYT", 50, 0.2, 0.8));
        stones.add(new PreciousStone("RUBY", 80, 0.2, 0.2));

        assertEquals(0.6000000000000001,Necklace.getTotalWeight(stones,logger));
    }

    @org.junit.jupiter.api.Test
    void testWriteFile() throws Exception {
        logger.setUseParentHandlers(false);

        Necklace content = new Necklace("Test");
        content.addStone(Stone.StoneType.PREC, "DIAMOND", 100, 0.2, 0.1);

        new WorkFile().FileWiter("Test",content,logger);

        Necklace readActual = new WorkFile().FileReader("Test",logger);

        String expected = content.getStones().get(0).toString();

        String actual = readActual.getStones().get(0).toString();

        assertEquals(expected,actual);

        content.getStones().clear();
        readActual.getStones().clear();
    }

    @org.junit.jupiter.api.Test
    void testReadFile() throws Exception {
        logger.setUseParentHandlers(false);

        Necklace content = new Necklace("Test");
        content.addStone(Stone.StoneType.PREC,  "DIAMOND", 100, 0.2, 0.1);

        Necklace readActual = new WorkFile().FileReader("Test",logger);

        String expected = content.getStones().get(0).toString();

        String actual = readActual.getStones().get(0).toString();

        assertEquals(expected,actual);
    }
}
