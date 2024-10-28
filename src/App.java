import java.io.InputStream;
import java.io.ByteArrayInputStream;

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
        // System.out.println("Finally - I always execute.");
       }
    }


    public static void streamBytes(){
      byte[] bitsy = {9,-1,3,4,-22,127,-128};
      InputStream input = null;
      try{
        //Open stream & do things.
      } finally {
        //Close stream
      }
    }
}
