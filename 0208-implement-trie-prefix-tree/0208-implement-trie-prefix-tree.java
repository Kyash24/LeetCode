class Trie {
    
    public class Node {
        private boolean isWord;
        private Node[] child;
        
        public Node() {
            isWord = false;
            child = new Node[26];
        }
    }

    Node start;
    
    public Trie() {
        start = new Node();
    }
    
    public void insert(String word) {
        int n = word.length();
        
        Node head = start;
        
        for (int i = 0 ; i < n ; i++) {
            
            int index = word.charAt(i) - 'a';
            
            if (head.child[index] == null) {
                head.child[index] = new Node();
            }
            
            head = head.child[index];
        }

        head.isWord = true;
    }
    
    public boolean search(String word) {
        
        int n = word.length();
        
        Node head = start;
        for (int i = 0 ; i < n ; i++) {
            int index = word.charAt(i) - 'a';
            
            if (head.child[index] == null) return false;
            head = head.child[index];
        }
        
        return head.isWord;
    }
    
    public boolean startsWith(String prefix) {
        
        int m = prefix.length();
        
        Node head = start;
        for (int i = 0 ; i < m ; i++) {
            int index = prefix.charAt(i) - 'a';
            
            if (head.child[index] == null) return false;
            head = head.child[index];
        }
        
        return true;
    }
}