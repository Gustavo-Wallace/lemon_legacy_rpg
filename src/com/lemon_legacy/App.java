package com.lemon_legacy;

import com.lemon_legacy.core.game;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        game.main_menu();

        int choice = sc.nextInt();

        //while (choice < 1 || choice > 3) {

            //int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    game.exit();
                default:
                    game.invalid_code();
            }

        //}

        game.clear_screen();

        sc.close();

    }

}
