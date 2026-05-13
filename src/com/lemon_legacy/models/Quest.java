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

    public static void showCurrentQuest(Player player) {
        Quest quest = player.getCurrentQuest();

        if (quest == null) {
            System.out.println("You do not have an active quest.");
            return;
        }

        System.out.println("===== Current Quest =====");
        System.out.println("Name: " + quest.name);
        System.out.println("Objective: Defeat " + quest.getRequiredAmount() + " " + quest.getTargetEnemy());
        System.out.println("Progress: " + quest.getCurrentAmount() + "/" + quest.getRequiredAmount());
        System.out.println("Reward: " + quest.getGoldReward() + " gold and " + quest.getXpReward() + " XP");
        System.out.println("Completed: " + quest.isCompleted());
    }
    

}