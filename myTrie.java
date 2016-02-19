public class myTrie{
	TrieNode root;
	TrieNode currentNode;

	// Initiation of a myTrie object, which is internally a TrieNode object

	public myTrie(){
		this.root = new TrieNode('-');
	}


	// From this node, we building a path within this node's children
	// The child is chosen and initiated by getting the index first.
	// The index is computed as the which index the letter has in the alphabet minus 1. 

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
 				TrieNode nextTrie = new TrieNode(word.charAt(i));
 				currentNode.children[index] = nextTrie;
 				currentNode = nextTrie;
 			}else{
 				currentNode = currentNode.children[index];
 			}
		}

		currentNode.leafNode = true;
	}

	// A word is in the tree if there is a path from the first to last letter
	// of the word in the tree and the last letter os at a leaf node. 

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
 				TrieNode testNode = currentNode.children[index];
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



// The object TrieNode has 26 children, holds a character and can be leaf node.

class TrieNode
{	
	public TrieNode[] children;
	public char data;
	public boolean leafNode; 


	public TrieNode(char c){
		this.data = c;
		this.children = new TrieNode[26];
		this.leafNode = false;
	}
}   