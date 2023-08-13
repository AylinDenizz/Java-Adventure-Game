package model;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("^^^^^^^^Wellcome to our store.^^^^^^^^");
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
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleeriz !");

                return true;
        }
        return true;
    }

    public void printWeapon() {
// purchasing weapon codes.
        System.out.println("^^^^^^^^Weapons^^^^^^^^");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + "-" +weapon.getName() + " , Para :" + weapon.getPrice() +
                    " Hasar : " + weapon.getDamage());

        }
        System.out.println("Choose a weapon : ");
        int selectWeapon = scanner.nextInt();
        while (selectWeapon< 1 || selectWeapon > Weapon.weapons().length) {
            System.out.println("You entered an invalid value");
            selectWeapon =scanner.nextInt();
        }
        Weapon weapon= Weapon.getWeaponObyByID(selectWeapon);
        if (weapon != null) {
            if(weapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Don't enough money!");
            }else {
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

    public void printArmor() {
        System.out.println("Armors");
    }


}
