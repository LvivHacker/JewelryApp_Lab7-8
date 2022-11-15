package menu.methods.GlobalCommands;

import StonesContent.Necklace;
import menu.Command;

import java.util.logging.Logger;

public class Total implements Command {
    @Override
    public void execute(Necklace content, Logger logger) {
        logger.info("Знаходимо загальну ціну та вагу каменів у намисті");

        content.setTotalPrice(content.getTotalPrice(content.getStones(), logger));
        content.setTotalWeight(content.getTotalWeight(content.getStones(), logger));
    }
}