public class myTrie{
	TryNode root;
	TryNode currentNode;

	public myTrie(){
		this.root = new TryNode('-');
	}

	public void putWords(String word){
		currentNode = root;
		for(int i = 0; i < word.length(); i++){
			int input = Character.getNumericValue(word.charAt(i));
			int standard = Character.getNumericValue('a');
			int index = standard - input;
			if(index < 0){
				index = index * -1;
			}
 			if(currentNode.children[index] == null){
 				TryNode nextTrie = new TryNode(word.charAt(i));
 				currentNode.children[index] = nextTrie;
 				currentNode = nextTrie;
 			}else{
 				currentNode = currentNode.children[index];
 			}
		}

		currentNode.leafNode = true;
	}

	public boolean contains(String word){
		currentNode = root;
		for(int i = 0; i < word.length(); i++){
			int input = Character.getNumericValue(word.charAt(i));
			int standard = Character.getNumericValue('a');
			int index = standard - input;
			if(index < 0){
				index = index * -1;
			}
 			if(currentNode.children[index] != null){
 				TryNode testNode = currentNode.children[index];
 				if(testNode.leafNode){
 					return true;
 				}
 				currentNode = testNode;
 			}else{
 				return false;
 			}
		}

		return false;
	} 
}





class TryNode
{	
	public TryNode[] children;
	public char data;
	public boolean leafNode; 


	public TryNode(char c){
		this.data = c;
		this.children = new TryNode[26];
		this.leafNode = false;
	}
}   