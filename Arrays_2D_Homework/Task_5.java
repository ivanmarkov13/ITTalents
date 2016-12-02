import java.util.Scanner;

public class Task_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr2d = new int[4][4];
		
		System.out.println("¬ъведете масива:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("елемент [" + i + "][" + j + "]");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		int maxSumRows = 0;
		int maxSumCols = 0;
		int tempSumRows = 0;
		int tempSumCols = 0;
		
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				tempSumRows += arr2d[i][j];
			}
			if(tempSumRows > maxSumRows){
				maxSumRows = tempSumRows;
			}
			tempSumRows = 0;
		}
		
		for(int j = 0; j < arr2d[0].length; j++){
			for(int i = 0; i < arr2d.length; i++){
				tempSumCols += arr2d[i][j];
			}
			if(tempSumCols > maxSumCols){
				maxSumCols = tempSumCols;
			}
			tempSumCols = 0;
		}
		
		System.out.println("най-гол€ма сума по редове: " + maxSumRows);
		System.out.println("най-гол€ма сума по колони: " + maxSumCols);
		System.out.print("ћаксималната сума по редове е ");
		System.out.print((maxSumRows > maxSumCols)?  ">":"<");
		System.out.println(" от максималната сума по колони.");
	}

}
