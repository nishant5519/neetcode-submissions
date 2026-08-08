class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;

        for(int i = 0 ; i < word.length() ; i++) {
            int index = word.charAt(i) - 'a';
            TrieNode[] tempArr = current.getChildren();
            if(tempArr[index] == null){
                tempArr[index] = new TrieNode();
            }
            current = tempArr[index];
        }
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        return search(word , 0 , root);
    }

    private boolean search(String word, int index, TrieNode current){
        if(word.length() == index){
            return current.isEndOfWord();
        }

        char ch = word.charAt(index);
        TrieNode[] array = current.getChildren();

        if(ch != '.'){
           
            int i = ch-'a';
            if(array[i] == null)
                return false;
            current = array[i];
            return search(word , index+1 , current);
        }
        else {
            for(int i = 0 ; i < 26 ; i++){
                if(array[i] != null && search(word , index+1 , array[i]))
                    return true;
            }
            return false;
        }
    }
}

class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public boolean isEndOfWord() {
		return isEndOfWord;
	}

	public void setEndOfWord(boolean isEndOfWord) {
		this.isEndOfWord = isEndOfWord;
	}

}