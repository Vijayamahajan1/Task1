import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;



public class task {

    private static final Logger logger = Logger.getLogger(task.class.getName());

    private static String reverseWord(String word) {
        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                letters.append(ch);
            } else {
                specials.append(ch);
            }
        }
        reversed.append(letters.reverse());
        reversed.append(specials);
        return reversed.toString();
    }
    

    public static void main(String[] args) {
        String inputfile = "input.txt";
        String outputfile= "output.txt";

        try 
            (BufferedReader reader = new BufferedReader(new FileReader(inputfile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile)))
            {
            String line;
            while ((line = reader.readLine())!=null) {
               String[] words = line.split("\\s+");
             
               StringBuilder reversedline = new StringBuilder();
               for(String word : words){
                String reversedword = reverseWord(word);
                reversedline.append(reversedword).append(" ");
               }
               writer.write(reversedline.toString().trim());
               writer.newLine();    
            }
            logger.info("reversed words saved to "+outputfile);
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
  //Test cases

// public void testwords(){
//     assert reverseWord("yogesh").equals("hsegoy");
// }

}

