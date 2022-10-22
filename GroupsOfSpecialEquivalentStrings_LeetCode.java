// https://leetcode.com/problems/groups-of-special-equivalent-strings/

public class  GroupsOfSpecialEquivalentStrings_LeetCode {
    public static void main(String[] args) {
        int ans;
        String words1[] = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        ans = numSpecialEquivGroups(words1);
        System.out.println(ans == 3 ? "True" : "False "+ans);

        String words2[] = {"abc","acb","bac","bca","cab","cba"};
        ans = numSpecialEquivGroups(words2);
        System.out.println(ans == 3 ? "True" : "False "+ans);

        // String words3[] = {"ababaa","aaabaa"};
        // ans = numSpecialEquivGroups(words3);
        // System.out.println(ans == 2 ? "True" : "False");
    }

    public static int numSpecialEquivGroups(String[] words) {
        
        int groupCount = 0, len=words[0].length(), swapPos = 1;
        
        for(int i=0;i<words.length;i++){
            int count = 0, j=0,k=0;
            String evenPosis = "";
            String oddPosis = "";
            if(swapPos != words.length - 1) swapPos = i + 1;

            for(k=0;k<len;k++){
                char ch = words[i].charAt(k);
                if(k%2==0) evenPosis+=ch+"";
                else oddPosis+=ch+"";
            }
            
            for(j=i+1;j<words.length;j++){
                for(k=0;k<len;k++){
                    char ch = words[j].charAt(k);
                    if(k%2==0){
                        int pos = evenPosis.indexOf(ch);
                        if(pos == -1){
                            break;
                        }
                        evenPosis = evenPosis.substring(0, pos) + evenPosis.substring(pos+1);
                    }
                    else {
                        int pos = oddPosis.indexOf(ch);
                        if(pos == -1){
                            break;
                        }
                        oddPosis = oddPosis.substring(0, pos) + oddPosis.substring(pos+1);

                    }
                }
                
                if(k == len){
                    String temp = words[swapPos];
                    words[swapPos] = words[j];
                    words[j] = temp;
                    ++count;
                    ++swapPos;
                }
            }
            
            i = i + count ;
            ++groupCount;
        }

        return groupCount;
    }
}
