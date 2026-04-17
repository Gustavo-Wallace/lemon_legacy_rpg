package com.lemon_legacy.models;

public class Player {

    private String name;
    private static int role;
    private static int hpMax;
    private static int hp;
    private static int defense;
    private static int strength;
    private static int agility;
    private static int magic;

    public Player(String name, int role){
        this.name = name;
        this.role = role;
    }

    public void takeDamage(int value) {
        int finalDamage = value - defense;

        if (finalDamage < 0) {
            finalDamage = 0;
        }

        hp -= finalDamage;
    }

    public void heal(int value) {
        hp += value;

        if (hp > hpMax) {
            hp = hpMax;
        }
    }

    public void showStats() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.print("Class: ");
        System.out.println((role == 1) ? "Warrior" : (role == 2) ? "Mage" : "Rogue");
        System.out.println();
        System.out.println("== Defensive stats ==");
        System.out.println("Max HP: " + hpMax);
        System.out.println("Current HP: " + hp);
        System.out.println("Defense: " + defense);
        System.out.println();
        System.out.println("== Ofensive stats ==");
        System.out.println("Strength: " + strength);
        System.out.println("Agility: "+ agility);
        System.out.println("Magic: " + magic);
    }
    
}
