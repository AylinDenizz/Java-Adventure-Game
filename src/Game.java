import model.Player;
import model.Samurai;

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

        player.selectChar();

    }
}
