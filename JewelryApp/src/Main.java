import StonesContent.Necklace;
import menu.Menu;

import java.util.Scanner;
import java.util.logging.*;

import static message.SendEmail.sendMessage;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            logger.setUseParentHandlers(false);
            logger.info("Оголошення змінних: Сканнера, " +
                             "Консольного меню та пустого класу Necklace, для подальшого заповнення");

            Scanner scanner = new Scanner(System.in);
            Necklace jewelery = new Necklace();
            Menu mainMenu = new Menu();

            logger.info("Виклик функції, у якій використовуємо консольне меню та вибираємо команду");
            while (true) {
                System.out.println("\nДоступні команди: " + mainMenu.getAllCommands());
                System.out.print(" Введіть команду-: ");
                String command = scanner.nextLine();

                mainMenu.execute(command, jewelery, logger);
            }
        }catch (Exception e) {
            logger.log(Level.WARNING,"Знайдено критичну помилку: ",e);
            System.out.println("The error occurred.\n");
            sendMessage("Знайдено критичну помилку: " + e);
            e.printStackTrace();
        }
    }
}