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
        
        int choice = 1;

        while (choice != 3) {
            TerminalUtils.clear_screen();
            Menus.main_menu();

            try {

                System.out.print("\nChoose an action: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.println("Loading a new game...");
                        TerminalUtils.pause(sc);
                        TerminalUtils.clear_screen();

                        Menus.nameChoose();
                        String name = sc.next();

                        Menus.classChoose();
                        int role = sc.nextInt();

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
                        TerminalUtils.invalid_code();
                        TerminalUtils.pause(sc);
                        break;
                }
            
            } catch (InputMismatchException e) {
                TerminalUtils.invalid_code();
                TerminalUtils.pause(sc);
            }

        }

        sc.close();
    }

}
