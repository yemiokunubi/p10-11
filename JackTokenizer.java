import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JackTokenizer{
  static ArrayList<String> firstpassfileInput = new ArrayList<String>();
  static ArrayList<String> secondpassList = new ArrayList<String>();

  public static void firstPass(String path) throws FileNotFoundException{
    File file = new File(path);
    Scanner sc = new Scanner(file);
    
    int count = 0;
    while(sc.hasNextLine()){
      
      String line = sc.nextLine();
      String trimmed = line.trim();
      String firstElement = trimmed.split("")[0];
      if(firstElement.equals("") | firstElement.equals("/")){ //take out values that are not comments or whitespace
        
      }
      else{
        String trimming = line.trim();
        // String newVal = trimming.split(" ")[0]; //get every token value
        String newVal[] = trimming.split(" "); //split the line and get every value/word
        // System.out.println(newVal);
        int arraylength = newVal.length;
		    int i = 0;
        while(i<arraylength){
          String separateTok = newVal[i];
          firstpassfileInput.add(separateTok.trim());
          // if(separateTok.contains("()")){
            // separateTok = trimming.split("[\\()]")[0];
            // firstpassfileInput.add(separateTok.trim());
            // firstpassfileInput.add("(");
            // firstpassfileInput.add(")");
          // }
          // else{
          //   firstpassfileInput.add(separateTok.trim());
          // }
          // System.out.println(newVal[i]);
          
          
          i++;
        }
        
        // fileInput.add(trimming);

        count++;
        
      }
      
    }
    
  }

  public static void createFile(String fileName) throws FileNotFoundException{
    try {
      File hFile = new File(fileName);
      if (hFile.createNewFile()) {
      } else {

      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public static void writeTofile(String fileName, String input, int i) throws FileNotFoundException{
    try {
      if(i==0){
        FileWriter myWriter = new FileWriter(fileName,false);
        myWriter.write(input);
        myWriter.close();
      }
      else{
        FileWriter myWriter = new FileWriter(fileName,true);
        myWriter.write(input);
        myWriter.close();
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) throws FileNotFoundException{
    String originalFile = args[0];
    // String strippedName = originalFile.split("\\.")[0];
    String myFileNameNoPath = originalFile.split("\\.")[0] + ".xml";  // the name of the new file we are creating
    createFile(myFileNameNoPath);
    System.out.println("path is " + myFileNameNoPath);

    firstPass(originalFile); //takes out lines with whitespace and comments
    for(int i = 0; i<firstpassfileInput.size(); i++){
      System.out.println(firstpassfileInput.get(i));

      if(firstpassfileInput.get(i).equals("class")){
        writeTofile(myFileName, finishedBinary+"\n",i); //t
      }
    }
    

  }
  
}