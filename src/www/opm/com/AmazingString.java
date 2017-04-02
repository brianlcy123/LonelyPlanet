package www.opm.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AmazingString {
/*	We consider a string consisting of two or more lowercase English alphabetic letters (i.e., [a-z]) to be amazing if no adjacent characters in the string are equal. For example, the strings "abc", "abab", and "abca" are amazing; however, the strings "aab", "abba", and "abcaa" are not amazing. If a string is not amazing, then we can perform zero or more replace operations on the string. We define a single replace operation to be the replacement of any character in the string with any other lowercase English alphabetic letter.
	 
	Complete the minimalOperations function in your editor. It has one parameter: an array of n strings, words. The function must return an array of n integers where the value at each index i denotes the minimum number of replace operations necessary to make string wordsi amazing.
	 
	Input Format
	Locked stub code in the editor reads the following input from stdin and passes it to the function:
	The first line contains an integer, n, denoting the total number of elements in words.
	Each line i of the n subsequent lines (where i ¡Ü 0 < n) contains a string describing wordsi.
	 
	Constraints
	1 ¡Ü n ¡Ü 100
	2 ¡Ü length of wordsi ¡Ü 105
	It is guaranteed that wordsi consists of lowercase English alphabetic letters (i.e., [a-z]) only.
	 
	Output Format
	Return an array of n integers where the value at each index i denotes the minimum number of replace operations necessary to make string wordsi amazing.
	 
	Sample Input 0
	5
	ab
	aab
	abb
	abab
	abaaaba
	 
	Sample Output 0
	0
	1
	1
	0
	1
	 
	Explanation 0
	Let's call our return array ops. We fill ops as follows:
	 
	word = "ab" is already amazing, so we need not perform any replace operations and ops[0] = 0.
	word = "aab" is not amazing. We can replace word0 = 'a' with 'g' to get the amazing string "gab", so ops[1] = 1 as we only performed one replace operation.
	word = "abb" is not amazing. We can replace word2 = 'b' with 'c' to get the amazing string "abc", so ops[2] = 1 as we only performed one replace operation.
	word = "abab" is amazing so we need not perform any replace operations, so ops[3] = 0.
	word = "abaaaba" is not amazing. We can replace word3 = 'a' with 'b' to get the amazing string "abababa", so ops[4] = 1 as we only performed one replace operation.
	 
	We then return ops = [0, 1, 1, 0, 1].*/
    static int[] minimalOperations(String[] words) {
        int[] ans = new int[words.length];
        int i=0;
        for(String word:words) ans[i++]=getMinOpr(word); 
        return ans;
    }
    static int getMinOpr(String word){
        int min=0;
        for(int i=0;i<word.length()-1;i++){
            int j=i;
            while(j+1<word.length()&&word.charAt(j)==word.charAt(j+1)) j++;
            min+=(j-i+1)/2;
            i=j;
        }
        return min;
    }

    public static void main(String[] args) throws IOException{
    	String[] words = {"a","ab","aab","abb","aaab"};
    	int[] ans = minimalOperations(words);
    	for(int i:ans) System.out.println(i);
        /*Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        
        int _words_size = 0;
        _words_size = Integer.parseInt(in.nextLine().trim());
        String[] _words = new String[_words_size];
        String _words_item;
        for(int _words_i = 0; _words_i < _words_size; _words_i++) {
            try {
                _words_item = in.nextLine();
            } catch (Exception e) {
                _words_item = null;
            }
            _words[_words_i] = _words_item;
        }
        
        res = minimalOperations(_words);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();*/
    }
}
