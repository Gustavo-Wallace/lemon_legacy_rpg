package com.lemon_legacy;

import com.lemon_legacy.core.Game;
import com.lemon_legacy.core.Menus;
import com.lemon_legacy.core.TerminalUtils;
import com.lemon_legacy.model.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        int choice = 1;

        while (choice != 3) {
            TerminalUtils.clearScreen();
            Menus.mainMenu();

            try {

                System.out.print("\nChoose an action: ");
                choice = Integer.parseInt(line);

                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.println("Loading a new game...");
                        TerminalUtils.pause(sc);
                        TerminalUtils.clearScreen();

                        Menus.nameChoose();
                        String name = sc.next();

                        Menus.classChoose();
                        int role = 0;

                        do {
                            role = sc.nextInt();
                        } while (role < 1 || role > 3);

                        Player player = new Player(name, role);

                        player.showStats();
                        TerminalUtils.pause(sc);

                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Loading your saved games...");
                        TerminalUtils.pause(sc);
                        break;
                    case 3:
                        Game.exit();
                        break;
                    default:
                        TerminalUtils.invalidCode();
                        TerminalUtils.pause(sc);
                        break;
                }
            
            } catch (InputMismatchException e) {
                TerminalUtils.invalidCode();
                TerminalUtils.pause(sc);
            }

        }

        sc.close();
    }

}
