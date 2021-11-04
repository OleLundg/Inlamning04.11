public class NewGame {
    static Player player;

    public static void introTitle() {

        StandardMethods.clearConsole();
        StandardMethods.printWaves(37);
        StandardMethods.printWaves(37);
        System.out.println("~~~~~~~~~~~~SURF'S UP TXT~~~~~~~~~~~~");
        System.out.println("a surfers path through heavenly waves");
        StandardMethods.printWaves(37);
        StandardMethods.printWaves(37);
        StandardMethods.pressToContinue();
    }
        public static void newName(){

            boolean setName = false;
            String name;
            do {
            StandardMethods.clearConsole();
            StandardMethods.printHeading("What do you wish your surfer to be called?");
            name = StandardMethods.scanner.next();
            StandardMethods.clearConsole();
            StandardMethods.printHeading("Your name is now: " + name + ".\nAre you happy with your new name?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, i'd like to change the name");
            int input = StandardMethods.readInputValidator("-> ", 2);
            if (input == 1) setName = true;

        } while (!setName);


        player = new Player(name) {
        };
        }
}

