package model;

public abstract class GameChar {
    private int id;
    private int damage;
    private int health;
    private int price;
    private String name;


    public GameChar(int id, int damage, int health, int price, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.price = price;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

