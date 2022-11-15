package menu.methods.GlobalCommands;

import StonesContent.Necklace;
import StonesContent.Stonetypes.Stone;
import menu.Command;

import java.util.logging.Logger;

public class Info implements Command {
    @Override
    public void execute(Necklace content, Logger logger) {
        logger.info("Виводимо назву намиста ");
        System.out.print("\nНазву намиста-: ");
        System.out.println(content.getNecklaceName());
        Stone.listOfStones(content.getStones(), logger);
    }
}
