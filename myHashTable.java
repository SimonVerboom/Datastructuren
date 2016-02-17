public class myHashTable
{	
	private String[] table;
	public int size; 


	public myHashTable(int size){
		this.size = size;
		this.table = new String[size];
	}

	public int size(){
		return size;
	}	

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
		while(true){
			if((words[index] == null) || (!words[index].equals(s))){
				index++;
				if(words.length <= index){
					return false;
				} 
			}else{
				return true;
			}
		}
	}

	public int put(String s){
		int index = hashFunc(s, table.length);
		while(table.length <= index){
			table = copyArray(table);
		}
		
		if(table[index] != null){
			index = linearProbe(index, table);
		}

		while(table.length <= index){
			table = copyArray(table);
		}
		table[index] = s;
		return (index);
	}
	private int linearProbe(int index, String[] words){
		while(true){
			if(words.length > index){
				if(words[index] != null){
					index++;
				}else{
					return index;
				}
			}else{
				return index;
			}
		}
	}

	private int hashFunc(String s, int length){
		int hash = 1;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			hash = Character.getNumericValue(c) + hash;
		}
		return (hash % (length + 1));
	}

	private String[] copyArray(String[] original){
	  	int length = original.length;
	  	String[] copy = new String[length * 2];
	  	size = length * 2;
	  	for(int i = 0; i < length; i++){
	  		if(false){
	  			hashFunc(original[i], size);	
	  		}else{
	  			copy[i] = original[i];
	  		}


	  	}

  	return copy;
  }
}