package pac;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task3_MagicSquare {
	
	private static final String FILE ="MagicSquare.txt";
	private int[][] square;	
	private int n=5;
	
	public Task3_MagicSquare(){
		square=new int[n][n]; 
	}
	
	public int formula(int i, int j){
		int result=1+((i-j+(n-1)/2)% n)*n+((i+j+(n+1)/2)%n);
		return result;		
	}
	
	public void writeToFile() throws IOException{
		FileWriter fileWriter = new FileWriter(new File(FILE));
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(square[i][j]<=9){
					fileWriter.write(square[i][j]+ "  ");
				}else{
					fileWriter.write(square[i][j]+ " ");
				}
			}
			fileWriter.write("\n");
		}		
		fileWriter.close();
	}

	public void printSquare(){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(square[i][j]<=9){
					System.out.print(square[i][j]+"  ");
				}else{
					System.out.print(square[i][j]+" ");
				}
			}
			System.out.println();
		}		
	}
	
	public void calculate(){
		int r=1;
		int c=1;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				square[i][j]=formula(r, c);	
				r++;
			}
			c++;
		}	
	}
	
	 public static void main(String[] args){
		 Task3_MagicSquare s = new Task3_MagicSquare();
		 s.calculate();
		 s.printSquare();
		 try {
			s.writeToFile();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	 }
}
