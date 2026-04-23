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

}
