package menu.methods.SortCommands;

import StonesContent.Necklace;
import StonesContent.Stonetypes.Stone;
import menu.Command;

import java.util.logging.Logger;

public class Filt implements Command{
    @Override
    public void execute(Necklace content, Logger logger) {
        Stone.filterStones(content.getStones(), logger);
    }
}


