
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StandardMethods {
    static Scanner scanner = new Scanner(System.in);
    public static boolean isRunning;
    public static boolean surf;

    public static int readInputValidator(String init, int preInput) {
        int input;

        do {
            System.out.println(init);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = 0;
                System.out.println("Please input a valid command");
            }

        } while (input < 1 || input > preInput);
        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

    public static void printWaves(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("~");
        System.out.println();

    }

    public static void pressToContinue() {
        System.out.println("\nEnter something to continue..");
        scanner.next();
    }

    public static void printHeading(String title) {
        printWaves(42);
        System.out.println(title);
        printWaves(42);
    }

    public static void menuLoop() {
        while (isRunning) {
            menuHeadingPrint();
            int input = readInputValidator("->", 5);
            if (input == 1)
                exitMenu();
            else if (input == 2)
                menuCharStatus();
            else if (input == 3) {
                clearConsole();
                System.out.println(MainStoryPartOne.boardCollection);
                pressToContinue();
            } else if (input == 4) {
                menuHelpCommands();
            } else {
                isRunning = false;
            }
        }
    }

    public static void exitMenu() {
        clearConsole();
        if (StandardMethods.surf) {
            MainStoryPartTwo.runGamePartTwo();
        } else
            MainStoryPartOne.runGamePartOne();
    }

    public static void menuCharStatus() {
        clearConsole();
        printHeading(NewGame.player.name + "'s current status");
        System.out.println("\tHP: " + Player.getHp() + "/" + NewGame.player.maxHP + "      |   Strength: " + Player.getStrength() +
                "/" + NewGame.player.maxStr + "\n\tStamina: " + Player.getStamina() + "/" + NewGame.player.maxStam
                + " |   Speed: " + Player.getSpeed() + "/" + NewGame.player.maxSpe);
        printWaves(42);
        pressToContinue();
    }

    public static void menuHeadingPrint() {
        clearConsole();
        if (StandardMethods.surf) {
            printHeading(MainStoryPartTwo.parts[MainStoryPartTwo.part]);
        } else {
            printHeading(MainStoryPartOne.places[MainStoryPartOne.place]);
        }
        menuPrinting();
    }

    private static void menuPrinting() {
        System.out.println("What do you want to do?");
        printWaves(42);
        System.out.println("(1) Continue to surf");
        System.out.println("(2) Check your status");
        System.out.println("(3) Check your boardcollection");
        System.out.println("(4) Help");
        System.out.println("(5) End session");
    }

    public static void menuHelpCommands() {
        clearConsole();
        printWaves(10);
        System.out.println("MOVE COMMANDS:\n'next' = move forward\n'pre' = move back\n'paddle' = paddle further out");
        printWaves(10);
        System.out.println("IN-ACTION COMMANDS:\n'catch' = catch wave\n'turn' = make a turn\n'duck' = duckdive through wave");
        printWaves(10);
        System.out.println("EQUIP BOARDS:\n'rocket' = equip the Rocket\n'razor' = equip the Razor\n'javelin' = equip the Javelin");
        printWaves(10);
        pressToContinue();
    }

    public static void equipRocket() {
        Player.setStamina(17);
        Player.setHp(11);
        Player.setStrength(12);
        Player.setSpeed(13);
    }

    public static void equipJavelin() {
        Player.setStamina(10);
        Player.setHp(13);
        Player.setStrength(13);
        Player.setSpeed(17);

    }

    public static void equipRazor() {
        Player.setStamina(13);
        Player.setHp(12);
        Player.setStrength(17);
        Player.setSpeed(11);
    }

    public static void smallWaveList() {
        Item smallWave1 = new Item("Small wave", "There's a small wave coming towards you, nothing to do but to avoid being slapped in the face.");
        Item smallWave2 = new Item("Small wave", "There's a small wave coming towards you, is it surfable? well maybe there's somethin sweet building up.");
        Item smallWave3 = new Item("Small wave", "There's a small wave coming towards you, it's powerful but small and might crash right upon you!");
        suppliesRandomWave(smallWave1, smallWave2, smallWave3);
    }

    public static void mediumWaveList() {
        Item mediumWave1 = new Item("Medium wave", "There's a medium wave coming towards you, it's powerful and might allow you to take some pretty sweet turns.");
        Item mediumWave2 = new Item("Medium wave", "There's a medium wave coming towards you, with the right technique you will have a good time surfing this one.");
        Item mediumWave3 = new Item("Medium wave", "There's a medium wave coming towards you, this one gonna take you for a ride if you manage to catch it!");
        suppliesRandomWave(mediumWave1, mediumWave2, mediumWave3);
    }

    public static void bigWaveList() {
        Item bigWave1 = new Item("Big wave", "This is what you've been waiting for, finally some great surf's coming up!");
        Item bigWave2 = new Item("Big wave", "Woohaa, even the air feel different when this monster approach you! Time to take action and keep your mind together!");
        Item bigWave3 = new Item("Big wave", "Holy Margret! If your not ready then paddle for life! If this one crashes down you wont be able to surf more today!");
        suppliesRandomWave(bigWave1, bigWave2, bigWave3);
    }

    private static void suppliesRandomWave(Item bigWave1, Item bigWave2, Item bigWave3) {
        List<Item> bigWave = Arrays.asList(bigWave1, bigWave2, bigWave3);
        Supplier<String> supplier = () -> {
            Random rnd = new Random();
            return String.valueOf(bigWave.get(rnd.nextInt(bigWave.size())));
        };
        Consumer<String> consumer = System.out::println;
        consumer.accept(supplier.get());
    }
}
