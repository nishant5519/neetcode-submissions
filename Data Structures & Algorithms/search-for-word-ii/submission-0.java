class Solution {
    private List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.add(word);
        }

         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (trie.root.children[ch - 'a'] != null) {
                    dfs(board, i, j, trie.root);
                }
            }
        }

        return result;
    }

    void dfs(char[][] board , int row , int col , TrieNode node){

         if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length || board[row][col] == '#')
            return;

        char ch = board[row][col];
        TrieNode next = node.children[ch-'a']; 
        if(next == null){
            return;
        }

        if (next.word != null) {
            result.add(next.word);
            next.word = null; // Avoid duplicates by updating the word to null , so next time no word is found in that node
        }


        board[row][col] = '#';
            dfs(board , row ,  col + 1 , next);
            dfs(board , row ,  col - 1 , next);
            dfs(board , row+1 ,  col , next);
            dfs(board , row-1 ,  col , next);
        board[row][col] = ch;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
    boolean isEndofWord;
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = word;
        curr.isEndofWord = true;
    }
}