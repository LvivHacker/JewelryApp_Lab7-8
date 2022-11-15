package menu.methods.AddingMethods;

import StonesContent.Necklace;
import menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class Del implements Command {
    @Override
    public void execute(Necklace content, Logger logger) {
        logger.finer("Видаляємо камені з нашого намиста. Не можливо вибрати тип, який не існує");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.println("  |            ВВЕДІТЬ ІНДЕКС КАМЕНЯ ДЛЯ ВИДАЛЕННЯ              |");
            System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.print("Ваш вибір-: ");
            int choice = Integer.parseInt(scanner.nextLine());
            content.delStone(choice);
            System.out.println("Видалити ще один камінь? \n1 - Так \n2 - Ні");
            int num = Integer.parseInt(scanner.nextLine());
            if (num == 2) { break; }
        }
    }
}