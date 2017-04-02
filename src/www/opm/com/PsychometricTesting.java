package www.opm.com;

import java.util.Arrays;

public class PsychometricTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]scores = {4,8,7};
		int[] lowerLimits = {2,4};
		int[] upperLimits = {4,8};
		int[] ans=jobOffers(scores,lowerLimits,upperLimits);
		for(int i:ans) System.out.println(i);

	}
	static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int[]ans = new int[lowerLimits.length];
        Arrays.sort(scores);
        for(int i=0;i<lowerLimits.length;i++){
            for(int score:scores){
                if(score>=lowerLimits[i]&&score<=upperLimits[i]) ans[i]++;
                if(score>upperLimits[i]) break;
            }
        }
        return ans;
    }

}
