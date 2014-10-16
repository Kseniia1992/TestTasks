package knight;

import java.awt.Point;

public class Task2_Knight {
	 private boolean[][] b;
	 private static int n=5;
	 private int board[][]=new int [n][n];
	 private int count, cells;
	 
	 public Task2_Knight(){
    	 for (int i = 0; i < n; i++) {
 	        for (int j = 0; j < n; j++) {
 	            board[i][j] = -1;
 	        }
 	    } 
    	 b = new boolean[n][n];
         cells = n*n;
         count = 0;
     }
	 
	 //the possible moves for the Knight	 
	 private static final Point[] MOVES = new Point[]{
	      new Point(-2, -1),
	      new Point(-2, 1),
	      new Point(2, -1),
	      new Point(2, 1),
	      new Point(-1, -2),
	      new Point(-1, 2),
	      new Point(1, -2),
	      new Point(1, 2)
	 };	    
	 		
     public boolean tourFrom(int row, int col){
    	//it starts from current cell, increments count to the occupied cells
    	b[row][col] = true;
        board[row][col]=count++;
	     
        if(count == cells)  
        	return true;
	 
        for(Point p:MOVES){	 
        	int nextX = row + p.x;	 
	 	    int nextY = col + p.y;     
	 	        	 
	 	    if (((nextX < 0)||(nextX >= n)||(nextY < 0)||(nextY >= n))||(b[nextX][nextY])) 
	 	    	 continue;
	            
	 	    if(tourFrom(row+p.x, col+p.y))	
	 	    	 return true;	 
	 	}	 
	 	    b[row][col] = false;  
	 	    count--;	          // return to the previous step
	 	    return false;	 
     }	      
	 
	  private void printGrid(){	 
	        for (int i = 0; i < n; i++) {
	 	        for (int j = 0; j < n; j++) {
	 	        	 System.out.print(board[i][j] + " ");
	 	        }
	 	       System.out.println();   
	         }	 
	     }	  
	 
	     public static void main(String[] args){	
	         Task2_Knight test = new Task2_Knight();	
	         test.tourFrom(0, 0);	
	         test.printGrid();	 
	     }

}
