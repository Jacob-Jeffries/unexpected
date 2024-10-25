import dangerous.Hangover;
import dangerous.UnreliableObject;

public class App {
    public static void main(String[] args) throws Exception {
      for(int i=0; i< 10; ++i){
        printOutObjectStatus();
      }
    }

    public static void printOutObjectStatus() throws Exception {
      try{
        System.out.println(UnreliableObject.areYouOk());
      } catch (Hangover e) {
        System.out.println(e.getMessage() + " Go to rehab.");
      } catch(Exception e) {
        String message = e.getMessage();
        System.err.println(message);
       } finally {
        System.out.println("I always execute.");
       }
    }
}
