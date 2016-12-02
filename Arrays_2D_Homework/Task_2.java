import java.util.Scanner;

public class Task_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter dimension of the array:");
		int n = sc.nextInt();
		
		while(n < 1){
			System.out.println("The dimension must be positive!:");
			System.out.println("Please, enter again:");
			n = sc.nextInt();
		}
		
		int[][] arr2d = new int[n][n];
		
		System.out.println("Enter the array:");
		for(int i = 0; i < arr2d.length; i++){
			for(int j = 0; j < arr2d[i].length; j++){
				System.out.println("element [" + i + "][" + j + "]:");
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Main diagonal:");
		for(int i = 0, j = 0; i < arr2d.length; i++, j++){
			System.out.print(arr2d[i][j] + " ");
		}
		
		System.out.println();
		
		System.out.println("Second diagonal:");
		for(int i = 0, j = arr2d.length - 1; i < arr2d.length; i++, j--){
			System.out.print(arr2d[i][j] + " ");
		}
		
		System.out.println();
		
	}

}
