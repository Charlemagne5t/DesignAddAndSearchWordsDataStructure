
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode trie = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!trie.children.containsKey(currentChar)) {
                TrieNode node = new TrieNode();
                trie.children.put(currentChar, node);
            }
            trie = trie.children.get(currentChar);
            if(i == word.length() -1 ){
                trie.isTerminal = true;
            }
        }
    }

    public boolean search(String word) {
        return searchFromNode(word, root);
    }
    private boolean searchFromNode(String word, TrieNode start) {
        TrieNode trie = start;
        if(trie.children.isEmpty()){
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(currentChar != '.'){
                if(trie.children.containsKey(currentChar)){
                    trie = trie.children.get(currentChar);
                    if(i == word.length() - 1){
                        return trie.isTerminal;
                    }
                } else return false;
            }else if(currentChar == '.' && i == word.length() - 1){
                for (Map.Entry<Character, TrieNode> child: trie.children.entrySet()) {
                    if(child.getValue().isTerminal){
                        return true;
                    }
                }
                return false;
            }else if(currentChar == '.'){
                for (Map.Entry<Character, TrieNode> child: trie.children.entrySet()) {
                    if(searchFromNode(word.substring(i + 1), child.getValue())){
                        return true;
                    }
                } return false;
            }
        }
        return trie.isTerminal;
    }
}
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isTerminal = false;

    public TrieNode() {
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
