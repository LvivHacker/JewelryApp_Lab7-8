package menu.methods.SortCommands;

import StonesContent.Necklace;
import StonesContent.Stonetypes.Stone;
import menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class Sort implements Command {
    @Override
    public void execute(Necklace content, Logger logger) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.println("  |                   ВИБЕРІТЬ ТИП СОРТУВАННЯ                   |");
            System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.println("  |  ЗА ЗРОСТАННЯМ  |                          |  ЗА СПАДАННЯМ  |   ");
            System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.print("Ваш вибір [1/2]-: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                content.setStones(Stone.sortStones(content.getStones(), Stone.rangeSorting.ASC, logger));
            } else if (choice == 2) {
                content.setStones(Stone.sortStones(content.getStones(), Stone.rangeSorting.DESC, logger));
            } else {
                System.out.println(" НЕВІРНО ВВЕДЕНІ ДАННІ! \nСПРОБУЙТЕ ЩЕ РАЗ ");
            }
            System.out.println("Бажаєте провести сортування ще раз? \n1 - Так \n2 - Ні");
            System.out.print("Ваш вибір [1/2]-: ");
            int num = Integer.parseInt(scanner.nextLine());
            if(num == 2){ break; };
        }
    }
}
