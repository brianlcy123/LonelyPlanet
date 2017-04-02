package www.opm.com;

public class BuyShowTickets {
	/*	There are n people standing in line to buy show tickets. Due to high demand, the venue sells tickets according to the following rules:
		The person at the head of the line can buy exactly 1 ticket and must then exit the line.
		If a person needs to purchase additional tickets, they must re-enter the end of the line and wait to be sold their next ticket (assume exit and re-entry takes zero seconds).
		Each ticket sale takes exactly 1 second.
		 
		We express the initial line of n people as an array, tickets = [tickets0, tickets1, ��, ticketsn-1], where each ticketsi denotes the number of tickets that person i wishes to buy. If Jesse is located at position p, how many seconds will it take for him to purchase ticketsp tickets?
		 
		For example, if tickets = [1, 2, 5] and p = 1, the first five seconds of ticket sales look like this:
		Buying-Show-Tickets-PS1
		Green denotes Jesse, and gray denotes a person that left the line.
		Jesse finishes purchasing all tickets1 = 2 tickets at time t = 4.
		 
		Complete the waitingTime function in the editor below. It has two parameters:
		An array, tickets, of n positive integers describing the initial sequence of people standing in line. Each ticketsi describes the number of tickets that the person waiting at initial position i needs to purchase.
		An integer, p, denoting Jesse's position in tickets.
		The function must return an integer denoting the number of seconds it takes for Jesse to finish purchasing exactly ticketsp tickets.
		 
		Input Format
		Locked stub code in the editor reads the following input from stdin and passes it to the function:
		The first line contains an integer, n, denoting the number of elements in tickets.
		Each line i of the n subsequent lines contains an integer describing ticketsi.
		The last line contains an integer, p.
		 
		Constraints
		1 �� n �� 105
		1 �� tickets[i] �� 109, where 0 �� i < n.
		0 �� p < n
		 
		Output Format
		Return an integer denoting the number of seconds it takes for Jesse to finish purchasing exactly ticketsp tickets.
		 
		Sample Input 0
		5
		2
		6
		3
		4
		5
		2
		 
		Sample Output 0
		12
		 
		Explanation 0
		Given tickets = [2, 6, 3, 4, 5], Jesse's wait time looks like this:
		window �� 2 �� 6 �� 3 �� 4 �� 5
		window �� 6 �� 3 �� 4 �� 5 �� 1
		window �� 3 �� 4 �� 5 �� 1 �� 5
		window �� 4 �� 5 �� 1 �� 5 �� 2
		window �� 5 �� 1 �� 5 �� 2 �� 3
		window �� 1 �� 5 �� 2 �� 3 �� 4
		window �� 5 �� 2 �� 3 �� 4 (the person at the head of the line in the previous step purchased their last ticket and does not re-enter the line)
		window �� 2 �� 3 �� 4 �� 4
		window �� 3 �� 4 �� 4 �� 1
		window �� 4 �� 4 �� 1 �� 2
		window �� 4 �� 1 �� 2 �� 3
		window �� 1 �� 2 �� 3 �� 3
		window �� 2 �� 3 �� 3 (Jesse purchased his last ticket and does not re-enter the line)
		Because it took a total of twelve seconds for Jesse to purchase all tickets2 = 3 tickets, we return 12.
		 
		Sample Input 1
		4
		1
		1
		1
		1
		0
		 
		Sample Output 1
		1
		 
		Explanation 1
		Given tickets = [1, 1, 1, 1], Jesse's wait time looks like this:
		window �� 1 �� 1 �� 1 �� 1
		window �� 1 �� 1 �� 1 (Jesse purchased his ticket and does not re-enter the line)
		Because it took a total of one second for Jesse to purchase tickets0 = 1 ticket, we return 1.
		 
		Sample Input 2
		4
		5
		5
		2
		3
		3
		 
		Sample Output 2
		11
		 
		Given tickets = [5, 5, 2, 3], Jesse's wait time looks like this:
		window �� 5 �� 5 �� 2 �� 3
		window �� 5 �� 2 �� 3 �� 4
		window �� 2 �� 3 �� 4 �� 4
		window �� 3 �� 4 �� 4 �� 1
		window �� 4 �� 4 �� 1 �� 2
		window �� 4 �� 1 �� 2 �� 3
		window �� 1 �� 2 �� 3 �� 3
		window �� 2 �� 3 �� 3 (the person at the head of the line in the previous step purchased their last ticket and does not re-enter the line)
		window �� 3 �� 3 �� 1
		window �� 3 �� 1 �� 2
		window �� 1 �� 2 �� 2
		window �� 2 �� 2 (Jesse purchased his last ticket and does not re-enter the line)
		Because it took a total of eleven second for Jesse to purchase all tickets3 = 3 tickets, we return 11.*/
	static long waitingTime(int[] tickets, int p) {
        long ans = 0;
        for(int i=0;i<tickets.length;i++){
            if(i<=p) ans+=tickets[i]<tickets[p]?tickets[i]:tickets[p];
            else ans+=tickets[i]<tickets[p]-1?tickets[i]:tickets[p]-1;
        }
        return ans;
    }
    public static void main(String[]args){
    	int[]tickets={2,6,3,4,5};
    	System.out.println(waitingTime(tickets,2));
    }
}
