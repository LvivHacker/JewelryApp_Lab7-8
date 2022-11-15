package menu.methods.GlobalCommands;

import StonesContent.Necklace;
import menu.Command;

import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Create implements Command{
    @Override
    public void execute(Necklace content, Logger logger) {

        if(Objects.equals(content.getNecklaceName(), "")) {
            Scanner scanner = new Scanner(System.in);

            logger.finer("Вписуємо назву намиста");
            content.setNecklaceName(scanner.nextLine());
        }else {
            logger.finer("Намисто вже існує");
            System.out.println("\nYour necklace is created. Try something else");
        }
    }
}
