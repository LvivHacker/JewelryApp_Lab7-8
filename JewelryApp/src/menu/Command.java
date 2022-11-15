package menu;

import StonesContent.Necklace;

import java.util.logging.Logger;

public interface Command {
    void execute(Necklace content, Logger logger) throws Exception;
}