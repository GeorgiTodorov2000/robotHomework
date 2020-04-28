import java.util.Scanner;
import java.util.Random;

public class robotHomework {
    private static int hitCount = 0;
    public static void main(String[] args) {
        navigation();
        isRobotReady();
        speech();
    }
    public static void navigation() {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is in front of the robot");

        String object = scan.nextLine();

        String wall = "wall";
        String chair = "chair";

        if (object.equals(wall)) {
            System.out.println("Robot go sideways");
        } else if (object.equals(chair)) {
            System.out.println("Robot jump");
        } else {
            System.out.println("Robot move forward");
        }
    }
    public static void energy() {
        Random numb = new Random();
        int powerChargerMin = numb.nextInt(1000);
        int powerChargerMax = numb.nextInt(1000);

        System.out.println("Robot doesn't have power. He will try to charge");

        while (powerChargerMin == powerChargerMax) {
            System.out.println("Recheck the charger");
            powerChargerMin = numb.nextInt(1000);
            powerChargerMax = numb.nextInt(1000);
        }

            if (powerChargerMin > powerChargerMax) {
                hitCount = 0;
                System.out.println("Robot is fully charged");
            } else if (powerChargerMin < powerChargerMax) {
                System.out.println("Robot can't recharge here, no power. Robot try to charge on different place");
            }

    }
    public static void isRobotReady() {
        Scanner scan = new Scanner(System.in);
        Random numb = new Random();
        System.out.println("How many moves we have");
        int totalMoves = scan.nextInt();
        hitCount = 0;
        System.out.println("What does the robot see in pixels");
        for (int i = 0; i < totalMoves; i++) {
            int hitPower  = numb.nextInt(10);
            int hitMouse = numb.nextInt(2);
            int objectPixels = scan.nextInt();

            if (hitCount < 4) {
                if (objectPixels % 2 == 0) {

                    hitCount++;
                        System.out.println("Mouse found, preparing for attack");
                        System.out.println("Robot tries to hit the damn mouse");

                        if (hitMouse == 1) {
                            if (hitPower < 5) {
                                System.out.println("Mouse was killed, no damage on furniture");
                            } else {
                                System.out.println("Mouse was killed so was your furniture");
                            }

                        } else {
                            if (hitPower < 5) {
                                System.out.println("Mouse wasn't killed, no damage on the furniture");
                            } else {
                                System.out.println("Mouse wasn't killed, but your furniture on the other hand...");
                            }
                        }
                     if(hitCount > 4) {
                         energy();
                     }
                } else {
                    System.out.println("mouse was not found, keep searching");
                    navigation();
                }
            } else {
                energy();
            }
        }
    }
    public static void speech() {
        int numbers = 10;
        for (int i = 0; i <= 10; i++) {
            System.out.println(numbers);
            if (numbers % 2 == 0) {
                System.out.println("I am a Robottttt " + i);
            } else if (numbers == 1) {
                break;
            }
            numbers--;
        }
    }
}
