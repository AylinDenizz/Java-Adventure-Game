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

        System.out.println("^^^^^^^^Weapons^^^^^^^^");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getName() + " , Para :" + weapon.getPrice() + " Hasar : " + weapon.getDamage());

        }
    }

    public void printArmor() {
        System.out.println("Armors");
    }


}
