package com.lemon_legacy.models;

public class Player {

    private String name;
    private int level = 1;
    private int xp = 0;
    private int xpToLevel = 40;

    private int maxHealth = 100;
    private int Health = 1000;

    private int maxMana = 40;
    private int mana = 40;

    private int atack = 12;
    private int defense = 3;
    private int gold = 30;

    private int x = 0;
    private int y = 0;

    public Player(String name) {
        this.name = name;
    }



    
}
