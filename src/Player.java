
public class Player  {


    static int stamina;
 static int hp;
 static int strength;
 static int speed;
        int maxStam;
        int maxHP;
        int maxStr;
        int maxSpe;

    public Player(String name){
        this.name = name;
        stamina = 10;
        hp = 10;
        strength = 10;
        speed = 10;
        maxStam = 20;
        maxHP = 20;
        maxStr = 20;
        maxSpe = 20;

    }

    public String name;

    public static void setStamina(int stamina) {
        Player.stamina = stamina;
    }

    public static void setHp(int hp) {
        Player.hp = hp;
    }

    public static void setStrength(int strength) {
        Player.strength = strength;
    }

    public static void setSpeed(int speed) {
        Player.speed = speed;
    }

    public static int getStamina() {
        return stamina;
    }

    public static int getHp() {
        return hp;
    }

    public static int getStrength() {
        return strength;
    }

    public static int getSpeed() {
        return speed;
    }
}
