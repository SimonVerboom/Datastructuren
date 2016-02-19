import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;

/*
 * This file contains the main program execution. There are three evaluations being done.
 * Array, Hash Table with Open Addressing and the Trie are being evalutated. 
 * Every evaluation method has two corresponding methods that read in the words and store them
 * in the given data structure and another that check whether from all the sample file are in the 
 * original collection of words collected when reading in. 
 */

public class DS 
{
  public static void main(String[] args)
  {
  	DS ds_eval = new DS();
    System.out.println("Array Evalutation:");
    System.out.println("***********");
    ds_eval.arrayEval("wordlist.txt", "C:\\Users\\albert\\Documents\\Datastructuren\\Datastructuren\\samples\\Samples");
    System.out.println("HashTable Evalutation:");
    System.out.println("***********");
    ds_eval.hashTableEval("wordlist.txt", "C:\\Users\\albert\\Documents\\Datastructuren\\Datastructuren\\samples\\Samples");
    System.out.println("Trie Evalutation:");
    System.out.println("***********");
    ds_eval.trieEval("wordlist.txt", "C:\\Users\\albert\\Documents\\Datastructuren\\Datastructuren\\samples\\Samples");
  }

  private void trieEval(String filename, String path){
    myTrie myTree = readInTrie(filename);
    checkTrie(myTree, path);
  }

  private void hashTableEval(String filename, String path){
    myHashTable hashTable = readInTable(filename);
    checkHash(hashTable, path);    
  }

  private void arrayEval(String filename, String sample_path){
    String[] test = readInArray(filename);
    checkArray(test, sample_path);
  }


  private float checkArray(String[] set, String path){
    File dir = new File(path);
    String line;
    File[] directoryListing = dir.listFiles();
    if (directoryListing != null) {
      for (File child : directoryListing) {
        int cor_count = 0;
        int tot_count = 0;
        try{

          System.out.println(child);
          BufferedReader bf = new BufferedReader(new FileReader(child));
          long startTime = System.nanoTime();
          while((line = bf.readLine()) != null){
            tot_count++;
            if(inArray(set, line)){
              cor_count++;
            }
          }
          long endTime = System.nanoTime();
          long duration = (endTime - startTime);

          System.out.println("The accuracy is:");
          System.out.println((float) cor_count/tot_count);
          System.out.println("It took: " + duration);
          bf.close();
        }catch(IOException e){
          System.out.println("IT WENT HORRIBLY WRONG");
        }
      }
    } else {
      System.out.println("There is no directory here");
      System.exit(0);
    }

    return 0;
  }


  private String[] readInArray(String filename){
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
      bf.close();
      return words;
    }catch(IOException e){
      System.out.println("IT WENT HORRIBLY WRONG");
    }

    return null;
  }

  // The function below copies all the elements of the input array and
  // stores these in a new array that has double the length of the original array.

  private String[] copyArray(String[] original){
  	int length = original.length;
  	String[] copy = new String[length * 2];
  	for(int i = 0; i < length; i++){
  		copy[i] = original[i];
  	}

  	return copy;
  }

  // The function below checks if a word is in the array, by going thorugh all the elements
  // and checking if one of them is the same as the word. 

  private boolean inArray(String[] set, String subject){
    for(int i = 0; i < set.length; i++){
      if(set[i] != null){        
        if( set[i].equals(subject)){
          return true;
        }
      }
    }

    return false;
  }

  private myHashTable readInTable(String filename){
    String line;
    try{
      BufferedReader bf = new BufferedReader(new FileReader(filename));
      myHashTable hash = new myHashTable(660000);
      int t = 0;
      while((line = bf.readLine()) != null){
        t = hash.put(line);
      }
      bf.close();
      return hash;
    }catch(IOException e){
      System.out.println("IT WENT HORRIBLY WRONG");
    }

    return null;
  }

  private float checkHash(myHashTable set, String path){
    File dir = new File(path);
    String line;
    File[] directoryListing = dir.listFiles();
    if (directoryListing != null) {
      for (File child : directoryListing) {
        int cor_count = 0;
        int tot_count = 0;
        try{

          System.out.println(child);
          BufferedReader bf = new BufferedReader(new FileReader(child));
          long startTime = System.nanoTime();
          while((line = bf.readLine()) != null){
            tot_count++;
            if(set.contains(line)){
              cor_count++;
            }
          }
          long endTime = System.nanoTime();
          long duration = (endTime - startTime);
          System.out.println("The accuracy is:");
          System.out.println((float) cor_count/tot_count);
          System.out.println("It took: " + duration);
          bf.close();
        }catch(IOException e){
          System.out.println("IT WENT HORRIBLY WRONG");
        }
      }
    } else {
      System.out.println("There is no directory here");
      System.exit(0);
    }

    return 0;
  }

  private myTrie readInTrie(String filename){
    String line;
    try{
      BufferedReader bf = new BufferedReader(new FileReader(filename));
      myTrie hash = new myTrie();
      int t = 0;
      while((line = bf.readLine()) != null){
        line = line.toLowerCase();
        line = line.replace("'", "");
        hash.putWords(line);
      }
      bf.close();
      return hash;
    }catch(IOException e){
      System.out.println("IT WENT HORRIBLY WRONG");
    }

    return null;
  }

    private float checkTrie(myTrie tree, String path){
    File dir = new File(path);
    String line;
    File[] directoryListing = dir.listFiles();
    if (directoryListing != null) {
      for (File child : directoryListing) {
        int cor_count = 0;
        int tot_count = 0;
        try{

          System.out.println(child);
          BufferedReader bf = new BufferedReader(new FileReader(child));
          long startTime = System.nanoTime();
          while((line = bf.readLine()) != null){
            tot_count++;
            line = line.toLowerCase();
            line = line.replace("'", "");
            if(tree.contains(line)){
              cor_count++;
            }
          }
          long endTime = System.nanoTime();
          long duration = (endTime - startTime);
          System.out.println("The accuracy is:");
          System.out.println((float) cor_count/tot_count);
          System.out.println("It took: " + duration);
          bf.close();
        }catch(IOException e){
          System.out.println("IT WENT HORRIBLY WRONG");
        }
      }
    } else {
      System.out.println("There is no directory here");
      System.exit(0);
    }

    return 0;
  }
}