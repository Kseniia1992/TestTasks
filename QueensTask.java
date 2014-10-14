package pac;

public class QueensTask {
	
	 static int n=8;
	 static int[] board=new int[n];
	 static int solution=0;
	 
	    public static boolean isSafe(int r, int c) {	        
	        for (int i = 0; i < r; i++) {
	        	//check by vertical, diagonals 
	            if (board[i] == c || (i - r) == (board[i] - c) ||(i - r) == (c - board[i])) 
	            {
	                return false; //not safe
	            }
	        }
	        return true; //safe cell for queen
	    }
	 
	    public static void printQueens() {
	    	System.out.println("\n #" + (++solution));	       
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (board[i] == j) {
	                    System.out.print("1 ");
	                } else {
	                    System.out.print("- ");
	                }
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	    
	 //checking all rows and cells to set queen
	    public static void setQueen(int r, int n) {
	        for (int c = 0; c < n; c++) {
	            if (isSafe(r, c)) {
	            	board[r] = c; 
	                if (r == 7) { 
	                    printQueens();
	                } else {
	                    setQueen(r + 1, n); // only one queen in row; go to next row
	                }
	            }
	        }
	    }
	 
	    public static void callsetQueen() {
	        setQueen(0, board.length);
	    }
	 
	    public static void main(String args[]) {
	    	callsetQueen();	      
	    }

}
