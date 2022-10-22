// https://www.codechef.com/OCT221C/problems/SINGLEOP1
import java.util.*;

public class SingleOperationPart1_CodeChef {
    static long binToDec(String numBin, int len){
        long val=0;
        for(int i=len-1 ; i>=0 ; i--){
            if(numBin.charAt(i) == '1'){
                val += Math.pow(2, len-i-1);   
            }
        }
        return val;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner get = new Scanner(System.in);
		int t = get.nextInt();
		
		int len, i, maxIval;
		long x, val, maxVal;
        String binStrNum;
		
		while(t-- > 0){
		    len = get.nextInt();
		    binStrNum = get.next();
		    x = binToDec(binStrNum, len);
		    maxVal = -1;
		    maxIval = -1;
		    
		    for(i=1 ; i<=len ; i++){
		      //  System.out.println("X = " + x + " y = " + i);
		        val = x ^ (int)Math.floor(x / (int)Math.pow(2, i));
		      //  System.out.println(x + " XOR ⌊"+x + "/(2^" + i + "="+(int)Math.pow(2, i)+")⌋["+(int)Math.floor(x / (int)Math.pow(2, i))+"] = " + val);
		        if(val > maxVal){
		            maxIval = i;
		            maxVal = val;
		        }
		    }
		    
		    System.out.println(maxIval);
		  //  System.out.println();
		}
	}
}