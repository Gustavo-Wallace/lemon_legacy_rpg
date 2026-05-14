package com.lemon_legacy.models;

public class Item {

    private String name;
    private String type;
    private int value;
    private int heal;
    private int mana;
    private int bonusAttack;
    private int bonusHealth;
    private int bonusDefense;

    public Item(String name, String type, int value, int heal, int mana, int bonusAttack, int bonusHealth, int bonusDefense) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.heal = heal;
        this.mana = mana;
        this.bonusAttack = bonusAttack;
        this.bonusHealth = bonusHealth;
        this.bonusDefense = bonusDefense;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getHeal() {
        return heal;
    }

    public int getMana() {
        return mana;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public void showDetails() {
        System.out.println(name + " (" + type + ")");

        if (heal > 0) {
            System.out.println(" | Heal: " + heal);
        }

        if (mana > 0) {
            System.out.println(" | Mana: " + mana);
        }

        if (bonusAttack > 0) {
            System.out.println(" | Attack: +" + bonusAttack);
        }

        if (bonusDefense > 0) {
            System.out.println(" | Defense: +" + bonusDefense);
        }

        if (bonusHealth > 0) {
            System.out.println(" | Health: +" + bonusHealth);
        }
    }

}
