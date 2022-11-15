package StonesContent.Stonetypes;
import StonesContent.Sorting.*;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.Scanner;

public class Stone {
    String name;
    double price, weight, transparency;

    public enum StoneType{
        PREC,
        SEMI
    }
    StoneType type;

    public enum rangeSorting{
        ASC,
        DESC
    }

    public static void listOfStones(ArrayList<Stone> list, Logger logger){

        logger.finest("Виводимо список каменів в нашому намисті. Є вийняток, коли каменів у намисті немає.");
        if(list.size() == 0){
            System.out.println("В намисті каменів нема");
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ") Тип каменя: " + list.get(i).getType() +
                             "," + list.get(i).toString());
        }
    }

    public static ArrayList<Stone> sortStones(ArrayList<Stone> stones, rangeSorting type, Logger logger) {

        logger.fine("Створюємо ArrayList, де відсортуємо наш оригінальний список. " +
                "Типи сортування не можливо вибрати таким чином, щоб програма аварійно завершилася.");

        ArrayList<Stone> sortedArray = new ArrayList<>(stones);
        int N = sortedArray.size();
        if (type == rangeSorting.ASC) {
            sortedArray.sort(new AscSorting());
        }else {
            System.out.println("Сортуємо за спаданням");
            sortedArray.sort(new DescSorting());
        }
        while (N-- != 0) {
            System.out.print(sortedArray.get(N));
        }
        return sortedArray;
    }

    public static void filterStones(ArrayList<Stone> list, Logger logger){

        logger.fine("Фільтруємо наші камені за показником прозорості.");
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        /*System.out.println("Введіть діапазон сортування!");
        System.out.print("Від-:");
        double first = Double.parseDouble(scanner.nextLine());
        System.out.print("До-:");
        double second = Double.parseDouble(scanner.nextLine());*/

        for(Stone stone : list){
            if(stone.getTransparency() > 0 && stone.getTransparency() < 0.3){
                System.out.println("\n");
                System.out.print(stone);
                counter++;
            }
        }

        if(counter == 0){
            System.out.println("\nТаких каменів нема! :(");
        }
    }

    public String getStoneName() { return name; }
    public StoneType getType() { return type; }
    public double getPrice(){return price;}
    public double getWeight(){return weight;}
    public double getTransparency(){return transparency;}

    @Override
    public String toString() {
        return    " Назва-: "+ name +
                  ", Ціна-: " + price +
                  ", Вага-: " + weight +
                  ", Прозорість-: " + transparency
                  + '\'' + '\n';
    }
}
