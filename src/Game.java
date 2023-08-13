import model.*;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game!");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println(player.getName() + ", welcome to this dark and wicked island!" +
                "All the things that happened here is real! ");
        System.out.println();

        player.selectChar();

        Location location = null;
        while (true) {
            System.out.println("\n^^^^^^^^^^^^^^^^^^^Locations^^^^^^^^^^^^^^^^^^^^\n");
            System.out.println("\n 1 - Safe House --> This plase is a safe place for you (There is no enemy in here!)." +
                    "\n 2 - Store --> This plase is a  place to buy armor and wapon." +
                    "\n Please choose a place to go : ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(location.onLocation()) {
                System.out.println("Game Over!");
                break;
            }


        }

    }
}
