class Solution {
    public String addBinary(String a, String b) {
        if(b.length() > a.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        
        int diff = a.length()-b.length();
        for(int i=0 ; i<diff ; i++){
            b = "0" + b;
        }
        
        String ans = "";
        int carry = 0, sum, x, y;
        
        for(int i=a.length()-1 ; i>=0 ; i--){
            x = Integer.parseInt(a.charAt(i)+"");
            y = Integer.parseInt(b.charAt(i)+"");
            a = a.substring(0, i);
            b = b.substring(0, i);
            
            sum = x + y;
            
            if(sum == 0){
                ans = (sum + carry) + ans;
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
                if(carry == 0){
                    ans = "0" + ans;
                } else {
                    ans = "1" + ans;
                }
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