/*
	We werent able to complete this assignment on time.
*/


public class myHastTableCollision
{	
	private String[] table;
	public int size;
	Node next;


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
		}else{
			return true;
		}
	}

	public int put(String s){
		int index = hashFunc(s, table.length);
		while(table.length <= index){
			table = copyArray(table);
		}
		
		if(table[index] != null){
			new Node[] = table[index]; 
		}

		while(table.length <= index){
			table = copyArray(table);
		}
		table[index] = s;
		return (index);
	}

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


  	public Node (){
  		String s;
  		Node next = null;
  	}
  	public Node (String s, Node next)  {
  		this.s = s;
  		this.next = next;
  		return s + "";
	}
}


