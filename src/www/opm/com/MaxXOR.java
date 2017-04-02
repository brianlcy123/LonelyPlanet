package www.opm.com;

public class MaxXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxXor(1,3,3));
	}
	static int maxXor(int left, int right, int k) {
        int max=0;
        for(int i=left;i<right;i++){
            for(int j=i+1;j<=right;j++){
                int temp = i^j;
                if(temp>max&&temp<=k) max=temp;
            }
        }
        return max;
    }
}
