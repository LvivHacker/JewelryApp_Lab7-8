package menu.methods.AddingMethods;

import StonesContent.Necklace;
import StonesContent.Stonetypes.Stone;
import menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class Add implements Command {
    @Override
    public void execute(Necklace content, Logger logger) {
        Scanner scanner = new Scanner(System.in);
        logger.finer("Додаємо камені до нашого намиста. Не можливо вибрати тип, який не існує");
        while (true) {
            System.out.println("\n *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.println("  |                    ВИБЕРІТЬ ТИП КАМЕНЯ                      |");
            System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.println("  |  ДОРОГОЦІННИЙ  |                         |  НАПІВКОШТОВНИЙ  |   ");
            System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
            System.out.print("Ваш вибір [1/2]-: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("Введіть назву каменя-: ");
            String name = scanner.nextLine();
            System.out.println("Введіть вартість каменя-: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Введіть вагу каменя(в каратах)-: ");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println("Введіть прозорість каменя-: ");
            double transparency = Double.parseDouble(scanner.nextLine());
            if(choice == 1) {
                content.addStone(Stone.StoneType.PREC, name,
                        price, weight, transparency);
            }else if (choice == 2) {
                content.addStone(Stone.StoneType.SEMI, name,
                        price, weight, transparency);
            }else {
                System.out.println(" НЕВІРНО ВВЕДЕНІ ДАННІ! \nСПРОБУЙТЕ ЩЕ РАЗ ");
            }
            System.out.println("Додати новий камінь до списку? \n1 - Так \n2 - Ні");
            System.out.print("Ваш вибір [1/2]-: ");
            int num = Integer.parseInt(scanner.nextLine());
            if (num == 2) { break; }
        }
    }
}

