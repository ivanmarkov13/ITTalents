import java.util.Scanner;

public class Task_1 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int[][] arr2d = new int [6][5];
		System.out.println("Enter the array:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("element [" + i + "][" + j + "]:");
				arr2d[i][j] = sc.nextInt();
			}
		}

		int max = arr2d[0][0];
		int min = arr2d[0][0];
		
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				if(arr2d[i][j] > max){
					max = arr2d[i][j];
				}
				if(arr2d[i][j] < min){
					min = arr2d[i][j];
				}
			}
		}
		
		System.out.println("min: " + min + ";");
		System.out.println("max " + max);
	}

}
