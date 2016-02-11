import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HelloWorld
{
  public static void main(String[] args)
  {
  	HelloWorld leukObject = new HelloWorld();
  	String[] test = leukObject.readIn("wordlist.txt");
    System.out.println(leukObject.inArray(test, "AATech"));
  }

  private String[] readIn(String filename){
  	String line;
  	try{
	    BufferedReader bf = new BufferedReader(new FileReader(filename));
	    String[] words = new String[1];
	    int n = 0;
	    while((line = bf.readLine()) != null){
	    	words[n] = line;
        int length = words.length;
	    	if (length == (n + 1)){
	    		words = copyArray(words);
	    	}
	    	n++;
	    }

      return words;
  	}catch(IOException e){
  		System.out.println("IT WENT HORRIBLY WRONG");
  	}

    return null;
  }

  // The funct5ion below copies all the elements of the input array and
  // stores these in a new array that has double the length of the original array.

  private String[] copyArray(String[] original){
  	int length = original.length;
  	String[] copy = new String[length * 2];
  	for(int i = 0; i < length; i++){
  		copy[i] = original[i];
  	}

  	return copy;
  }

  private boolean inArray(String[] set, String subject){
    for(int i = 0; i < set.length; i++){
      if(set[i].equals(subject)){
        return true;
      }
    }

    return false;
  }
}