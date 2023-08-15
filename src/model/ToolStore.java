package model;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("^^^^^^^^Wellcome to our store.^^^^^^^^");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Weapons");
            System.out.println("2-Armors");
            System.out.println("3-Exit");
            System.out.print("Your choose : ");
            int selectCase = Location.scanner.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("You entered an invalid value");
                selectCase = scanner.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleeriz !");
                    showMenu = false;
                    break;
            }
            return true;
        }
    }

    public void printWeapon() {
// purchasing weapon codes.
        System.out.println("^^^^^^^^Weapons^^^^^^^^");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + "-" + weapon.getName() + " , Price :" + weapon.getPrice() +
                    " Damage : " + weapon.getDamage());

        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.println("Choose a weapon : ");
        int selectWeapon = scanner.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("You entered an invalid value");
            selectWeapon = scanner.nextInt();
        }
        if (selectWeapon != 0) {
            Weapon weapon = Weapon.getWeaponByID(selectWeapon);
            if (weapon != null) {
                if (weapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Don't enough money!");
                } else {
                    System.out.println(weapon.getName() + "is bought !");
                    int balance = this.getPlayer().getMoney() - weapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println(this.getPlayer().getMoney() + "left from your money !");
                    System.out.println("Previous weapon : " + this.getPlayer().getInventory().getWeapon());
                    this.getPlayer().getInventory().setWeapon(weapon);
                    System.out.println("Current weapon : " + this.getPlayer().getInventory().getWeapon());

                }

            }
        }
    }

    public void printArmor() {
        System.out.println("^^^^^^^^Armors^^^^^^^^");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + "-" + armor.getName() + " , Price :" + armor.getPrice() +
                    " Block : " + armor.getBlock());

        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {
        System.out.println("Choose an armor : ");
        int selectArmor = scanner.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("You entered an invalid value");
            selectArmor = scanner.nextInt();
        }
        if (selectArmor != 0) {
            Armor armor = Armor.getArmorByID(selectArmor);
            if (armor != null) {
                if (armor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Don't enough money!");
                } else {
                    System.out.println(armor.getName() + "is bought !");
                    int balance = this.getPlayer().getMoney() - armor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println(this.getPlayer().getMoney() + "left from your money !");
                    System.out.println("Previous weapon : " + this.getPlayer().getInventory().getWeapon());
                    this.getPlayer().getInventory().setArmor(armor);
                    System.out.println("Current weapon : " + this.getPlayer().getInventory().getWeapon());
                    System.out.println("lefted money: " + this.getPlayer().getMoney());
                }

            }

        }


    }
}
