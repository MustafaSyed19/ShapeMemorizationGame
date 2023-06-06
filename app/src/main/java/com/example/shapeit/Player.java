package com.example.shapeit;

public class Player {
    private String Name;
    private int level;
    private int lives;
    public Player(String playerName)
    {
        this.Name=playerName;
        level=1;
        lives=3;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}


