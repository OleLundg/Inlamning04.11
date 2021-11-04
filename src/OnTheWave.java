public class OnTheWave {
    static Scenery wave;
    public static void makeAWave() {

        wave = new Scenery("""
                The wave is building up behind you. Getting bigger and scarier\s
                and you feel how it pushes you up and releasing its power. You stand up on your board and feel the speed increasing.
                Whats your next move?""");

    }
    
    public static void onWave(){
        StandardMethods.clearConsole();
        System.out.println(wave.toString() + "\n\nType 'turn' to make a turn.\nType 'duck' to skip wave.");
        String command = StandardMethods.scanner.next();

        if(command.equalsIgnoreCase("turn")){
            StandardMethods.clearConsole();
            System.out.println("You made a perfect turn, feeling the speed and power of your board.");
            Player.strength--;
            StandardMethods.pressToContinue();
            if(Player.strength<10){
                StandardMethods.clearConsole();
                System.out.println("You feel pain in your legs. You are simply too tired to make a turn and falls off\n" +
                        "the wave.");
                StandardMethods.pressToContinue();
                Player.hp--;

            }
        }

        else if(command.equalsIgnoreCase("duck")){
            StandardMethods.clearConsole();
            System.out.println("You get off the wave and feel your strength returning");
            Player.strength++;
            StandardMethods.pressToContinue();
            MainStoryPartTwo.runGamePartTwo();
        }
    }
}
