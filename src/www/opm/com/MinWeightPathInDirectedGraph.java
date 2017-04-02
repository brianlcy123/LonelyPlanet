/**
 * 
 */
package www.opm.com;

/**
 * @author Owner
 *
 */
public class MinWeightPathInDirectedGraph {
/*	Explanation 0
	A directed edge already exists from node 1 to node 2 and the path 1 ¡ú 2 is the minimum cost path, so the function returns 3.
	 
	Sample Input 1
	3 1
	1 2 3
	 
	Sample Output 1
	1
	 
	Explanation 1
	As graph g has no edge between node 1 and node 3, we can add an extra edge from node 1 to node 3 having weight 1. Thus, the path 1 ¡ú 3 is the minimum weight path and the function returns 1.
	 
	Sample Input 2
	4 4
	1 2 3
	1 3 3
	1 4 3
	2 1 3
	 
	Sample Output 2
	3
	 
	Explanation 2
	A directed edge already exists from node 1 to node 4 and the path 1 ¡ú 4 is the minimum cost path, so the function returns 3.*/
	static int minCost(int g_nodes, int[] g_from, int[] g_to, int[] g_weight) {
        int[][] connected = new int[g_nodes+1][g_nodes+1];
        
        for(int i=0;i<g_from.length;i++){
            connected[g_from[i]][g_to[i]]=g_weight[i];
            connected[g_to[i]][g_from[i]]=Integer.MAX_VALUE;
        }
        for(int i=1;i<=g_nodes;i++){
            for(int j=i+1;j<=g_nodes;j++){
                if(connected[i][j]==0&&connected[j][i]==0) connected[i][j]=1;
                if(connected[1][i]!=Integer.MAX_VALUE&&connected[i][j]!=Integer.MAX_VALUE){
                    connected[1][j]=Math.min(connected[1][j],connected[1][i]+connected[i][j]);
                }
            }
        }
        return connected[1][g_nodes];
    }
	public static void main(String[] args){
		int[] from={1,1,1,2};
		int[] to={2,3,4,1};
		int[] weight={3,3,3,3};
		int ans = minCost(4,from,to,weight);
		System.out.println(ans);
	}

}
