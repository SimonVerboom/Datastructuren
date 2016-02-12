public class myHashTable
{	
	private String[] table;
	public int size; 


	public HashTable(int size){
		this.size = size;
		this.table = new String[size];
	}

	public int size(){
		return size;
	}	

	public boolean contains(String s){
		int index = hashFunc(s);
		return (table[index].equals(s));
	}

	public void put(String s){
		int index = hashFunc(s);
		if(table.length >= index){
			table = copyArray(table);
		}
		table[index] = s;
	}

	private int hashFunc(String s){
		int hash = 1;
		for(int i = 0, i < s.length){
			char c = s.charAt(i);
			hash = Character.getNumericValue(c) * hash;
		}

		return (hash % Character.getNumericValue(s.charAt(s.length-1)));
	}

	private String[] copyArray(String[] original){
	  	int length = original.length;
	  	String[] copy = new String[length * 2];
	  	for(int i = 0; i < length; i++){
	  		copy[i] = original[i];
	  	}

  	return copy;
  }
}