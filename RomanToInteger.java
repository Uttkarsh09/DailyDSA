// https://leetcode.com/problems/roman-to-integer/

class RomanToInteger{
    public int romanToInt(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        int total = 0, len = s.length();
        
        for(int i=0 ; i<len ; i++){
            int curr = hm.get(s.charAt(i)+"");
            int next = 0;
            if(i < len-1){
                next = hm.get(s.charAt(i+1)+"");
            }
            if(i<len-1 && curr < next){
                total += next - curr;
                i++;
            } else {
                total += curr;
            }
        }
        
        
        return total;
    }
}