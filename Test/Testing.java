import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Testing {
    Player player = new Player("Kelly"){
    };

    @Test
    public void playerNameTest(){
        Assertions.assertEquals("Kelly", player.name);
    }

    @Test
    public void statusCheck(){
        int result = Player.getStamina();
        Assertions.assertEquals(10, result);
        int result2 = Player.getHp();
        Assertions.assertEquals(10, result2);
        int result3 = Player.getSpeed();
        Assertions.assertEquals(10, result3);
        int result4 = Player.getStrength();
        Assertions.assertEquals(10, result4);
    }

    @Test
    public void equipBoardTest(){
        StandardMethods.equipRocket();
        int[] result ={Player.getStamina(),Player.getHp(), Player.getSpeed(), Player.getStrength()};
        Assertions.assertArrayEquals(new int[]{17, 11, 13, 12}, result);
        StandardMethods.equipJavelin();
        int[] result2 ={Player.getStamina(),Player.getHp(), Player.getSpeed(), Player.getStrength()};
        Assertions.assertArrayEquals(new int[]{10, 13, 17, 13}, result2);
        StandardMethods.equipRazor();
        int[] result3 ={Player.getStamina(),Player.getHp(), Player.getSpeed(), Player.getStrength()};
        Assertions.assertArrayEquals(new int[]{13, 12, 11, 17}, result3);
    }

    Scenery scenery = new Scenery("Surf City, Is this really a place?");
    @Test
    public void sceneryTest(){
       String result = scenery.description;
       Assertions.assertEquals("Surf City, Is this really a place?", result);
   }

   @Test
    public void mainStorySurfTest(){
    MainStoryPartTwo.makeWaterStory();
    Assertions.assertTrue(StandardMethods.surf);
   }
}