package com.lemon_legacy.model;

public class Player {

    public String name;
    public int role;
    public int hpMax;
    public int hp;
    public int defense;
    public int strengh;
    public int agility;
    public int magic;

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
    
}
