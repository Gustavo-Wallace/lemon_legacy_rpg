package com.lemon_legacy;

import com.lemon_legacy.core.Game;
import com.lemon_legacy.core.Menus;
import com.lemon_legacy.core.TerminalUtils;
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
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Loading your saved games...");
                        break;
                    case 3:
                        Game.exit();
                        break;
                    default:
                        TerminalUtils.invalid_code();
                        break;
                }
            
            } catch (InputMismatchException e) {
                TerminalUtils.invalid_code();
            }

            TerminalUtils.pause(sc);

        }

        sc.close();
    }

}
