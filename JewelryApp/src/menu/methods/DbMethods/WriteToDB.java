package menu.methods.DbMethods;

import StonesContent.Necklace;
import WorkDB.DBOper;
import menu.Command;

import java.util.logging.Logger;

public class WriteToDB implements Command {

    @Override
    public void execute(Necklace content, Logger logger) throws Exception {
        DBOper.writeToDB(content, logger);
    }
}
