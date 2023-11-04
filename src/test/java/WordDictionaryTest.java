import org.junit.Assert;
import org.junit.Test;

public class WordDictionaryTest {
    @Test
    public void testWordDictionaryClass1(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad"));
        Assert.assertTrue(wordDictionary.search("bad"));
        Assert.assertTrue(wordDictionary.search(".ad"));
        Assert.assertTrue(wordDictionary.search("b.."));

    }
    @Test
    public void testWordDictionaryClass2(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        wordDictionary.addWord("add");
        Assert.assertTrue(wordDictionary.search("."));
        Assert.assertTrue(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search("aa"));
        Assert.assertTrue(wordDictionary.search("a.d"));
        Assert.assertFalse(wordDictionary.search("a."));
        Assert.assertFalse(wordDictionary.search(".a"));


    }
}
