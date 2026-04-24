package com.lemon_legacy.models;

public class Quest {

    private String name;
    private String targetEnemy;
    private int requiredAmount;
    private int currentProgress;
    private int rewardGold;
    private int rewardXp;
    private boolean completed;

    public Quest(String name, String targetEnemy, int requiredAmount, int rewardGold, int rewardXp) {
        this.name = name;
        this.targetEnemy = targetEnemy;
        this.requiredAmount = requiredAmount;
        this.currentProgress = 0;
        this.rewardGold = rewardGold;
        this.rewardXp = rewardXp;
        this.completed = false;
    }

    public void registerKill(String enemyName) {
        if (completed) {
            return;
        }

        if (targetEnemy.equalsIgnoreCase(enemyName)) {
            currentProgress++;
            
            if (currentProgress >= requiredAmount) {
                completed = true;
            }
        }

    }
    
}
