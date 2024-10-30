import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;

import dangerous.Hangover;
import dangerous.UnreliableObject;

public class App {
    public static void main(String[] args) throws Exception {
      // for(int i=0; i< 10; ++i){
      //   printOutObjectStatus();
      // }
      streamBytes();
      System.out.print("There are ");
      System.out.print(ocurrencesOf("README.md", 'e'));
      System.out.println(" occurances of 'e' in the file.");
      fileCopy("README.md", "README_copy.md");
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


    public static void streamBytes() throws IOException {
      byte[] bitsy = {9,-1,3,4,-22,127,-128};
      InputStream input = null;
      try{
        //Open stream & do things.
        input = new ByteArrayInputStream(bitsy);
        int nextbyte;
        while ((nextbyte = input.read()) != -1){
          System.out.println((byte)nextbyte);
        }
      } finally {
        //Close stream
        if(input != null) {
          input.close();
        }
      }
    }

    public static int ocurrencesOf(String fileName, char letter) throws IOException {
      Reader input = null; // The input variable needs to be declared outside the try catch so its visible.
      try {
        //Open File
        input = new FileReader(fileName);
        int count = 0;
        int nextChar;
        while((nextChar = input.read()) != -1){ // While the value is not equal to 32 bits of '1'.
          if ((char)nextChar == 'e'){ // Type cast the variable to the usable value.
            ++count;
          }
        }
        return count;
      } finally {
        //Close File
        if (input != null){
          input.close(); // Close stream
        }
      }
    }

    public static void fileCopy(String filename, String newName) throws IOException {
      // To faithfully copy, just copy the bits.
      InputStream input = null;
      OutputStream output = null;
      try{
        input = new FileInputStream(filename);
        output = new FileOutputStream(newName);
        int nextByte;
        while((nextByte = input.read()) != -1){
          output.write((byte)nextByte);
        }

      } finally {
        if ( input != null){
          input.close();
        }
        if ( output != null ){
          output.close();
        }
      }

    }
}
