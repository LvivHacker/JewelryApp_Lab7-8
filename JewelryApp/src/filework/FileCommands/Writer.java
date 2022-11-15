package filework.FileCommands;

import StonesContent.Necklace;
import filework.*;
import menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class Writer implements Command{
    @Override
    public void execute(Necklace content, Logger logger) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведіть ім'я файлу: ");
        String destination = scanner.nextLine();
        new WorkFile().FileWiter(destination,content, logger);
    }
}
