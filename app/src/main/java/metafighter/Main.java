Here's a simple console-based fighting game in Java featuring superheroes:
import java.util.Scanner;

class Superhero {
    String name;
    int health;
    int attack;

    Superhero(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    void attack(Superhero opponent) {
        opponent.health -= this.attack;
        System.out.println(this.name + " attacks " + opponent.name + " for " + this.attack + " damage!");
    }
}

public class SuperheroFightingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Superhero ironMan = new Superhero("Iron Man", 100, 20);
        Superhero captainAmerica = new Superhero("Captain America", 120, 15);
        Superhero spiderMan = new Superhero("Spider-Man", 90, 25);

        System.out.println("Choose your superhero:");
        System.out.println("1. Iron Man");
        System.out.println("2. Captain America");
        System.out.println("3. Spider-Man");

        int choice = scanner.nextInt();
        Superhero player;

        switch (choice) {
            case 1:
                player = ironMan;
                break;
            case 2:
                player = captainAmerica;
                break;
            case 3:
                player = spiderMan;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Iron Man.");
                player = ironMan;
        }

        Superhero opponent = spiderMan; // Default opponent

        if (player == spiderMan) {
            opponent = ironMan; // Change opponent if player is Spider-Man
        }

        System.out.println("You chose " + player.name + "!");
        System.out.println("Your opponent is " + opponent.name + "!");

        while (player.health > 0 && opponent.health > 0) {
            System.out.println(player.name + "'s health: " + player.health);
            System.out.println(opponent.name + "'s health: " + opponent.health);

            System.out.println("1. Attack");
            System.out.println("2. Run");

            choice = scanner.nextInt();

            if (choice == 1) {
                player.attack(opponent);

                if (opponent.health > 0) {
                    opponent.attack(player);
                }
            } else if (choice == 2) {
                System.out.println(player.name + " runs away!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        if (player.health <= 0) {
            System.out.println(player.name + " has been defeated! " + opponent.name + " wins!");
        } else if (opponent.health <= 0) {
            System.out.println(opponent.name + " has been defeated! " + player.name + " wins!");
        }
    }
}
This game allows you to choose a superhero and fight against another superhero. You can attack or run away. The game continues until one superhero's health reaches zero.

Note that this is a simple console-based game and can be expanded upon to include more features, superheroes, and game modes.
