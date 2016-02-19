import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;


public class DS 
{
  public static void main(String[] args)
  {
  	DS ds_eval = new DS();
    // System.out.println("Array Evalutation:");
    // System.out.println("***********");
    // ds_eval.arrayEval("wordlist.txt", "C:\\Users\\albert\\Documents\\Datastructuren\\Datastructuren\\samples\\Samples");
    // System.out.println("HashTable Evalutation:");
    // System.out.println("***********");
    // ds_eval.hashTableEval("wordlist.txt", "C:\\Users\\albert\\Documents\\Datastructuren\\Datastructuren\\samples\\Samples");
    myTrie myTree = ds_eval.readInTrie("wordlist.txt");
    ds_eval.checkTrie(myTree, "C:\\Users\\albert\\Documents\\Datastructuren\\Datastructuren\\samples\\Samples");
  }

  // private void hashTableEval(String filename, String path){
  //   myHashTable hashTable = readInTable(filename);
  //   checkHash(hashTable, path);    
  // }

  // private void arrayEval(String filename, String sample_path){
  //   String[] test = readInArray(filename);
  //   long startTime = System.nanoTime();
  //   checkWords(test, sample_path);
  //   long endTime = System.nanoTime();
  //   long duration = (endTime - startTime);
  //   double sec = (double)duration / 1000000000.0;
  //   System.out.println("It took: " + sec);
  // }


  // private float checkWords(String[] set, String path){
  //   File dir = new File(path);
  //   String line;
  //   File[] directoryListing = dir.listFiles();
  //   if (directoryListing != null) {
  //     for (File child : directoryListing) {
  //       int cor_count = 0;
  //       int tot_count = 0;
  //       try{

  //         System.out.println(child);
  //         BufferedReader bf = new BufferedReader(new FileReader(child));
  //         long startTime = System.nanoTime();
  //         while((line = bf.readLine()) != null){
  //           tot_count++;
  //           if(inArray(set, line)){
  //             cor_count++;
  //           }
  //         }
  //         long endTime = System.nanoTime();
  //         long duration = (endTime - startTime);
  //         double sec = (double)duration / 1000000000.0;
  //         System.out.println("The accuracy is:");
  //         System.out.println((float) cor_count/tot_count);
  //         System.out.println("It took: " + sec);

  //       }catch(IOException e){
  //         System.out.println("IT WENT HORRIBLY WRONG");
  //       }
  //     }
  //   } else {
  //     System.out.println("There is no directory here");
  //     System.exit(0);
  //   }

  //   return 0;
  // }


  // private String[] readInArray(String filename){
  //   String line;
  //   try{
  //     BufferedReader bf = new BufferedReader(new FileReader(filename));
  //     String[] words = new String[1];
  //     int n = 0;
  //     while((line = bf.readLine()) != null){
  //       words[n] = line;
  //       int length = words.length;
  //       if (length == (n + 1)){
  //         words = copyArray(words);
  //       }
  //       n++;
  //     }

  //     return words;
  //   }catch(IOException e){
  //     System.out.println("IT WENT HORRIBLY WRONG");
  //   }

  //   return null;
  // }

  // // The funct5ion below copies all the elements of the input array and
  // // stores these in a new array that has double the length of the original array.

  // private String[] copyArray(String[] original){
  // 	int length = original.length;
  // 	String[] copy = new String[length * 2];
  // 	for(int i = 0; i < length; i++){
  // 		copy[i] = original[i];
  // 	}

  // 	return copy;
  // }

  // private boolean inArray(String[] set, String subject){
  //   for(int i = 0; i < set.length; i++){
  //     if(set[i] != null){        
  //       if( set[i].equals(subject)){
  //         return true;
  //       }
  //     }
  //   }

  //   return false;
  // }

  // private myHashTable readInTable(String filename){
  //   String line;
  //   try{
  //     BufferedReader bf = new BufferedReader(new FileReader(filename));
  //     myHashTable hash = new myHashTable(660000);
  //     int t = 0;
  //     while((line = bf.readLine()) != null){
  //       t = hash.put(line);
  //     }

  //     return hash;
  //   }catch(IOException e){
  //     System.out.println("IT WENT HORRIBLY WRONG");
  //   }

  //   return null;
  // }

  // private float checkHash(myHashTable set, String path){
  //   File dir = new File(path);
  //   String line;
  //   File[] directoryListing = dir.listFiles();
  //   if (directoryListing != null) {
  //     for (File child : directoryListing) {
  //       int cor_count = 0;
  //       int tot_count = 0;
  //       try{

  //         System.out.println(child);
  //         BufferedReader bf = new BufferedReader(new FileReader(child));
  //         long startTime = System.nanoTime();
  //         while((line = bf.readLine()) != null){
  //           tot_count++;
  //           if(set.contains(line)){
  //             cor_count++;
  //           }
  //         }
  //         long endTime = System.nanoTime();
  //         long duration = (endTime - startTime);
  //         double sec = (double)duration / 1000000000.0;
  //         System.out.println("The accuracy is:");
  //         System.out.println((float) cor_count/tot_count);
  //         System.out.println("It took: " + sec);
  //       }catch(IOException e){
  //         System.out.println("IT WENT HORRIBLY WRONG");
  //       }
  //     }
  //   } else {
  //     System.out.println("There is no directory here");
  //     System.exit(0);
  //   }

  //   return 0;
  // }

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
            System.out.println(line);
            if(tree.contains(line)){
              cor_count++;
            }
          }
          long endTime = System.nanoTime();
          long duration = (endTime - startTime);
          double sec = (double)duration / 1000000000.0;
          System.out.println("The accuracy is:");
          System.out.println((float) cor_count/tot_count);
          System.out.println("It took: " + sec);
          break;
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