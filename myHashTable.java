public class myHashTable
{	
	private String[] table;
	public int size; 
	private int countElem;

	/*
	 * This is the definition of the Hash Table object, which is an array internally.
	 * Given a string, the hash function computes the corresponding index in the array.
	 * If this index is already filled, the string is placed is at the next free index.
	 */


	public myHashTable(int size){
		this.size = size;
		this.table = new String[size];
	}

	public int size(){
		return size;
	}	

	// To check if a word is in the Hash Table, we first try to find it a the by hashFunc given index
	// If it is not there, we probe until we find the word or realise it is not in the Hash Table.

	public boolean contains(String s){
		int index = hashFunc(s, table.length);
		if(index < 0){
			return false;	
		}else if((table[index] == null) || (!table[index].equals(s))){
			return linearProbeCheck(index, table, s);
		}else{
			return true;
		}
	}

	private boolean linearProbeCheck(int index, String[] words, String s){
		for(int i= 0; i < words.length; i++){
			if((words[index] == null) || (!words[index].equals(s))){
				index = (index + 1) % words.length;
				if(words.length <= index){
					return false;
				} 
			}else{
				return true;
			}
		}

		return false;
	}

	public int put(String s){
		int index = hashFunc(s, table.length);
		if(table[index] != null){
			index = linearProbe(index, table);
		}
		table[index] = s;
		countElem++;
		int filled = countElem/table.length;

		// The Array is doubled in size when it is 70 percent full.
		// This is done after research online revealed this to be a good measure,
		// corroborated by one of the Teaching Assistants

		if(filled >= 0.7){
			copyArray(table);
		}
		return index;
	}
	private int linearProbe(int index, String[] words){
		while(true){
			if(words[index] != null){
				index = (index + 1) % words.length;				
			}else{
				return index;
			}
		}

	}

	// Computing the index, by multiplying the numeric value of every letter by two prime numbers
	// Sources on the net recommended this, becasuse the chances of a collision decline.
	// http://stackoverflow.com/questions/3613102/why-use-a-prime-number-in-hashcode

	private int hashFunc(String s, int length){
		int hash = 3;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			hash = Character.getNumericValue(c) * (hash * 17);
		}
		int index = (hash % (length));
		if(index < 0){
			index = index * -1;
		}
		return index;
	}

	private String[] copyArray(String[] original){
		System.out.println("Copying...");
	  	int length = original.length;
	  	size = length * 2;
	  	String[] table = new String[size];
	  	for(int i = 0; i < length; i++){
	  		if(original[i] != null){
	  			int index = hashFunc(original[i], size);
	  			if(table[index]  != null){
	  				index = linearProbe(index, table);
	  				table[index] = original[i]; 	
	  			}else{
	  				table[index] = original[i];
	  			}


	  		}else{
	  			table[i] = original[i];
	  		}


	  	}
	  	return table;
  	}
}