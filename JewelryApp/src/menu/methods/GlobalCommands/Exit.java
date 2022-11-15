package menu.methods.GlobalCommands;

import StonesContent.Necklace;
import menu.Command;

import java.util.logging.Logger;

public class Exit implements Command{
    @Override
    public void execute(Necklace content, Logger logger) throws Exception {
        logger.finest("Завершуємо програму ");

        System.out.println("До зустрічі! ;)");
        System.exit(0);
    }
}
