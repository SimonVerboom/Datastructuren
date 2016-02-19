public class myTrie
{	
	private myTrie[] letters;
	public int size;
	public myTrie currentNode; 


	public myTrie(int size){
		this.size = size;
		this.letters = new myTrie[size];
	}

	public void putWords(String word){
		for(int i = 0; i < word.length(); i++){	
			char c = word.charAt(i);	
			int input = Character.getNumericValue(c);
			int standard = Character.getNumericValue('a');
			myTrie nextTrie = new myTrie(26);
			int index = standard - input;
			if((index > 0) && (index < size)){
				if(letters[index] == null){
					letters[index] = nextTrie;
					System.out.println("doing something!");
					currentNode = nextTrie;
				}
			}
		}
	}
}   