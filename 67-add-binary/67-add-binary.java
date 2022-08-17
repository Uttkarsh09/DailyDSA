class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        String ans = "";
        int carry = 0, sum, x, y, i, diff;
        
        if(lenB > lenA){
            String temp = a;
            a = b;
            b = temp;
        }
        
        lenA = a.length(); 
        lenB = b.length();
        diff = lenA-lenB;
            
        for(i=0 ; i<diff ; i++){
            b = "0" + b;
        }
        
        for(i=lenA-1 ; i>=0 ; i--){
            x = Integer.parseInt(a.charAt(i)+"");
            y = Integer.parseInt(b.charAt(i)+"");
            sum = x + y;
            
            if(sum == 0){
                ans = carry + ans;
                carry = 0;
            } 
            else if(sum == 1) {
                if(carry == 0){
                    ans = "1" + ans;
                } else {
                    ans = "0" + ans;
                }
            } 
            else {
                ans = carry + ans;
                carry = 1;
            }
        }
        
        if(carry != 0)
            ans = carry + ans;
        
        if(ans.indexOf(1) != -1)
            return ans.substring(ans.indexOf("1"));
        
        return ans;
    }
}