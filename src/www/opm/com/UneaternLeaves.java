package www.opm.com;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UneaternLeaves {
	    /*
	 * Complete the function below.
	 */
    static int countUneatenLeaves(int n, int[] a) {
    	Arrays.sort(a);
    	int sign =1;
    	int count=0;
    	for(int k=1;k<=a.length;k++){
    	    List<Integer> list = getKth(n,a,k);
    	        
    	    if(sign>0){
    	        for(int i:list) count+=i;
    	        sign=-1;
    	    }else{
    	        for(int i:list) count-=i;
    	        sign=1;
    	    }
    	}
    	return n-count;
    }
    
    
    public static List<Integer> getKth(int n, int[] a, int i){
        List<Integer> ans = new ArrayList<Integer>();
        if(i==1){
            for(int aa:a)
                ans.add(n/aa);
        }else{
            helper(n,a,i,ans,new ArrayList<Integer>(),0);
        }
        return ans;
    }
    public static void helper(int n, int[] a, int i, List<Integer> ans, List<Integer> list, int start){
        if(list.size()==i){
            int lcm = list.get(0);
            for(int j=1;j<i;j++){
                lcm = lcm(lcm,list.get(j));
                if(lcm>n) return;
            }
            ans.add(n/lcm);
        }else{
            for(int j=start;j<a.length;j++){
                list.add(a[j]);
                helper(n,a,i,ans,list,j+1);
                list.remove(list.size()-1);
            }
        }
    }
    private static int lcm(int a, int b){
        return a * (b / findGCD (a, b));
    }
 
    private static int findGCD(int number1, int number2) {
        if(number2 == 0){
            return number1;
        }
 
        return findGCD(number2, number1%number2);
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }
        
        res = countUneatenLeaves(_n, _a);
        bw.write(String.valueOf(res));
        bw.newLine();
                
        bw.close();
    }
}

