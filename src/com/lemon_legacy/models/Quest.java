package com.lemon_legacy.models;

public class Quest {

    private String name;
    private String targetEnemy;
    private int requiredAmount;
    private int currentAmount;
    private int goldReward;
    private int xpReward;
    private boolean completed;

    public Quest(String name, String targetEnemy, int requiredAmount, int goldReward, int xpReward) {
        this.name = name;
        this.targetEnemy = targetEnemy;
        this.requiredAmount = requiredAmount;
        this.goldReward = goldReward;
        this.xpReward = xpReward;
        this.currentAmount = 0;
        this.completed = false;
    }

    public void registerKill(String enemyName) {
        if (completed) {
            return;
        }

        if (enemyName.equalsIgnoreCase(targetEnemy)) {
            currentAmount++;

            System.out.println("Quest progress: " + name + " (" + currentAmount + "/" + requiredAmount + ")");

            if (currentAmount >= requiredAmount) {
                completed = true;
                System.out.println("Quest completed: " + name + "!");
            }
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getName() {
        return name;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public int getXpReward() {
        return xpReward;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }

    public String getTargetEnemy() {
        return targetEnemy;
    }

    public void showDetails() {
        System.out.println("===== Current Quest =====");
        System.out.println("Name: " + name);
        System.out.println("Objective: Defeat " + requiredAmount + " " + targetEnemy);
        System.out.println("Progress: " + currentAmount + "/" + requiredAmount);
        System.out.println("Reward: " + goldReward + " gold and " + xpReward + " XP");
        System.out.println("Completed: " + completed);
    }
    
}