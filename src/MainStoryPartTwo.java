
public class MainStoryPartTwo {
    static Scenery[] waterMap;
    static int part = 0;

    public static String[] parts = {"Beach Break", "Small Break", "Point Break", "Far far out"};


    public static void makeWaterStory(){
        Scenery beachBreak = new Scenery("You are on your bord leveled with the ocean. The water is warm and comfy but the fist waves that approach you\n" +
            "feels scary and breaks heavily on to the beach. Hope I dont get hit by one of those!");
    Scenery smallBreak = new Scenery("""
                When you look behind you can see the beach stretching out, it's a  beautiful sight from far out the water.\s
                Hopefully you can get some pretty awesome waves as well. This is not where the really big waves surprise you from behind and you
                feel quite safe after all. Maybe theres sharks in the water though??!\s""");
    Scenery pointBreak = new Scenery("This is where the action happens! all types of waves coming here and breaks in towards the beach. \n" +
            "it's the perfect place to sit and wait for your opportunity to catch the wave of your life.");
    Scenery farFarOut = new Scenery("Ohh.. this is way to far out to get the chance to surf. Try paddle towards the beach to get closer to the break.");

    waterMap = new Scenery[]{beachBreak, smallBreak, pointBreak, farFarOut};


    StandardMethods.surf=true;

    }
    public static void runGamePartTwo(){

        while (StandardMethods.isRunning){

            if(part > waterMap.length-1){
                System.out.println("The beach seems VERY far away. Suddenly you felt something touching your leg and a stinging pain goes trough your body?! \n" +
                        "Not staying here to find out what bit you!!");
                StandardMethods.pressToContinue();
                Player.hp--;
                part--;

            }else if(part==0){//random small wave
                StandardMethods.clearConsole();
                System.out.println(waterMap[part].toString());
                StandardMethods.printWaves(10);
                StandardMethods.smallWaveList();
                StandardMethods.printWaves(10);
                System.out.println("\n\nType 'paddle' to move on.\nType 'menu' to see the menu.");
            }

            else if(part==1){//random medium wave
                StandardMethods.clearConsole();
                System.out.println(waterMap[part].toString());
                StandardMethods.printWaves(10);
                StandardMethods.mediumWaveList();
                StandardMethods.printWaves(10);
                System.out.println("\n\nType 'paddle' to move on.\nType 'menu' to see the menu.");
            }
            else if(part==2){//random big wave
                StandardMethods.clearConsole();
                System.out.println(waterMap[part].toString());
                StandardMethods.printWaves(10);
                StandardMethods.bigWaveList();
                StandardMethods.printWaves(10);
                System.out.println("\n\nType 'paddle' to move on.\nType 'menu' to see the menu.");
            }

            else {
                System.out.println(waterMap[part].toString() + "\n\nType 'paddle' to move on.\nType 'menu' to see the menu.");
            }

            String command = StandardMethods.scanner.next();
            if (command.equalsIgnoreCase("menu")) {
                StandardMethods.menuLoop();
            }
            else if(command.equalsIgnoreCase("paddle")){
                StandardMethods.clearConsole();
                part++;
            }
            else if(command.equalsIgnoreCase("catch")){
                OnTheWave.makeAWave();
                OnTheWave.onWave();
            }
            else {
                System.out.println("Try another command");
                StandardMethods.pressToContinue();
            }
            if(Player.hp==0){
                StandardMethods.isRunning=false;
                System.out.println("Game over, try again!");
            }

        }
    }
}
