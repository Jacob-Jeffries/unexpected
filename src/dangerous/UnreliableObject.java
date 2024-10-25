package dangerous;

import java.util.Random;
import dangerous.Hangover;

public class UnreliableObject {
  private static Random rando = new Random();

  public static String areYouOk() throws Exception {
    // if (rando.nextBoolean()){
    //   throw new Exception("I'm having a bad day.");
    // } else {
    //   return "Yes, I'm OK.";
    // }

    switch(rando.nextInt(4)){
      case 0:
        return "Yes, I'm OK.";
      case 1:
        return "Meh ... I've been better.";
      case 2:
        throw new Hangover("Ooff had one too many.");
      case 3:
        throw new Exception("Having a bad day.");
      default:
        return "This should not happen.";
    }
  }

}
