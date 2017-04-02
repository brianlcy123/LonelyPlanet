package www.opm.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SuperStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		String[] ops = {"push 4"
				,"pop"
				,"push 3"
				,"push 5"
				,"push 2"
				,"inc 3 1"
				,"pop"
				,"push 1"
				,"inc 2 2","push 4","pop","pop"};
		
		superStack(ops);
	}
	
	static void superStack(String[] operations) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int maxE = 0;
        SuperStack ss = new SuperStack();
        for(String op : operations){
            if(op.contains("push")){
                String[] temp = op.split(" ");
                //ss.push(Integer.valueOf(temp[1]));
                stack.push(Integer.valueOf(temp[1]));
            }
            else if(op.contains("inc")){
                String[] temp = op.split(" ");
                int e =Integer.valueOf(temp[1]);
                int k =Integer.valueOf(temp[2]);
                if(map.containsKey(e)) map.put(e,map.get(e)+k);
                else map.put(e,k);
                
                if(e>maxE) maxE=e;
                
                if(maxE==stack.size()){
                    int i = map.get(maxE);
                    stack.push(stack.pop()+i);
                    map.remove(maxE);
                    if(map.containsKey(maxE-1)) map.put(maxE-1,map.get(maxE-1)+i);
                    else map.put(maxE-1,i);
                    maxE--;
                }
                //ss.inc(Integer.valueOf(temp[1]),Integer.valueOf(temp[2]));
            }else if(op.contains("pop")){
            	stack.pop();
                if(maxE==stack.size()&&!stack.isEmpty()){
                    int i = map.get(maxE);
                    stack.push(stack.pop()+i);
                    map.remove(maxE);
                    if(map.containsKey(maxE-1)) map.put(maxE-1,map.get(maxE-1)+i);
                    else map.put(maxE-1,i);
                    maxE--;
                }
                
            }
            
            System.out.println(stack.isEmpty()?"EMPTY":stack.peek());
        }

    }

}
