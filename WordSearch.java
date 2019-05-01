import java.util.ArrayList;
import java.util.List;

class WordSearch {
    static TrieNode crawl;

    public static void buildTrie(List<String> dict){

        crawl = new TrieNode();

        for( String a: dict ){

            TrieNode current = crawl;

            int size = a.length();

            for( int level = 0; level < size; level++ ){

                if(current.children[a.charAt(level) - 'a'] == null){

                    current.children[a.charAt(level) - 'a'] = new TrieNode();
                    current =  current.children[a.charAt(level) - 'a'] ;

                } else {

                    current =current.children[a.charAt(level) - 'a'];
                }
            }

            current.word = a;
        }

    }

    public static String replaceWords(List<String> dict, String sentence) {



        StringBuilder s = new StringBuilder();

        for( String words : sentence.split(" ") ){

            if(s.length() > 0)
                s.append(" ");

            TrieNode check = crawl;

            StringBuilder wd = new StringBuilder();

            for( Character c : words.toCharArray() ){


                if(check.children[c - 'a'] != null ){
                    wd.append(c);
                    check = check.children[c - 'a'];
                    if( check.word != null)
                        break;
                } else {
                    break;
                }

            }

            if(wd.length() > 0 && check.word != null){
                s.append(wd);
            } else {
                s.append(words);
            }

        }

        return s.toString();

    }

    public static void main(String[] args) {

        List<String> dict = new ArrayList();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";

        buildTrie(dict);

        System.out.println(replaceWords(dict,sentence));


    }
}


class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}

