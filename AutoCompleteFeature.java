

import java.util.*;


// th - the ,there

public class AutoCompleteFeature {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Trie t = new Trie();

        List<String> lst = new ArrayList<String>();

        lst.add("th");
        lst.add("the");
        lst.add("there");
        lst.add("those");
        lst.add("tom");

        for(String s : lst)
            t.insert(s);

        System.out.println(t.search("th"));
        System.out.println(t.search("ab"));


    }
}

// t
// h
// e true  o
// r       s
// e true  e


class TrieNode1{

    TrieNode1 [] children;
    boolean isEndWord;

    public TrieNode1(){
        children = new TrieNode1[26];
        isEndWord = false;

        for(int i = 0; i< 26; i++){
            children[i] = null;
        }

    }
}

class Trie{

    TrieNode1 root;

    public Trie(){
        root = new TrieNode1();

    }

    public void insert(String word){

        TrieNode1 top = root;

        for(Character ch : word.toCharArray()){
            if(top.children[ch - 'a'] == null){
                top.children[ch - 'a'] = new TrieNode1();
                top = top.children[ch - 'a'];
            } else{
                top = top.children[ch - 'a'];
            }
        }
        top.isEndWord = true;
    }



    public List<String> search(String prefix){

        List<String> recommendation = new ArrayList<>();

        TrieNode1 top = root;

        for(Character ch : prefix.toCharArray()){
            if(top.children[ch - 'a'] != null){
                top = top.children[ch - 'a'];
            } else{
                return recommendation;
            }

        }

        dfs( top , recommendation , prefix);

        return recommendation;

    }


    public void dfs(TrieNode1 top, List<String> recommendation , String word){

        if(top.isEndWord == true){
            recommendation.add(word);
        }

        for(int i = 0 ; i < 26 ; i++){
            if(top.children[i] != null){
                word += ((char)(i + 'a'));
                dfs(top.children[i], recommendation, word);
                word = word.substring(0, word.length()-1);

            }
        }
    }
}