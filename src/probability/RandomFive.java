package probability;

import java.util.Random;

public class RandomFive {
  public static int random5() {
    Random rand = new Random();
    return rand.nextInt(5);
  }
}
