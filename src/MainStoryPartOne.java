
import java.util.ArrayList;
import java.util.List;

public class MainStoryPartOne {

    public static int place = 0;
    public static String[] places = {"Car Park", "Yellow Surfbus", "Beach"};


    static Scenery[] map;
    static int location;
    public static void setLocation(int location) {
        MainStoryPartOne.location = location;
    }

    static List<Item> boardCollection = new ArrayList<>();


    public static void makeLandStory() {
        Scenery carPark = new Scenery("You just arrived at the carpark right beside you local surfbeach.\n" +
                "The sun is blazing and you feel the heat burning through the windshield of your car.\n" +
                "Theres plenty of people around getting their surfgear ready for yet another day amongst the waves.\n" +
                "Some of them you know and they give you a greeting nod as you pass by. Hey " + NewGame.player.name + "!" +
                " someone calls out.\n" + "This really feels like home.");
        Scenery yellowBus = new Scenery("""
                You are now standing behind your yellow surf bus. Your surfgear is perfectly lined up on the ground beside
                each other ready to be surfed. You hear the sound of waves crashing on to the beach which puts both excitement and a\s
                touch of fear into your bones.""");
        Scenery beach = new Scenery("""
                Finally at the beach! You feel the cooling winds against your face the hot sand underyour feet. You are almost unable to to stand still cuz of the burning sensation. Its clearly time to head into the water
                to get this surfing ongoing. You zig zag through the crowd with your board under your arm and your leach attached to your ankle.
                Its an amazing feeling and soon you'll be ready for your first surfsession.""");


        map = new Scenery[]{carPark, yellowBus, beach};


        Item Javelin = new Item("JAVELIN:", "This surfboard is 7'6 long with loads of speed for the bigger faster waves\n");
        Item Razor = new Item("RAZOR:", "This surfboard is 6'4 long, built for medium waves, easy to catch waves and great stability\n");
        Item Rocket = new Item("ROCKET:", "This surfboard is 5'11 long for the medium to small waves, quick to turn with great performances");


        boardCollection.add(Javelin);
        boardCollection.add(Razor);
        boardCollection.add(Rocket);


        StandardMethods.isRunning = true;
        StandardMethods.clearConsole();
        StandardMethods.surf = false;
    }

    public static void runGamePartOne() {

        while (StandardMethods.isRunning) {
            if(location == map.length-1){
                System.out.println(map[location].toString()+"\n\nDont forget to equip your board, check help in menu.\nType 'surf' to go into water." +
                        "\nType 'menu' to see the menu.");
            }

            else {
                System.out.println(map[location].toString() + "\n\nType 'next' to move on.\nType 'menu' to see the menu.");
            }
            String command = StandardMethods.scanner.next();

            if (command.equalsIgnoreCase("next")) {
                StandardMethods.clearConsole();
                location++;
                place++;
                if (location == map.length){
                    System.out.println("You cant type 'next' to go in to the water, try type 'surf' to enter surf mode");
                    location--;
                    place--;
                    StandardMethods.pressToContinue();
                    StandardMethods.clearConsole();
                }
            }
            else if (location == map.length-1 && command.equalsIgnoreCase("surf")) {
                       MainStoryPartTwo.makeWaterStory();
                       MainStoryPartTwo.runGamePartTwo();
            }
            else if (command.equalsIgnoreCase("pre")) {
                StandardMethods.clearConsole();
                location--;
                place--;
                if (location < 0) {
                    System.out.println("Wait! WHAT!? Where am I? This place feels weird!");
                    StandardMethods.pressToContinue();
                    setLocation(0);
                    place=0;
                    StandardMethods.clearConsole();
                }
            } else if (command.equalsIgnoreCase("menu")) {
                StandardMethods.menuLoop();
            }
            else if(command.equalsIgnoreCase("rocket")){
                StandardMethods.equipRocket();
                StandardMethods.clearConsole();
                System.out.println("You've equipped the Rocket! It will greatly improve your stamina. Go check your stats");
                StandardMethods.pressToContinue();

            }
            else if(command.equalsIgnoreCase("javelin")){
                StandardMethods.equipJavelin();
                StandardMethods.clearConsole();
                System.out.println("You've equipped the Javelin! It will greatly improve your speed. Go check your stats");
                StandardMethods.pressToContinue();

            }

            else if(command.equalsIgnoreCase("razor")){
                StandardMethods.equipRazor();
                StandardMethods.clearConsole();
                System.out.println("You've equipped the Razor! It will greatly improve your strength. Go check your stats");
                StandardMethods.pressToContinue();

            }
            else {
                System.out.println("try another command");
                StandardMethods.pressToContinue();
            }

        }
    }
}