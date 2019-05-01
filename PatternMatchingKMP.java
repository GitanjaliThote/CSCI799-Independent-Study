import java.util.ArrayList;
import java.util.List;

public class PatternMatchingKMP {

    public static List<Integer> buildPatternMatchList(String pattern){


        List<Integer> patternList = new ArrayList<>();
        patternList.add(0);

        if(pattern.length() == 1)
            return patternList;


        int j = 0;
        int i = j+1;
        int end = pattern.length();

        while(i < end && j < end){
            //            System.out.println(patternList+""+i);
            if(pattern.charAt(i) == pattern.charAt(j)){
                patternList.add(j+1);
                i++;
                j++;
            } else {
                if(j!= 0){
                    j=patternList.get(j-1);

                } else {
                    patternList.add(0);
                    i++;
                }

            }
        }

        return patternList;
    }

    public static boolean isSubString(String s, List<Integer> patternList, String pattern){
        int strIdx = 0;
        int patIdx = 0;

        while(strIdx < s.length() && patIdx < patternList.size()){
            if(s.charAt(strIdx) == pattern.charAt(patIdx)){
                strIdx++;
                patIdx++;
            } else{
                if(patIdx!=0){
                    patIdx = patternList.get(patIdx-1);
                } else {
                    strIdx++;
                }

            }
        }

        if(patIdx == pattern.length())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        List<Integer> patternList = buildPatternMatchList("abcaby");
//        System.out.println(patternList);
        System.out.println(isSubString("abxabcabcaby",patternList,"abcabz"));

    }
}