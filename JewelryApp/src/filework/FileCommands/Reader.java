package filework.FileCommands;

import StonesContent.Necklace;
import filework.*;
import menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

import static message.SendEmail.sendMessage;

public class Reader implements Command {
    @Override
    public void execute(Necklace content, Logger logger) throws Exception {
        WorkFile fileRead = new WorkFile();
        Scanner reader = new Scanner(System.in);
        System.out.print("\nВведіть назву файлу-: ");
        String destination = reader.nextLine();

        try {
            content = fileRead.FileReader(destination, logger);
        } catch (Exception e) {
            logger.log(Level.WARNING,"Знайдено критичну помилку: ",e);
            System.out.println("The error occurred.\n");
            sendMessage("Знайдено критичну помилку: " + e);
            e.printStackTrace();
        }
    }
}
