package model;

import java.util.Scanner;

public class Player {
    private int id;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    Scanner input = new Scanner(System.in);

    public void selectChar() {
        Scanner input = new Scanner(System.in);

        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charlist = {new Samurai(), new Knight(), new Archer(), new Test()};

        for(GameChar gameChar : charlist) {
            System.out.println("--------------------------------------------");

            System.out.println("id: "+ gameChar.getId() +
                    "\t\tCharacter: " + gameChar.getName() +
                    "\t\t Damage: " + gameChar.getDamage() +
                    "\t\t Health" + gameChar.getHealth() +
                    "\t\t Price: " + gameChar.getMoney());
        }
        System.out.println("--------------------------------------------");
        System.out.println("Please choose a character to fight");
        int selectedChar = input.nextInt();
        switch (selectedChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("id: "+ this.id +
                "\t\tCharacter: " + this.name  +
                "\t\t Damage: " + this.damage  +
                "\t\t Health" + this.health  +
                "\t\t Price: " + this.money);

        System.out.println(this.toString());

    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setName(gameChar.getName());
        this.setMoney(gameChar.getMoney());
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", damage=" + damage +
                ", health=" + health +
                ", money=" + money +
                ", name='" + name + '\'' +
                ", charName='" + charName + '\'' +
                ", inventory=" + inventory +
                ", input=" + input +
                '}';
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
