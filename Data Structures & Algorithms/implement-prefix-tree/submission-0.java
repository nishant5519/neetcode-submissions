class PrefixTree {

    private TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();
    }
    

    public void insert(String word) {
        TrieNode current = root;

       for(int i = 0 ; i < word.length() ; i++) {
                char ch = word.charAt(i);
                int index = ch-'a';

                TrieNode[] tempArr = current.getChildren();
        
                if(tempArr[index] == null){
                    tempArr[index] = new TrieNode();
                }
                current = tempArr[index];
            }
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            TrieNode[] tempArr = current.getChildren();
            if(tempArr[index] == null){
                return false;
            }
            current = tempArr[index];
        }
        return current.isEndOfWord();
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0 ; i < prefix.length() ; i++){
            int index = prefix.charAt(i) - 'a';
             TrieNode[] tempArr = current.getChildren();
            if(tempArr[index] == null){
                return false;
            }
            current = tempArr[index];
        }
        return true;
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
