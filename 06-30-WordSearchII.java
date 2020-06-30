class Solution {
    int row, col;
    ArrayList<String> ans;
    int itr = 0;
    int visited[][];

    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        ans = new ArrayList<String>();
        if (row == 0) return ans;
        col = board[0].length;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.setKey(ch, new TrieNode());
                }
                node = node.getKey(ch);
            }
            node.isEnd = true;
            node.value = word;
        }

        // checkTrie(root, words);

        visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                itr++;
                helper(i, j, board, root);
            }
        }

        return ans;
    }


    public void helper(int i, int j, char[][] board, TrieNode node) {
        char ch = board[i][j];

        if (!node.containsKey(ch) || visited[i][j] == itr) return;

        node = node.getKey(ch);
        if (node.isEnd && node.value != "") {
            ans.add(node.value);
            node.value = "";
        }
        visited[i][j] = itr;
        if (i < row - 1) helper(i + 1, j, board, node);
        if (i > 0) helper(i - 1, j, board, node);
        if (j < col - 1) helper(i, j + 1, board, node);
        if (j > 0) helper(i, j - 1, board, node);
        visited[i][j]--;
    }


    // public void checkTrie(TrieNode root, String[] words){
    //     TrieNode a = root;
    //     for(String word: words){
    //         a = root;
    //         for(char ch: word.toCharArray()){
    //             if(!a.containsKey(ch)){
    //                 System.out.print("Error: " + ch);
    //                 break;
    //             }
    //             a = a.getKey(ch);
    //             if(a.isEnd){
    //                 System.out.println(a.value);
    //             }
    //         }
    //     }
    // }
}

class TrieNode {
    TrieNode[] children;
    String value = "";
    boolean isEnd = false;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public boolean containsKey(char ch) {
        if (!Character.isLetter(ch)) return false;
        if (children[ch - 'a'] != null) return true;
        return false;
    }

    public void setKey(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public TrieNode getKey(char ch) {
        if (children[ch - 'a'] == null) System.out.println(ch);
        return children[ch - 'a'];
    }
}